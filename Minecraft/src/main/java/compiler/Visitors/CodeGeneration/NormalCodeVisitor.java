package compiler.Visitors.CodeGeneration;

import compiler.ASTNodes.Declarations.*;
import compiler.ASTNodes.GeneralNodes.CollectionNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.Operators.*;
import compiler.ASTNodes.SyntaxNodes.*;
import compiler.TypeChecking.SymbolTable;
import compiler.Utility.AbstractKeywordSheet;
import compiler.Utility.JavaSourceBuffer;
import compiler.Visitors.AbstractVisitor;

import java.util.ArrayList;

/**
 * Created by morell on 4/26/16.
 */
public abstract class NormalCodeVisitor extends AbstractVisitor {
    protected StringBuilder codeBuilder = new StringBuilder();
    protected String robotName;
    AbstractKeywordSheet keywords;

    public  NormalCodeVisitor (AbstractKeywordSheet aks)
    {
        this.keywords = aks;
    }

    public JavaSourceBuffer GetSourceCode()
    {
        return new JavaSourceBuffer(robotName + "NormalThread", codeBuilder.toString());
    }

    private void emitHeader()
    {
        //Append imports
        codeBuilder.append("import compiler.CodeGeneration.*;\n");
        codeBuilder.append("import compiler.Utility.Coord;\n");
        codeBuilder.append("import com.obsidiskrivemaskine.SyncRobot;\n");
        codeBuilder.append("import java.lang.reflect.Method; \n");
        codeBuilder.append("import java.util.ArrayList;\n");
        //Append class-header
        codeBuilder.append(String.format("public class %sRobot extends SyncRobot {\n", robotName));

        //Append constructor
        codeBuilder.append(String.format("public %sRobot() {\n", robotName));
        codeBuilder.append("createEntityIfNotPresent();\n");
        codeBuilder.append(String.format("hear = new %sHearThread();\n", robotName));
        codeBuilder.append("}\n");
    }

    private void visitDeclarationGeneric(DeclarationNode node, String type)
    {
        //Append type-name
        codeBuilder.append(type);
        codeBuilder.append(' ');
        //visit left-child to append ID
        visit(node.GetLeftChild());
        //Append initialization, if present
        if(node.GetRightChild() != null) {
            codeBuilder.append(" = ");
            visit(node.GetRightChild());
        }
        //Append statement-end
        codeBuilder.append(";\n");
    }

    @Override
    public Object visit(BoolDcl node) {
        visitDeclarationGeneric(node, keywords.BOOLEAN);
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        visitDeclarationGeneric(node, keywords.COORD);
        return null;
    }

    @Override
    public Object visit(NumDcl node) {
        visitDeclarationGeneric(node, keywords.FLOAT);
        return null;
    }

    @Override
    public Object visit(StringDcl node) {
        visitDeclarationGeneric(node, keywords.STRING);
        return null;
    }

    @Override
    public Object visit(ListDcl node) {
        //Append ArrayList<Object> ID = new ArrayList<Object>();
        codeBuilder.append(keywords.LIST);
        codeBuilder.append(' ');
        visit(node.GetLeftChild());
        codeBuilder.append(" = ");
        codeBuilder.append(keywords.NEW);
        codeBuilder.append(' ');
        codeBuilder.append(keywords.LIST);
        codeBuilder.append("();\n");

        //Add each node in the initialization to the list via list.add()
        for (Node n : ((CollectionNode) node.GetRightChild()).GetChildren()) {
            visit(node.GetLeftChild());
            codeBuilder.append(keywords.CLASS_ACCESS);
            codeBuilder.append(keywords.ADD_TO_LIST);
            codeBuilder.append('(');
            visit(n);
            codeBuilder.append(");\n");
        }
        return null;
    }

    private void visitMethodDclGeneric(MethodDcl node, String type)
    {
        //Append override if start-method
        if(node.id.equals("START"))
            codeBuilder.append("@Override\n");
        //Append public type id
        codeBuilder.append(keywords.ACCESS);
        codeBuilder.append(' ');
        codeBuilder.append(type);
        codeBuilder.append(' ');
        codeBuilder.append(node.id);
        //Append each of the parameters with type and ID
        codeBuilder.append('(');
        ArrayList<Node> params = node.parameters;
        for (int i = 0; i < params.size(); i++) {
            Node n = params.get(i);
            if(i > 0)
                codeBuilder.append(", ");
            if(n instanceof BoolDcl)  codeBuilder.append(keywords.BOOLEAN);
            if(n instanceof StringDcl)  codeBuilder.append(keywords.STRING);
            if(n instanceof NumDcl)  codeBuilder.append(keywords.FLOAT);
            if(n instanceof CoordDcl)  codeBuilder.append(keywords.COORD);
            codeBuilder.append(" ");
            visit(n.GetLeftChild());
        }
        codeBuilder.append(")");
        //Insert body
        visit(node.GetLeftChild());
    }

    @Override
    public Object visit(HearDcl node) {
        /*Skip all hear-declarations - will be declared in separate thread*/
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        String typeExt;
        //Find the correct keyword for the method
        switch (node.getT())
        {
            case bool:
                typeExt = keywords.BOOLEAN;
                break;
            case num:
                typeExt = keywords.FLOAT;
                break;
            case string:
                typeExt = keywords.STRING;
                break;
            case Coord:
                typeExt = keywords.COORD;
                break;
            case Void:
                typeExt = keywords.VOID;
                break;
            case List:
                typeExt = keywords.LIST;
                break;
            default:
                typeExt = "";
                break;
        }
        visitMethodDclGeneric(node, typeExt);
        return null;
    }



    @Override
    public Object visit(ReferenceNode node) {
        if(node.getT() == Node.Type.List && node._parent instanceof DeclarationNode) {
            codeBuilder.append('(');
            switch (node._parent.getT()) {
                case num:
                    codeBuilder.append("float)");
                    break;
                case string:
                    codeBuilder.append("String)");
                    break;
                case Coord:
                    codeBuilder.append("Coord)");
                    break;
                case bool:
                    codeBuilder.append("boolean)");
                    break;
            }
        }
        //Append ID
        IDNode id = node.GetId();
        codeBuilder.append(id.GetID());
        System.out.println("Parent of " + id._id + " is " + node._parent);
        System.out.println("Grandparent of " + id._id + " is " + node._parent._parent);
        //Append indexing if it's a list
        if(node.getT() == Node.Type.List && node._parent instanceof DeclarationNode) {
            codeBuilder.append(".get(Math.round(");
            visit(id._extension);
            codeBuilder.append("))");
        }
        return null;
    }

    @Override
    public Object visit(DotNode node) {
        //Append ID
        visit(node.GetLeftChild());
        //Append Dot
        codeBuilder.append(keywords.CLASS_ACCESS);
        //Append right-side of the dot
        codeBuilder.append(node.name);
        return null;
    }

    private void visitExpressionGeneric(ExprNode n, String operator)
    {
        //Append LHS
        visit(n.GetLeftChild());
        codeBuilder.append(' ');
        //Add operator
        codeBuilder.append(operator);
        codeBuilder.append(' ');
        //Append RHS
        visit(n.GetRightChild());
    }

    @Override
    public Object visit(GreaterEqualNode node) {
        visitExpressionGeneric(node, keywords.GREATER_THAN_EQUAL);
        return null;
    }

    @Override
    public Object visit(LessEqualNode node) {
        visitExpressionGeneric(node, keywords.LESS_THAN_EQUAL);
        return null;
    }

    @Override
    public Object visit(AndNode node) {
        visitExpressionGeneric(node, keywords.AND);
        return null;
    }

    @Override
    public Object visit(AssignNode node) {
        //Actually the same as visitExpressionGeneric, but AssignNode is not an expression
        visit(node.GetLeftChild());
        codeBuilder.append(keywords.ASSIGN);
        visit(node.GetRightChild());
        codeBuilder.append("; \n");
        return null;
    }

    @Override
    public Object visit(DivNode node) {
        //Get types
        Node.Type left = node.GetLeftChild().getT();
        Node.Type right = node.GetRightChild().getT();

        //Both are Strings
        if(left == Node.Type.string && right == Node.Type.string)
        {
            codeBuilder.append("divStringString(");
            visit(node.GetLeftChild());
            codeBuilder.append(", ");
            visit(node.GetRightChild());
            codeBuilder.append(")");
        }
        //LHS is Coord
        else if(left == Node.Type.Coord)
        {
            if(right == Node.Type.num)
                CoordSimplifier(node, InputTypes.COORDNUM, '/');
            else if(right == Node.Type.Coord)
                CoordSimplifier(node, InputTypes.COORDCOORD, '/');
        }
        //RHS and LHS is BOOL
        else if(left == Node.Type.bool && right == Node.Type.bool)
        {
            //(b1 && b2)
            codeBuilder.append("((");
            visit(node.GetLeftChild());
            codeBuilder.append(" && ");
            visit(node.GetRightChild());
            codeBuilder.append(")");

            codeBuilder.append(" || ");

            //(!b1 && !b2)
            codeBuilder.append("(!");
            visit(node.GetLeftChild());
            codeBuilder.append(" && !");
            visit(node.GetRightChild());
            codeBuilder.append("))");
        }
        //LHS is NUM and RHS is Coord
        else if(left == Node.Type.num && right == Node.Type.Coord)
            CoordSimplifier(node, InputTypes.NUMCOORD, '/');
        else
            visitExpressionGeneric(node, keywords.DIV);
        return null;
    }

    @Override
    public Object visit(GreaterNode node) {
        visitExpressionGeneric(node, keywords.GREATER_THAN);
        return null;
    }

    @Override
    public Object visit(IsNode node) {
        visitExpressionGeneric(node, keywords.EQUAL);
        return null;
    }

    @Override
    public Object visit(LessNode node) {
        visitExpressionGeneric(node, keywords.LESS_THAN);
        return null;
    }

    @Override
    public Object visit(MinusNode node) {
        Node.Type left = node.GetLeftChild().getT();
        Node.Type right = node.GetRightChild().getT();

        if(left == Node.Type.string && right == Node.Type.string)
        {
            visit(node.GetLeftChild());
            codeBuilder.append(".replaceAll(");
            visit(node.GetRightChild());
            codeBuilder.append(", \"\")");
        }
        else if(left ==  Node.Type.Coord)
        {
            if(right == Node.Type.num)
                CoordSimplifier(node, InputTypes.COORDNUM, '-');
            else if (right == Node.Type.Coord)
                CoordSimplifier(node, InputTypes.COORDCOORD, '-');

        }
        else if(left ==  Node.Type.bool && right == Node.Type.bool)
        {
            //(b1 && !b2)
            codeBuilder.append("((");
            visit(node.GetLeftChild());
            codeBuilder.append(" && !");
            visit(node.GetRightChild());
            codeBuilder.append(")");

            codeBuilder.append(" || ");

            //(!b1 && b2)
            codeBuilder.append("(!");
            visit(node.GetLeftChild());
            codeBuilder.append(" && ");
            visit(node.GetRightChild());
            codeBuilder.append("))");
        }
        else if(left ==  Node.Type.num && right == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.NUMCOORD, '-');
        }
        else if(left == Node.Type.List) {
            visit(node.GetLeftChild());
            if(right != Node.Type.List)
                codeBuilder.append(".removeAll(");
            else
                codeBuilder.append(".removeAll(");
            visit(node.GetRightChild());
            codeBuilder.append(")\n");
        }
        else {visitExpressionGeneric(node, keywords.MINUS); }
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        Node.Type left = node.GetLeftChild().getT();
        Node.Type right = node.GetRightChild().getT();

        if(left == Node.Type.string) {
            if(right == Node.Type.string)
                codeBuilder.append("multStringString(");
            else if (right == Node.Type.num)
                codeBuilder.append("multStringNum(");

            visit(node.GetLeftChild());
            codeBuilder.append(", ");
            visit(node.GetRightChild());
            codeBuilder.append(")\n");
        }

        else if(left == Node.Type.Coord)
        {
            if(right == Node.Type.num)
                CoordSimplifier(node, InputTypes.COORDNUM, '*');
            else if(right == Node.Type.Coord)
                CoordSimplifier(node, InputTypes.COORDCOORD, '*');
        }
        else if(left == Node.Type.bool && right == Node.Type.bool)
        {
            visit(node.GetLeftChild()); codeBuilder.append(" && "); visit(node.GetRightChild());
        }
        else if(left == Node.Type.num && right == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.NUMCOORD, '*');
        }
        else
        {
            visitExpressionGeneric(node, keywords.MULT);
        }
        return null;
    }

    @Override
    public Object visit(NotNode node) {
        codeBuilder.append("!(");
        visitExpressionGeneric(node, keywords.EQUAL);
        codeBuilder.append(')');
        return null;
    }

    @Override
    public Object visit(OrNode node) {
        visitExpressionGeneric(node, keywords.OR);
        return null;
    }

    @Override
    public Object visit(PlusNode node) {
        Node.Type left = node.GetLeftChild().getT();
        Node.Type right = node.GetRightChild().getT();

        if(left == Node.Type.num && right != Node.Type.num)
        {
            if(right == Node.Type.string) {
                //Convert from float to string
                codeBuilder.append("Float.toString(");
                visit(node.GetLeftChild());
                codeBuilder.append(')');

                //And plus the string
                codeBuilder.append(" + ");
                visit(node.GetRightChild());
            }
            else if(right == Node.Type.Coord)
                CoordSimplifier(node, InputTypes.NUMCOORD, '+');
        }

        else if(left == Node.Type.bool)
        {
            if(right == Node.Type.string) {
                //Find the value of the bool
                codeBuilder.append("String.valueOf(");
                visit(node.GetLeftChild());
                codeBuilder.append(").toUpperCase()");

                //And plus String
                codeBuilder.append(" + ");
                visit(node.GetRightChild());
            }
            else if(right == Node.Type.bool) {
                visit(node.GetLeftChild());
                codeBuilder.append(" || ");
                visit(node.GetRightChild());
            }
        }

        else if(left == Node.Type.Coord)
        {
            if(right == Node.Type.string) {
                //Convert Coord to string
                visit(node.GetLeftChild());
                codeBuilder.append(".toString()");

                //And plus the String
                codeBuilder.append(" + ");
                visit(node.GetRightChild());
            }
            else if (right == Node.Type.num)
                CoordSimplifier(node,InputTypes.COORDNUM,'+');
            else if(right == Node.Type.Coord)
                CoordSimplifier(node, InputTypes.COORDCOORD, '+');
        }

        else if(left == Node.Type.string && right != Node.Type.string)
        {
            visit(node.GetLeftChild());
            codeBuilder.append(" + ");

            if(right == Node.Type.num) {
                codeBuilder.append("Float.toString(");
                visit(node.GetRightChild());
                codeBuilder.append(")");
            }
            else if(right == Node.Type.bool) {
                codeBuilder.append("String.valueOf(");
                visit(node.GetRightChild());
                codeBuilder.append(").toUpperCase()");
            }
            else if(right == Node.Type.Coord) {
                visit(node.GetRightChild());
                codeBuilder.append(".toString()");
            }
        }
        //Lists
        else if(left == Node.Type.List)
        {
            visit(node.GetLeftChild());
            if(right != Node.Type.List)
                codeBuilder.append(".add(");
            else
                codeBuilder.append(".addAll(");
            visit(node.GetRightChild());
            codeBuilder.append(")\n");
        }
        else { visitExpressionGeneric(node, keywords.PLUS); }
        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        codeBuilder.append(keywords.MINUS);
        visit(node.GetLeftChild());
        return null;
    }

    @Override
    public Object visit(XnorNode node) {
        codeBuilder.append("((");
        visitExpressionGeneric(node, keywords.AND);
        codeBuilder.append(')');
        codeBuilder.append(keywords.OR);
        codeBuilder.append(keywords.NOT);
        codeBuilder.append('(');
        visitExpressionGeneric(node, keywords.AND);
        codeBuilder.append("))");
        return null;
    }

    @Override
    public Object visit(XorNode node) {
        codeBuilder.append("((");

        //Append first expression (b1 ^ !b2)
        visit(node.GetLeftChild());
        codeBuilder.append(' ');
        codeBuilder.append(keywords.AND);
        codeBuilder.append(' ');
        codeBuilder.append(keywords.NOT);
        visit(node.GetRightChild());
        codeBuilder.append(')');

        codeBuilder.append(keywords.OR);

        //Append second expression (!b1 ^ b2)
        codeBuilder.append('(');
        codeBuilder.append(keywords.NOT);
        visit(node.GetLeftChild());
        codeBuilder.append(' ');
        codeBuilder.append(keywords.AND);
        codeBuilder.append(' ');
        visit(node.GetRightChild());
        codeBuilder.append("))");
        return null;
    }

    @Override
    public Object visit(BlockNode node) {
        codeBuilder.append("{ \n");
        for (Node n : node.GetChildren()) {
            visit(n);
        }

        codeBuilder.append("} \n");
        return null;
    }

    @Override
    public Object visit(CollectionNode node) {
        for (Node n : node.GetChildren()) visit(n);
        return null;
    }

    @Override
    public Object visit(BoolLit node) {
        codeBuilder.append(node.value.toLowerCase());
        return null;
    }

    @Override
    public Object visit(BreakNode node) {
        codeBuilder.append("break; \n");
        return null;
    }

    @Override
    public Object visit(CoordLit node) {

        double x = node.x;
        double y = node.y;
        double z = node.z;
        codeBuilder.append("new ");
        codeBuilder.append(keywords.COORD);
        codeBuilder.append("(");
        codeBuilder.append(x);
        codeBuilder.append("f");
        codeBuilder.append(", ");
        codeBuilder.append(y);
        codeBuilder.append("f");
        codeBuilder.append(", ");
        codeBuilder.append(z);
        codeBuilder.append("f");
        codeBuilder.append(")");
        return null;
    }

    @Override
    public Object visit(ElseNode node) {
        codeBuilder.append("else { \n");
        visit(node.GetLeftChild());
        codeBuilder.append(" } \n");
        return null;
    }



    @Override
    public Object visit(ExprNode node) {
        //Never used - all ExprNode should have a more specilized type
        return null;
    }

    @Override
    public Object visit(ParenNode node) {
        codeBuilder.append("(");
        visit(node.GetLeftChild());
        codeBuilder.append(")");
        return null;
    }

    @Override
    public Object visit(IDNode node) {
        codeBuilder.append(node._id);
        return null;
    }

    @Override
    public Object visit(IfNode node) {

        codeBuilder.append("if(");
        visit(node.GetCondition());
        codeBuilder.append(")");
        visit(node.GetBody());
        codeBuilder.append("\n");

        if(node.GetElseIf() != null)
        {
            codeBuilder.append("else ");
            visit(node.GetElseIf());
        }

        if(node.GetElse() != null) { visit(node.GetElse()); }

        return null;
    }


    //todo yet to be implemented
    @Override
    public Object visit(LoadNode node) {
        return null;
    }



    @Override
    public Object visit(LoopNode node) {
        codeBuilder.append("while(!(");
        visit(node.GetLeftChild());
        codeBuilder.append("))");
        visit(node.GetRightChild());
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        boolean outermethod = (node._parent instanceof BlockNode);
        if(outermethod){
            codeBuilder.append("\nmutex.WaitForTurn();\n");
        }
        visit(node.GetLeftChild());
        //Append arguments
        codeBuilder.append("(");
        ArrayList<Node> args = node.GetChildren();
        for (int i = 0; i < args.size(); i++) {
            if(i > 0) codeBuilder.append(", ");
            Node n = args.get(i);
            visit(n);
        }
        codeBuilder.append(") ");

        if (outermethod) {
            codeBuilder.append(";");
        }

        return null;
    }

    @Override
    public Object visit(NumLit node) {
        codeBuilder.append(node._value);
        codeBuilder.append("f");
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        this.robotName = node._id;
        emitHeader();
        for (Node n : node.GetChildren()) visit(n);

        return null;
    }

    @Override
    public Object visit(ReturnNode node) {

        codeBuilder.append("return ");
        visit(node.GetLeftChild());
        codeBuilder.append(";");
        return null;
    }

    @Override
    public Object visit(SignalNode node) {
        ArrayList<Node> args = ((CollectionNode) node.GetRightChild()).GetChildren();

        codeBuilder.append("sendSignal(\"");
        codeBuilder.append(((IDNode) node.GetLeftChild())._id);
        codeBuilder.append("\", new Object[] {");
        for (int i = 0; i < args.size(); i++) {
            if(i > 0)
                codeBuilder.append(',');
            Node n = args.get(i);
            visit(n);
        }
        codeBuilder.append("});\n");

        return null;
    }

    @Override
    public Object visit(StringLit node) {
        codeBuilder.append(node.text);
        return null;
    }

    public void CoordSimplifier(ExprNode node, InputTypes inputtypes, char operator)
    {
        switch (inputtypes) {
            case COORDNUM:
                    HandleNumCoord(node.GetLeftChild(), node.GetRightChild(), operator);
                break;
            case NUMCOORD:
                    HandleNumCoord(node.GetRightChild(), node.GetLeftChild(), operator);
                break;
            case COORDCOORD:
                //Append left Coord
                visit(node.GetLeftChild());
                //Determine the operator and call corresponding method
                if(operator == '+')
                    codeBuilder.append(".plusCoord(");
                else if(operator == '*')
                    codeBuilder.append(".multCoord(");
                else if(operator == '-')
                    codeBuilder.append(".minusCoord(");
                else if(operator == '/')
                    codeBuilder.append(".divCoord(");
                //Add argument and close parenthesis
                visit(node.GetRightChild());
                codeBuilder.append(')');
                break;
        }
    }

    private void HandleNumCoord(Node coord, Node num, char operator)
    {
        //Append coord
        visit(coord);
        //Determine which method to call in the coord class
        if(operator == '+')
            codeBuilder.append(".plusNum(");
        else if(operator == '*')
            codeBuilder.append(".multNum(");
        else if(operator == '-')
            codeBuilder.append(".minusNum(");
        else if(operator == '/')
            codeBuilder.append(".divNum(");

        //Append Num and close parenthesis
        visit(num);
        codeBuilder.append(')');
    }

    public enum InputTypes {
        COORDNUM, NUMCOORD, COORDCOORD
    }


}

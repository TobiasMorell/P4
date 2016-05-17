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

/**
 * Created by morell on 4/26/16.
 */
public abstract class NormalCodeVisitor extends AbstractVisitor {
    //todo: Implement use of SymbolTable, must also use the approach defined by Arne & Lee

    protected StringBuilder codeBuilder = new StringBuilder();
    protected String robotName;
    AbstractKeywordSheet keywords;
    private SymbolTable symtable;

    public NormalCodeVisitor(AbstractKeywordSheet keywords, SymbolTable symtab)
    {
        this.keywords = keywords;
        this.symtable = symtab;
    }

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
        //codeBuilder.append("package CompiledRobots;\n");
        codeBuilder.append("import compiler.CodeGeneration.*;\n");
        codeBuilder.append("import compiler.Utility.Coord;\n");
        codeBuilder.append("import com.obsidiskrivemaskine.SyncRobot;\n");
        codeBuilder.append("import java.lang.reflect.Method; \n");
        codeBuilder.append(String.format("public class %sRobot extends SyncRobot {\n", robotName));

        //Append constructor
        codeBuilder.append(String.format("public %sRobot() {\n", robotName));
        codeBuilder.append("createEntityIfNotPresent();\n");
        codeBuilder.append(String.format("hear_thread = new Thread(new %sHearThread(this, mutex));\n", robotName));
        codeBuilder.append("}\n");
    }
        //Note to self, both generic dcls and blocks all produce \n which kinda seems overkill, unsure what to change
        //Note not all of our custom orthogonality with operators and types can be made directly in code gen,
        // some must be made instead as methods in the generated language
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
        codeBuilder.append(keywords.LIST);
        codeBuilder.append(' ');
        visit(node.GetLeftChild());
        codeBuilder.append(" = ");
        codeBuilder.append(keywords.NEW);
        codeBuilder.append(' ');
        codeBuilder.append(keywords.LIST);
        codeBuilder.append("();\n");

        for (Node n : ((CollectionNode) node.GetLeftChild()).GetChildren()) {
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
        if(node.id.equals("START"))
            codeBuilder.append("@Override\n");
        codeBuilder.append(keywords.ACCESS);
        codeBuilder.append(' ');
        codeBuilder.append(type);
        codeBuilder.append(' ');
        codeBuilder.append(node.id);
        codeBuilder.append('(');
        int i = node.parameters.size();
        for (Node n : node.parameters) {

            //istedet for visits på n så gør det her "manuelt" for at undgå at postfix ;
            //Kan helt sikkert gøres smartere
            if(n instanceof BoolDcl) { codeBuilder.append(keywords.BOOLEAN);  }
            if(n instanceof StringDcl) { codeBuilder.append(keywords.STRING);  }
            if(n instanceof NumDcl) { codeBuilder.append(keywords.FLOAT);  }
            if(n instanceof CoordDcl) { codeBuilder.append(keywords.COORD);  }
            //codeBuilder.append(n);
            codeBuilder.append(" ");
            visit(n.GetLeftChild());
            --i;
            if(i > 0)
            {
                codeBuilder.append(", ");
            }
        }
        codeBuilder.append(")");

        visit(node.GetLeftChild());


    }

    @Override
    public Object visit(HearDcl node) {
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        String typeExt;

        switch (node.type)
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
        //todo Check if type is list and then find index if it has one.

        IDNode id = node.GetId();
        if(node._GlobalRef) {codeBuilder.append("r."); }
        codeBuilder.append(id.GetID());
        if(id._extension != null)
        {
            codeBuilder.append(".get(");
            visit(id._extension);
            codeBuilder.append(')');
        }

        codeBuilder.append("");
        return null;
    }

    @Override
    public Object visit(DotNode node) {
        visit(node.GetLeftChild());
        codeBuilder.append(keywords.CLASS_ACCESS);
        codeBuilder.append(node.name);
        return null;
    }

    private void visitExpressionGeneric(ExprNode n, String operator)
    {
            visit(n.GetLeftChild());
            codeBuilder.append(' ');
            codeBuilder.append(operator);
            codeBuilder.append(' ');
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

    //At tilføje et ; og \n løste super mange problemer, ved ik om det godt i alle tilfælde.
    @Override
    public Object visit(AssignNode node) {
        visit(node.GetLeftChild());
        codeBuilder.append(keywords.ASSIGN);
        visit(node.GetRightChild());
        codeBuilder.append("; \n");
        return null;
    }

    @Override
    public Object visit(DivNode node) {
        if(node.GetLeftChild().type == Node.Type.string && node.GetRightChild().type == Node.Type.string)
        {
            //picks out all chars of rhs in lhs.
            //todo this
        }
        else if(node.GetLeftChild().type == Node.Type.Coord && node.GetRightChild().type == Node.Type.num)
        {
            CoordSimplifier(node, InputTypes.COORDNUM, '/');
        }
        else if(node.GetLeftChild().type == Node.Type.bool && node.GetRightChild().type == Node.Type.bool)
        {
            //todo this
           //boolean exclusive and visit(node.GetLeftChild()); codeBuilder.append(""); visit(node.GetRightChild());
            //wtf is exclusive and?
        }
        else if(node.GetLeftChild().type == Node.Type.num && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.NUMCOORD, '/');
        }
        else if(node.GetLeftChild().type == Node.Type.Coord && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.COORDCOORD, '/');
        }
        else
        {
            visitExpressionGeneric(node, keywords.DIV);
        }
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
        if(node.GetLeftChild().type == Node.Type.string && node.GetRightChild().type == Node.Type.string)
        {
            visit(node.GetLeftChild());
            codeBuilder.append(".replaceAll(");
            visit(node.GetRightChild());
            codeBuilder.append(", \"\")");
        }
        else if(node.GetLeftChild().type ==  Node.Type.Coord && node.GetRightChild().type == Node.Type.num)
        {
            CoordSimplifier(node, InputTypes.COORDNUM, '-');
        }

        else if(node.GetLeftChild().type ==  Node.Type.bool && node.GetRightChild().type == Node.Type.bool)
        {
            visit(node.GetLeftChild()); codeBuilder.append(" ^ "); visit(node.GetRightChild());
        }
        else if(node.GetLeftChild().type ==  Node.Type.num && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.NUMCOORD, '-');
        }
        else if(node.GetLeftChild().type ==  Node.Type.Coord && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.COORDCOORD, '-');
        }
        else {visitExpressionGeneric(node, keywords.MINUS); }
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        if(node.GetLeftChild().type == Node.Type.string && node.GetRightChild().type == Node.Type.string) {
            //takes first char in lhs then first char in rhs and so forth
            //lave while ikke tom og så take hvert element over i en ny string
            //todo this
            String string1 = "ExampleString";
            String string2 = "ExampleString";
            char[] chars = new char[1000];

            //while (string1.length() > 0)
              //  chars[1] = string1.charAt(1);

            for (int i = 0, x = 0; i < string1.length() + string2.length(); i += 2, x++)
            {
                chars[i] = string1.charAt(x);
                chars[i + 1] = string2.charAt(x);
                codeBuilder.append(i);
            }
            codeBuilder.append(chars);
        }

        else if(node.GetLeftChild().type == Node.Type.string && node.GetRightChild().type == Node.Type.num)
        {
            /*
            String teststring = "Beers"; float myfloat = 4; String test = ""; int j = 0;
            codeBuilder.append("String test; ");
            codeBuilder.append("for(int i = 0; i < ");
            visit(node.GetRightChild()); codeBuilder.append("; 1++){ ");
            codeBuilder.append("test += "); visit(node.GetLeftChild()); codeBuilder.append("}");
            visit(node.GetLeftChild()); codeBuilder.append(" = test");
            */
            //repeat string num times.
            //todo this
        }

        else if(node.GetLeftChild().type == Node.Type.Coord && node.GetRightChild().type == Node.Type.num)
        {
            CoordSimplifier(node, InputTypes.COORDNUM, '*');
        }
        else if(node.GetLeftChild().type == Node.Type.bool && node.GetRightChild().type == Node.Type.bool)
        {
            visit(node.GetLeftChild()); codeBuilder.append(" && "); visit(node.GetRightChild());
        }
        else if(node.GetLeftChild().type == Node.Type.num && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.NUMCOORD, '*');
        }
        else if(node.GetLeftChild().type == Node.Type.Coord && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.COORDCOORD, '*');
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

        if(node.GetLeftChild().type == Node.Type.num && node.GetRightChild().type == Node.Type.string)
        {
            visit(node.GetLeftChild());  codeBuilder.append(".toString()"); codeBuilder.append(" + "); visit(node.GetRightChild());
        }

        else if(node.GetLeftChild().type == Node.Type.bool && node.GetRightChild().type == Node.Type.string)
        {
            codeBuilder.append("String.valueOf("); visit(node.GetLeftChild()); codeBuilder.append(").toUpperCase()");
            codeBuilder.append(" + "); visit(node.GetRightChild());
        }

        else if(node.GetLeftChild().type == Node.Type.Coord && node.GetRightChild().type == Node.Type.string)
        {
            visit(node.GetLeftChild()); codeBuilder.append(".toString()"); codeBuilder.append(" + ");
            visit(node.GetRightChild());
        }

        else if(node.GetLeftChild().type == Node.Type.string && node.GetRightChild().type == Node.Type.num)
        {
            visit(node.GetLeftChild()); codeBuilder.append(" + "); visit(node.GetRightChild()); codeBuilder.append(".toString()");
        }

        //This may have to change
        //else it could produce in example: oldcoord = oldcoord + 10
        //makes: oldcoord.x += 10; oldcoord.y +=
        else if(node.GetLeftChild().type == Node.Type.Coord && node.GetRightChild().type == Node.Type.num)
        {
            CoordSimplifier(node,InputTypes.COORDNUM,'+');
        }

        else if(node.GetLeftChild().type == Node.Type.string && node.GetRightChild().type == Node.Type.bool)
        {
            visit(node.GetLeftChild()); codeBuilder.append(" + "); codeBuilder.append("String.valueOf(");
            visit(node.GetRightChild()); codeBuilder.append(").toUpperCase()");
        }

        else if(node.GetLeftChild().type == Node.Type.bool && node.GetRightChild().type == Node.Type.bool)
        {
            visit(node.GetLeftChild()); codeBuilder.append(" || "); visit(node.GetRightChild());
        }

        else if(node.GetLeftChild().type == Node.Type.string && node.GetRightChild().type == Node.Type.Coord)
        {
            visit(node.GetLeftChild()); codeBuilder.append(" + "); visit(node.GetRightChild());
            codeBuilder.append(".toString()");
        }
        else if(node.GetLeftChild().type == Node.Type.num && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.NUMCOORD, '+');
        }

        else if(node.GetLeftChild().type == Node.Type.Coord && node.GetRightChild().type == Node.Type.Coord)
        {
            CoordSimplifier(node, InputTypes.COORDCOORD, '+');
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


    //Curly braces are now specific to blocknodes
    @Override
    public Object visit(BlockNode node) {
        codeBuilder.append(" \n { \n");
        codeBuilder.append("\nmutex.WaitForTurn();\n");
        for (Node n : node.GetChildren()) {
            visit(n);
        }

        codeBuilder.append(" \n } \n");
        return null;
    }


    //Needs to be implemented to show code produced
    @Override
    public Object visit(CollectionNode node) {
        for (Node n : node.GetChildren()
                ) { visit(n);
        }
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
        codeBuilder.append("else { ");
        visit(node.GetLeftChild());
        codeBuilder.append(" } \n");
        return null;
    }


    //bruger visitExpressionGeneric med en operator istedet
    //Bliver aldrig brugt
    @Override
    public Object visit(ExprNode node) {
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
        codeBuilder.append(") \n");
        visit(node.GetBody());
        codeBuilder.append(" \n");

        if(node.GetElseIf() != null)
        {
            codeBuilder.append("else if(");
            visit(node.GetElseIf().GetCondition());
            codeBuilder.append(") \n");
            visit(node.GetElseIf().GetBody());
            codeBuilder.append("\n");

        }

        //if(node.GetElseIf() != null ) { visit(node.GetElseIf()); }
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
        //todo Add call to WaitForTurn();
        codeBuilder.append("while(!(");
        visit(node.GetLeftChild());
        codeBuilder.append("))");
        visit(node.GetRightChild());
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
       // codeBuilder.append("Robot.");
        //todo Add call to WaitForTurn()
        codeBuilder.append("\nmutex.WaitForTurn();\n");
        visit(node.GetLeftChild());
        codeBuilder.append("(");
        int i = node.GetChildren().size();
        for (Node g : node.GetChildren()) { visit(g); --i; if(i > 0) codeBuilder.append(", "); }
        codeBuilder.append(") ");
        if(node._parent._parent instanceof MethodDcl){
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
        for (Node n : node.GetChildren()
             ) { visit(n);
        }

        //codeBuilder.append("}");
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
            case COORDNUM: codeBuilder.append(keywords.NEW);
                codeBuilder.append(" ");
                codeBuilder.append(keywords.COORD);
                codeBuilder.append("(");
                visit(node.GetLeftChild());
                codeBuilder.append(".x ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(", ");
                visit(node.GetLeftChild());
                codeBuilder.append(".y ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(", ");
                visit(node.GetLeftChild());
                codeBuilder.append(".z ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(")");
                break;
            case NUMCOORD: codeBuilder.append(keywords.NEW);
                codeBuilder.append(" ");
                codeBuilder.append(keywords.COORD);
                codeBuilder.append("(");
                visit(node.GetLeftChild());
                codeBuilder.append(" ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(".x, ");
                visit(node.GetLeftChild());
                codeBuilder.append(" ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(".y, ");
                visit(node.GetLeftChild());
                codeBuilder.append(" ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(".z)");
                break;
            case COORDCOORD: codeBuilder.append(keywords.NEW);
                codeBuilder.append(" ");
                codeBuilder.append(keywords.COORD);
                codeBuilder.append("(");
                visit(node.GetLeftChild());
                codeBuilder.append(".x ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(".x, ");
                visit(node.GetLeftChild());
                codeBuilder.append(".y ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(".y, ");
                visit(node.GetLeftChild());
                codeBuilder.append(".z ");
                codeBuilder.append(operator);
                codeBuilder.append(" ");
                visit(node.GetRightChild());
                codeBuilder.append(".z)");
                break;
        }
    }

    public enum InputTypes {
        COORDNUM, NUMCOORD, COORDCOORD
    }


}

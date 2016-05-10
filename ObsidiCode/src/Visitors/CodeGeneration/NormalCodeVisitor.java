package Visitors.CodeGeneration;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import TypeChecking.SymbolTable;
import Utility.AbstractKeywordSheet;
import Utility.JavaSourceBuffer;
import Visitors.AbstractVisitor;


/**
 * Created by morell on 4/26/16.
 */
public class NormalCodeVisitor extends AbstractVisitor {
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
        codeBuilder.append("package CompiledRobots;\n");
        codeBuilder.append("import Java.Util.ArrayList;\n");
        codeBuilder.append("import Utility.Coord;\n\n");
        codeBuilder.append("public class " + robotName + "NormalThread extends NormalThread { \n");
        codeBuilder.append("private " + robotName +"Robot Robot; \n");
        codeBuilder.append("public " + robotName + "NormalThread(" + robotName + "Robot r, RobotMutex mut) {");
        codeBuilder.append("super(mutex); Robot = r; }  \n");

    }
        //Note to self, both generic dcls and blocks all produce \n which kinda seems overkill, unsure what to change
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
            case coord:
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
        if(n.GetLeftChild().type == Node.Type.num && n.GetRightChild().type == Node.Type.string) {n.GetLeftChild().toString();}  //NUM concat end of string }
        //codeBuilder.append(n.GetLeftChild().type);
        //codeBuilder.append(n.GetRightChild().type);


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
        visitExpressionGeneric(node, keywords.MINUS);
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        visitExpressionGeneric(node, keywords.MULT);
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
        visitExpressionGeneric(node, keywords.PLUS);
        //codeBuilder.append(node.GetLeftChild());
        //codeBuilder.append(node.GetRightChild());
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
        codeBuilder.append(", ");
        codeBuilder.append(y);
        codeBuilder.append(", ");
        codeBuilder.append(z);
        codeBuilder.append(");");
        return null;
    }

    @Override
    public Object visit(ElseNode node) {
        codeBuilder.append("else { ");
        visit(node.GetLeftChild());
        codeBuilder.append(" } \n");
        return null;
    }

    @Override
    public Object visit(ExprNode node) {
        return null;
    }




    @Override
    public Object visit(IDNode node) {
        //todo mangler at tjekke om variablen er declared i symbol table, det gør topdcl visitor vist allerede
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
        codeBuilder.append("while(!(");
        visit(node.GetLeftChild());
        codeBuilder.append("))");

        visit(node.GetRightChild());
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        visit(node.GetLeftChild());
        codeBuilder.append("( ");
        int i = node.GetChildren().size();
        for (Node g : node.GetChildren()) { visit(g); --i; if(i > 0) codeBuilder.append(", "); }
        codeBuilder.append("); ");
        return null;
    }

    @Override
    public Object visit(NumLit node) {

        codeBuilder.append(node._value);
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        this.robotName = node._id;
        emitHeader();
        for (Node n : node.GetChildren()
             ) { visit(n);
        }

        codeBuilder.append("}");
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
}

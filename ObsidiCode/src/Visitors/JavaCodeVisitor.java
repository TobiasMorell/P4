package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import Utility.AbstractKeywordSheet;
import Utility.JavaSourceBuffer;

/**
 * Created by morell on 4/26/16.
 */
public class JavaCodeVisitor extends AbstractVisitor {
    //todo: Implement use of SymbolTable, must also use the approach defined by Arne & Lee

    private StringBuilder codeBuilder = new StringBuilder();
    private String robotName;
    AbstractKeywordSheet keywords;

    public JavaCodeVisitor (AbstractKeywordSheet keywords)
    {
        this.keywords = keywords;
    }

    public JavaSourceBuffer GetSourceCode()
    {
        return new JavaSourceBuffer(robotName, codeBuilder.toString());
    }

    private void emitHeader()
    {
        codeBuilder.append("package CompiledRobots;\n");
        codeBuilder.append("import Java.Util.ArrayList;\n");
        codeBuilder.append("import Utility.Coord;\n\n");
        codeBuilder.append(keywords.ACCESS);
        codeBuilder.append(' ');
        codeBuilder.append(keywords.CLASS);
        codeBuilder.append(' ');
        codeBuilder.append(robotName);
        codeBuilder.append(' ');
        codeBuilder.append(keywords.EXTENSION);
        codeBuilder.append(" {\n");

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

    private void visitMethodDclGeneric(MethodDcl node, String type, String idExtension)
    {
        codeBuilder.append(keywords.ACCESS);
        codeBuilder.append(' ');
        codeBuilder.append(node.type);
        codeBuilder.append(' ');
        codeBuilder.append(idExtension);
        codeBuilder.append(node.id);
        codeBuilder.append('(');
        for (Node n : node.parameters) {
            visit(n);
        }
        codeBuilder.append(") {\n");
        visit(node.GetLeftChild());
        codeBuilder.append("}\n");
    }

    @Override
    public Object visit(HearDcl node) {
        visitMethodDclGeneric(node, keywords.VOID, "hear");
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
        visitMethodDclGeneric(node, typeExt, "");
        return null;
    }



    @Override
    public Object visit(ReferenceNode node) {
        IDNode id = node.GetId();
        codeBuilder.append(id.GetID());
        if(id._extension != null){
            codeBuilder.append(".get(");
            visit(id._extension);
            codeBuilder.append(')');
        }
        codeBuilder.append(";\n");
        return null;
    }

    @Override
    public Object visit(DotNode node) {
        codeBuilder.append(keywords.CLASS_ACCESS);
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

    @Override
    public Object visit(AssignNode node) {
        visit(node.GetLeftChild());
        codeBuilder.append(keywords.ASSIGN);
        visit(node.GetRightChild());
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
        for (Node n : node.GetChildren()) {
            visit(n);
        }
        return null;
    }

    @Override
    public Object visit(CollectionNode node) {

        return null;
    }

    @Override
    public Object visit(BoolLit node) {
        return null;
    }

    @Override
    public Object visit(BreakNode node) {
        return null;
    }

    @Override
    public Object visit(CoordLit node) {
        return null;
    }

    @Override
    public Object visit(ElseNode node) {
        return null;
    }

    @Override
    public Object visit(ExprNode node) {
        return null;
    }

    @Override
    public Object visit(IDNode node) {
        return null;
    }

    @Override
    public Object visit(IfNode node) {
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        return null;
    }

    @Override
    public Object visit(LoopNode node) {
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        return null;
    }

    @Override
    public Object visit(NumLit node) {
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        this.robotName = node._id;
        return null;
    }

    @Override
    public Object visit(ReturnNode node) {
        return null;
    }

    @Override
    public Object visit(SignalNode node) {
        return null;
    }

    @Override
    public Object visit(StringLit node) {
        return null;
    }
}

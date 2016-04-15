package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by Gedesnegl on 12-04-2016.
 */
public class DeclVisitor extends AbstractVisitor {
    @Override
    public Object visit(Node n) {
        return n.Accept(this);
    }

    @Override
    public Object visit(BoolDcl node) {
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        return null;
    }

    @Override
    public Object visit(DeclarationNode node) {
        return null;
    }

    @Override
    public Object visit(HearDcl node) {
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        return null;
    }

    @Override
    public Object visit(NumDcl node) {
        return null;
    }

    @Override
    public Object visit(ReferenceNode node) {
        return null;
    }

    @Override
    public Object visit(StringDcl node) {
        return null;
    }

    @Override
    public Object visit(ListDcl node) {
        return null;
    }

    @Override
    public Object visit(GreaterEqualNode node) {
        return null;
    }

    @Override
    public Object visit(LessEqualNode node) {
        return null;
    }

    @Override
    public Object visit(AndNode node) {
        return null;
    }

    @Override
    public Object visit(AssignNode node) {
        return null;
    }

    @Override
    public Object visit(DivNode node) {
        return null;
    }

    @Override
    public Object visit(GreaterNode node) {
        return null;
    }

    @Override
    public Object visit(IsNode node) {
        return null;
    }

    @Override
    public Object visit(LessNode node) {
        return null;
    }

    @Override
    public Object visit(MinusNode node) {
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        return null;
    }

    @Override
    public Object visit(NotNode node) {
        return null;
    }

    @Override
    public Object visit(OrNode node) {
        return null;
    }

    @Override
    public Object visit(PlusNode node) {
        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        return null;
    }

    @Override
    public Object visit(XandNode node) {
        return null;
    }

    @Override
    public Object visit(XorNode node) {
        return null;
    }

    @Override
    public Object visit(BlockNode node) {
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

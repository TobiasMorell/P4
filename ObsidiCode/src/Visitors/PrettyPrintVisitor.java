package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by Nete on 09-03-2016.
 */
public class PrettyPrintVisitor extends AbstractVisitor {
    @Override
    public Object visit(Node n) {
        return n.Accept(this);
    }

    @Override
    public Object visit(BoolDcl node) {
        Object lo, ro;

        lo = node.GetLeftChild().Accept(this);
        ro = node.GetRightChild().Accept(this);

        return lo.toString() + ", BoolDcl [" + ro.toString() + ']';
    }

    @Override
    public Object visit(CoordDcl node) {
        Object lo, ro;

        lo = node.GetLeftChild().Accept(this);
        ro = node.GetRightChild().Accept(this);

        return lo.toString() + ", CoordDcl [" + ro.toString() + ']';
    }

    @Override
    public Object visit(DeclarationNode node) {
        Object lo, ro;

        lo = node.GetLeftChild().Accept(this);
        ro = node.GetRightChild().Accept(this);

        return lo.toString() + ", DeclarationNode [" + ro.toString() + ']';
    }

    @Override
    public Object visit(HearDcl node) {
        Object lo;

        lo = node.GetLeftChild().Accept(this);

        return "HearDcl" + ", id: " + node.id + ", params: " + node.parameters + "body: " + lo;
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
    public Object visit(FuncNode node) {
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

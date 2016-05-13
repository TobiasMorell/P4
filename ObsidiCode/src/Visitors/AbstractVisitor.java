package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.*;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by morell on 4/10/16.
 */
public abstract class AbstractVisitor {
    public Object visit(Node n)
    {
        return n.Accept(this);
    }

    public abstract Object visit(BoolDcl node);
    public abstract Object visit(CoordDcl node);
    public abstract Object visit(HearDcl node);
    public abstract Object visit(MethodDcl node);
    public abstract Object visit(NumDcl node);
    public abstract Object visit(ReferenceNode node);
    public abstract Object visit(StringDcl node);
    public abstract Object visit(ListDcl node);
    public abstract Object visit(DotNode node);

    public abstract Object visit(GreaterEqualNode node);
    public abstract Object visit(LessEqualNode node);
    public abstract Object visit(AndNode node);
    public abstract Object visit(AssignNode node);
    public abstract Object visit(DivNode node);
    public abstract Object visit(GreaterNode node);
    public abstract Object visit(IsNode node);
    public abstract Object visit(LessNode node);
    public abstract Object visit(MinusNode node);
    public abstract Object visit(MultNode node);
    public abstract Object visit(NotNode node);
    public abstract Object visit(OrNode node);
    public abstract Object visit(PlusNode node);
    public abstract Object visit(UnaryMinusNode node);
    public abstract Object visit(XnorNode node);
    public abstract Object visit(XorNode node);
    public abstract Object visit(ParenNode node);

    public abstract Object visit(BlockNode node);
    public abstract Object visit(CollectionNode node);
    public abstract Object visit(BoolLit node);
    public abstract Object visit(BreakNode node);
    public abstract Object visit(CoordLit node);
    public abstract Object visit(ElseNode node);
    public abstract Object visit(ExprNode node);
    public abstract Object visit(IDNode node);
    public abstract Object visit(IfNode node);
    public abstract Object visit(LoadNode node);
    public abstract Object visit(LoopNode node);
    public abstract Object visit(MethodInvocationNode node);
    public abstract Object visit(NumLit node);
    public abstract Object visit(ProgNode node);
    public abstract Object visit(ReturnNode node);
    public abstract Object visit(SignalNode node);
    public abstract Object visit(StringLit node);

    protected void VisitChildren(Node n) {}
    protected void VisitChildren(BinaryNode n) {
        visit(n.GetLeftChild());
        visit(n.GetRightChild());
    }
    protected void VisitChildren(UnaryNode n) {
        visit(n.GetLeftChild());
    }
    protected void VisitChildren(NaryNode n) {
        for (Node node: n.GetChildren()) {visit(node);}
    }
    protected void VisitChildren(LeafNode n) {}
}

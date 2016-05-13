package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.*;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;


/**
 * Created by Gedesnegl on 15-04-2016.
 */
public class SemanticsVisitor extends AbstractVisitor {

    private int breakable;
    @Override
    public Object visit(DotNode node) {
        return null;
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
        if(node.GetLeftChild() instanceof ReferenceNode)
        {
            ((ReferenceNode) node.GetLeftChild()).set_isValue(true);
        }
        node.GetRightChild();

        return null;
    }

    @Override
    public Object visit(DivNode node) {

        if(node.GetLeftChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetLeftChild()).set_isValue(true);
        }
        else if(node.GetRightChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetRightChild()).set_isValue(true);
        }
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
        if(node.GetLeftChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetLeftChild()).set_isValue(true);
        }
        else if(node.GetRightChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetRightChild()).set_isValue(true);
        }
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        if(node.GetLeftChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetLeftChild()).set_isValue(true);
        }
        else if(node.GetRightChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetRightChild()).set_isValue(true);
        }
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
        if(node.GetLeftChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetLeftChild()).set_isValue(true);
        }
        else if(node.GetRightChild() instanceof ReferenceNode){
            ((ReferenceNode) node.GetRightChild()).set_isValue(true);
        }
        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        return null;
    }

    @Override
    public Object visit(XnorNode node) {
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
        if(breakable > 0){
            //Allow the break-node
        }
        else{
            //Throw exception, break not allowed since its not inside a loop or if
        }
        return null;
    }

    @Override
    public Object visit(CoordLit node) {
        return null;
    }

    @Override
    public Object visit(ElseNode node) {
        breakable++;
        visit(node.GetLeftChild());
        breakable--;
        return null;
    }

    @Override
    public Object visit(ExprNode node) {
        return null;
    }

    @Override
    public Object visit(ParenNode node) {
        return visit(node.GetLeftChild());
    }

    @Override
    public Object visit(IDNode node) {
        return null;
    }

    @Override
    public Object visit(IfNode node) {
        breakable++;
        visit(node.GetBody());
        breakable--;
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        return null;
    }

    @Override
    public Object visit(LoopNode node) {
        breakable++;
        visit(node.GetRightChild());
        breakable--;
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
        //Since the Prog Node is the beginning of the program it makes sense to initialize our breakable var here
        breakable = 0;
        //visit(node.GetLeftChild());
        VisitChildren(node);
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

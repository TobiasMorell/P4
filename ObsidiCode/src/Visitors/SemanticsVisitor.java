package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.LeafNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by Gedesnegl on 15-04-2016.
 */
public class SemanticsVisitor extends AbstractVisitor {


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

        }
        node.GetRightChild();

        return null;
    }

    @Override
    public Object visit(DivNode node) {
        Node.Type lhs = node.GetLeftChild().getT();
        Node.Type rhs = node.GetRightChild().getT();
        if(lhs == rhs && lhs == Node.Type.string){
            //Todo remove all instancees of rhs from lhs
            node.setT(Node.Type.string);
        }
        else if(lhs == rhs && lhs == Node.Type.num){
            node.setT(Node.Type.num);
        }
        else if(lhs == Node.Type.num && rhs == Node.Type.coord){
            node.setT(Node.Type.coord);
        }
        else if(lhs == rhs && lhs == Node.Type.bool){
            node.setT(Node.Type.bool);
        }
        else if(lhs == Node.Type.coord && rhs == Node.Type.num){
            node.setT(Node.Type.coord);
        }

        else if(lhs == rhs && lhs == Node.Type.coord){
            node.setT(Node.Type.coord);
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
        Node.Type lhs   = node.GetLeftChild().getT();
        Node.Type rhs   = node.GetRightChild().getT();
        if(lhs == rhs && lhs == Node.Type.string){
            //Todo remove all instances of rhs from lhs
            node.setT(Node.Type.string);
        }
        else if(lhs == rhs && lhs == Node.Type.num){
            //Todo standard minus operation
            node.setT(Node.Type.num);
        }
        else if(lhs == rhs && lhs == Node.Type.bool){
            //Todo similar to boolean exclusive-or
            node.setT(Node.Type.bool);
        }
        else if(lhs == rhs && lhs == Node.Type.coord){
            //Todo (x1-x2,y1-y2,z1-z2)
            node.setT(Node.Type.coord);
        }
        else {
            //Todo illegal combination of types
        }
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        Node.Type lhs = node.GetLeftChild().getT();
        Node.Type rhs = node.GetRightChild().getT();
        if(lhs == Node.Type.string && rhs == Node.Type.string){
            //Todo Create a string with
            node.setT(Node.Type.string);
        }
        if(lhs == Node.Type.string && rhs == Node.Type.num){
            //Todo repeat string lhs equal to the rhs
            node.setT(Node.Type.string);
        }
        if(lhs == Node.Type.num && rhs == Node.Type.num){
            //Todo standard mult
            node.setT(Node.Type.num);
        }
        if(lhs == Node.Type.num && rhs == Node.Type.coord){
            //Todo (rhs.x * lhs,rhs.y * lhs, rhs.z * lhs)
            node.setT(Node.Type.coord);
        }
        if(lhs == Node.Type.bool && rhs == Node.Type.bool){
            //Todo Boolean and
            node.setT(Node.Type.bool);
        }
        if(lhs == Node.Type.coord&& rhs == Node.Type.num){
            //Todo (lhs.x+rhs,lhs.y+rhs,lhs.z+rhs)
            node.setT(Node.Type.coord);
        }
        if(lhs == Node.Type.coord&& rhs == Node.Type.coord){
            //Todo (lhs.x*rhs.x,lhs.y*rhs.y,lhs.z*rhs.z)
            node.setT(Node.Type.coord);
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
        Node lhs = node.GetLeftChild();
        Node rhs = node.GetRightChild();

        if( lhs.isType(Node.Type.string) && rhs.isType(Node.Type.string)){
            //Todo Concatenate rhs to lhs
            node.setT(Node.Type.string);
        }
        else if(lhs.isType(Node.Type.string) && rhs.isType(Node.Type.num)){
            //Todo Concatenate rhs.ToString concatenated to lhs
            node.setT(Node.Type.string);
        }
        else if(lhs.isType(Node.Type.string) && rhs.isType(Node.Type.bool)){
            //Todo Boolean literal to String concatenated to lhs
            node.setT(Node.Type.string);
        }
        else if(lhs.isType(Node.Type.string) && rhs.isType(Node.Type.coord)){
            //Todo Coord toString (x, y ,z) concatenated to lhs
            node.setT(Node.Type.string);
        }
        else if(lhs.isType(Node.Type.num) && rhs.isType(Node.Type.string)){
            //Todo num toString concatenated to start of rhs
            node.setT(Node.Type.string);
        }
        else if(lhs.isType(Node.Type.num) && rhs.isType(Node.Type.num)){
            //num + num result is a num
            node.setT(Node.Type.num);
        }
        else if(lhs.isType(Node.Type.num) && rhs.isType(Node.Type.coord)){
            //Todo add the num to each coord (x +a,y+a,z+a) resulting in a coord
            node.setT(Node.Type.coord);
        }
        else if(lhs.isType(Node.Type.bool) && rhs.isType(Node.Type.string)){
            //Todo Bool literal concatenated to start of rhs
            node.setT(Node.Type.string);
        }
        else if(lhs.isType(Node.Type.bool) && rhs.isType(Node.Type.bool)){
            //Todo Similar to boolean or - whatever that means :) type is bool
            node.setT(Node.Type.bool);
        }
        else if(lhs.isType(Node.Type.coord) && rhs.isType(Node.Type.string)){
            //Todo coord toString to start of rhs
            node.setT(Node.Type.string);
        }
        else if(lhs.isType(Node.Type.coord) && rhs.isType(Node.Type.num)){
            //Todo (x+rhs,y+rhs,z+rhs)
            node.setT(Node.Type.coord);
        }
        else if(lhs.isType(Node.Type.coord) && rhs.isType(Node.Type.coord)){
            //(x1+x2,y1+y2,z1+z2) type coord
            node.setT(Node.Type.coord);
        }
        else {
            //Todo Throw exception since the combination of types is illegal
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

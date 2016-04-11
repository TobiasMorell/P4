package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class IsNode extends ExprNode {
    public IsNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

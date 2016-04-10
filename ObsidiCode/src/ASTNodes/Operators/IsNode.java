package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class IsNode extends BinaryNode {
    public IsNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

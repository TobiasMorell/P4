package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class OrNode extends BinaryNode {
    public OrNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
        t = Type.bool;
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.Visitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class OrNode extends BinaryNode {
    @Override
    public Object Visit(Visitor v) {
        return null;
    }

    public OrNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
        t = Type.bool;
    }
}

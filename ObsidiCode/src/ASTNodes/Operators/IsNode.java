package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.Visitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class IsNode extends BinaryNode {
    @Override
    public Object Visit(Visitor v) {
        return null;
    }

    public IsNode(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
        t = Type.bool;
    }
}

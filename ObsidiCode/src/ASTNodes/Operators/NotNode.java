package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class NotNode extends BinaryNode {
    public NotNode(Node child, Node rightChild) {
        super(child, rightChild);
        t = Type.bool;
    }
}

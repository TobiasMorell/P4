package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class StringDcl extends DclNode {
    public StringDcl(Node leftChild, Node rightChild) {
        super(Type.string, (IDNode)leftChild, rightChild);
    }

    public StringDcl(String id, Node rightChild)
    {
        super(Type.string, new IDNode(id), rightChild);
    }
}

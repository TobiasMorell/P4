package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class BoolDcl extends DclNode {

    public BoolDcl(Node leftChild, Node rightChild) {
        super(Type.bool, (IDNode)leftChild, rightChild);
    }
    
    public BoolDcl(String id, Node rightChild)
    {
    	super(Type.bool, new IDNode(id), rightChild);
    }
}

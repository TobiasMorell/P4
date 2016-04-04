package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.IDNode;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class BoolDcl extends BinaryNode {
    public BoolDcl(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }
    
    public BoolDcl(String id, Node rightChild)
    {
    	super(new IDNode(id), rightChild);
    }
}

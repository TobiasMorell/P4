package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.IDNode;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class StringDcl extends BinaryNode {
    public StringDcl(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }
    
    public StringDcl(String id, Node rightChild)
    {
    	super(new IDNode(id), rightChild);
    }
}

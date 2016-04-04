package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.IDNode;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class CoordDcl extends BinaryNode {
    public CoordDcl(Node leftChild, Node rightChild) {
        super(leftChild, rightChild);
    }
    
    public CoordDcl(String id, Node rightChild)
    {
    	super(new IDNode(id), rightChild);
    }
}

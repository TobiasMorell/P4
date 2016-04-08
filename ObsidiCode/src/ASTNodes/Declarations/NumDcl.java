package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class NumDcl extends DclNode {
	public NumDcl(Node leftChild, Node rightChild) {
		super(Type.num, (IDNode)leftChild, rightChild);
	}

	public NumDcl(String id, Node rightChild)
	{
		super(Type.num, new IDNode(id), rightChild);
	}
}

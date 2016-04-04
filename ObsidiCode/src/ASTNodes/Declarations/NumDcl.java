package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.IDNode;

/**
 * Created by Gedesnegl on 22-03-2016.
 */
public class NumDcl extends BinaryNode{
	public NumDcl(String identifier, Node rightChild) {
		super(new IDNode(identifier), rightChild);
	}
	
	public NumDcl(Node leftNode, Node rightNode)
	{
		super(leftNode, rightNode);
	}
}

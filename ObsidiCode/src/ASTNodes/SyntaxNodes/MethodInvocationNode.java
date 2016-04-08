package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;

public class MethodInvocationNode extends BinaryNode {

	public MethodInvocationNode(IDNode leftChild, BlockNode rightChild) {
		super(leftChild, rightChild);
	}

}

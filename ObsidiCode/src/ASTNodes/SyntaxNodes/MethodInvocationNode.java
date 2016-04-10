package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;
import Visitors.AbstractVisitor;

public class MethodInvocationNode extends BinaryNode {

	public MethodInvocationNode(IDNode leftChild, BlockNode rightChild) {
		super(leftChild, rightChild);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

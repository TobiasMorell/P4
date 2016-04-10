package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

public class LessNode extends BinaryNode {

	public LessNode(Node leftChild, Node rightChild) {
		super(leftChild, rightChild);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

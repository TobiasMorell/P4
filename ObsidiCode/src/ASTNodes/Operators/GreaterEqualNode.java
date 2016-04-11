package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

public class GreaterEqualNode extends ExprNode {

	public GreaterEqualNode(Node leftChild, Node rightChild) {
		super(leftChild, rightChild);
		t = Type.bool;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

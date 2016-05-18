package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

public class LessNode extends ExprNode {

	public LessNode(Node leftChild, Node rightChild) {
		super(leftChild, rightChild);
		type = Type.bool;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

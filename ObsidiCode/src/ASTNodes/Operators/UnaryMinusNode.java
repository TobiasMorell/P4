package ASTNodes.Operators;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import Visitors.AbstractVisitor;

public class UnaryMinusNode extends UnaryNode {

	public UnaryMinusNode(Node child) {
		super(child);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

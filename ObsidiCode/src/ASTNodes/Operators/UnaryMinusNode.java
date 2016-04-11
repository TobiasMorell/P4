package ASTNodes.Operators;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

public class UnaryMinusNode extends ExprNode {

	public UnaryMinusNode(Node child) {
		super(child, null);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

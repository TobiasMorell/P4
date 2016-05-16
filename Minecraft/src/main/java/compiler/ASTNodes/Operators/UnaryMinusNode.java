package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.GeneralNodes.UnaryNode;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.Visitors.AbstractVisitor;

public class UnaryMinusNode extends ExprNode {

	public UnaryMinusNode(Node child) {
		super(child, null);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

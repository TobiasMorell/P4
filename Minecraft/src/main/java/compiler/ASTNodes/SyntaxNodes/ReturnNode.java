package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.GeneralNodes.UnaryNode;
import compiler.Visitors.AbstractVisitor;

public class ReturnNode extends UnaryNode {

	public ReturnNode(ExprNode child) {
		super(child);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

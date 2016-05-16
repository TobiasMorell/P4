package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.UnaryNode;
import compiler.Visitors.AbstractVisitor;

public class ElseNode extends UnaryNode {

	public ElseNode(BlockNode body) {
		super(body);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

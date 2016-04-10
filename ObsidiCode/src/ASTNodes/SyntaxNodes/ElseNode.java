package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.UnaryNode;
import Visitors.AbstractVisitor;

public class ElseNode extends UnaryNode {

	public ElseNode(BlockNode body) {
		super(body);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

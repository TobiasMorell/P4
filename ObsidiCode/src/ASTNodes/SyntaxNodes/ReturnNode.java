package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import Visitors.AbstractVisitor;

public class ReturnNode extends UnaryNode {

	public ReturnNode(Node child) {
		super(child);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

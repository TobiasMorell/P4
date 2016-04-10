package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;
import Visitors.AbstractVisitor;

public class SignalNode extends BinaryNode {

	public SignalNode(IDNode id, BlockNode args) {
		super(id, args);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}

}

package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.CollectionNode;
import Visitors.AbstractVisitor;

public class SignalNode extends BinaryNode {

	public SignalNode(IDNode id, CollectionNode args) {
		super(id, args);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}

}

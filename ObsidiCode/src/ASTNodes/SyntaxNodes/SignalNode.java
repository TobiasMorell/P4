package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.CollectionNode;
import Visitors.AbstractVisitor;

public class SignalNode extends BinaryNode {

	public SignalNode(String id, CollectionNode args) {
		super(null, args);
		this.SetLeftmostNode(new IDNode(id, this));
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}

}

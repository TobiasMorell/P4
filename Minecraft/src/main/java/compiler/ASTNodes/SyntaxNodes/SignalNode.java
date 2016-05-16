package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.CollectionNode;
import compiler.Visitors.AbstractVisitor;

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

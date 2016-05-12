package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.LeafNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.ExprNode;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

public class ReferenceNode extends LeafNode {
	IDNode referencedIdentifier;
	private boolean _isValue;
	public boolean _GlobalRef = false;

	public void set_isValue(boolean _isValue) {
		this._isValue = _isValue;
	}

	public IDNode GetId()
	{
		return referencedIdentifier;
	}
	
	public ReferenceNode(String id) {
		this.referencedIdentifier = new IDNode(id, this);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

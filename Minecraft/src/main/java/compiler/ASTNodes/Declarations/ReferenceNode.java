package compiler.ASTNodes.Declarations;

import compiler.ASTNodes.GeneralNodes.LeafNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.GeneralNodes.UnaryNode;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.ASTNodes.SyntaxNodes.IDNode;
import compiler.Visitors.AbstractVisitor;
import compiler.Visitors.Visitable;

public class ReferenceNode extends LeafNode {
	IDNode referencedIdentifier;
	private boolean _isValue = true;
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

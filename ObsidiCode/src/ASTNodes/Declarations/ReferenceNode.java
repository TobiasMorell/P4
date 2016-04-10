package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

public class ReferenceNode extends UnaryNode {

	public IDNode GetId()
	{
		return (IDNode) this._leftmostChild;
	}
	
	public ReferenceNode(String id) {
		super(new IDNode(id));
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

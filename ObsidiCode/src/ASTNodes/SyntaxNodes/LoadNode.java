package ASTNodes.SyntaxNodes;

import java.util.ArrayList;

import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

public class LoadNode extends NaryNode {

	public LoadNode()
	{
		super(new ArrayList<Node>());
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}

}

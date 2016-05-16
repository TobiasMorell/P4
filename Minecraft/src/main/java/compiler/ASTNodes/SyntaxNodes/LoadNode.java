package compiler.ASTNodes.SyntaxNodes;

import java.util.ArrayList;

import compiler.ASTNodes.GeneralNodes.NaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.Visitors.AbstractVisitor;

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

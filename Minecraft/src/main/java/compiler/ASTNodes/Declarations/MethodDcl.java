package compiler.ASTNodes.Declarations;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.GeneralNodes.UnaryNode;
import compiler.ASTNodes.SyntaxNodes.BlockNode;
import compiler.Visitors.AbstractVisitor;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class MethodDcl extends UnaryNode {
	public ArrayList<Node> parameters;
	public String id;

	public void AddBody(BlockNode body)
	{
		this._leftmostChild = body;
		body._parent = this;
	}

	public MethodDcl(String id, ArrayList<Node> params, Type t, BlockNode body)
	{
		super(body);
		this.parameters = params;
		this.type = t;
		this.id = id;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

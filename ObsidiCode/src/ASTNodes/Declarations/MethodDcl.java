package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.AbstractVisitor;
import Visitors.Visitable;
import org.antlr.v4.codegen.model.decl.Decl;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class MethodDcl extends UnaryNode {
	public ArrayList<Node> parameters;
	public Type type;
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

package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.NaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.Visitors.AbstractVisitor;

import java.util.ArrayList;

public class MethodInvocationNode extends NaryNode {

	public MethodInvocationNode(IDNode leftChild, ArrayList<Node> args) {
		super(args);
		this._leftmostChild = leftChild;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

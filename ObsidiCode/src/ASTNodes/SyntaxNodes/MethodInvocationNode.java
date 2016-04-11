package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

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

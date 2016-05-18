package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.Visitors.AbstractVisitor;

public class GreaterEqualNode extends ExprNode {

	public GreaterEqualNode(Node leftChild, Node rightChild) {
		super(leftChild, rightChild);
		type = Type.bool;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

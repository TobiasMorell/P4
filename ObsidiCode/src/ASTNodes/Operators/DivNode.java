package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

public class DivNode extends ExprNode {
	public DivNode(Node left, Node right){
		super(left,right);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
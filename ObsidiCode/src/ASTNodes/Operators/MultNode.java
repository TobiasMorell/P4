package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

public class MultNode extends ExprNode {
	public MultNode(Node left, Node right){
		super(left, right);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
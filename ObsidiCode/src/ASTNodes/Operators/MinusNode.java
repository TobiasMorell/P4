package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

public class MinusNode extends ExprNode{
	public MinusNode(Node left, Node right){
		super(left,right);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
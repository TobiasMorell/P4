package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.*;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.Visitors.AbstractVisitor;

public class DivNode extends ExprNode {
	public DivNode(Node left, Node right){
		super(left,right);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
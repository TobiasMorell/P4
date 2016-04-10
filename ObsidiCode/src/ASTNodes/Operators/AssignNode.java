package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import ASTNodes.SyntaxNodes.ExprNode;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.AbstractVisitor;

public class AssignNode extends BinaryNode{
	public AssignNode(IDNode id, ExprNode expr){
		super(id,expr);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.*;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.ASTNodes.SyntaxNodes.IDNode;
import compiler.Visitors.AbstractVisitor;

public class AssignNode extends BinaryNode{
	public AssignNode(Node lhs, Node rhs){
		super(lhs,rhs);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import ASTNodes.SyntaxNodes.ExprNode;
import ASTNodes.SyntaxNodes.IDNode;

public class AssignNode extends BinaryNode{
	public AssignNode(IDNode id, ExprNode expr){
		super(id,expr);
	}
}
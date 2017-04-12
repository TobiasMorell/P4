package org.AST;

import org.AST.SyntaxNodes;
import org.AST.GeneralNodes;

public class AssignNode extends BinaryNode{
	public AssignNode(IDNode id, ExpressionNode expr){
		this.leftmostchild = id;
		this.rightChild = expr;
	}
}
package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import ASTNodes.SyntaxNodes.IDNode;

public class AssignNode extends BinaryNode{
	public AssignNode(IDNode id, Node expr){
		super(id,expr);
	}
}
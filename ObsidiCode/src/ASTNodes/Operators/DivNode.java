package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import Visitors.AbstractVisitor;

public class DivNode extends BinaryNode{
	public DivNode(Node left, Node right){
		super(left,right);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
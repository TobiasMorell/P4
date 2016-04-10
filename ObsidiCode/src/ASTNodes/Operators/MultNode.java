package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import Visitors.AbstractVisitor;

public class MultNode extends BinaryNode{
	public MultNode(Node left, Node right){
		super(left, right);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
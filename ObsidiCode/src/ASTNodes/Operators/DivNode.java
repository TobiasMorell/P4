package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import Visitors.Visitor;

public class DivNode extends BinaryNode{
	public DivNode(Node left, Node right){
		super(left,right);

	}

	@Override
	public Object Visit(Visitor v) {
		return null;
	}
}
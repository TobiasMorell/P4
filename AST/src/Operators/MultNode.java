package Operators;

import GeneralNodes.*;
import Visitors.Visitor;

public class MultNode extends BinaryNode{
	public MultNode(Node left, Node right){
		super(left, right);
	}

	@Override
	public Object Visit(Visitor v) {
		return null;
	}
}
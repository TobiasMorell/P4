package Operators;

import GeneralNodes.*;
import Visitors.Visitor;

public class MinusNode extends BinaryNode{
	public MinusNode(Node left, Node right){
		super(left,right);
	}

	@Override
	public Object Visit(Visitor v) {
		return null;
	}
}
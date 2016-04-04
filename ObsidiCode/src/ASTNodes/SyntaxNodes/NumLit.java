package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;
import Visitors.Visitor;

public class NumLit extends LeafNode{
	private String _value;
	public NumLit(String val){
		this._value = val;
	}

	@Override
	public Object Visit(Visitor v) {
		return null;
	}
}
package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;
import Visitors.AbstractVisitor;

public class NumLit extends LeafNode{
	public float _value;
	public NumLit(float val){
		this._value = val;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
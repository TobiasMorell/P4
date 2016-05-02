package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;
import Visitors.AbstractVisitor;

public class NumLit extends ExprNode{
	public float _value;
	public NumLit(float val){
		super(null, null);
		this._value = val;
		type = Type.num;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}
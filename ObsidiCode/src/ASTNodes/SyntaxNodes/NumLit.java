package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

public class NumLit extends LeafNode{
	private float _value;
	public NumLit(float val){
		this._value = val;
	}
}
package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

public class NumLit extends LeafNode{
	private String _value;
	public NumLit(String val){
		this._value = val;
	}
}
package org.AST;

public class ValueNode extends UnaryNode{
	private String value;
	public ValueNode(String val){
		this.value = val;
	}
}
package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;
import Visitors.AbstractVisitor;

public class StringLit extends LeafNode {
	private String text;
	
	public StringLit(String spelling)
	{
		this.text = spelling;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

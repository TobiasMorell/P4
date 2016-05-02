package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;
import Visitors.AbstractVisitor;

public class StringLit extends ExprNode {
	public String text;
	
	public StringLit(String spelling)
	{
		super(null,null);
		this.text = spelling;
		type = Type.string;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

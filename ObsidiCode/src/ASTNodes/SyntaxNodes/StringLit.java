package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;

public class StringLit extends LeafNode {
	private String text;
	
	public StringLit(String spelling)
	{
		this.text = spelling;
	}

}

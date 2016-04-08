package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;

public class ReturnNode extends UnaryNode {

	public ReturnNode(ExprNode child) {
		super(child);
	}

}

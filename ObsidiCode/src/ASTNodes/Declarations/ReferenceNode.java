package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.IDNode;

public class ReferenceNode extends UnaryNode {

	public ReferenceNode(String id) {
		super(new IDNode(id));
		// TODO Auto-generated constructor stub
	}

}

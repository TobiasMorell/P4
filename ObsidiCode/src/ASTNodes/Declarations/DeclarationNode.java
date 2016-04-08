package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.IDNode;

public class DeclarationNode extends BinaryNode {

	public DeclarationNode(IDNode leftChild, BlockNode rightChild) {
		super(leftChild, rightChild);
	}

}

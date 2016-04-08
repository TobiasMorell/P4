package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;

public class HearDcl extends BinaryNode {

	public HearDcl(DeclarationNode leftChild, BlockNode rightChild) {
		super(leftChild, rightChild);
	}

}

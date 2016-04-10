package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

public class HearDcl extends BinaryNode {

	public HearDcl(DeclarationNode leftChild, BlockNode rightChild) {
		super(leftChild, rightChild);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

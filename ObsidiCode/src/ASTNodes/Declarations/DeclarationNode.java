package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

public class DeclarationNode extends BinaryNode{

	public DeclarationNode(IDNode leftChild, BlockNode rightChild) {
		super(leftChild, rightChild);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

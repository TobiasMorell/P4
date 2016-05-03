package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.ExprNode;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

public class DeclarationNode extends BinaryNode{

	public Type type;

	public DeclarationNode(Type t, IDNode leftChild, Node rightChild) {
		super(leftChild, rightChild);
		type = t;
	}

	public String GetID(){
		return ((IDNode)GetLeftChild())._id;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

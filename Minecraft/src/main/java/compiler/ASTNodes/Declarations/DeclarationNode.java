package compiler.ASTNodes.Declarations;

import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.BlockNode;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.ASTNodes.SyntaxNodes.IDNode;
import compiler.Visitors.AbstractVisitor;
import compiler.Visitors.Visitable;

public class DeclarationNode extends BinaryNode{

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

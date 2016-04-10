package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class ExprNode extends BinaryNode{

	public ExprNode(ExprNode leftChild, ExprNode rightChild) {
		super(leftChild, rightChild);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

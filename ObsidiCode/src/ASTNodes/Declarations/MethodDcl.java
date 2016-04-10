package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class MethodDcl extends BinaryNode {

	public MethodDcl(Node leftChild, Node rightChild) {
		super(leftChild, rightChild);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

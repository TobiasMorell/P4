package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

import java.util.ArrayList;

public class HearDcl extends MethodDcl {

	public HearDcl(String id, ArrayList<Node> params, BlockNode body) {
		super(id, params, Type.Void, body);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
}

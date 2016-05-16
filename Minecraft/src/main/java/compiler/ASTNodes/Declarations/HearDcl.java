package compiler.ASTNodes.Declarations;

import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.BlockNode;
import compiler.Visitors.AbstractVisitor;
import compiler.Visitors.Visitable;

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

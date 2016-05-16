package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.LeafNode;
import compiler.Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class BoolLit extends ExprNode {
	public String value;
	public BoolLit(String spelling) {
		super(null, null);
		this.value = spelling;
		type = Type.bool;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
    
}

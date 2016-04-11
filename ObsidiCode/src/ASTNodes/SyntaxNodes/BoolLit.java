package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class BoolLit extends ExprNode {
	public String value;
	public BoolLit(String spelling) {
		super(null, null);
		this.value = spelling;
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
    
}

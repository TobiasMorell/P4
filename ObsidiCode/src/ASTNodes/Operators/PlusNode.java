package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

/**
 * Created by Nete on 09-03-2016.
 */
public class PlusNode extends ExprNode {
    public PlusNode(Node left, Node right)
    {
        super(left, right);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

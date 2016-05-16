package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.*;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.Visitors.AbstractVisitor;

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

package ASTNodes.Operators;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.ExprNode;
import Visitors.AbstractVisitor;

/**
 * Created by morell on 5/13/16.
 */
public class ParenNode extends UnaryNode {
    public ParenNode (Node expr)
    {
        super (expr);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

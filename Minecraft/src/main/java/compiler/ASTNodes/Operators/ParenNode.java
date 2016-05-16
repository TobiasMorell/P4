package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.GeneralNodes.UnaryNode;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.Visitors.AbstractVisitor;

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

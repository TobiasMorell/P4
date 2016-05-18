package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;
import Visitors.AbstractVisitor;

/**
 * Created by morell on 3/31/16.
 */
public class LoopNode extends BinaryNode{
    public LoopNode(Node condition, BlockNode stmts){
        super(condition, stmts);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

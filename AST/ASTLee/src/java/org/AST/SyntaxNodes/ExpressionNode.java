package org.AST.SyntaxNodes;

import org.AST.GeneralNodes.BinaryNode;
import org.AST.GeneralNodes.Node;
import org.Visitors.Visitor;

/**
 * Created by Nete on 09-03-2016.
 */
public class ExpressionNode extends BinaryNode{
    public ExpressionNode (Node left, Node right)
    {
        super(left, right);
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }
}

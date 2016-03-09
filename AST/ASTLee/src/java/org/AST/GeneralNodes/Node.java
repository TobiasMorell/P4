package org.AST.GeneralNodes;

import org.Visitors.Visitor;

public abstract class Node
{
    public Node _parent;
    protected Node _leftmostChild;

    public Node GetLeftChild()
    {
        return _leftmostChild;
    }

    public abstract Object Visit(Visitor v);
}

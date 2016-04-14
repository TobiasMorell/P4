package ASTNodes.GeneralNodes;

import Visitors.Visitable;

public abstract class Node implements Visitable
{
    public enum Type{
        num, string, coord, bool, Void, List
    }
    public Node _parent;
    protected Node _leftmostChild;

    public Node GetLeftChild()
    {
        return _leftmostChild;
    }
}

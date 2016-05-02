package ASTNodes.GeneralNodes;

import Visitors.Visitable;

public abstract class Node implements Visitable
{
    public enum Type {
        num, string, coord, bool, Void, List, unknown
    }
    public Node _parent;
    protected Node _leftmostChild;

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }

    protected Type t;

    public Node GetLeftChild()
    {
        return _leftmostChild;
    }

    public boolean isType(Type t) {
        return this.t == t;
    }

}

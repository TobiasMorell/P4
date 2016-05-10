package ASTNodes.GeneralNodes;

import Visitors.BuildASTVisitor;
import Visitors.Visitable;

public abstract class Node implements Visitable
{
    public int line;
    public Node(){
        line = BuildASTVisitor.line;
    }
    public enum Type {
        num, string, coord, bool, Void, List, unknown
    }
    public Type type;
    public Node _parent;
    protected Node _leftmostChild;

    public Type getT() {
        return type;
    }

    public void setT(Type t) {
        this.type = t;
    }

    public Node GetLeftChild()
    {
        return _leftmostChild;
    }

    public boolean isType(Type t) {
        return this.type == t;
    }

}

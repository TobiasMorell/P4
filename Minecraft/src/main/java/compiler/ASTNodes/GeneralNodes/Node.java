package compiler.ASTNodes.GeneralNodes;

import compiler.Visitors.BuildASTVisitor;
import compiler.Visitors.Visitable;

public abstract class Node implements Visitable
{
    public int line;
    public Node(){
        line = BuildASTVisitor.line;
    }
    public enum Type {
        num, string, Coord, bool, Void, List
    }
    protected Type type;
    public Node _parent;
    protected Node _leftmostChild;

    public final Type getT() {
        return this.type;
    }

    public final void setT(Type t) {
        this.type = t;
    }

    public final Node GetLeftChild()
    {
        return _leftmostChild;
    }

    public final boolean isType(Type t) {
        return this.type == t;
    }

}

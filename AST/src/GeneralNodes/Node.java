package GeneralNodes;

public abstract class Node
{
    public enum Type{
        num, string, coord, bool
    }
    public Node _parent;
    protected Node _leftmostChild;

    public Node GetLeftChild()
    {
        return _leftmostChild;
    }

    public abstract Object Visit(Visitors.Visitor v);
}

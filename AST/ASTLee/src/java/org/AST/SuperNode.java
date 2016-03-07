package org.AST;

public abstract class SuperNode
{
    protected String _nodeName;
    public Node _parent;

    public  Node _leftmost;
    public Node _rightmost;
    
    public Node _leftSibling;
    public Node _rightSibling;

    public SuperNode (String nodeName)
    {
        _nodeName = nodeName;
    }
}

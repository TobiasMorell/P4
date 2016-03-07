package org.AST;

public class Node extends SuperNode
{
    public Node (String nodeName, Node parent)
    {
        super(nodeName);
        _parent = parent;
    }

    @Override
    public String toString()
    {
        return _nodeName;
    }
}

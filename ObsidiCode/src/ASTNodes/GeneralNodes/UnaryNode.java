package ASTNodes.GeneralNodes;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class UnaryNode extends Node {
    public UnaryNode (Node child)
    {
        this._leftmostChild = child;
        if (child != null)
            child._parent = this;
    }
}

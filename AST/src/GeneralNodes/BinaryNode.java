package GeneralNodes;

import Visitors.Visitor;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class BinaryNode extends Node {
    protected Node rightChild;
    protected Type t;

    public Node GetRightChild()
    {
        return rightChild;
    }

    public BinaryNode (Node leftChild, Node rightChild){
        this._leftmostChild = leftChild;
        this.rightChild =  rightChild;
        leftChild._parent = this;
        rightChild._parent = this;
    }
}

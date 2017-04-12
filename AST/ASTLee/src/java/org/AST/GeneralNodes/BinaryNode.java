package org.AST.GeneralNodes;

import org.Visitors.Visitor;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class BinaryNode extends Node {
    protected Node rightChild;

    public Node GetRightChild()
    {
        return rightChild;
    }

    public BinaryNode (Node leftChild, Node rightChild){
        this._leftmostChild = leftChild;
        this.rightChild =  rightChild;
    }
}

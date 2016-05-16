package compiler.ASTNodes.GeneralNodes;

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
    
    public void SetLeftmostNode(Node n)
    {
    	this._leftmostChild = n;
    }

    public BinaryNode (Node leftChild, Node rightChild){
        this._leftmostChild = leftChild;
        this.rightChild =  rightChild;
        if(leftChild != null) leftChild._parent = this;
        if(rightChild != null) rightChild._parent = this;
    }
}

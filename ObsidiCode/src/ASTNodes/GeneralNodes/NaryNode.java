package ASTNodes.GeneralNodes;

import java.util.ArrayList;
import ASTNodes.GeneralNodes.Node;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class NaryNode extends Node {
    protected ArrayList<Node> children;

    public NaryNode(ArrayList<Node> childNodes)
    {
        for (int i = 0; i < childNodes.size(); i++) {
            Node n = childNodes.get(i);
            n._parent = this;
        }

        //childNodes must be ordered in left to right appearance in tree
        this._leftmostChild = childNodes.get(0);

        childNodes.remove(0);
        this.children = childNodes;
    }
    
    public void AddNode(Node n)
    {
    	if(children != null)
    		children.add(n);
    	else {
    		children = new ArrayList<Node>();
    		children.add(n);
    	}
    }
}

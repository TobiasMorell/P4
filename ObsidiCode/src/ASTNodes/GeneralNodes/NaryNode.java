package ASTNodes.GeneralNodes;

import java.util.ArrayList;
import java.util.List;

import ASTNodes.GeneralNodes.Node;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class NaryNode extends Node {
    protected List<Node> children;

    public NaryNode(List<Node> childNodes)
    {
        for (int i = 0; i < childNodes.size(); i++) {
            Node n = childNodes.get(i);
            n._parent = this;
        }

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

    public ArrayList<Node> GetChildren(){
        return children;
    }
}

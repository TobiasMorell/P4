package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

import java.util.ArrayList;

public class BlockNode extends NaryNode{
	
	public ArrayList<Node> GetStatements()
	{
		return this.children;
	}

    public BlockNode(ArrayList<Node> stmts){
        super(stmts);
    }
    
    public BlockNode()
    {
    	super(new ArrayList<Node>());
    }
    
    public BlockNode(String id, ArrayList<Node> stmts)
    {
    	super(stmts);
    	this._leftmostChild = new IDNode(id);
    }
}
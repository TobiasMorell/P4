package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

import java.util.ArrayList;
import java.util.List;

public class BlockNode extends NaryNode{
	
	public List<Node> GetStatements()
	{
		return this.children;
	}

    public BlockNode(List<Node> stmts){
        super(stmts);
    }
    
    public BlockNode()
    {
    	super(new ArrayList<Node>());
    }
    
    public BlockNode(String id, List<Node> stmts)
    {
    	super(stmts);
    	this._leftmostChild = new IDNode(id);
    }
}
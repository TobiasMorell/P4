package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;
import Visitors.AbstractVisitor;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
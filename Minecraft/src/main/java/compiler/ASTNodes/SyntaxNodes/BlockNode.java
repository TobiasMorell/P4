package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.*;
import compiler.Visitors.AbstractVisitor;

import java.util.ArrayList;
import java.util.List;

public class BlockNode extends NaryNode{
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
    	this._leftmostChild = new IDNode(id, this);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
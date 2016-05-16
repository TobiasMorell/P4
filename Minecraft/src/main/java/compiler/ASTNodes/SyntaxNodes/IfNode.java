package compiler.ASTNodes.SyntaxNodes;

import java.util.ArrayList;

import compiler.ASTNodes.Declarations.ReferenceNode;
import compiler.ASTNodes.GeneralNodes.NaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.Visitors.AbstractVisitor;

/**
 * Created by morell on 3/31/16.
 */
public class IfNode extends NaryNode{

	public BlockNode GetBody()
	{
		for(Node n : children)
		{
			if(n instanceof BlockNode)
				return (BlockNode) n;
		}
		
		return null;
	}
	
	public IfNode GetElseIf()
	{
		for(Node n : children)
		{
			if(n instanceof IfNode)
				return (IfNode) n;
		}
		
		return null;
	}
	
	public Node GetCondition()
	{
		for(Node n : children)
		{
			if(n instanceof ExprNode)
				return n;
			else if (n instanceof ReferenceNode)
				return n;
		}
		
		return null;
	}
	
	public ElseNode GetElse()
	{
		for(Node n : children)
		{
			if(n instanceof ElseNode)
				return (ElseNode) n;
		}
		
		return null;
	}
	
	public IfNode(ArrayList<Node> childNodes) {
		super(childNodes);
	}

	@Override
	public Object Accept(AbstractVisitor v) {
		return v.visit(this);
	}
	
}

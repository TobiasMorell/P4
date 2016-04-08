package ASTNodes.SyntaxNodes;

import java.util.ArrayList;

import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;

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
	
	public ExprNode GetCondition()
	{
		for(Node n : children)
		{
			if(n instanceof ExprNode)
				return (ExprNode) n;
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
		// TODO Auto-generated constructor stub
	}
	
}

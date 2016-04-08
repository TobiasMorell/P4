package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

public class IDNode extends LeafNode{
    private String _id;
    private ExprNode _extension;
    
    public IDNode(String identifier){
        this._id = identifier;
    }
    public String GetID(){return _id;}
    
    public IDNode(String identifier, ExprNode extension)
    {
    	this._id = identifier;
    	this._extension = extension;
    }
    
    public void AddExtension(ExprNode ext)
    {
    	_extension = ext;
    }
}
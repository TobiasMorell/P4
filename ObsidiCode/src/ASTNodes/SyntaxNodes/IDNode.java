package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;
import Visitors.AbstractVisitor;

public class IDNode extends LeafNode{
    public String _id;
    public ExprNode _extension;
    
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

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
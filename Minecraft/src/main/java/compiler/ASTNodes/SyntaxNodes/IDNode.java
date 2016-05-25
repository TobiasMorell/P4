package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.*;
import compiler.Visitors.AbstractVisitor;

public class  IDNode extends LeafNode{
    public String _id;
    public Node _extension;
    
    public IDNode(String identifier, Node parent){
        this._id = identifier;
        this._parent = parent;
    }
    public String GetID(){return _id;}
    
    public IDNode(String identifier, ExprNode extension, Node parent)
    {
    	this._id = identifier;
    	this._extension = extension;
        this._parent = parent;
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
package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

public class IDNode extends LeafNode{
    private String _id;
    public IDNode(String identifier){
        this._id = identifier;
    }
    public String GetID(){return _id;}
}
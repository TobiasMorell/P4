package SyntaxNodes;

import GeneralNodes.*;
import Visitors.Visitor;

public class IDNode extends LeafNode{
    private String _id;
    public IDNode(String identifier){
        this._id = identifier;
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }
}
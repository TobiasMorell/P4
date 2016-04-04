package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;
import Visitors.Visitor;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class CoordLit extends LeafNode{
    private String _value;
    public CoordLit(String val){
        _value = val;
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }
}

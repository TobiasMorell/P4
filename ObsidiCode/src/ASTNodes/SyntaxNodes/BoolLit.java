package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class BoolLit extends LeafNode {
    private String _value;
    public BoolLit(String val){
        _value = val;
    }
}

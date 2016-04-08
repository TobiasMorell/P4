package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class DclNode extends BinaryNode{
    public DclNode(Type type, IDNode id, Node rigtHandSide){
        super(id, rigtHandSide);
        t = type;

    }
    public Type GetType(){
        return t;
    }
}

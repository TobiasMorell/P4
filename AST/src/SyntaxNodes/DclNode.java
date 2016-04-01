package SyntaxNodes;

import GeneralNodes.BinaryNode;
import GeneralNodes.Node;
import Visitors.Visitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class DclNode extends BinaryNode{
    public DclNode(Type type, IDNode id, Node rigtHandSide){
        super(id, rigtHandSide);
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }
}

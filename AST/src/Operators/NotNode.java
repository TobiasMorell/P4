package Operators;

import GeneralNodes.Node;
import GeneralNodes.UnaryNode;
import Visitors.Visitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class NotNode extends UnaryNode {
    public NotNode(Node child) {
        super(child);
        t = Type.bool;
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }
}

package Declarations;

import GeneralNodes.LeafNode;
import Visitors.Visitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class BoolDcl extends LeafNode {
    @Override
    public Object Visit(Visitor v) {
        return null;
    }

    public BoolDcl() {
        t = Type.bool;
    }
}

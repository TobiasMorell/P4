package Declarations;

import GeneralNodes.LeafNode;
import Visitors.Visitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class CoordDcl extends LeafNode {
    @Override
    public Object Visit(Visitor v) {
        return null;
    }

    public CoordDcl() {
        t = Type.coord;
    }
}

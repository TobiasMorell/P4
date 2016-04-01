package GeneralNodes;

import Visitors.Visitor;

/**
 * Created by Gedesnegl on 22-03-2016.
 */

public abstract class LeafNode extends Node {
    protected Type t;
    public LeafNode(){
        this._leftmostChild = null;
    }
}

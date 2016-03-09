package org.AST.GeneralNodes;

import java.util.ArrayList;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class NaryNode extends Node {
    public NaryNode(ArrayList<Node> childNodes)
    {
        //childNodes must be ordered in left to right appearance in tree
        this._leftmostChild = childNodes.get(0);

        for (int i = 0; i < childNodes.size(); i++) {
            Node n = childNodes.get(i);
            n._parent = this;

        }
    }
}

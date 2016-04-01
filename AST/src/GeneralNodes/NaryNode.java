package GeneralNodes;

import com.sun.org.apache.xpath.internal.operations.Plus;
import SyntaxNodes.*;
import java.util.ArrayList;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class NaryNode extends Node {
    protected ArrayList<Node> children;

    public NaryNode(ArrayList<Node> childNodes)
    {
        for (int i = 0; i < childNodes.size(); i++) {
            Node n = childNodes.get(i);
            n._parent = this;
        }

        //childNodes must be ordered in left to right appearance in tree
        this._leftmostChild = childNodes.get(0);

        childNodes.remove(0);
        this.children = childNodes;
    }
}

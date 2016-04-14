package ASTNodes.GeneralNodes;

import Visitors.AbstractVisitor;

import java.util.ArrayList;

/**
 * Created by Morell on 4/14/16.
 */
public class CollectionNode extends NaryNode {
    public CollectionNode ()
    {
        super(new ArrayList<Node>());
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

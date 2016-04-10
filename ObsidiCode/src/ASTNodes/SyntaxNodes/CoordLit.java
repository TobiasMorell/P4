package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class CoordLit extends LeafNode{
    private float x, y, z;
    public CoordLit(String[] coords){
        this.x = Float.parseFloat(coords[0]);
        this.y = Float.parseFloat(coords[1]);
        this.z = Float.parseFloat(coords[2]);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }

}

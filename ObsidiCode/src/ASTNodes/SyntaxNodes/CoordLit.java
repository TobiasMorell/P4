package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class CoordLit extends ExprNode{
    public float x, y, z;
    public CoordLit(String[] coords){
        super(null,null);
        this.x = Float.parseFloat(coords[0]);
        this.y = Float.parseFloat(coords[1]);
        this.z = Float.parseFloat(coords[2]);
        type = Type.coord;
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String x = Float.toString(this.x);
        String y = Float.toString(this.y);
        String z = Float.toString(this.z);

        sb.append('(');
        sb.append(x);
        sb.append(',');
        sb.append(y);
        sb.append(',');
        sb.append(z);
        sb.append(")");

        return sb.toString();
    }
}

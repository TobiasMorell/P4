package compiler.ASTNodes.Declarations;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.*;
import compiler.Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class CoordDcl extends DeclarationNode {
    public CoordDcl(Node leftChild, Node rightChild) {
        super(Node.Type.Coord, (IDNode)leftChild, rightChild);
    }
    public CoordDcl(String id, Node rightChild)
    {
        super(Type.Coord, null, rightChild);
        this.SetLeftmostNode(new IDNode(id, this));
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }

}

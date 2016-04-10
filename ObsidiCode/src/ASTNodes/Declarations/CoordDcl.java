package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.*;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class CoordDcl extends BinaryNode {
    public CoordDcl(Node leftChild, Node rightChild) {
        super((IDNode)leftChild, rightChild);
    }
    public CoordDcl(String id, Node rightChild)
    {
        super(new IDNode(id), rightChild);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }

}

package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.*;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class BoolDcl extends DeclarationNode{
    public BoolDcl(Node leftChild, Node rightChild) {
        super(Node.Type.bool, (IDNode)leftChild, rightChild);
    }
    public BoolDcl(String id, Node rightChild)
    {
        super(Type.bool, null, rightChild);
        this.SetLeftmostNode(new IDNode(id, this));
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

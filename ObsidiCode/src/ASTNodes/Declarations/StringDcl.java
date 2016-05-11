package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.*;
import Visitors.AbstractVisitor;
import Visitors.Visitable;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class StringDcl extends DeclarationNode {
    public StringDcl(Node leftChild, Node rightChild) {
        super(Node.Type.string, (IDNode)leftChild, rightChild);
    }
    public StringDcl(String id, Node rightChild)
    {
        super(Type.string, null, rightChild);
        this.SetLeftmostNode(new IDNode(id, this));
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

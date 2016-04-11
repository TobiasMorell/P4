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
    public BoolDcl(Node leftChild, ExprNode rightChild) {
        super(Node.Type.bool, (IDNode)leftChild, rightChild);
    }
    public BoolDcl(String id, ExprNode rightChild)
    {
        super(Type.bool, new IDNode(id), rightChild);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

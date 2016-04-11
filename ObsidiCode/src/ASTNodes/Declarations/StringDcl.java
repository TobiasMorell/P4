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
    public StringDcl(Node leftChild, ExprNode rightChild) {
        super(Node.Type.string, (IDNode)leftChild, rightChild);
    }
    public StringDcl(String id, ExprNode rightChild)
    {
        super(Type.string, new IDNode(id), rightChild);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
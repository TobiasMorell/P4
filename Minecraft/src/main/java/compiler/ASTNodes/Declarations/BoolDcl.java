package compiler.ASTNodes.Declarations;

import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.*;
import compiler.Visitors.AbstractVisitor;
import compiler.Visitors.Visitable;

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

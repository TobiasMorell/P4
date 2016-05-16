package compiler.ASTNodes.Declarations;

import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.*;
import compiler.Visitors.AbstractVisitor;
import compiler.Visitors.Visitable;

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

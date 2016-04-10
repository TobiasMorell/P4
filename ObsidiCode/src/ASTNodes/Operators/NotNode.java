package ASTNodes.Operators;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class NotNode extends BinaryNode {
    public NotNode(Node child, Node rightChild) {
        super(child, rightChild);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

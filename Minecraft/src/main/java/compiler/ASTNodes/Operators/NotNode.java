package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.ExprNode;
import compiler.Visitors.AbstractVisitor;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class NotNode extends ExprNode {
    public NotNode(Node child, Node rightChild) {
        super(child, rightChild);
        type = Type.bool;
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

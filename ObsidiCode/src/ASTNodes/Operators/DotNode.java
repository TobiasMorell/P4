package ASTNodes.Operators;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import Visitors.AbstractVisitor;

/**
 * Created by morell on 4/20/16.
 */
public class DotNode extends UnaryNode {

    public String name;

    public DotNode(Node child, String name) {
        super(child);
        this.name = name;
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

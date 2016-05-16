package compiler.ASTNodes.Operators;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.GeneralNodes.UnaryNode;
import compiler.Visitors.AbstractVisitor;

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

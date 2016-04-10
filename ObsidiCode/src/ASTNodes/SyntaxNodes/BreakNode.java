package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.LeafNode;
import Visitors.AbstractVisitor;

public class BreakNode extends LeafNode {
    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

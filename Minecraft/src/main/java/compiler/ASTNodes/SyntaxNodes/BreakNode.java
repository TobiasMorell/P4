package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.LeafNode;
import compiler.Visitors.AbstractVisitor;

public class BreakNode extends LeafNode {
    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

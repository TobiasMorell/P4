package compiler.ASTNodes.Declarations;


import compiler.ASTNodes.GeneralNodes.CollectionNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.IDNode;
import compiler.Visitors.AbstractVisitor;

/**
 * Created by morell on 4/14/16.
 */
public class ListDcl extends DeclarationNode {
    public ListDcl(String id, CollectionNode members) {
        super(Type.List, null, members);
        this.SetLeftmostNode(new IDNode(id, this));
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

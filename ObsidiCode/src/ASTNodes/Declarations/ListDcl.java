package ASTNodes.Declarations;


import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.AbstractVisitor;

/**
 * Created by morell on 4/14/16.
 */
public class ListDcl extends DeclarationNode {
    public ListDcl(Type t, IDNode id, CollectionNode members) {
        super(t, id, members);
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }
}

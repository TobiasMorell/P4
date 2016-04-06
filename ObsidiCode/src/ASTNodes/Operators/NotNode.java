package ASTNodes.Operators;

import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class NotNode extends UnaryNode {
    public NotNode(Node child) {
        super(child);
        t = Type.bool;
    }
}

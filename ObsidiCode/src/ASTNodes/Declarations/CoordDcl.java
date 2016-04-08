package ASTNodes.Declarations;

import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.*;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class CoordDcl extends DclNode {
    public CoordDcl(Node leftChild, Node rightChild) {
        super(Type.coord, (IDNode)leftChild, rightChild);
    }

    public CoordDcl(String id, Node rightChild)
    {
        super(Type.coord, new IDNode(id), rightChild);
    }
}

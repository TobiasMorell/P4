package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class ProgNode extends NaryNode {
    String _id;

    public ProgNode(ArrayList<Node> stmts, String id){
        super(stmts);
        _id = id;
    }

}

package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class ProgNode extends NaryNode {
    String _id;

    public ProgNode(List<Node> stmts, String id){
        super(stmts);
        System.out.println("Now creating the ProgNode with name " + id);
        _id = id;
    }

}

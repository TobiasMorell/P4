package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;
import Visitors.AbstractVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class ProgNode extends NaryNode {
    public String _id;

    public ProgNode(ArrayList<Node> stmts, String id){
        super(stmts);
        //System.out.println("Now creating the ProgNode with name " + id);
        _id = id;
    }

    @Override
    public Object Accept(AbstractVisitor v) {
        return v.visit(this);
    }

}

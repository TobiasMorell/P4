package SyntaxNodes;

import GeneralNodes.NaryNode;
import GeneralNodes.Node;
import Visitors.Visitor;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 29-03-2016.
 */
public class Prog extends NaryNode {
    String _id;

    public Prog(ArrayList<Node> stmts, String id){
        super(stmts);
        _id = id;
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }

}

package compiler.ASTNodes.SyntaxNodes;

import compiler.ASTNodes.GeneralNodes.NaryNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.Visitors.AbstractVisitor;

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

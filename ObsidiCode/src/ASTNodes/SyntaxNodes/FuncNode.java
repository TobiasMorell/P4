package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 31-03-2016.
 */
public class FuncNode extends NaryNode{
    public FuncNode(ArrayList<Node> stmts){
        super(stmts);
    }
}

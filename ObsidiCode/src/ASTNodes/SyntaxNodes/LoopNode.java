package ASTNodes.SyntaxNodes;

import ASTNodes.GeneralNodes.*;

/**
 * Created by morell on 3/31/16.
 */
public class LoopNode extends BinaryNode{
    public LoopNode(Node condition, Node stmts){
        super(condition, stmts);
    }
}

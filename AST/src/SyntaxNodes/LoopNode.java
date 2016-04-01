package SyntaxNodes;

import GeneralNodes.*;
import Visitors.Visitor;

/**
 * Created by morell on 3/31/16.
 */
public class LoopNode extends BinaryNode{
    public LoopNode(Node condition, Node stmts){
        super(condition, stmts);
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }
}

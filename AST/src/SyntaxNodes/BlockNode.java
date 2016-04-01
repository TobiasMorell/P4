package SyntaxNodes;

import GeneralNodes.*;
import Visitors.Visitor;

import java.util.ArrayList;
import java.util.List;

public class BlockNode extends NaryNode{

    public BlockNode(ArrayList<Node> stmts){
        super(stmts);
    }

    @Override
    public Object Visit(Visitor v) {
        return null;
    }
}
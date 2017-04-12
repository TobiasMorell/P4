package org.AST;

import org.AST.GeneralNodes.NaryNode;
import org.AST.GeneralNodes.Node;
import org.AST.SyntaxNodes.ExpressionNode;
import org.AST.SyntaxNodes.PlusNode;
import org.Visitors.PrettyPrintVisitor;
import org.Visitors.Visitor;

import java.util.ArrayList;

public class Main
{
    public static void main (String args[])
    {
        ArrayList<Node> al = new ArrayList<Node>();
        al.add(new ExpressionNode(null, null) );
        NaryNode n = new NaryNode(al) {
            @Override
            public Object Visit(Visitor v) {
                return null;
            }
        };
    }
}

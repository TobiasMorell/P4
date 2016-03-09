package org.AST;

import org.AST.GeneralNodes.Node;
import org.AST.SyntaxNodes.PlusNode;
import org.Visitors.PrettyPrintVisitor;

public class Main
{
    public static void main (String args[])
    {
        PlusNode pn = new PlusNode(null, null);
        PrettyPrintVisitor ppv = new PrettyPrintVisitor();
        ppv.Visit(pn);
    }
}

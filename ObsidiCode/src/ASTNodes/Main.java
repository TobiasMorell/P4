package ASTNodes;

import ASTNodes.Operators.PlusNode;
import ASTNodes.SyntaxNodes.NumLit;
import Visitors.PrettyPrintVisitor;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Worldd!\n\n");

        PlusNode TestNode = new PlusNode(new NumLit("5"),new NumLit("7"));
        PrettyPrintVisitor PPTest = new PrettyPrintVisitor();
        PPTest.Visit(TestNode);
    }
}

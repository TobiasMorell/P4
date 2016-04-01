import Operators.PlusNode;
import SyntaxNodes.*;
import Visitors.PrettyPrintVisitor;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!\n\n");

        PlusNode TestNode = new PlusNode(new NumLit("5"),new NumLit("7"));
        PrettyPrintVisitor PPTest = new PrettyPrintVisitor();
        PPTest.Visit(TestNode);
    }
}

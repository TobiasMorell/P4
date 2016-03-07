package org.AST;

public class Main 
{
    public static final void main (String args[])
    {
        Node a = new Node ("Root", null);
        Node b = new Node ("LeftMost", a); 
        Node c = new Node ("RightMost", a);

        a._leftmost = b;
        a._rightmost = c;

        printTree(a);
    }

    public static void printTree (Node root)
    {
        String space = "     ";
        System.out.println(space + root);
        System.out.println(root._leftmost + space + root._rightmost); 
    }
}

package ASTNodes.Operators;

import ASTNodes.GeneralNodes.*;

/**
 * Created by Nete on 09-03-2016.
 */
public class PlusNode extends BinaryNode {
    private Type t;

    public PlusNode(Node left, Node right)
    {
        super(left, right);
    }
}

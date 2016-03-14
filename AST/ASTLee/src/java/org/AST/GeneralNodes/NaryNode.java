package org.AST.GeneralNodes;

import com.sun.org.apache.xpath.internal.operations.Plus;
import org.AST.SyntaxNodes.ExpressionNode;
import org.AST.SyntaxNodes.PlusNode;

import java.util.ArrayList;

/**
 * Created by Nete on 08-03-2016.
 */
public abstract class NaryNode extends Node {
    protected ArrayList<Node> children;

    public NaryNode(ArrayList<Node> childNodes)
    {
        //childNodes must be ordered in left to right appearance in tree
        this._leftmostChild = childNodes.get(0);

        for (int i = 0; i < childNodes.size(); i++) {
            Node n = childNodes.get(i);
            n._parent = this;
        }

        if(this._leftmostChild != null)
            System.out.println("In outer if.");
            if (this._leftmostChild instanceof ExpressionNode)
                System.out.println("Left child is plus");
    }
}

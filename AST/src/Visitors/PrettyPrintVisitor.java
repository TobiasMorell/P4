package Visitors;

import GeneralNodes.Node;
import Operators.AndNode;
import Operators.AssignNode;
import Operators.PlusNode;

/**
 * Created by Nete on 09-03-2016.
 */
public class PrettyPrintVisitor extends Visitor {

    @Override
    public Object Visit(PlusNode n) {
        System.out.println("Encountered a plus node!");

        Node c = n.GetLeftChild();
        if(c != null)
            Visit(c);
        c = n.GetRightChild();
        if(c != null)
            Visit(c);

        //Should be fixed!!!
        return null;
    }

    @Override
    public void Visit(Node n) {
        System.out.println("Encountered a Node: " + n.toString() + "\n");
    }

    @Override
    public void Visit(AndNode n) {

    }

    @Override
    public void Visit(AssignNode n) {

    }
}

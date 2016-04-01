package Visitors;

import GeneralNodes.Node;
import Operators.AndNode;
import Operators.AssignNode;
import Operators.PlusNode;

/**
 * Created by Nete on 09-03-2016.
 */
public abstract class Visitor {
    public abstract Object Visit(PlusNode n);
    public abstract void Visit(Node n);
    public abstract void Visit(AndNode n);
    public abstract void Visit(AssignNode n);
}

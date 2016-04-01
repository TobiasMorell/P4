package Operators;

import GeneralNodes.*;
import Visitors.Visitor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Nete on 09-03-2016.
 */
public class PlusNode extends BinaryNode {
    private Type t;

    public PlusNode(Node left, Node right)
    {
        super(left, right);
    }

    @Override
    public Object Visit(Visitor v) {
        v.Visit(this);

        return null;
    }
}

package com.company;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by Lee on 28/04/16.
 */
public class testMethods {

    /* Contains the method arguments */
    ArrayList<Object> methodArguments = new ArrayList<>();

    /* Allows outside classes to add arguments to the Array */
    public ArrayList GetMethodArguments() throws Exception
    {
        return methodArguments;
    }

    /* Allows outside classes to access methods in the method array */
    public Method[] getMethods() throws Exception
    {
        Method[] methods = new Method[3];
        methods[0] = this.getClass().getDeclaredMethod("_1ReturnString");
        methods[1] = this.getClass().getDeclaredMethod("_2ReturnString");
        methods[2] = this.getClass().getDeclaredMethod("_3ReturnString");

        return methods;
    }

    public testMethods()
    {
        /* Empty constructor */
    }

    /* From here on and down are test methods */
    public String _1ReturnString() throws Exception
    {
        return methodArguments.get(0).toString();
    }

    public String _2ReturnString() throws Exception
    {
        return methodArguments.get(1).toString();
    }

    public String _3ReturnString() throws Exception
    {
        return methodArguments.get(2).toString();
    }
}

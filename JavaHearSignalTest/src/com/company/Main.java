package com.company;
import java.lang.reflect.Method;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception
    {
        /* How many times each method will be executed */
        final int NUMBER_OF_ITERATIONS = 5;

        /* Class containing test methods */
        testMethods testMethodsClass = new testMethods();

        /* Test methods extracted from the test class -> methods array */
        Method[] methods = testMethodsClass.getMethods();

        /* Reads input and stores input as arguments in test class argument array */
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 3; i++)
        {
            System.out.println("method " + i + " argument");
            testMethodsClass.GetMethodArguments().add(s.nextLine());
        }

        /* Invokes the [current] method [NUMER_OF_ITERATIONS] of times */
        int current = 0;
        for (int i = 0; i < methods.length * NUMBER_OF_ITERATIONS; ++i)
        {
            if (i % NUMBER_OF_ITERATIONS == 0 && i != 0)
                current ++;

            System.out.println(methods[current].invoke(testMethodsClass));

            /* Sleeps for 0.6 seconds */
            Thread.sleep(600);
        }
    }
}

package Utility;

import java.io.IOException;

/**
 * Created by morell on 5/3/16.
 */
public class JavaSourcePrinter {

    public static void PrintSource(JavaSourceBuffer jsb)
    {
        try {
            System.out.printf("Code from %s:\n", jsb.getName());
            System.out.println(jsb.getCharContent(false));
            System.out.println("\n\n");
        } catch (IOException e)
        {
            //Never reaches this point, but exception must be caught due to override.
        }
    }
}

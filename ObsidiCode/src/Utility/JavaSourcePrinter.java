package Utility;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by morell on 5/3/16.
 */
public class JavaSourcePrinter {

    static int i = 0;
    public static void PrintSource(JavaSourceBuffer jsb)
    {
        try {
            PrintWriter writer = new PrintWriter(jsb.getClassName() + ".txt", "UTF-8");
            //System.out.printf("Code from %s:\n", jsb.getName());
            //System.out.println(jsb.getCharContent(false));
            writer.println(jsb.getCharContent(false));
            //System.out.println("\n\n");
            writer.close();
            i++;
        } catch (IOException e)
        {
            //Never reaches this point, but exception must be caught due to override.
        }

    }
}

package compiler.Utility;

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
            PrintWriter writer = new PrintWriter(jsb.getClassName() + ".java", "UTF-8");
            writer.println(jsb.getCharContent(false));
            writer.close();
            i++;
        } catch (IOException e)
        {
            //Never reaches this point, but exception must be caught due to override.
        }

    }
}

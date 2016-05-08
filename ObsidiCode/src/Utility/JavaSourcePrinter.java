package Utility;

/**
 * Created by morell on 5/3/16.
 */
public class JavaSourcePrinter {

    public static void PrintSource(JavaSourceBuffer jsb)
    {
        System.out.printf("Code from %s:\n", jsb.getName());
        System.out.println(jsb.getCharContent());
        System.out.println("\n\n");
    }
}

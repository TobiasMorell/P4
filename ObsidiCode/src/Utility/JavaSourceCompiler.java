package Utility;

import javax.tools.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by morell on 4/27/16.
 */
public class JavaSourceCompiler {
    private static String targetDir;
    private DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

    public void CompileJavaSource(JavaSourceBuffer jsb)
    {
        //Loads current directory and specify where to store compiled files
        targetDir = System.getProperty("user.dir") + "/out/" + jsb.getName() + ".class";

        //Create an iteratable data-structure to store compilation-files
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(jsb);
        //And get the compiler from the system
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        try {
            //Open an out-stream for code output
            FileWriter codeOutput = new FileWriter(targetDir, false); //false means override existing file
            //Compile and store in the output-stream
            JavaCompiler.CompilationTask task = compiler.getTask(codeOutput, null, diagnostics, null, null, compilationUnits);

            //Close and flush output-stream
            codeOutput.flush();
            codeOutput.close();

            //Check if the compilation went well
            boolean succes = task.call();
            if(!succes) {
                System.out.println("Compilation failed, should provide some errors in console.");
            }
        }
        catch (IOException e)
        {
            System.out.println("Could create compilation output.");
        }


    }

    public String getDiagnostics()
    {
        StringBuilder sb = new StringBuilder();
        //Generate error-pages here, right now just writing to console
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            sb.append("Line " + diagnostic.getLineNumber());
            sb.append(", position " + diagnostic.getPosition());
            sb.append(": ");
            sb.append(diagnostic.getMessage(null));
            sb.append('\n');
        }

        return sb.toString();
    }

}

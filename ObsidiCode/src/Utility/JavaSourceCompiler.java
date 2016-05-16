package Utility;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;

import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by morell on 4/27/16.
 */
public class JavaSourceCompiler {
    private static String targetDir;
    private DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();

    public void CompileJavaSource(JavaSourceBuffer[] jsb)
    {
        //Loads current directory and specify where to store compiled files
        targetDir = System.getProperty("user.dir");

        jsb[0].getClassName();
        if(targetDir.contains("ObsidiCode"))
            targetDir += "/CompiledSources/";
        else if(targetDir.contains("Minecraft")) {
            targetDir += "/saves/";
            File targetFolder = new File(targetDir + "CompiledSources/");
            if(!targetFolder.exists())
            {
                try {
                    System.out.println("Creating directory for compiled sources");
                    targetFolder.mkdir();
                    targetDir = targetFolder.getAbsolutePath() + "/";
                }
                catch (SecurityException e)
                {
                    ErrorHandling.Error("Could not create directory for compiled sources.");
                }
            }
            targetDir = targetFolder.getAbsolutePath() + "/";
        }

        //Create an iteratable data-structure to store compilation-files
        List<JavaSourceBuffer> compilationUnits = new ArrayList<>();

        for (int i = 0; i < jsb.length; i++)
        {
            compilationUnits.add(jsb[i]);
        }
        //And get the compiler from the system
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        try {
            //Open an out-stream for code output
            FileWriter codeOutput = new FileWriter(targetDir + jsb[0].getClassName() + ".class", false); //false means override existing file
            //Compile and store in the output-stream
            JavaCompiler.CompilationTask task = compiler.getTask(codeOutput, null, diagnostics, null, null, compilationUnits);

            //Close and flush output-stream
            codeOutput.flush();
            codeOutput.close();

            try {
                if (!task.call())
                    System.out.println("Compilation failed, should provide some errors in console.");
            } catch (UnsupportedOperationException e)
            {
                System.out.println(e.getMessage());
            }
            //For debugging!
            //System.out.println(getDiagnostics());
        }
        catch (IOException e)
        {
            System.out.println("Could not create compilation output.");//todo: IO exception thrown.. why?
        }


    }

    public String getDiagnostics() {
        StringBuilder sb = new StringBuilder();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            sb.append(diagnostic.getSource() + "\n");
            sb.append("Line " + diagnostic.getLineNumber());
            sb.append(", position " + diagnostic.getPosition());
            sb.append(": ");
            sb.append(diagnostic.getMessage(null));
            sb.append("\n\n");
        }
        //Generate error-pages here, right now just writing to console

        try {
            FileWriter fw = new FileWriter("Compilation Diagnostics.txt");
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}

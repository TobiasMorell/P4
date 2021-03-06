package compiler.Utility;


import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by morell on 4/27/16.
 */
public class JavaSourceCompiler {
    private static String targetDir;
    private DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

    public void CompileJavaSource(JavaSourceBuffer jsb)
    {
        //Loads current directory and specify where to store compiled files
        targetDir = System.getProperty("user.dir");

        jsb.getClassName();
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
        List<JavaSourceBuffer> compilationUnits = new ArrayList<JavaSourceBuffer>();

        compilationUnits.add(jsb);

        //And get the compiler from the system
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        try {
            //Open an out-stream for code output
            FileWriter codeOutput = new FileWriter(targetDir + jsb.getClassName() + ".class", false); //false means override existing file
            //Compile and store in the output-stream
            JavaCompiler.CompilationTask task = compiler.getTask(codeOutput, null, diagnostics, null, null, compilationUnits);

            //Close and flush output-stream
            codeOutput.flush();
            codeOutput.close();

            try {
                if (!task.call())
                    ErrorHandling.Error(getDiagnostics());
            } catch (UnsupportedOperationException e)
            {
                System.out.println(e.getMessage());
            }
            //For debugging!
            //System.out.println(getDiagnostics());
        }
        catch (IOException e)
        {
            System.out.println("Could not create compilation output.");
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

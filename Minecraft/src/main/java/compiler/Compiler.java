package compiler;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.TypeChecking.SymbolTable;
import compiler.Utility.*;
import compiler.Visitors.CodeGeneration.HearCodeVisitor;
import compiler.Visitors.CodeGeneration.NormalCodeVisitor;
import compiler.Visitors.CodeGeneration.RobotCodeVisitor;

public class Compiler {
	public static void main(String fileToCompile) throws Exception
    {
        if(fileToCompile == "")
        {
            //Only for debugging - should be removed
            System.out.println("No file was specified for compilation, attempting to find files.");
            String OS = System.getProperty("os.name");
            String path = System.getProperty("user.dir");
            System.out.println("Attempting to find OS.");
            if(OS.startsWith("Windows"))
            {
                System.out.println("Running on Windows - compiling esben_test.oc");
                if(!path.endsWith("\\ObsidiCode"))
                    path += "\\ObsidiCode";
                path += "\\Test\\TypeCompatibilitytest.txt";
            }
            else if (OS.startsWith("Linux")) {
                System.out.println("Running on Linux - compiling esben_test.oc");
                if(!path.endsWith("/ObsidiCode"))
                    path += "/ObsidiCode";
                path += "/Test/esben_test.oc";
            }
            else if (OS.startsWith("Mac")) {
                System.out.println("Running on mac - compiling esben_test.oc");
                path += "/Test/esben_test.oc";
            }
            else {
                System.out.println("Could not correctly determine the operating system, aborting compilation.");
                throw new IllegalArgumentException("No file was specified when calling the compiler, please do so.");
            }

            fileToCompile = path;
        }
        AntlrASTBuilder astBuilder = new AntlrASTBuilder();
        Node root = astBuilder.Compile(fileToCompile); //<-- write file to compile here!

        if(root != null) {
            //Build the symbol table
            SymbolTable st = new SymbolTable(root);

            //Compile either to java or java-byte code
            JavaKeywordSheet jsk = new JavaKeywordSheet();
            RobotCodeVisitor rcv = new RobotCodeVisitor(jsk);
            rcv.visit(root);

            JavaSourceBuffer sourceCode = rcv.GetSourceCode();

            JavaSourcePrinter.PrintSource(sourceCode);

            JavaSourceCompiler jsc = new JavaSourceCompiler();
            jsc.CompileJavaSource(sourceCode);

        } else {
            System.out.println("The root was null; could not compile!");
        }
        ErrorHandling.printErrors();

    }
}

package compiler;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.TypeChecking.SymbolTable;
import compiler.Utility.*;
import compiler.Visitors.CodeGeneration.RobotCodeVisitor;

public class Compiler {
	public static void main(String fileToCompile) throws Exception
    {
        if(fileToCompile == "")
        {
            ErrorHandling.Error("No file specified - please do so.");
        }
        AntlrASTBuilder astBuilder = new AntlrASTBuilder();
        Node root = astBuilder.Compile(fileToCompile);

        if(root != null) {
            //Build the symbol table
            SymbolTable st = new SymbolTable(root);

            //Compile to java
            JavaKeywordSheet jsk = new JavaKeywordSheet();
            RobotCodeVisitor rcv = new RobotCodeVisitor(jsk);
            rcv.visit(root);

            //Get the generated java-code and compile that
            JavaSourceBuffer sourceCode = rcv.GetSourceCode();
            JavaSourcePrinter.PrintSource(sourceCode);
            JavaSourceCompiler jsc = new JavaSourceCompiler();
            jsc.CompileJavaSource(sourceCode);

        } else {
            ErrorHandling.Error("The parser was unable to complete; no files generated!");
        }
    }
}

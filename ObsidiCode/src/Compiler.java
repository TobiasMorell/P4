
import ASTNodes.GeneralNodes.Node;
import TypeChecking.SymbolTable;
import Utility.*;
import Visitors.DeclVisitor;

public class Compiler {
	public static void main( String[] args) throws Exception 
    {
        if(args.length == 0)
        {
            //Only for debugging - should be removed
            System.out.println("No file was specified for compilation, attempting to find files.");
            args = new String[1];
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

            args[0] = path;
        }
        AntlrASTBuilder astBuilder = new AntlrASTBuilder();
        Node root = astBuilder.Compile(args[0]); //<-- write file to compile here!

        if(root != null) {
            //Build the symbol table
            SymbolTable st = new SymbolTable(root);

            DeclVisitor smv = new DeclVisitor(st);
            smv.visit(root);
        } else {
            System.out.println("The root was null; could not compile!");
        }
        ErrorHandling.printErrors();

    }
}

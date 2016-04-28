
import ASTNodes.GeneralNodes.Node;
import SymbolTable.SymbolTable;
import Utility.AntlrASTBuilder;
import Utility.JavaKeywordSheet;
import Visitors.JavaCodeVisitor;

import java.util.ArrayList;

public class Compiler {
	public static void main( String[] args) throws Exception 
    {
        AntlrASTBuilder astBuilder = new AntlrASTBuilder();
        Node root = astBuilder.Compile("esben_test.oc"); //<-- write file to compile here!

        //OCPPVisitor ppv = new OCPPVisitor(); <-- Un-comment to print ObsidiCode
        //PrettyPrintVisitor ppv = new PrettyPrintVisitor(); <-- Un-comment to print java-code
        //System.out.println(ppv.visit(pn)); <-- this writes the code to console.

        //Build the symbol table
        SymbolTable st = new SymbolTable(root);

        //Compile either to java or java-byte code
        JavaCodeVisitor jcv = new JavaCodeVisitor(new JavaKeywordSheet());

    }
}

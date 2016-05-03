
import ASTNodes.GeneralNodes.Node;
import TypeChecking.SymbolTable;
import Utility.AntlrASTBuilder;
import Utility.JavaKeywordSheet;
import ASTNodes.Declarations.ReferenceNode;
import ASTNodes.Operators.AssignNode;
import ASTNodes.SyntaxNodes.NumLit;
import Visitors.CodeGeneration.HearCodeVisitor;
import Visitors.CodeGeneration.NormalCodeVisitor;

public class Compiler {
	public static void main( String[] args) throws Exception 
    {
        AntlrASTBuilder astBuilder = new AntlrASTBuilder();
        Node root = astBuilder.Compile("test_decl.txt"); //<-- write file to compile here!

        //OCPPVisitor ppv = new OCPPVisitor(); //<-- Un-comment to print ObsidiCode
        //PrettyPrintVisitor ppv = new PrettyPrintVisitor(); //<-- Un-comment to print java-code
        //System.out.println(ppv.visit(pn)); //<-- this writes the code to console.

        ReferenceNode ref = new ReferenceNode("Test");
        NumLit nl = new NumLit(12.4f);
        AssignNode an = new AssignNode(ref, nl);
        //System.out.printf("Result of CheckBoolean %b");

        //Build the symbol table
        SymbolTable st = new SymbolTable(root);

        //Compile either to java or java-byte code
        NormalCodeVisitor jcv = new NormalCodeVisitor(new JavaKeywordSheet());
        HearCodeVisitor hcv = new HearCodeVisitor(new JavaKeywordSheet(), st);
    }
}

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Console;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import ASTNodes.SyntaxNodes.ProgNode;

public class Compiler {
	public static void main( String[] args) throws Exception 
    {
		String work_dir = System.getProperty("user.dir") + '/';
		//System.out.println("Working in: " + work_dir);
		String file_path;
		
		System.out.println("Please specify name of the file to parse:\n");
		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));
		
		file_path = rb.readLine();

        ANTLRInputStream ais = new ANTLRInputStream( new FileInputStream( work_dir + file_path));

        ObsidiCodeLexer lex = new ObsidiCodeLexer(ais);

        CommonTokenStream tokens = new CommonTokenStream(lex);

        ObsidiCodeParser parser = new ObsidiCodeParser(tokens);
        ParseTree tree = parser.prog();// begin parsing at rule 'r'
        //System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        
        BuildASTVisitor bASTv = new BuildASTVisitor();
        ProgNode pn = (ProgNode) bASTv.visit(tree);
    }
}

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

import SymbolTable.SymbolTable;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;
import ObsidiCodeAntlr.*;

import ASTNodes.SyntaxNodes.ProgNode;
import Visitors.BuildASTVisitor;
import Visitors.PrettyPrintVisitor;

import org.antlr.v4.runtime.tree.gui.TreeViewer;
import javax.swing.*;

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
        ParseTree tree = parser.prog();// begin parsing at rule 'prog'
        //System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        //showTreeOnGUI(tree, parser);

        BuildASTVisitor bASTv = new BuildASTVisitor();
        ProgNode pn = (ProgNode) bASTv.visit(tree);

        PrettyPrintVisitor ppv = new PrettyPrintVisitor();
        SymbolTable st = new SymbolTable(pn);
        System.out.println(ppv.visit(pn));
    }

    /*
     * FOR TESTING ONLY - show AST in GUI, but doesn't work with large trees
     */
    private static void showTreeOnGUI(ParseTree tree, ObsidiCodeParser parser)
    {
        JFrame frame = new JFrame("ObsidiCode Tree Viewer");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1.5);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        frame.setVisible(true);
    }
}

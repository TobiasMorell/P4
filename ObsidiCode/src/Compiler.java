import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

import ASTNodes.GeneralNodes.Node;
import SymbolTable.SymbolTable;
import Utility.AntlrASTBuilder;
import Utility.JavaKeywordSheet;
import Visitors.JavaCodeVisitor;
import Visitors.OCPPVisitor;
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

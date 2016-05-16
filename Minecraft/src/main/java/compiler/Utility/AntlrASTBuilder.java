package compiler.Utility;

import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.ProgNode;
import compiler.ObsidiCodeAntlr.ObsidiCodeLexer;
import compiler.ObsidiCodeAntlr.ObsidiCodeParser;
import compiler.Visitors.BuildASTVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

/**
 * Created by morell on 4/27/16.
 */
public class AntlrASTBuilder {

    public Node Compile(String file)
    {
        try {
            //Open file-reader and create an input stream for ANTLR
            FileInputStream fis = new FileInputStream(file);
            ANTLRInputStream ais = new ANTLRInputStream(fis);

            //Create a lexer and token stream
            ObsidiCodeLexer lex = new ObsidiCodeLexer(ais);
            CommonTokenStream tokens = new CommonTokenStream(lex);

            //Create parser and start parsing
            ObsidiCodeParser parser = new ObsidiCodeParser(tokens);
            ParseTree tree = parser.prog(); //<--Specify the start-rule of the parser

            //Close file-stream!
            fis.close();

            //Finally build the AST and return it
            BuildASTVisitor bASTv = new BuildASTVisitor();
            return bASTv.visit(tree);
        }
        catch (FileNotFoundException e) {
            System.out.println("The given file was not found:\n" + file);
        }
        catch (IOException e) {
            System.out.println("Could not open input-stream to read source-file.");
        }

        return null;
    }
}

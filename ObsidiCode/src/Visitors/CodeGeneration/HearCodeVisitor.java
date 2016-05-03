package Visitors.CodeGeneration;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import CodeGeneration.Signal;
import TypeChecking.Func;
import TypeChecking.SymbolTable;
import Utility.AbstractKeywordSheet;
import Visitors.AbstractVisitor;

import java.util.ArrayList;

/**
 * Created by morell on 5/1/16.
 */
public class HearCodeVisitor extends NormalCodeVisitor {
    private ArrayList<String> hearMethods = new ArrayList<>();
    private SymbolTable st;

    public HearCodeVisitor(AbstractKeywordSheet aks, SymbolTable st)
    {
        super(aks);
        this.st = st;
    }

    private void placeHeader()
    {
        //Add class header
        codeBuilder.append(String.format("%s %s %sHearThread %s HearThread {\n",
                keywords.ACCESS, keywords.CLASS, robotName, keywords.EXTENSION));
        //Add fields
        codeBuilder.append("private Robot Robot;\n");
        //Declare a constructor
        codeBuilder.append(String.format("public %sHearThread (Robot r, RobotMutex mut) {\n", robotName));
        codeBuilder.append("super(mut);\n");
        codeBuilder.append("this.Robot = r;\n");
        codeBuilder.append("}\n");
        //Override the Handle-method
        codeBuilder.append("@Override\n");
        codeBuilder.append("public void Handle(Signal sig_id) {\n");
        codeBuilder.append("switch (sig_id.GetID()){\n");
        for (String s : hearMethods) {
            codeBuilder.append(String.format("case \"%s\":\n", s));
            //Parse arguments
            //todo: find out how to parse the parameters
            Signal si = new Signal("TestSignal", new Object[3]);
            Object[] objs = si.GetArguments();
            Func f = st.RetrieveMethod(si.GetID(), Node.Type.num);

            //Call the corresponding method
            codeBuilder.append(String.format("%s(PUT ARGUMENTS HERE);\n", s));
            codeBuilder.append("break;\n");
        }
        codeBuilder.append("default:\n");
        codeBuilder.append("break;\n");
        codeBuilder.append("}\n");
    }

    @Override
    public Object visit(HearDcl node) {
        hearMethods.add(node.id);
        codeBuilder.append(String.format("private void %s (", node.id));
        for (Node n : node.parameters) {
            visit(n);
        }
        codeBuilder.append(") {\n");
        visit(node.GetLeftChild());
        codeBuilder.append("}\n");
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        //Todo must find out how to import other robots
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        placeHeader();
        for (Node n: node.GetChildren()) {
            visit(n);
        }
        codeBuilder.append("}");
        return null;
    }
}

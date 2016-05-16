package compiler.Visitors.CodeGeneration;

import compiler.ASTNodes.Declarations.HearDcl;
import compiler.ASTNodes.Declarations.MethodDcl;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.LoadNode;
import compiler.ASTNodes.SyntaxNodes.ProgNode;
import compiler.Utility.AbstractKeywordSheet;
import compiler.Utility.JavaSourceBuffer;

import java.util.ArrayList;

/**
 * Created by morell on 5/1/16.
 */
public class HearCodeVisitor extends NormalCodeVisitor {
    private ArrayList<String> hearMethods = new ArrayList<>();

    public HearCodeVisitor(AbstractKeywordSheet aks)
    {
        super(aks);
    }

    public JavaSourceBuffer GetSourceCode()
    {
        return new JavaSourceBuffer(robotName + "HearThread", codeBuilder.toString());
    }

    private void placeHeader()
    {
        //added requested import
        codeBuilder.append("package CompiledRobots;\n");
        codeBuilder.append("import CodeGeneration.*;\n");
        codeBuilder.append("import Utility.Coord;\n\n");
        //Add class header
        codeBuilder.append(String.format("public class %sHearThread extends HearThread {\n", robotName));
        //Add fields
        codeBuilder.append(String.format("private %sRobot r;\n", robotName));
        //Declare a constructor
        codeBuilder.append(String.format("public %sHearThread (%sRobot r, RobotMutex mut) {\n", robotName, robotName));
        codeBuilder.append("super(mut);\n");
        codeBuilder.append("this.r = r;\n");
        codeBuilder.append("}\n");
        //Override the Handle-method
        codeBuilder.append("@Override\n");
        codeBuilder.append("public void Handle(Signal sig_id) {\n");
        //Create a switch of methods to call correct hear
        codeBuilder.append("switch (sig_id.GetID()){\n");
        for (String s : hearMethods) {
            codeBuilder.append(String.format("case \"%s\":\n", s));
            //find and possibly invoke the method of the given Signal
            codeBuilder.append("Method m = findHearFromSignal(sig_id.GetID())");
            codeBuilder.append("if(m != null) {\n");
            codeBuilder.append("invokeMethod(m, sig_id);\n}");
            codeBuilder.append("break;\n");
        }
        codeBuilder.append("default:\n");
        codeBuilder.append("break;\n");
        codeBuilder.append("}\n");
        codeBuilder.append("}\n");
    }

    @Override
    public Object visit(HearDcl node) {
        hearMethods.add(node.id);
        codeBuilder.append(String.format("private void %s (", node.id));
        for (Node n : node.parameters) {
            visit(n);
        }
        codeBuilder.append(")");
        visit(node.GetLeftChild());
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
        robotName = node._id;
        placeHeader();
        for (Node n: node.GetChildren()) {
            visit(n);
        }
        codeBuilder.append("}");
        return null;
    }
}

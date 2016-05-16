package compiler.Visitors.CodeGeneration;

import compiler.ASTNodes.Declarations.*;
import compiler.ASTNodes.GeneralNodes.CollectionNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.Operators.*;
import compiler.ASTNodes.SyntaxNodes.*;
import compiler.CodeGeneration.RobotMutex;
import compiler.Utility.AbstractKeywordSheet;
import compiler.Utility.JavaSourceBuffer;
import compiler.Visitors.AbstractVisitor;

/**
 * Created by morell on 5/3/16.
 */
public class RobotCodeVisitor extends NormalCodeVisitor {
    //This class only needs to scan for variable declarations

    public RobotCodeVisitor(AbstractKeywordSheet aks)
    {
        super(aks);
    }

    public JavaSourceBuffer GetSourceCode()
    {
        return new JavaSourceBuffer(robotName + "Robot", codeBuilder.toString());
    }

    private void placeHeader()
    {
        codeBuilder.append("package CompiledRobots;\n");
        codeBuilder.append("import CodeGeneration.*;\n");
        codeBuilder.append("import Utility.Coord;\n");
        codeBuilder.append("import com.obsidiskrivemaskine.SyncRobot;\n");
        codeBuilder.append(String.format("public class %sRobot extends SyncRobot {\n", robotName));

        //Append global variables
        codeBuilder.append(String.format("private %sHearThread hearThread;\n", robotName));
        codeBuilder.append(String.format("private %sNormalThread normalThread;\n", robotName));

        //Append constructor
        codeBuilder.append(String.format("public %sRobot() {\n", robotName));
        codeBuilder.append("RobotMutex mutex = new RobotMutex();\n");
        codeBuilder.append(String.format("this.hearThread = new %sHearThread(this, mutex);\n", robotName));
        codeBuilder.append(String.format("this.normalThread = new %sNormalThread(this, mutex);\n", robotName));
        codeBuilder.append("}\n");
    }

    @Override
    public Object visit(ProgNode node) {
        robotName = node._id;
        placeHeader();
        for (Node n : node.GetChildren())
        {
            if(n instanceof CollectionNode)
                visit(n);
        }

        codeBuilder.append("}");
        return null;
    }

    @Override
    public Object visit(HearDcl node) {
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        return null;
    }
}

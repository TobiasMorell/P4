package Visitors.CodeGeneration;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import CodeGeneration.RobotMutex;
import Utility.AbstractKeywordSheet;
import Visitors.AbstractVisitor;

/**
 * Created by morell on 5/3/16.
 */
public class RobotCodeVisitor extends NormalCodeVisitor {
    //This class only needs to scan for variable declarations

    public RobotCodeVisitor(AbstractKeywordSheet aks)
    {
        super(aks);
    }

    private void placeHeader()
    {
        codeBuilder.append(String.format("public class %sRobot extends SyncRobot {\n", robotName));

        //Append global variables
        codeBuilder.append(String.format("private %HearThread hearThread;\n", robotName));
        codeBuilder.append(String.format("private %NormalThread normalThread;\n", robotName));

        //Append constructor
        codeBuilder.append(String.format("public %sRobot() {\n", robotName));
        codeBuilder.append("RobotMutex mutex = new RobotMutex();\n");
        codeBuilder.append(String.format("this.hearThread = new %sHearThread(this, mutex);\n"));
        codeBuilder.append(String.format("this.normalThread = new %sNormalThread(this, mutex);\n"));
        codeBuilder.append("}\n");
    }

    @Override
    public Object visit(ProgNode node) {
        placeHeader();
        robotName = node._id;
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

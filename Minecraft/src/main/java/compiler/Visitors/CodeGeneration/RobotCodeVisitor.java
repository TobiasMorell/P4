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

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by morell on 5/3/16.
 */
public class RobotCodeVisitor extends NormalCodeVisitor {
    //This class only needs to scan for variable declarations
    private HearCodeVisitor hcv;
    public RobotCodeVisitor(AbstractKeywordSheet aks)
    {
        super(aks);
        hcv = new HearCodeVisitor(aks);
    }

    public JavaSourceBuffer GetSourceCode()
    {
        return new JavaSourceBuffer(robotName + "Robot", codeBuilder.toString());
    }

    @Override
    public Object visit(ProgNode node) {
        super.visit(node);
        try{
            hcv.visit(node);
            codeBuilder.append(hcv.GetSourceCode().getCharContent(false));
        } catch(IOException e){
            e.printStackTrace();
        }
        codeBuilder.append("\n}");
        return null;
    }
}

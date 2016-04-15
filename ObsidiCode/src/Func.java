import ASTNodes.Declarations.DeclarationNode;
import ASTNodes.Declarations.MethodDcl;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 14-04-2016.
 */
public class Func {
    Node.Type returnType;
    public ArrayList<Node.Type> parameters;

        public Func(MethodDcl methodNode){
            returnType = methodNode.type;
            for (Node n :methodNode.parameters) {
                DeclarationNode N = (DeclarationNode)n;
                parameters.add(N.type);
            }
            //Add the parameters to the beginning of the blockNode so they'll be recorded in the scope for checking.
            ((BlockNode)methodNode.GetLeftChild()).GetChildren().addAll(0,methodNode.parameters);
        }
}

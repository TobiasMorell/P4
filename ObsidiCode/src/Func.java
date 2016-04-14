import ASTNodes.Declarations.DeclarationNode;
import ASTNodes.Declarations.MethodDcl;
import ASTNodes.GeneralNodes.Node;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 14-04-2016.
 */
public class Func {
    Node.Type returnType;
    ArrayList<Symbol> parameters;

        public Func(MethodDcl methodNode){
            for (Node n :methodNode.parameters) {
                ;
            }
        }
}

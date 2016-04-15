package SymbolTable;

import ASTNodes.Declarations.DeclarationNode;
import ASTNodes.Declarations.MethodDcl;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;

import java.util.ArrayList;

/**
 * This Class holds information about a method declaration in the code.
 * Created by Gedesnegl on 14-04-2016.
 */
public class Func {
    public Node.Type returnType;
    public ArrayList<Node.Type> parameters;

    /***
     * When we construct Func, the types and return type are stored in the public variables.
     * The Parameters will then be added to the Method block to be registered in that scope.
     * @param methodNode The AST node that represents the method
     */
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

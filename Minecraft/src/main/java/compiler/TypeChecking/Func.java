package compiler.TypeChecking;

import compiler.ASTNodes.Declarations.DeclarationNode;
import compiler.ASTNodes.Declarations.MethodDcl;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.BlockNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This Class holds information about a method declaration in the code.
 * Created by Gedesnegl on 14-04-2016.
 */
public class Func {
    public String name;
    public Node.Type returnType;
    public ArrayList<Node.Type> parameters;

    /***
     * When we construct Func, the types and return type are stored in the public variables.
     * The Parameters will then be added to the Method block to be registered in that scope.
     * @param methodNode The AST node that represents the method
     */
    public Func(MethodDcl methodNode){
            parameters = new ArrayList<Node.Type>();
            int i = parameters.size();
            returnType = methodNode.getT();
            name = methodNode.id;
            for (Node n :methodNode.parameters) {
                DeclarationNode N = (DeclarationNode)n;
                parameters.add(N.getT());
            }
        }
    public Func(String Name, Node.Type ret, Node.Type... params){
        parameters = new ArrayList<Node.Type>();
        if(params != null) {
            parameters = new ArrayList<Node.Type>(Arrays.asList(params));
        }
        returnType = ret;
        name = Name;
    }
}

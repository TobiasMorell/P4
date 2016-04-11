import ASTNodes.Declarations.DeclarationNode;
import ASTNodes.Declarations.MethodDcl;
import ASTNodes.Declarations.ReferenceNode;
import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.IDNode;
import ASTNodes.SyntaxNodes.ProgNode;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 08-04-2016.
 */
public class SymbolTable {
    ArrayList<Symbol> Elements;
    int depth = 0;

    public SymbolTable(ProgNode ASTRoot){
        ProcessNode(ASTRoot);
    }
    /*
    Scopedisplay[depth] bliver brugt til at adde og slette symboler i den pågælende dybte/index,.
    Samtidig viser bogen et hashtable ved siden af hvor symboler aldrig slettes.
    Dette kan muligvis bruges når der skal laves multipass.
    Det meget spøjse er Lasse ansigt. Side 292
     */

    /**
     * Fills out symbol table from a node.
     * @param node
     */
    private void ProcessNode(Node node) {
        //Check weather to put something in the SymbolTable
        if (node instanceof BlockNode) {
            OpenScope();
            ProcessChildren(node);
            CloseScope();
        }else if(node instanceof DeclarationNode){
            String id = ((IDNode)node.GetLeftChild()).GetID();
            EnterSymbol(id, ((DeclarationNode)node).type);
        }else if(node instanceof ReferenceNode){
            //Symbol = Symboltable.retrieveSymbol(node.name)
            //if(Symbol == null) error
            //elseerror
        }else if(node instanceof MethodDcl){

        }

    }

    /**
     * Processes all children of a parent node
     * @param node parent node
     */
    private void ProcessChildren(Node node){
        if(node instanceof UnaryNode){
            ProcessNode(((UnaryNode)node).GetLeftChild());

        }else if(node instanceof BinaryNode){
            ProcessNode(((BinaryNode)node).GetLeftChild());
            ProcessNode(((BinaryNode)node).GetRightChild());
        }else if(node instanceof NaryNode){
            for (Node n: ((NaryNode)node).GetChildren()) {
                ProcessNode(n);
            }
        }

        if(node instanceof BlockNode){
            CloseScope();
        }
    }



    private void EnterSymbol(String id, Node.Type type) {
        Symbol oldSymbol = RetrieveSymbol(id);
        if(oldSymbol != null && oldSymbol.depth == depth){
            //Error...
        }else{

            Symbol newSymbol = new Symbol(id, type, null, 0, depth);
        }

    }

    private Symbol RetrieveSymbol(String id) {
        return null;
    }

    private void OpenScope() {
        depth++;
    }

    private void CloseScope() {
        depth--;
    }

}


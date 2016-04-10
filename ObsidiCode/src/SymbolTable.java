import ASTNodes.Declarations.ReferenceNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.IDNode;
import ASTNodes.SyntaxNodes.ProgNode;

/**
 * Created by Gedesnegl on 08-04-2016.
 */
public class SymbolTable {
    int depth = 0;

    public SymbolTable(ProgNode ASTRoot){
        ProcessNode(ASTRoot);
    }

    private void ProcessNode(Node node) {
        if (node instanceof BlockNode) {
            OpenScope();
        }else if(node instanceof DclNode){
            String id = ((IDNode)node.GetLeftChild()).GetID();
            EnterSymbol(id, ((DclNode)node).GetType());
        }else if(node instanceof ReferenceNode){
            //Symbol = Symboltable.retrieveSymbol(node.name)
            //if(Symbol == null) error
            //elseerror
        }
    }

    private void EnterSymbol(String id, Node.Type type) {
    }

    private void OpenScope() {
    }

}

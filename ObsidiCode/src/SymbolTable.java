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
import java.util.Hashtable;

/**
 * Created by Gedesnegl on 08-04-2016.
 */
public class SymbolTable {
    ArrayList<Symbol> Elements;
    int depth = 0;
    Symbol scopeDisplay[];
    Hashtable HashTable;
    Symbol prevsym = null;
    Symbol sym = null;
    Symbol newsym = null;
    Symbol oldsym = null;

    public SymbolTable(ProgNode ASTRoot)
    {
        HashTable = new Hashtable();
        scopeDisplay = new Symbol[];
        ProcessNode(ASTRoot);
    }
    /*
    Scopedisplay[depth] bliver brugt til at adde og slette symboler i den pågælende dybte/index,.
    Samtidig viser bogen et hashtable ved siden af hvor symboler aldrig slettes.
    Dette kan muligvis bruges når der skal laves multipass.

    291 bogen. hashtab til lookup, scope til list til nuværende level, sikkert så den hurtigere kan abandon scope

    var er bare en nested liste af symboler med samme navn, så når der kommer et nyt med samme navn,
    bliver den gamle slettet og peget på af den nye (assigned til den nyes var field).
    Dvs at hashtable sletter symboler, men dem som tager deres plads holder en reference til dem.
    Det bare en kosteffektiv måde at gøre det på.

    Btw Multipass er vi genere vores shit i flere phases
    Foreksempel laver vi først laver vi inputtet til tokenstream, så til et ast, og derefter modified ast og så til
    assembly modsat syntax directed translation hvor alt gennemgås på engang, chapter 7 i fischer.
    Btw godt eksempel af et mega simpelt symb tab for syntax directed translation i THE DRAGON BOOK.

    Det meget spøjse er Lasse ansigt. Side 292
     */

    /**
     * Fills out symbol table from a node.
     * @param node
     */
    private void ProcessNode(Node node) {
        //Check weather to put something in the SymbolTable
        if (node instanceof BlockNode) {
            //As a new scope is already opened with a method declaration.
            //we choose to check that the parent is not of this type
            if(!(node._parent instanceof MethodDcl))
                OpenScope();
            ProcessChildren(node);
            CloseScope();
        }else if(node instanceof DeclarationNode){
            String id = ((IDNode)node.GetLeftChild()).GetID();
            EnterSymbol(id, ((DeclarationNode)node).type);
        }else if(node instanceof ReferenceNode){
            Symbol s = RetrieveSymbol(((ReferenceNode) node).GetId().GetID());
            if(s == null)
                MakeError("Symbol \"" +s.name+ "\" does not exist");
        }else if(node instanceof MethodDcl){
            OpenScope();
            ProcessChildren(node);
            //As MethodDcl Always has a Blocknode in it, Scope will automatically be closed
        }

    }

    /**
     * Prints a simple error message and exits the compiler afterwards.
     * @param s Error message
     */
    private void MakeError(String s) {
        System.out.println(s);
        System.exit(-1);
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



    private void EnterSymbol(String id, Node.Type type)
    {
        oldsym = RetrieveSymbol(id);
        if (oldsym != null && oldsym.depth == depth) MakeError("Symbol \"" + id + "\" has already been initialized in this scope");

        newsym = new Symbol(id, type, scopeDisplay[depth], null, depth);
        //mangler at sætte hashvalue
        scopeDisplay[depth] = newsym;
        if(oldsym == null) HashTable.put(newsym.getName(), newsym);
        else
        {
            HashTable.remove(oldsym);
            HashTable.put(newsym.getName(), newsym);

        }
        newsym.var = oldsym;
    }

    /**
     * Retrieves Closest(scope wise) symbol with given id
     * @param id String name of the symbol.
     * @return
     */
    private Symbol RetrieveSymbol(String id) {
        sym = (Symbol)HashTable.get(id);
        while(sym != null)
        {
            if(sym.name == id) return(sym);

            //I bogen gør de bagefter sym = sym.getHashValue();

        }
        return null;
    }

    private void OpenScope()
    {
        depth++;
        scopeDisplay[depth] = null;
    }

    /**
     * Closes current scope and deletes all Symbols contained.
     *
     * Ikke særlig effektiv kører igennem hele tablet.
     *
     */
    private void CloseScope() {
        //Needs to be improved so all variabes in the same depth are removed, can be done through the level field;
        Symbol c = scopeDisplay[depth];
        prevsym = c.var;
        HashTable.remove(c);
        if(prevsym != null) HashTable.put(prevsym.getName(),prevsym);
        depth--;
    }

    private Boolean DeclaredLocally(String name)
    {
        sym = RetrieveSymbol(name);
        if(sym != null && sym.depth == depth) { return true;     }
        else return false;
    }



}

/* Lasse Rant

Ser fint ud, mangler persistent data structure methods, classes, det vil vi gerne beholde efter scope ender.
Muligvis vise forskel igennem typer, methods ... ah det kommer i bogen 298 og frem.

*/

//TODO: all except open,
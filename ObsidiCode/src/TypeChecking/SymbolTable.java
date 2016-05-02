package TypeChecking;

import ASTNodes.Declarations.DeclarationNode;
import ASTNodes.Declarations.ReferenceNode;
import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.IDNode;
import Visitors.DeclVisitor;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Gedesnegl on 08-04-2016.
 */
public class SymbolTable {
    public ArrayList<Symbol> symbols;
    public ArrayList<Func> functions;
    public int depth = -1;
    ArrayList<Symbol> scopeDisplay;
    Hashtable HashTable;
    public DeclVisitor dclvisitor;
    public Node _ASTRoot;

    public SymbolTable(Node ASTRoot)
    {
        _ASTRoot = ASTRoot;
        HashTable = new Hashtable();
        scopeDisplay = new ArrayList<>();
        symbols = new ArrayList<>();
        functions = new ArrayList<>();
        dclvisitor = new DeclVisitor(this);
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
        //Check weather to put something in the TypeChecking.TypeChecking
        System.out.println("Processing Node");
        if (node instanceof BlockNode) {
            //As a new scope is already opened with a method declaration.
            //we choose to check that the parent is not of this type
            OpenScope();
        }else if(node instanceof DeclarationNode){
            String id = ((IDNode)node.GetLeftChild()).GetID();
            EnterSymbol(id, ((DeclarationNode)node).type);
        }else if(node instanceof ReferenceNode) {
            Symbol s = RetrieveSymbol(((ReferenceNode) node).GetId().GetID());
            if (s == null)
                MakeError("TypeChecking.Symbol \"" + s.name + "\" does not exist");
        }
        // Make foreach node n : n.GetChildren()) ProcessNde(n)
        // if(node instanceof BlockNode) symtab.CloseScope();


        }

    /**
     * Prints a simple error message and exits the compiler afterwards.
     * @param s Error message
     */
    public void MakeError(String s) {
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



    public void EnterSymbol(String id, Node.Type type)
    {
        Symbol oldsym = RetrieveSymbol(id);
        if (oldsym != null && oldsym.depth == depth) MakeError("TypeChecking.Symbol \"" + id + "\"" +
                " of type "+ type.toString() + " has already been initialized in this scope");
        Symbol newsym = new Symbol(id, type, scopeDisplay.get(depth), depth);
        //mangler at sætte hashvalue
        scopeDisplay.set(depth, newsym);
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
    public Symbol RetrieveSymbol(String id) {
        Symbol sym = (Symbol)HashTable.get(id);
        while(sym != null)
        {
            if(sym.name.equals(id)) return(sym);

        }
        return null;
    }

    public void OpenScope()
    {
        depth++;
        scopeDisplay.add(null);
    }

    /**
     * Closes current scope and deletes all Symbols contained.
     *
     * Ikke særlig effektiv kører igennem hele tablet.
     *
     */
    public void CloseScope() {
        //Needs to be improved so all variabes in the same depth are removed, can be done through the level field;
        scopeDisplay.trimToSize();
        if(scopeDisplay.size()>depth) {
            Symbol c = scopeDisplay.get(depth);
            if (c != null) {
                Symbol prevsym = c.var;
                HashTable.remove(c.name); //todo: Det hér virker nok ikke.
                if (prevsym != null)
                    HashTable.put(prevsym.getName(), prevsym);
            }
            scopeDisplay.remove(depth);
        }
        depth--;
    }

    public Boolean DeclaredLocally(String name)
    {
        Symbol sym = RetrieveSymbol(name);
        if(sym != null && sym.depth == depth) { return true;     }
        else return false;
    }



}

/* Lasse Rant

Ser fint ud, mangler persistent data structure methods, classes, det vil vi gerne beholde efter scope ender.
Muligvis vise forskel igennem typer, methods ... ah det kommer i bogen 298 og frem.

*/

//TODO: all except open,
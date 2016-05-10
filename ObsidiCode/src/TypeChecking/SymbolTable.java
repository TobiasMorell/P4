package TypeChecking;

import ASTNodes.Declarations.DeclarationNode;
import ASTNodes.Declarations.ReferenceNode;
import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.NaryNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.GeneralNodes.UnaryNode;
import ASTNodes.SyntaxNodes.BlockNode;
import ASTNodes.SyntaxNodes.IDNode;
import ASTNodes.SyntaxNodes.MethodInvocationNode;
import Utility.ErrorHandling;
import Visitors.DeclVisitor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

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
        addNativeFunctions();
        dclvisitor = new DeclVisitor(this);
    }

    private void addNativeFunctions() {
        functions.add(new Func("GetHP", Node.Type.num));
        functions.add(new Func("GetPosition", Node.Type.coord, null));
        functions.add(new Func("Mine", Node.Type.Void, Node.Type.string));
        functions.add(new Func("LootChest", null));
        functions.add(new Func("Move", null, Node.Type.string));
        functions.add(new Func("GiveItem", null, Node.Type.string));
        functions.add(new Func("Drop", null, Node.Type.string, Node.Type.num));
        functions.add(new Func("Talk", null, Node.Type.string));
        functions.add(new Func("Equip", null, Node.Type.string));
        functions.add(new Func("GetX", Node.Type.num, Node.Type.coord));
        functions.add(new Func("GetY", Node.Type.num, Node.Type.coord));
        functions.add(new Func("GetZ", Node.Type.num, Node.Type.coord));
    }

    /**
     * Prints a simple error message and exits the compiler afterwards.
     * @param s Error message
     */
    public void MakeError(String s) {
        ErrorHandling.Error(s);
        //System.exit(-1);
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
        //while(sym != null)
        //{
            if(sym != null && sym.name.equals(id))
                return(sym);

        //}
        return null;
    }

    public Func RetrieveMethod(MethodInvocationNode refNode, ArrayList<Node.Type> types){
        String name = ((IDNode)refNode.GetLeftChild())._id;
        for (Func F : functions) {
            if(name.equals(F.name) && types.size() == F.parameters.size() ){
                for (int i = 0; i < F.parameters.size(); i++) {
                    if (F.parameters.get(i) != types.get(i)){
                        MakeError("Invalid parameters in " + name);
                        return null;
                    }
                }
                return F;
            }
        }
        MakeError("Invalid Method invocation: " + name);
        return null;
    }

    /***
     * Find all methods in the symbol table with the given name
     * @param name of the methods to search for
     * @return an array of all declared methods with that name
     */
    public Func[] RetrieveAllMethodsWithName(String name)
    {
        //Make a new list to store all methods
        ArrayList<Func> funcs = new ArrayList<>();
        //Find all methods with the given name and store in list
        for(Func F : functions)
        {
            if(name.equals(F.name))
                funcs.add(F);
        }

        //Convert to array and return
        Func[] f = new Func[funcs.size()];
        f = funcs.toArray(f);
        return f;
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
                HashTable.remove(c.name); //todo: might not work, however is not put to use as of current
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

//todo: Persistent data?
package compiler.TypeChecking;


import compiler.ASTNodes.Declarations.MethodDcl;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.SyntaxNodes.IDNode;
import compiler.ASTNodes.SyntaxNodes.MethodInvocationNode;
import compiler.Utility.ErrorHandling;
import compiler.Visitors.SemanticVisitor;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Gedesnegl on 08-04-2016.
 */
public class SymbolTable {
    public ArrayList<Func> functions;
    public int depth = -1;
    private ArrayList<ArrayList<Symbol>> scopeDisplay;
    public SemanticVisitor semvisitor;
    public Node _ASTRoot;

    public SymbolTable(Node ASTRoot)
    {
        _ASTRoot = ASTRoot;
        scopeDisplay = new ArrayList<ArrayList<Symbol>>();
        functions = new ArrayList<Func>();
        addNativeFunctions();
        semvisitor = new SemanticVisitor(this);
    }

    private void addNativeFunctions() {
        functions.add(new Func("GetHP", Node.Type.num));
        functions.add(new Func("GetPosition", Node.Type.Coord, null));
        functions.add(new Func("Mine", Node.Type.Void, Node.Type.string));
        functions.add(new Func("LootChest", null));
        functions.add(new Func("StoreAllInChest", null));
        functions.add(new Func("Move", null, Node.Type.string));
        functions.add(new Func("GiveItem", null, Node.Type.string));
        functions.add(new Func("Drop", null, Node.Type.string, Node.Type.num));
        functions.add(new Func("Talk", null, Node.Type.string));
        functions.add(new Func("Equip", null, Node.Type.string));
        functions.add(new Func("GetX", Node.Type.num, Node.Type.Coord));
        functions.add(new Func("GetY", Node.Type.num, Node.Type.Coord));
        functions.add(new Func("GetZ", Node.Type.num, Node.Type.Coord));
    }

    /***
     * Enters a new symbol by first checking that the chosen name isn't already taken in the current scope
     * @param id The name for the symbol
     * @param type The type of the symbol
     * @param line The line in the code, in which the symbol is defined(error messages)
     */
    public void EnterSymbol(String id, Node.Type type, int line)
    {
        Symbol oldsym = RetrieveSymbol(id);
        if (oldsym != null && oldsym.depth == depth){
            ErrorHandling.Error("Variable \"" + id + "\"" +
                    " of type "+ type.toString() + " has already been initialized in this scope", line);
            return;
        }
        Symbol newsym = new Symbol(id, type, depth);
        scopeDisplay.get(depth).add(newsym);
    }

    /**
     * Retrieves Closest(scope wise) symbol with given id
     * @param id String name of the symbol.
     * @param line line number, for errormessaging and debugging
     * @return
     */
    public Symbol RetrieveSymbol(String id, int line) {
        Symbol s = RetrieveSymbol(id);
        if(s==null) {
            ErrorHandling.Error("Variable " + id + " has not been declared at this point", line);
            return null;
        }else{
            return s;
        }

    }
    /**
     * Retrieves Closest(scope wise) symbol with given id
     * @param id String name of the symbol.
     * @return
     */
    public Symbol RetrieveSymbol(String id) {
        for(int i = depth; i > 0; i--){
            for(Symbol s : scopeDisplay.get(i)){
                if(s.name.equals(id)){
                    return s;
                }
            }
        }
        return null;
    }

    public void EnterMethod(MethodDcl method){
        Func func = new Func(method);
        for (Func f:functions) {
            if(f.name.equals(method.id)){
                ErrorHandling.Error("Method, "+f.name+", has already been defined",method.line);
                return;
            }
        }
        functions.add(func);
    }

    public Func RetrieveMethod(MethodInvocationNode refNode, ArrayList<Node.Type> types){
        String name = ((IDNode)refNode.GetLeftChild())._id;
        for (Func F : functions) {
            if(name.equals(F.name) && types.size() == F.parameters.size() ){
                for (int i = 0; i < F.parameters.size(); i++) {
                    if (F.parameters.get(i) != types.get(i)){
                        ErrorHandling.Error("Invalid parameter in method invocation '" + name+"', expected "+F.parameters.get(i)
                        +"but found"+types.get(i), refNode.line);
                        return null;
                    }
                }
                return F;
            }
        }
        ErrorHandling.Error("Invalid Method invocation: " + name);
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
        ArrayList<Func> funcs = new ArrayList<Func>();
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

    /***
     * Opens a new scope and adds a new entry to scopedisplay
     */
    public void OpenScope()
    {
        depth++;
        scopeDisplay.add(new ArrayList<Symbol>());
    }

    /***
     * Closes the current scope and removes the content of the previous outermost scope.
     */
    public void CloseScope() {
        scopeDisplay.trimToSize();
        if(scopeDisplay.size()>depth) {
            scopeDisplay.remove(depth);
        }
        depth--;
    }

    /***
     * This method is used for byte code generation.
     * @param name a symbol to be checked
     * @return a boolean value representing weather or not the symbol is declared locally
     */
    public Boolean DeclaredLocally(String name)
    {
        Symbol sym = RetrieveSymbol(name,0);
        if(sym != null && sym.depth == depth) { return true;     }
        else return false;
    }



}
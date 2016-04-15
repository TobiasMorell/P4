package SymbolTable;

import ASTNodes.GeneralNodes.Node;

public class Symbol {
    public String getName() {
        return name;
    }

    public Node.Type getType() {
        return type;
    }

    public Symbol getVar() {
        return var;
    }

    public Symbol getLevel() {
        return level;
    }

    public int getDepth() {
        return depth;
    }

    public int getHashValue() {return hashvalue;}

    String name;
    Node.Type type;

    public void setVar(Symbol var) {
        this.var = var;
    }

    Symbol var, level;
    int depth, hashvalue;

    public Symbol(String name, Node.Type type, Symbol level, int hashValue, int depth){
        this.name = name;
        this.type = type;
        this.level = level;
        this.depth = depth;
        this.hashvalue = hashValue;
    }

    @Override
    public int hashCode() {
        return (depth + name).hashCode();
    }
}

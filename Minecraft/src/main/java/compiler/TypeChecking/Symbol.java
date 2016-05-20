package compiler.TypeChecking;

import compiler.ASTNodes.GeneralNodes.Node;

public class Symbol {
    public String getName() {
        return name;
    }

    public Node.Type getType() {
        return type;
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


    Symbol level;
    int depth, hashvalue;

    public Symbol(String name, Node.Type type, int depth){
        this.name = name;
        this.type = type;
        this.depth = depth;
    }

    @Override
    public int hashCode() {
        return (depth + name).hashCode();
    }
}

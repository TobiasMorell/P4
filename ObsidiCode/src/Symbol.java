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

    public int getLevel() {
        return level;
    }

    public int getDepth() {
        return depth;
    }

    String name;
    Node.Type type;
    Symbol var;
    int level, depth;

    public Symbol(String name, Node.Type type, Symbol var, int level, int depth){
        this.name = name;
        this.type = type;
        this.var = var;
        this.level = level;
        this.depth = depth;
    }

    @Override
    public int hashCode() {
        return (depth + name).hashCode();
    }
}

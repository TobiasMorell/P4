package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

import java.util.ArrayList;

//Slet ; i metode parametre
//Find ud af hvorfor repeats laver to conditions

/**
 * Created by SW409F16 on 09-03-2016.
 */
public class PrettyPrintVisitor extends AbstractVisitor {
    @Override
    public Object visit(Node n) {
        if(n != null)
            return n.Accept(this);
        else
            System.out.println("Found a null node, AST not supposed to have empty nodes!");
        return "FAULTY NODE!";
    }

    @Override
    public Object visit(ListDcl node) {
        String id = ((IDNode)node.GetLeftChild())._id;

        StringBuilder sb = new StringBuilder();
        sb.append("ArrayList<Object> ");
        sb.append(id);
        sb.append(" = new ArrayList<Object>();");

        for (Node n : ((CollectionNode) node.GetRightChild()).GetChildren()) {
            sb.append(id);
            sb.append(".add(");
            sb.append(visit(n));
            sb.append(");\n");
        }

        return sb.toString();
    }

    @Override
    public Object visit(DotNode node) {
        return node.name + '.' + visit(node.GetLeftChild());
    }

    @Override
    public Object visit(CollectionNode node) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Node> members = node.GetChildren();

        for (int i = 0; i < members.size(); i++) {
            sb.append(visit(members.get(i)).toString() + '\n');
        }

        return sb.toString();
    }

    @Override
    public Object visit(BoolDcl node) {
        String id;

        id = node.GetLeftChild().Accept(this).toString();
        if(node.GetRightChild() != null)
            id += " = " + visit(node.GetRightChild());


        return "boolean " + id + ';';
    }

    @Override
    public Object visit(CoordDcl node) {
        String dcl;

        dcl = "Coord " + visit(node.GetLeftChild()).toString();
        if(node.GetRightChild() != null)
            dcl += " = " + visit(node.GetRightChild());

        return dcl + ';';
    }

    @Override
    public Object visit(HearDcl node) {
        Object lo;

        lo = node.GetLeftChild().Accept(this);

        return "public void hear" + node.id + '(' + node.parameters + ") {\n" + lo + '}';
    }

    @Override
    public Object visit(MethodDcl node) {
        StringBuilder sb = new StringBuilder();

        //Create access modifier and return type
        sb.append("public ");
        switch (node.type){
            case bool:
                sb.append("boolean ");
                break;
            case coord:
                sb.append("Coord ");
                break;
            case num:
                sb.append("float ");
                break;
            case string:
                sb.append("String ");
                break;
            case Void:
                sb.append("void ");
                break;
        }

        //Append ID and params
        sb.append(node.id);
        sb.append(createParamsString(node.parameters));
        sb.append("{\n");
        sb.append(visit(node.GetLeftChild()));
        sb.append("}\n");

        return sb.toString();
    }

    private String createParamsString(ArrayList<Node> parameters)
    {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (int i = 0; i < parameters.size(); i++) {
            if(i != 0)
                sb.append(',');
            sb.append(visit(parameters.get(i)));
        }
        sb.append(')');

        return sb.toString().replace(";", "");
    }

    @Override
    public Object visit(NumDcl node) {
        String id = visit(node.GetLeftChild()).toString();
        if(node.GetRightChild() != null)
            id += " = " + visit(node.GetRightChild());
        return "float " + id + ';';
    }

    @Override
    public Object visit(ReferenceNode node) {
        return visit(node.GetId());
    }

    @Override
    public Object visit(StringDcl node) {
        String id = "String " + visit(node.GetLeftChild()).toString();
        if(node.GetRightChild() != null)
            id += " = " + visit(node.GetRightChild()) + ';';
        return id;
    }

    @Override
    public Object visit(GreaterEqualNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " >= " + ro;
    }

    @Override
    public Object visit(LessEqualNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " <= " + ro;
    }

    @Override
    public Object visit(AndNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " && " + ro;
    }

    @Override
    public Object visit(AssignNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " = " + ro + ";\n";
    }

    @Override
    public Object visit(DivNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " / " + ro;
    }

    @Override
    public Object visit(GreaterNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " > " + ro;
    }

    @Override
    public Object visit(IsNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " == " + ro;
    }

    @Override
    public Object visit(LessNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " < " + ro;
    }

    @Override
    public Object visit(MinusNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " - " + ro;
    }

    @Override
    public Object visit(MultNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " * " + ro;
    }

    @Override
    public Object visit(NotNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " != " + ro;
    }

    @Override
    public Object visit(OrNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " || " + ro;
    }

    @Override
    public Object visit(PlusNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " + " + ro;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        Object lo = visit(node.GetLeftChild());

        return "-" + lo;
    }

    @Override
    public Object visit(XnorNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " XAND " + ro;
    }

    @Override
    public Object visit(XorNode node) {
        Object lo = visit(node.GetLeftChild());
        Object ro = visit(node.GetRightChild());

        return lo + " XOR " + ro;
    }

    @Override
    public Object visit(BlockNode node) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Node> stmts = node.GetChildren();

        for (int i = 0; i < stmts.size(); i++) {
            sb.append(visit(stmts.get(i)).toString() + '\n');
        }

        return sb.toString();
    }

    @Override
    public Object visit(BoolLit node) {
        return node.value.toLowerCase();
    }

    @Override
    public Object visit(BreakNode node) {
        return "BREAK MOTHERFUCKERS!";
    }

    @Override
    public Object visit(CoordLit node) {
        return "new Coord("+ node.x + ", " + node.y + ", " + node.z + ")";
    }

    @Override
    public Object visit(ElseNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("else {\n");

        for (Node n : ((BlockNode) node.GetLeftChild()).GetChildren())
        {
            sb.append(visit(n));
        }

        sb.append("}\n");

        return sb.toString();
    }

    @Override
    public Object visit(ExprNode node) {
        StringBuilder sb = new StringBuilder();

        if(node.GetLeftChild() != null)
            sb.append( visit(node.GetLeftChild()) );
        if(node.GetRightChild() != null)
            sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(IDNode node) {
        String ext = "";

        if(node._extension != null)
            ext = visit(node._extension).toString();

        return node._id + ext;
    }

    @Override
    public Object visit(IfNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (");
        sb.append(visit(node.GetCondition()));
        sb.append(") { \n");
        if(node.GetBody() != null)
            sb.append(visit(node.GetBody()));
        sb.append("}\n");

        if(node.GetElseIf() != null) {
            sb.append("else ");
            sb.append(visit(node.GetElseIf()));
        }
        if(node.GetElse() != null)
            sb.append(visit(node.GetElse()));

        return sb.toString();
    }

    @Override
    public Object visit(LoadNode node) {
        StringBuilder sb = new StringBuilder();

        for (Node n : node.GetChildren()) {
            sb.append("import ");
            String id = ((ProgNode) n)._id;
            sb.append(id.replace("\"", ""));
            sb.append(';');
            sb.append('\n');
        }

        return sb.toString();
    }

    @Override
    public Object visit(LoopNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("while (!");
        sb.append(visit(node.GetLeftChild()));
        sb.append(") {\n");

        ArrayList<Node> stmts = ((BlockNode) node.GetRightChild()).GetChildren();

        for (Node n : stmts)
        {
            sb.append(visit(n));
        }

        sb.append("}\n");

        return sb.toString();
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        String id = visit(node.GetLeftChild()).toString();
        StringBuilder sb = new StringBuilder();

        sb.append(id);
        sb.append("(");

        ArrayList<Node> args = node.GetChildren();
        for (int i = 0; i < args.size(); i++) {
            if(i != 0)
                sb.append(", ");
            sb.append(visit(args.get(i)).toString());
        }

        sb.append(");\n");

        return sb.toString();
    }

    @Override
    public Object visit(NumLit node) {
        return node._value;
    }

    @Override
    public Object visit(ProgNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("public class " + node._id + " extends AbstractMinecraftRobot {\n");

        for (Node n : node.GetChildren()) {
            String res = visit(n).toString();
            if (res != null)
                sb.append(res + '\n');
        }
        sb.append('}');

        return sb.toString();
    }

    @Override
    public Object visit(ReturnNode node) {
        return "return " + visit(node.GetLeftChild()) + ';';
    }

    @Override
    public Object visit(SignalNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("Signal ");
        sb.append(visit(node.GetLeftChild()));
        sb.append(" (");

        ArrayList<Node> args = ((CollectionNode) node.GetRightChild()).GetChildren();
        for (int i = 0; i < args.size(); i++) {
            if(i > 0)
                sb.append(", ");
            sb.append(visit(args.get(i)));
        }
        sb.append(");");

        return sb.toString();
    }

    @Override
    public Object visit(StringLit node) {
        return node.text;
    }
}

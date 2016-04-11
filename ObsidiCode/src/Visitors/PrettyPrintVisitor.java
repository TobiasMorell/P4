package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

import java.util.ArrayList;

/**
 * Created by Nete on 09-03-2016.
 */
public class PrettyPrintVisitor extends AbstractVisitor {
    @Override
    public Object visit(Node n) {
        return n.Accept(this);
    }

    @Override
    public Object visit(BoolDcl node) {
        String id;

        id = node.GetLeftChild().Accept(this).toString();
        if(node.GetRightChild() != null)
            id += " = " + visit(node.GetRightChild()) + ';';


        return "boolean " + id;
    }

    @Override
    public Object visit(CoordDcl node) {
        String dcl;

        dcl = visit(node.GetLeftChild()).toString();
        if(node.GetRightChild() != null)
            dcl += " = " + visit(node.GetRightChild()) + ';';

        return dcl;
    }

    @Override
    public Object visit(DeclarationNode node) {
        String dcl;

        dcl = node.GetLeftChild().Accept(this).toString();
        if(node.GetRightChild() != null)
            dcl += " = " + visit(node.GetRightChild()) + ';';

        return dcl;
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
        appendParams(sb, node.parameters);
        sb.append("{\n");
        sb.append(visit(node.GetLeftChild()));
        sb.append("}\n");

        return sb.toString();
    }

    private void appendParams(StringBuilder sb, ArrayList<Node> parameters)
    {
        sb.append('(');
        for (int i = 0; i < parameters.size(); i++) {
            if(i != 0)
                sb.append(',');
            sb.append(visit(parameters.get(i)));
        }
        sb.append(')');
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
        String id = visit(node.GetLeftChild()).toString();
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
    public Object visit(XandNode node) {
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
        return "BoolLit: "+ node.value;
    }

    @Override
    public Object visit(BreakNode node) {
        return "BREAK MOTHERFUCKERS!";
    }

    @Override
    public Object visit(CoordLit node) {
        return "CoordLit: ("+ node.x + ", " + node.y + ", " + node.z + ")";
    }

    @Override
    public Object visit(ElseNode node) {
        return "Else node:\n" + visit(node.GetLeftChild());
    }

    @Override
    public Object visit(ExprNode node) {
        Object lo = null;
        Object ro = null;

        if(node.GetLeftChild() != null)
            lo = visit(node.GetLeftChild());
        if(node.GetRightChild() != null)
            lo = visit(node.GetRightChild());

        return "ExprNode: " + lo.toString() +' ' + ro.toString();
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
        String body = visit(node.GetBody()).toString();
        String cond = visit(node.GetCondition()).toString();
        String elseIf = visit(node.GetElseIf()).toString();
        String els = visit(node.GetElse()).toString();

        return "if (" + cond + ") {\n" + body + "}\n" + elseIf + els;
    }

    @Override
    public Object visit(LoadNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("import ");

        for (Node n : node.GetChildren()) {
            String id = ((ProgNode) n)._id;
            sb.append(id.replace("\"", ""));
        }

        sb.append(';');
        return sb.toString();
    }

    @Override
    public Object visit(LoopNode node) {
        String expr = visit(node.GetLeftChild()).toString();
        String body = visit(node.GetLeftChild()).toString();

        return "while (!" + expr + ") {\n" + body + "}\n";
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        String id = visit(node.GetLeftChild()).toString();
        StringBuilder sb = new StringBuilder();

        for (Node n : node.GetChildren()) {
            sb.append(visit(n).toString() + ", ");
        }

        return id + "(" + sb.toString() + ")";
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
        return "SignalNode: " + visit(node.GetLeftChild()) + " " + visit(node.GetRightChild());
    }

    @Override
    public Object visit(StringLit node) {
        return "StringLit: " + node.text;
    }
}

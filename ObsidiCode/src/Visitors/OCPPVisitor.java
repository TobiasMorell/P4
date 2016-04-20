package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.*;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

import java.util.ArrayList;

/**
 * Created by morell on 4/19/16.
 */
public class OCPPVisitor extends AbstractVisitor {
    @Override
    public Object visit(Node n) {
        if(n != null)
            return n.Accept(this);
        else
            System.out.println("Found a null node, AST not supposed to have empty nodes!");
        return "FAULTY NODE!";
    }

    @Override
    public Object visit(BoolDcl node) {
        String lhs = (String) visit(node.GetLeftChild());
        String init = (String) visit(node.GetRightChild());

        return "BOOL " + lhs + " = " + init + '\n';
    }

    @Override
    public Object visit(CoordDcl node) {
        String lhs = (String) visit(node.GetLeftChild());
        String init = (String) visit(node.GetRightChild());

        return "COORD " + lhs + " = " + init + '\n';
    }

    @Override
    public Object visit(DeclarationNode node) {
        String lhs = (String) visit(node.GetLeftChild());
        String init = (String) visit(node.GetRightChild());

        return "UNKNOWN DECLARATION " + lhs + " = " + init + '\n';
    }

    @Override
    public Object visit(HearDcl node) {
        String id = node.id;
        StringBuilder sb = new StringBuilder();

        sb.append("HEAR ");
        sb.append(node.id);
        sb.append('(');

        ArrayList<Node> params = node.parameters;

        for (int i = 0; i < params.size(); i++) {
            if(i > 0)
                sb.append(", ");
            sb.append(visit(params.get(i)));
        }
        sb.append(")\n");
        sb.append(node.GetLeftChild());
        sb.append("END ");
        sb.append(node.id);
        sb.append('\n');

        return sb.toString();
    }

    @Override
    public Object visit(MethodDcl node) {
        String id = node.id;
        StringBuilder sb = new StringBuilder();

        sb.append(node.type);
        sb.append(' ');
        sb.append(node.id);
        sb.append('(');

        ArrayList<Node> params = node.parameters;

        for (int i = 0; i < params.size(); i++) {
            if(i > 0)
                sb.append(", ");
            sb.append(visit(params.get(i)));
        }

        sb.append(")\n");
        sb.append(visit(node.GetLeftChild()));
        sb.append("END ");
        sb.append(node.id);
        sb.append('\n');

        return sb.toString();
    }

    @Override
    public Object visit(NumDcl node) {
        StringBuilder sb = new StringBuilder();
        sb.append("NUM ");
        sb.append(visit(node.GetLeftChild()));

        if(node.GetRightChild() != null)
        {
            sb.append(" = ");
            sb.append(visit(node.GetRightChild()));
        }

        return sb.toString();
    }

    @Override
    public Object visit(ReferenceNode node) {
        return visit(node.GetId());
    }

    @Override
    public Object visit(StringDcl node) {
        StringBuilder sb = new StringBuilder();
        sb.append("STRING ");
        sb.append(visit(node.GetLeftChild()));

        if(node.GetRightChild() != null)
        {
            sb.append(" = ");
            sb.append(visit(node.GetRightChild()));
        }

        return sb.toString();
    }

    @Override
    public Object visit(ListDcl node) {
        StringBuilder sb = new StringBuilder();
        sb.append("LIST ");
        sb.append(visit(node.GetLeftChild()));

        if(node.GetRightChild() != null)
        {
            sb.append(" = ");
            sb.append(visit(node.GetRightChild()));
            sb.append("END ");
        }

        return sb.toString();
    }

    @Override
    public Object visit(GreaterEqualNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append( " GREATER_THAN_EQUAL ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(LessEqualNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append( " LESS_THAN_EQUAL ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(AndNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append( " AND ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(AssignNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" = ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(DivNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" / ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(GreaterNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" GREATER_THAN ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(IsNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" IS ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(LessNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" LESS_THAN ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(MinusNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" - ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(MultNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" * ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(NotNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" NOT ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(OrNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" OR ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(PlusNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append(" + ");
        sb.append(visit(node.GetRightChild()));

        return sb.toString();
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(" - ");
        sb.append(visit(node.GetLeftChild()));

        return sb.toString();
    }

    @Override
    public Object visit(XandNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(" XAND ");
        sb.append(visit(node.GetLeftChild()));

        return sb.toString();
    }

    @Override
    public Object visit(XorNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(" XOR ");
        sb.append(visit(node.GetLeftChild()));

        return sb.toString();
    }

    @Override
    public Object visit(BlockNode node) {
        StringBuilder sb = new StringBuilder();

        for (Node n : node.GetChildren()) {
            sb.append(visit(n));
            sb.append('\n');
        }

        return sb.toString();
    }

    @Override
    public Object visit(CollectionNode node) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Node> children = node.GetChildren();

        for (int i = 0; i < children.size(); i++) {
            /*if(i > 0)
                sb.append(", ");*/
            sb.append(visit(children.get(i)));
        }

        return sb.toString();
    }

    @Override
    public Object visit(BoolLit node) {
        return node.value;
    }

    @Override
    public Object visit(BreakNode node) {
        return "BREAK";
    }

    @Override
    public Object visit(CoordLit node) {
        return node.toString();
    }

    @Override
    public Object visit(ElseNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append("ELSE\n");
        sb.append(visit(node.GetLeftChild()));
        sb.append("END ELSE\n");

        return sb.toString();
    }

    @Override
    public Object visit(ExprNode node) {
        return "EXPRESSION! SHOULD NOT GET HERE!";
    }

    @Override
    public Object visit(IDNode node) {
        String ret = node.GetID();

        if(node._extension != null)
            ret += visit(node._extension);

        return ret;
    }

    @Override
    public Object visit(IfNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append("IF (");
        sb.append(visit(node.GetCondition()));
        sb.append(")\n");
        sb.append(visit(node.GetBody()));
        sb.append("END IF\n");

        if (node.GetElseIf() != null) {
            sb.append(visit(node.GetElseIf()));
            sb.append('\n');
        }

        if(node.GetElse() != null) {
            sb.append(visit(node.GetElse()));
            sb.append('\n');
        }

        return sb.toString();
    }

    @Override
    public Object visit(LoadNode node) {
        StringBuilder sb = new StringBuilder();

        for (Node n : node.GetChildren()) {
            sb.append("LOAD(");
            sb.append(((ProgNode) n)._id);
            sb.append(")\n");
        }

        return sb.toString();
    }

    @Override
    public Object visit(LoopNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append("REPEAT UNTIL(");
        sb.append(visit(node.GetLeftChild()));
        sb.append(")\n");
        sb.append(visit(node.GetRightChild()));
        sb.append("END REPEAT\n");

        return sb.toString();

    }

    @Override
    public Object visit(MethodInvocationNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(visit(node.GetLeftChild()));
        sb.append('(');

        ArrayList<Node> children = node.GetChildren();

        for (int i = 0; i < children.size(); i++) {
            if(i > 0)
                sb.append(',');
            sb.append(visit(children.get(i)));
        }
        sb.append(")\n");

        return sb.toString();
    }

    @Override
    public Object visit(NumLit node) {
        return node._value;
    }

    @Override
    public Object visit(ProgNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append(node._id);
        sb.append(":\n");

        for (Node n : node.GetChildren()) {
            sb.append(visit(n));
            sb.append('\n');
        }

        return sb.toString();
    }

    @Override
    public Object visit(ReturnNode node) {
        return "RETURN\n";
    }

    @Override
    public Object visit(SignalNode node) {
        StringBuilder sb = new StringBuilder();

        sb.append("SIGNAL ");
        sb.append(visit(node.GetLeftChild()));
        sb.append(visit(node.GetRightChild()));
        sb.append(")\n");

        return sb.toString();
    }

    @Override
    public Object visit(StringLit node) {
        return node.text;
    }

    @Override
    protected void VisitChildren(Node n) {
        super.VisitChildren(n);
    }

    @Override
    protected void VisitChildren(BinaryNode n) {
        super.VisitChildren(n);
    }

    @Override
    protected void VisitChildren(UnaryNode n) {
        super.VisitChildren(n);
    }

    @Override
    protected void VisitChildren(NaryNode n) {
        super.VisitChildren(n);
    }

    @Override
    protected void VisitChildren(LeafNode n) {
        super.VisitChildren(n);
    }
}

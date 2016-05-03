package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import TypeChecking.Symbol;
import TypeChecking.SymbolTable;
import TypeChecking.Func;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gedesnegl on 12-04-2016.
 */
public class DeclVisitor extends AbstractVisitor {
    SymbolTable _table;

    /***
     * @param Table The symboltable that the visitor should fill
     */
    public DeclVisitor(SymbolTable Table){
        _table = Table;
        visit(_table._ASTRoot);
    }

    /***
     * todo: Implement this method!
     * @param node a dot node that holds a reference to package/class/variable
     * @return null
     */
    @Override
    public Object visit(DotNode node) {
        return null;
    }

    @Override
    public Object visit(Node n) {
        return n.Accept(this);
    }

    @Override
    public Object visit(BoolDcl node) {
        System.out.println("Visiting BoolDcl" + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth);
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.bool);
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        System.out.println("Visiting CoordDcl " + _table.depth);
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.coord);
        return null;
    }

    @Override
    public Object visit(HearDcl node) {
        System.out.println("Visiting HearDcl " + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth);
        _table.functions.add(new Func(node));
        visit(node.GetLeftChild());
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        System.out.println("Visiting MethodDcl " + node.id +" "+ _table.depth);
        _table.functions.add(new Func(node));
        visit(node.GetLeftChild());
        return null;
    }

    @Override
    public Object visit(NumDcl node) {
        System.out.println("Visiting NumDcl " + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth);
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.num);
        if(node.GetRightChild() != null) {
            Node.Type t = GetExpressionType(node.GetRightChild());
        }
        return null;
    }


    @Override
    public Object visit(ReferenceNode node) {
        System.out.println("Visiting Reference " + node.GetId()._id +" "+ _table.depth);
        Symbol s = _table.RetrieveSymbol(node.GetId()._id);
        if(s != null) {
            return s.getType();
        }
        return null;
    }

    @Override
    public Object visit(StringDcl node) {
        System.out.println("Visiting StringDcl " + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth);
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.string);
        return null;
    }


    @Override
    public Object visit(ListDcl node) {
        System.out.println("Visiting ListDcl "+ ((IDNode)node.GetLeftChild())._id +" " + _table.depth);
        return null;
    }

    @Override
    public Object visit(GreaterEqualNode node) {
        return null;
    }

    @Override
    public Object visit(LessEqualNode node) {
        return null;
    }

    @Override
    public Object visit(AndNode node) {
        return null;
    }

    @Override
    public Object visit(AssignNode node) {
        System.out.println("Visiting AssignNode " + _table.depth);
        return null;
    }

    @Override
    public Object visit(DivNode node) {
        return null;
    }

    @Override
    public Object visit(GreaterNode node) {
        return null;
    }

    @Override
    public Object visit(IsNode node) {
        return null;
    }

    @Override
    public Object visit(LessNode node) {
        return null;
    }

    @Override
    public Object visit(MinusNode node) {
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        return null;
    }

    @Override
    public Object visit(NotNode node) {
        return null;
    }

    @Override
    public Object visit(OrNode node) {
        return null;
    }

    @Override
    public Object visit(PlusNode node) {
        Node.Type t, t1, t2;
        t1 = node.GetLeftChild().getT();

        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        return null;
    }

    @Override
    public Object visit(XnorNode node) {
        return null;
    }

    @Override
    public Object visit(XorNode node) {
        return null;
    }

    @Override
    public Object visit(BlockNode node) {
        System.out.println("Visiting BlockNode " + _table.depth);
        _table.OpenScope();
        for (Node child : node.GetChildren()) {
            visit(child);
        }
        _table.CloseScope();
        return null;
    }

    @Override
    public Object visit(CollectionNode node) {
        System.out.println("Visiting Collection " + _table.depth);
        for (Node child : node.GetChildren()) {
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(BoolLit node) {
        System.out.println("Visiting BoolLit ");
        return Node.Type.bool;
    }

    @Override
    public Object visit(BreakNode node) {
        return null;
    }

    @Override
    public Object visit(CoordLit node) {
        System.out.println("Visiting CoordLit ");
        return Node.Type.coord;
    }

    @Override
    public Object visit(ElseNode node) {
        return null;
    }

    @Override
    public Object visit(ExprNode node) {
        System.out.println("Visiting Expr " + _table.depth);
        return null;
    }

    @Override
    public Object visit(IDNode node) {
        return null;
    }

    @Override
    public Object visit(IfNode node) {
        System.out.println("Visiting IfNode " + _table.depth);
        if(node != null) {
            visit(node.GetBody());
            visit(node.GetElseIf());
            visit(node.GetElse());
        }
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        System.out.println("Visiting Load " + _table.depth);
        return null;
    }

    @Override
    public Object visit(LoopNode node) {
        System.out.println("Visiting LoopNode " + _table.depth);
        visit(node.GetLeftChild());
        visit(node.GetRightChild());
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        System.out.println("Visiting Invocation " + "with name: "+ ((IDNode)node.GetLeftChild())._id +" "+_table.depth);
        ArrayList<Node.Type> types = new ArrayList<>();
        for (Node n: node.GetChildren()) {
            types.add((Node.Type)visit(n));
        }
        return null;
    }

    @Override
    public Object visit(NumLit node) {
        System.out.println("Visiting NumLit " + node.line);
        return Node.Type.num;
    }

    @Override
    public Object visit(ProgNode node) {
        System.out.println("Visiting Prognode " + _table.depth);
        _table.OpenScope();
        for (Node child : node.GetChildren()) {
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(ReturnNode node) {
        return null;
    }

    @Override
    public Object visit(SignalNode node) {
        return null;
    }

    @Override
    public Object visit(StringLit node) {
        System.out.println("Visiting stringLit ");
        return Node.Type.string;
    }

    /***
     * This method gets the value type returned by a given expression.
     * @param node The Exprnode to be type checked
     * @return The type of the expression
     */
    private Node.Type GetExpressionType(Node node) {
        Node.Type t;
        if(!(node instanceof ExprNode)){
            if(node instanceof MethodInvocationNode){
                //_table.
            }
            _table.MakeError("This must be an expression");
        }
        ExprNode n = (ExprNode)node;
        t = n.type;

        if(t == Node.Type.unknown){

        }
        return Node.Type.num;
    }
}

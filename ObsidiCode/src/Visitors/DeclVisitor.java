package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.BinaryNode;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import TypeChecking.Symbol;
import TypeChecking.SymbolTable;
import TypeChecking.Func;

import java.lang.reflect.Type;
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
        System.out.println("Visiting BoolDcl" + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth+ " on line " + node.line);
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.bool);
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        System.out.println("Visiting CoordDcl " + _table.depth+ " on line " + node.line);
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.coord);
        return null;
    }

    @Override
    public Object visit(HearDcl node) {
        System.out.println("Visiting HearDcl " + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth+ " on line " + node.line);
        _table.functions.add(new Func(node));
        visit(node.GetLeftChild());
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        System.out.println("Visiting MethodDcl " + node.id +" "+ _table.depth+ " on line " + node.line);
        visit(node.GetLeftChild());
        return null;
    }

    @Override
    public Object visit(NumDcl node) {
        System.out.println("Visiting NumDcl " + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth+ " on line " + node.line);
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.num);
        if(node.GetRightChild() != null) {
           // Node.Type t = GetExpressionType(node.GetRightChild());todo: fix
        }
        return null;
    }


    @Override
    public Object visit(ReferenceNode node) {
        System.out.println("Visiting Reference " + node.GetId()._id +" "+ _table.depth+ " on line " + node.line);
        Symbol s = _table.RetrieveSymbol(node.GetId()._id);
        if(s != null) {
            return s.getType();
        }
        return null;
    }

    @Override
    public Object visit(StringDcl node) {
        System.out.println("Visiting StringDcl " + ((IDNode)node.GetLeftChild())._id +" "+ _table.depth+ " on line " + node.line);
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
        return CheckBool(node, "And");
    }

    @Override
    public Object visit(AssignNode node) {
        Node.Type t1, t2;
        System.out.println("Visiting AssignNode " + _table.depth+ " on line " + node.line);
        if(!(node.GetLeftChild() instanceof ReferenceNode)){
            _table.MakeError("Error: trying to assign to non variable");
        }else{
            //todo: visit children and compare types according to rules
        }
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
        return CheckBool(node, "or");
    }

    @Override
    public Object visit(PlusNode node) {
        Node.Type t1, t2;
        t1 = node.GetLeftChild().getT();
        t2 = node.GetLeftChild().getT();

        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        return null;
    }

    @Override
    public Object visit(XnorNode node) {
        return CheckBool(node, "Xnor");
    }

    @Override
    public Object visit(XorNode node) {
        return CheckBool(node, "Xor");
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
        System.out.println("Visiting BoolLit "+ " on line " + node.line);
        return Node.Type.bool;
    }

    @Override
    public Object visit(BreakNode node) {
        return null;
    }

    @Override
    public Object visit(CoordLit node) {
        System.out.println("Visiting CoordLit "+ " on line " + node.line);
        return Node.Type.coord;
    }

    @Override
    public Object visit(ElseNode node) {
        return null;
    }

    @Override
    public Object visit(ExprNode node) {
        System.out.println("Visiting Expr " + _table.depth+ " on line " + node.line);
        return null;
    }

    @Override
    public Object visit(IDNode node) {
        return null;
    }

    @Override
    public Object visit(IfNode node) {
        System.out.println("Visiting IfNode " + _table.depth+ " on line " + node.line);
        if(node != null) {
            visit(node.GetBody());
            visit(node.GetElseIf());
            visit(node.GetElse());
        }
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        System.out.println("Visiting Load " + _table.depth+ " on line " + node.line);
        return null;
    }

    @Override
    public Object visit(LoopNode node) {
        System.out.println("Visiting LoopNode " + _table.depth+ " on line " + node.line);
        visit(node.GetLeftChild());
        visit(node.GetRightChild());
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        System.out.println("Visiting Invocation " + "with name: "+ ((IDNode)node.GetLeftChild())._id +" "+_table.depth
                + " on line " + node.line);
        ArrayList<Node.Type> types = new ArrayList<>();
        for (Node n: node.GetChildren()) {
            types.add((Node.Type)visit(n));
        }
        Func function =_table.RetrieveMethod(node, types);
        if(function!=null) {
            return function.returnType;
        }
        return null;
    }

    @Override
    public Object visit(NumLit node) {
        System.out.println("Visiting NumLit "+ " on line " + node.line);
        return Node.Type.num;
    }

    @Override
    public Object visit(ProgNode node) {
        System.out.println("Visiting Prognode " + _table.depth+ " on line " + node.line);
        _table.OpenScope();
        for (Node child : node.GetChildren()) {
            if(child instanceof CollectionNode){
                for (Node grandchild: ((CollectionNode)child).GetChildren()) {
                    if(grandchild instanceof CollectionNode){
                        for (Node dcl: ((CollectionNode)grandchild).GetChildren()) {
                            _table.EnterSymbol(((DeclarationNode)dcl).GetID(),((DeclarationNode)dcl).type);
                        }
                    }else if(grandchild instanceof MethodDcl){
                        _table.functions.add(new Func((MethodDcl)grandchild));
                    }else{
                        _table.MakeError("Error: This should not happen!");
                    }
                }
                for (Node grandchild: ((CollectionNode)child).GetChildren()) {
                    if(!(grandchild instanceof CollectionNode)){
                        visit(grandchild);
                    }
                }
            }
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(ReturnNode node) {
        System.out.println("Visiting ReturnNode "+ " on line " + node.line);
        return visit(node.GetLeftChild());
    }

    @Override
    public Object visit(SignalNode node) {
        return null;
    }

    @Override
    public Object visit(StringLit node) {
        System.out.println("Visiting stringLit "+ " on line " + node.line);
        return Node.Type.string;
    }

    /***
     * This method gets the value type returned by a given expression.
     * @param node The Exprnode to be type checked
     * @return The type of the expression
     */
    private Node.Type CheckBool(BinaryNode node, String typename) {
        Node.Type t1,t2;
        t1 = (Node.Type)visit(node.GetLeftChild());
        t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.bool && t1 == t2){
            return t1;
        }
        _table.MakeError(String.format("Error : %s on line %d is not a boolean expression", typename, node.line));
        return null;
    }
}

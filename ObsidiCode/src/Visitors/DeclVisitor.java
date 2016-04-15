package Visitors;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import SymbolTable.SymbolTable;
import SymbolTable.Func;

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

    @Override
    public Object visit(Node n) {
        return n.Accept(this);
    }

    @Override
    public Object visit(BoolDcl node) {
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.bool);
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.coord);
        return null;
    }

    @Override
    public Object visit(DeclarationNode node) {
        return null;
    }

    @Override
    public Object visit(HearDcl node) {
        _table.functions.add(new Func(node));
        visit(node.GetLeftChild());
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        _table.functions.add(new Func(node));
        visit(node.GetLeftChild());
        return null;
    }

    @Override
    public Object visit(NumDcl node) {
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.num);
        return null;
    }

    @Override
    public Object visit(ReferenceNode node) {
        return null;
    }

    @Override
    public Object visit(StringDcl node) {
        _table.EnterSymbol(((IDNode)node.GetLeftChild()).GetID(), Node.Type.string);
        return null;
    }


    @Override
    public Object visit(ListDcl node) {
        //To be implemented
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
        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        return null;
    }

    @Override
    public Object visit(XandNode node) {
        return null;
    }

    @Override
    public Object visit(XorNode node) {
        return null;
    }

    @Override
    public Object visit(BlockNode node) {
        _table.OpenScope();
        for (Node child : node.GetChildren()) {
            visit(child);
        }
        _table.CloseScope();
        return null;
    }

    @Override
    public Object visit(CollectionNode node) {
        for (Node child : node.GetChildren()) {
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(BoolLit node) {
        return null;
    }

    @Override
    public Object visit(BreakNode node) {
        return null;
    }

    @Override
    public Object visit(CoordLit node) {
        return null;
    }

    @Override
    public Object visit(ElseNode node) {
        return null;
    }

    @Override
    public Object visit(ExprNode node) {
        return null;
    }

    @Override
    public Object visit(IDNode node) {
        return null;
    }

    @Override
    public Object visit(IfNode node) {
        for (Node child : node.GetChildren()) {
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        return null;
    }

    @Override
    public Object visit(LoopNode node) {
        for (Node child : ((BlockNode)node.GetRightChild()).GetChildren()) {
            visit(child);
        }
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        return null;
    }

    @Override
    public Object visit(NumLit node) {
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        System.out.print("Visiting Prognode");
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
        return null;
    }
}

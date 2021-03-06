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
import Utility.ErrorHandling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gedesnegl on 12-04-2016.
 */
public class DeclVisitor extends AbstractVisitor {
    SymbolTable _table;
    public static ArrayList<String> seenfiles = new ArrayList<>();
    int breakable = 0;

    /***
     * @param Table The symboltable that the visitor should fills
     */
    public DeclVisitor(SymbolTable Table){
        _table = Table;
        visit(_table._ASTRoot);
    }

    /***
     * todo: Implement this method! (on hold)
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
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.bool, node.line);
        if(node.GetRightChild()!= null) {
            if((Node.Type)visit(node.GetRightChild()) == Node.Type.bool) {
                return Node.Type.bool;
            }else{
                _table.MakeError("Error: Trying to initialize boolian with unmatching type ");
            }
        }
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.Coord, node.line);
        if(node.GetRightChild()!= null) {
            if((Node.Type)visit(node.GetRightChild()) == Node.Type.Coord) {
                return Node.Type.Coord;
            }else{
                _table.MakeError("Error: Trying to initialize coordinate with unmatching type ");
            }
        }
        return null;
    }

    @Override
    public Object visit(HearDcl node) {
        VisitMethod(node);
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        VisitMethod(node);
        return null;
    }

    public void VisitMethod(MethodDcl method){
        _table.OpenScope();
        for(Node n : method.parameters){
            visit(n);
        }
        for (Node n:((BlockNode)method.GetLeftChild()).GetChildren()) {
            visit(n);
        }
        _table.CloseScope();
    }

    @Override
    public Object visit(NumDcl node) {
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.num, node.line);
        if(node.GetRightChild()!= null) {
            if((Node.Type)visit(node.GetRightChild()) == Node.Type.num) {
                return Node.Type.num;
            }else{
                _table.MakeError("Error: Trying to initialize number with unmatching type ");
            }
        }
        return null;
    }


    @Override
    public Object visit(ReferenceNode node) {
        Symbol s = _table.RetrieveSymbol(node.GetId()._id); //
        if(s != null) {
            if(_table.depth == 0){
                node._GlobalRef = true;
            }
            node.setT(s.getType());
            return node.getT();
        }
        return null;
    }

    @Override
    public Object visit(StringDcl node) {
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.string, node.line);
        if(node.GetRightChild()!= null) {
            if((Node.Type)visit(node.GetRightChild()) == Node.Type.string) {
                return Node.Type.string;
            }else{
                _table.MakeError("Error: Trying to initialize string with unmatching type ");
            }
        }
        return null;
    }


    @Override
    public Object visit(ListDcl node) {
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.List, node.line);
        if(node.GetRightChild()!= null) {
            if((Node.Type)visit(node.GetRightChild()) == Node.Type.List) {
                return Node.Type.List;
            }else{
                _table.MakeError("Error: Trying to initialize List with unmatching type ");//todo: lists should not work this way.
            }
        }
        return null;
    }

    @Override
    public Object visit(GreaterEqualNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.bool && t2 == Node.Type.bool){
            node.setT(Node.Type.bool);
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the Greater than Or Equal operator", node.line);
        }
        return null;
    }

    @Override
    public Object visit(LessEqualNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.bool && t2 == Node.Type.bool){
            node.setT(Node.Type.bool);
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the Less than Or Equal operator", node.line);
        }
        return null;
    }

    @Override
    public Object visit(AndNode node) {
        node.setT(Node.Type.bool);
        return CheckBool(node, "And");
    }

    @Override
    public Object visit(AssignNode node) {
        Node.Type t1, t2;
        if(!(node.GetLeftChild() instanceof ReferenceNode)){
            _table.MakeError("Error: trying to assign to non variable");
        }else{
            t2 = (Node.Type)visit(node.GetRightChild());
            String refID = ((ReferenceNode)node.GetLeftChild()).GetId()._id;
            Symbol s = _table.RetrieveSymbol(refID);
            if (s!= null)
                t1 = s.getType();
            else{
                _table.MakeError("Error: Variable "+refID+" does not exist in current scope");
                return null;
            }
            if(t1 == t2) {
                return t1;
            }else{
                _table.MakeError("Error: Trying to assign value of type " + t2 + " to variable of type " + t1 + " on line " + node.line);
            }
        }

        return null;
    }

    @Override
    public Object visit(DivNode node) {
        Node.Type t1, t2;
        t1 = (Node.Type)visit(node.GetLeftChild());
        t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == null || t2 == null)
            _table.MakeError("Error: Element in Division on line "+node.line+" has no type");
        switch (t1){
            case num:
                switch (t2){
                    case num:
                        node.setT(Node.Type.num);
                        return Node.Type.num;
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case List:case bool:case string:
                        _table.MakeError("Error: Numbers can only be divided with numbers and coords");
                        break;
                    default:
                        _table.MakeError("Shouldn't happen");
                }
                break;
            case bool:
                if(t2 == Node.Type.bool) {
                    node.setT(Node.Type.bool);
                    return Node.Type.bool;
                }
                _table.MakeError("Error: Boolean can only be Divided with boolean");
                break;
            case string:
                switch (t2){
                    case string:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    default:
                        _table.MakeError("Error: String can only be divided with string");
                }
                break;
            case Coord:
                switch (t2){
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case num:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    default:
                        _table.MakeError("Error: Coordinates can only be divided with numbers and coordinates");
                }
                break;
            case List:
                _table.MakeError("Error: Lists cannot be divided with anything");
                break;
            default:
                _table.MakeError("Error: Left side of assign on line "+node.line+" statement has no type");
        }

        return null;
    }

    @Override
    public Object visit(GreaterNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.bool && t2 == Node.Type.bool){
            node.setT( Node.Type.bool);
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the Greater than operator", node.line);
        }
        return null;
    }

    @Override
    public Object visit(IsNode node) {//todo: discuss weather Is is a good representation of ==<
        node.setT(Node.Type.bool);
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1==t2){
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Error: Is expression on line "+node.line+" compares values of different types");
            return Node.Type.bool;
        }
    }

    @Override
    public Object visit(LessNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.bool && t2 == Node.Type.bool){
            node.setT(Node.Type.bool);//todo check shit;
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the less than operator", node.line);
        }
        return null;
    }

    @Override
    public Object visit(MinusNode node) {
        Node.Type t1, t2;
        t1 = (Node.Type)visit(node.GetLeftChild());
        t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == null || t2 == null)
            _table.MakeError("Error: Element in MinusNode on line "+node.line+" has no type");
        switch (t1){
            case num:
                switch (t2){
                    case num:
                        node.setT(Node.Type.num);
                        return Node.Type.num;
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case List:case bool:case string:
                        _table.MakeError("Error: Cannot subtract Lists, Booleans or strings from numbers");
                        break;
                    default:
                        _table.MakeError("Shouldn't happen");
                }
                break;
            case bool:
                if(t2 == Node.Type.bool) {
                    node.setT(Node.Type.bool);
                    return Node.Type.bool;
                }
                _table.MakeError("Error: nothing but boolean can be subtracted from boolean");
                break;
            case string:
                switch (t2){
                    case string:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    default:
                        _table.MakeError("Error: nothing but strings can be subtracted form string");
                }
                break;
            case Coord:
                switch (t2){
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case num:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    default:
                        _table.MakeError("Error: only coordinates and numbers can be subtracted from coordinate");
                }
                break;
            case List:
                switch (t2){
                    case num:case bool:case string:case Coord:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                }
                break;
            default:
                _table.MakeError("Error: Left side of assign on line "+node.line+" statement has no type");
        }

        return null;
    }

    @Override
    public Object visit(MultNode node) {
        Node.Type t1, t2;
        t1 = (Node.Type)visit(node.GetLeftChild());
        t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == null || t2 == null)
            _table.MakeError("Error: Element in Multiplication on line "+node.line+" has no type");
        else switch (t1){
            case num:
                switch (t2){
                    case num:
                        node.setT(Node.Type.num);
                        return Node.Type.num;
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case List:case bool:case string:
                        _table.MakeError("Error: Cannot multiply Lists, Booleans or strings with numbers");
                        break;
                    default:
                        _table.MakeError("Shouldn't happen");
                }
                break;
            case bool:
                if(t2 == Node.Type.bool) {
                    node.setT(Node.Type.bool);
                    return Node.Type.bool;
                }
                _table.MakeError("Error: nothing but boolean can be multiplied with boolean");
                break;
            case string:
                switch (t2){
                    case string:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    case num:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    default:
                        _table.MakeError("Error: nothing but strings and numbers can be multiplied with string");
                }
                break;
            case Coord:
                switch (t2){
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case num:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    default:
                        _table.MakeError("Error: only coordinates and numbers can be multiplied with coordinate");
                }
                break;
            case List:
                _table.MakeError("Error: Lists cannot be multiplied with anything");
                break;
            default:
                _table.MakeError("Error: Left side of assign on line "+node.line+" statement has no type");
        }

        return null;
    }

    @Override
    public Object visit(NotNode node) {
        node.setT(Node.Type.bool);
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        if(t1== Node.Type.bool){
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Error: Trying to negate non boolean expression on line "+node.line);
            return null;
        }
    }

    @Override
    public Object visit(OrNode node) {
        node.setT(Node.Type.bool);
        return CheckBool(node, "or");
    }

    @Override
    public Object visit(PlusNode node) {
        Node.Type t1, t2;
        t1 = (Node.Type)visit(node.GetLeftChild());
        t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == null || t2 == null) {
            _table.MakeError("Error: Element in PlusNode on line " + node.line + " has no type");
            return null;
        }
        switch (t1){
            case num:
                switch (t2){
                    case num:
                        node.setT(Node.Type.num);
                        return Node.Type.num;
                    case string:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case List:case bool:
                        _table.MakeError("Error: Cannot add Lists or Booleans to numbers");
                        break;
                    default:
                        _table.MakeError("Shouldn't happen");
                }
                break;
            case bool:
                switch (t2){
                    case bool:
                        node.setT(Node.Type.bool);
                        return Node.Type.bool;
                    case string:
                        return Node.Type.string;
                    default:
                        ErrorHandling.Error("Only boolean and string can be added to boolean", node.line);
                        break;
                }
            case string:
                switch (t2){
                    case num:case string:case bool:case Coord:case List:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    default:
                        _table.MakeError("Shouldn't happen");
                    }
                break;
            case Coord:
                switch (t2){
                    case Coord:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case num:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    case string:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    default:
                        ErrorHandling.Error("Trying to add value of uncompatible type to coordinate",node.line);
                }
                break;
            case List:
                if(t2 != null) {
                    node.setT(Node.Type.List);
                    return Node.Type.List;
                }
                break;
            default:
                _table.MakeError("Error: Left side of assign on line "+node.line+" statement has no type");
        }

        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        Node.Type t1;
        t1 = (Node.Type)visit(node.GetLeftChild());
        if(t1 == null)
            _table.MakeError("Error: Element in unary minus on line "+node.line+" has no type");
        switch (t1){
            case num:
                node.setT(Node.Type.num);
                return Node.Type.num;
            case Coord:
                node.setT(Node.Type.Coord);
                return Node.Type.Coord;
            case bool:
                node.setT(Node.Type.bool);
                return Node.Type.bool;
            case List:case string:
                _table.MakeError("Error: Lists and strings can not be negative");
            default:
                _table.MakeError("This cannot happn'");
        }
        return null;
    }

    @Override
    public Object visit(XnorNode node) {
        node.setT(Node.Type.bool);
        return CheckBool(node, "Xnor");
    }

    @Override
    public Object visit(XorNode node) {
        node.setT(Node.Type.bool);
        return CheckBool(node, "Xor");
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
        node.setT(Node.Type.bool);
        return Node.Type.bool;
    }

    @Override
    public Object visit(BreakNode node) {
        if(breakable == 0){
            ErrorHandling.Error("Nothing to break out of", node.line);
        }
        return null;
    }

    @Override
    public Object visit(CoordLit node) {
        node.setT(Node.Type.Coord);
        return Node.Type.Coord;
    }

    @Override
    public Object visit(ElseNode node) {
        if(node != null){
            visit(node.GetLeftChild());
        }
        return null;
    }

    @Override
    public Object visit(ExprNode node) {
        return null;
    }

    @Override
    public Object visit(ParenNode node) {
        //System.out.println("Visiting Parentheses " + _table.depth + "on line " + node.line);
        Node.Type t = (Node.Type) visit(node.GetLeftChild());
        node.setT(t);
        return t;
    }

    @Override
    public Object visit(IDNode node) {
        return null;
    }

    @Override
    public Object visit(IfNode node) {
        breakable++;
        if(node != null) {
            if(visit(node.GetCondition()) == Node.Type.bool) {
                visit(node.GetBody());
                visit(node.GetElseIf());
                visit(node.GetElse());
            }else{
                ErrorHandling.Error("Condition in if statement is not boolean",node.line);
            }
        }
        breakable--;
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        return null;
    }

    @Override
    public Object visit(LoopNode node) {
        breakable++;
        //System.out.println("Visiting LoopNode " + _table.depth+ " on line " + node.line);
        if(visit(node.GetLeftChild()) == Node.Type.bool){
            visit(node.GetRightChild());
        }else{
            ErrorHandling.Error("Condition in if statement is not boolean",node.line);
        }
        breakable--;
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        ArrayList<Node.Type> types = new ArrayList<>();
        for (Node n: node.GetChildren()) {
            types.add((Node.Type)visit(n));
        }
        Func function =_table.RetrieveMethod(node, types);
        if(function!=null) {
            node.setT(function.returnType);
            return function.returnType;
        }
        return null;
    }

    @Override
    public Object visit(NumLit node) {
        node.setT(Node.Type.num);
        return Node.Type.num;
    }

    @Override
    public Object visit(ProgNode node) {
        _table.OpenScope();
        for (Node child : node.GetChildren()) {
            if(child instanceof CollectionNode){
                for (Node grandchild: ((CollectionNode)child).GetChildren()) {
                    if(grandchild instanceof CollectionNode){
                        visit(grandchild);
                    }else if(grandchild instanceof MethodDcl){
                        Func f = new Func((MethodDcl)grandchild);
                        _table.functions.add(f);
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
        }
        for (Func f:_table.functions) {
            if(f.name.equals("START")){
                return null;
            }
        }
        ErrorHandling.Error("Error: Program " + node._id + " Has no start method");
        return null;
    }

    @Override
    public Object visit(ReturnNode node) {
        return visit(node.GetLeftChild());
    }

    @Override
    public Object visit(SignalNode node) {
        return null;
    }

    @Override
    public Object visit(StringLit node) {
        node.setT(Node.Type.string);
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

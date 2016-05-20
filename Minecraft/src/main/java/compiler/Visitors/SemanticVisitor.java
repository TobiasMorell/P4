package compiler.Visitors;

import compiler.ASTNodes.Declarations.*;
import compiler.ASTNodes.GeneralNodes.BinaryNode;
import compiler.ASTNodes.GeneralNodes.CollectionNode;
import compiler.ASTNodes.GeneralNodes.Node;
import compiler.ASTNodes.Operators.*;
import compiler.ASTNodes.SyntaxNodes.*;
import compiler.TypeChecking.Symbol;
import compiler.TypeChecking.SymbolTable;
import compiler.TypeChecking.Func;
import compiler.Utility.ErrorHandling;

import java.util.ArrayList;

/**
 * Created by Gedesnegl on 12-04-2016.
 */
public class SemanticVisitor extends AbstractVisitor {
    SymbolTable _table;
    public static ArrayList<String> seenfiles = new ArrayList<String>();
    int breakable = 0;

    /***
     * @param Table The symboltable that the visitor should fills
     */
    public SemanticVisitor(SymbolTable Table){
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
            Node.Type RHS = (Node.Type) visit(node.GetRightChild());
            if(RHS == Node.Type.bool) {
                return Node.Type.bool;
            }else if(RHS == Node.Type.List){
                ErrorHandling.Error("Trying to initialize boolean with unmatching type",node.line);
            }
        }
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.Coord, node.line);
        if(node.GetRightChild()!= null) {
            Node.Type RHS = (Node.Type) visit(node.GetRightChild());
            if(RHS == Node.Type.Coord) {
                return Node.Type.Coord;
            }else if(RHS != Node.Type.List){
                ErrorHandling.Error("Trying to initialize coordinate with unmatching type",node.line);
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
        boolean foundReturn = false;
        for(Node n : method.parameters){
            visit(n);
        }
        for (Node n:((BlockNode)method.GetLeftChild()).GetChildren()) {
            visit(n);
            if(n instanceof ReturnNode){
                foundReturn = true;
                if(n.getT() != method.getT()){
                    ErrorHandling.Error("Trying to return "+ n.getT() +" in method of type "+ method.getT(),method.line);
                }
            }
        }
        if ( method.getT() != Node.Type.Void && !foundReturn){
            ErrorHandling.Error("Method "+method.id+" needs to have a return statement that is always reachable.");
        }
        _table.CloseScope();
    }

    @Override
    public Object visit(NumDcl node) {
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.num, node.line);
        if(node.GetRightChild()!= null) {
            Node.Type RHS = (Node.Type) visit(node.GetRightChild());
            if(RHS == Node.Type.num) {
                return Node.Type.num;
            }else if(RHS != Node.Type.List){
                ErrorHandling.Error("Trying to initialize number with unmatching type", node.line);
            }
        }
        return null;
    }


    @Override
    public Object visit(ReferenceNode node) {
        Symbol s = _table.RetrieveSymbol(node.GetId()._id,node.line); //
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
            Node.Type RHS = (Node.Type) visit(node.GetRightChild());
            if(RHS == Node.Type.string) {
                return Node.Type.string;
            }else if(RHS != Node.Type.List){
                ErrorHandling.Error("Trying to initialize string with unmatching type",node.line);
            }
        }
        return null;
    }


    @Override
    public Object visit(ListDcl node) {
        _table.EnterSymbol(((IDNode) node.GetLeftChild()).GetID(), Node.Type.List, node.line);
        node.setT(Node.Type.List);
        if(node.GetRightChild() instanceof CollectionNode)
            return Node.Type.List;
        else
            ErrorHandling.Error("Trying to initialize List with unmatching type",node.line);
        return null;
    }

    @Override
    public Object visit(GreaterEqualNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.num && t2 == Node.Type.num){
            node.setT(Node.Type.bool);//todo check shit;
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the GREATER_THAN_EQUAL operator", node.line);
        }
        return null;
    }

    @Override
    public Object visit(LessEqualNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.num && t2 == Node.Type.num){
            node.setT(Node.Type.bool);//todo check shit;
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the LESS_THAN_EQUAL operator", node.line);
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
            ErrorHandling.Error("trying to assign to non variable",node.line);
        }else{
            t2 = (Node.Type)visit(node.GetRightChild());
            String refID = ((ReferenceNode)node.GetLeftChild()).GetId()._id;
            Symbol s = _table.RetrieveSymbol(refID,node.line);
            if (s!= null)
                t1 = s.getType();
            else{
                ErrorHandling.Error("Variable "+refID+" does not exist in current scope",node.line);
                return null;
            }
            if(t1 == t2) {
                ((ReferenceNode) node.GetLeftChild()).set_isValue(false);
                return t1;
            }else{
                if(t2 != Node.Type.List)
                    ErrorHandling.Error("Trying to assign value of type " + t2 + " to variable of type " + t1, node.line);
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
            ErrorHandling.Error("Element in division has no type",node.line);
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
                        ErrorHandling.Error("Numbers can only be divided with numbers and coords",node.line);
                        break;
                    default:
                        ErrorHandling.Error("Shouldn't happen.",node.line);
                }
                break;
            case bool:
                if(t2 == Node.Type.bool) {
                    node.setT(Node.Type.bool);
                    return Node.Type.bool;
                }
                ErrorHandling.Error("Boolean can only be Divided with boolean",node.line);
                break;
            case string:
                switch (t2){
                    case string:
                        node.setT(Node.Type.string);
                        return Node.Type.string;
                    default:
                        ErrorHandling.Error("String can only be divided with string",node.line);
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
                        ErrorHandling.Error("Coordinates can only be divided with numbers and coordinates",node.line);
                }
                break;
            case List:
                ErrorHandling.Error("Lists cannot be divided with anything",node.line);
                break;
            default:
                ErrorHandling.Error("Left side of division has no type",node.line);
        }

        return null;
    }

    @Override
    public Object visit(GreaterNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.num && t2 == Node.Type.num){
            node.setT(Node.Type.bool);
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the GREATER_THAN operator", node.line);
        }
        return null;
    }

    @Override
    public Object visit(IsNode node) {
        node.setT(Node.Type.bool);
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1==t2){
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("IS expression on line "+node.line+" cannot compare values of different types");
            return Node.Type.bool;
        }
    }

    @Override
    public Object visit(LessNode node) {
        Node.Type t1 = (Node.Type)visit(node.GetLeftChild());
        Node.Type t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == Node.Type.num && t2 == Node.Type.num){
            node.setT(Node.Type.bool);
            return Node.Type.bool;
        }else{
            ErrorHandling.Error("Only numbers can be compared with the LESS_THAN operator", node.line);
        }
        return null;
    }

    @Override
    public Object visit(MinusNode node) {
        Node.Type t1, t2;
        t1 = (Node.Type)visit(node.GetLeftChild());
        t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == null || t2 == null)
            ErrorHandling.Error("Element in MinusNode has no type",node.line);
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
                        ErrorHandling.Error("Cannot subtract Lists, Booleans or strings from numbers",node.line);
                        break;
                    default:
                        ErrorHandling.Error("Shouldn't happen, line ",node.line);
                }
                break;
            case bool:
                if(t2 == Node.Type.bool) {
                    node.setT(Node.Type.bool);
                    return Node.Type.bool;
                }
                ErrorHandling.Error("Nothing but boolean can be subtracted from boolean",node.line);
                break;
            case string:
                switch (t2){
                    case string:
                        node.setT( Node.Type.string);
                        return Node.Type.string;
                    default:
                        ErrorHandling.Error("Nothing but strings can be subtracted form string",node.line);
                }
                break;
            case Coord:
                switch (t2){
                    case Coord:
                        node.setT( Node.Type.Coord);
                        return Node.Type.Coord;
                    case num:
                        node.setT(Node.Type.Coord);
                        return Node.Type.Coord;
                    default:
                        ErrorHandling.Error("Only coordinates and numbers can be subtracted from coordinates",node.line);
                }
                break;
            case List:
                if(node.GetRightChild() != null) {
                    node.setT(Node.Type.List);
                    return Node.Type.List;
                }
                break;
            default:
                ErrorHandling.Error("Left side of minus statement has no type",node.line);
        }

        return null;
    }

    @Override
    public Object visit(MultNode node) {
        Node.Type t1, t2;
        t1 = (Node.Type)visit(node.GetLeftChild());
        t2 = (Node.Type)visit(node.GetRightChild());
        if(t1 == null || t2 == null)
            ErrorHandling.Error("Element in Multiplication has no type",node.line);
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
                        ErrorHandling.Error("Cannot multiply Lists, booleans or strings with numbers",node.line);
                        break;
                    default:
                        ErrorHandling.Error("Shouldn't happen ",node.line);
                }
                break;
            case bool:
                if(t2 == Node.Type.bool) {
                    node.setT(Node.Type.bool);
                    return Node.Type.bool;
                }
                ErrorHandling.Error("Only booleans may be multiplied with booleans",node.line);
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
                        ErrorHandling.Error("Nothing but strings and numbers can be multiplied with strings",node.line);
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
                        ErrorHandling.Error("Only coordinates and numbers may be multiplied with coordinates",node.line);
                }
                break;
            case List:
                ErrorHandling.Error("Lists cannot be multiplied with anything",node.line);
                break;
            default:
                ErrorHandling.Error("Left side of multiplication statement has no type",node.line);
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
            ErrorHandling.Error("Negation of non-boolean expressions are not allowed",node.line);
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
            ErrorHandling.Error("Element in PlusNode has no type",node.line);
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
                        node.setT( Node.Type.Coord);
                        return Node.Type.Coord;
                    case List:case bool:
                        ErrorHandling.Error("Cannot add Lists or Booleans to numbers",node.line);
                        break;
                    default:
                        ErrorHandling.Error("Shouldn't happen",node.line);
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
                        ErrorHandling.Error("Shouldn't happen",node.line);
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
                ErrorHandling.Error("Left side of addition statement has no type",node.line);
        }

        return null;
    }

    @Override
    public Object visit(UnaryMinusNode node) {
        Node.Type t1;
        t1 = (Node.Type)visit(node.GetLeftChild());
        if(t1 == null)
            ErrorHandling.Error("Element in unary minus has no type",node.line);
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
                ErrorHandling.Error("Lists and strings can not be negative",node.line);
            default:
                ErrorHandling.Error("This cannot happen",node.line);
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
            Node n = node.GetCondition();
            if(n != null && visit(n) == Node.Type.bool) {
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
            ErrorHandling.Error("Condition in loop statement is not boolean",node.line);
        }
        breakable--;
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {
        ArrayList<Node.Type> types = new ArrayList<Node.Type>();
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
                        ErrorHandling.Error("Error: This should not happen!",node.line);
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
        ErrorHandling.Error("Program " + node._id + " must specify a 'VOID START()'-method");
        return null;
    }

    @Override
    public Object visit(ReturnNode node) {
        node.setT((Node.Type)visit(node.GetLeftChild()));
        return node.getT();
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
        ErrorHandling.Error(String.format("Both sides %s expression must be of type boolean", typename),node.line);
        return null;
    }
}

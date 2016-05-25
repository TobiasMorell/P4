package Visitors.CodeGeneration;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.CollectionNode;
import ASTNodes.GeneralNodes.Node;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import Visitors.AbstractVisitor;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by morell on 4/26/16.
 */
public class JvmCodeVisitor extends AbstractVisitor {


    private String robotName;
    protected StringBuilder codeBuilder = new StringBuilder();
    private String fullyQualifiedClassName;
    private Integer ActiveIndex;
    HashMap<String, Integer> ActiveVars = new HashMap<>(1000);
    int labelCounter = 0;

    public String GetrobotName()
    {
        return this.robotName;
    }

    //dictionary, index via navn og værdi er hvilket register

    //Notes, kunne godt have brugt et simple med antallet af locals vars til at bestemme limiten i methods, samme med antallet af ting der udregnes på stacken


   /*
    For byte, from -128 to 127  inclusive
• For short, from -32768 to 32767  inclusive
• For int, from -2147483648 to 2147483647 inclusive
• For long, from -9223372036854775808 to 9223372036854775807 inclusive
• For char, from 0 to 65535 inclusive
     */

    public String GetSource()
    {
        return codeBuilder.toString();
    }

    private void emitHeader()
    {
        //class declaration

        //Insert placeholder path
        fullyQualifiedClassName = robotName + "Robot";
        codeBuilder.append(String.format(".class public %s\n", fullyQualifiedClassName));
        //should be changed to SyncRobot
        //When syncrobot is available
        codeBuilder.append(".super java/lang/Object\n");
        codeBuilder.append("\n");
        //Constructor
        codeBuilder.append(".method public <init>()V\n");
        codeBuilder.append("aload_0\n");
        //Constructor call to super, in this case Object
        codeBuilder.append("invokenonvirtual java/lang/Object/<init>()V\n");
        codeBuilder.append("return \n");
        codeBuilder.append(".end method\n\n");

        //Inserting code for main, should probly be placed elsewhere
        codeBuilder.append(".method public static main([Ljava/lang/String;)V\n");
        //These values need to change depending of how many vars are needed.
        codeBuilder.append(".limit locals 5\n");
        codeBuilder.append(".limit stack 5\n");
        //What the heck is the fully qualified class name of this class?
        codeBuilder.append(String.format("new %s\n",fullyQualifiedClassName));
        codeBuilder.append("dup\n");
        codeBuilder.append(String.format("invokespecial %s/<init>()V\n", fullyQualifiedClassName));
        codeBuilder.append(String.format("invokevirtual %s/START()V\n", fullyQualifiedClassName));
        //codeBuilder.append(String.format("invokestatic %sRobot/methodname(params)ReturnT \n", robotName));
        codeBuilder.append("return \n");
        codeBuilder.append(".end method\n\n");




    }


    private void visitDclGeneric(DeclarationNode node)
    {
        //pushdown the value
        //then pop it into a suitable value
        //Needs to check what kind of storage leftchild is local or field and type of field static or instance
        if(node.GetRightChild() != null) visit(node.GetRightChild());
        String varname = node.GetID();
        ActiveVars.put(varname, ActiveIndex);
        String realtype = GetJVMSimpleType(node);
        codeBuilder.append(String.format("%sstore %d\n", realtype, ActiveVars.get(varname)));
        ActiveIndex++;
    }



    @Override
    public Object visit(BoolDcl node) {
        visitDclGeneric(node);
        return null;
    }

    @Override
    public Object visit(CoordDcl node) {
        return null;
    }

    @Override
    public Object visit(HearDcl node) {
        return null;
    }

    @Override
    public Object visit(MethodDcl node) {
        ActiveVars.clear();
        ActiveIndex = 0;

        //Since its a instance method, the zero index will hold a reference to the object (this)
        ActiveVars.put("this", 0);
        ActiveIndex++;
        codeBuilder.append(".method public ");
        codeBuilder.append(node.id);
        codeBuilder.append("(");
        ArrayList<Node> params = node.parameters;
        for (int i = 0; i < params.size(); i++) {
            Node n = params.get(i);
            //Types, B byte, F float, C character, D double,  J long,  S short, Z boolean
            codeBuilder.append(GetFormalJVMType(n));
            visit(n.GetLeftChild());
        }
        codeBuilder.append(")");
        codeBuilder.append(GetFormalJVMType(node));
        codeBuilder.append("\n");
        //generic limit stack n locsls 100
        codeBuilder.append(".limit stack 100\n");
        codeBuilder.append(".limit locals 100\n");
        //Call the body
        visit(node.GetLeftChild());
        //the body will normally call the return stat, but if no return is explicitly written it must be written anyway
        codeBuilder.append("return\n");
        codeBuilder.append(".end method\n\n");
        return null;

    }

    @Override
    public Object visit(NumDcl node) {
        visitDclGeneric(node);
        return null;
    }

    @Override
    public Object visit(ReferenceNode node) {
        //Id holds the name of the variable that reference node points to.
        //Simply loads the content of the reference onto TOS
        String id = node.GetId()._id;
        codeBuilder.append(String.format("fload %d\n", ActiveVars.get(id)));
        return null;
    }

    @Override
    public Object visit(StringDcl node) {
        return null;
    }

    @Override
    public Object visit(ListDcl node) {
        return null;
    }

    @Override
    public Object visit(DotNode node) {
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
        if(node.GetLeftChild().getT() == Node.Type.num && node.GetRightChild().getT() == Node.Type.num){
            visit(node.GetLeftChild());
            visit(node.GetRightChild());
            codeBuilder.append("fdiv \n");
        }
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
        if(node.GetLeftChild().getT() == Node.Type.num && node.GetRightChild().getT() == Node.Type.num){
            visit(node.GetLeftChild());
            visit(node.GetRightChild());
            codeBuilder.append("fsub \n");
        }
        return null;
    }

    @Override
    public Object visit(MultNode node) {
        if(node.GetLeftChild().getT() == Node.Type.num && node.GetRightChild().getT() == Node.Type.num){
            visit(node.GetLeftChild());
            visit(node.GetRightChild());
            codeBuilder.append("fmul \n");
        }
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
         if(node.GetLeftChild().getT() == Node.Type.num && node.GetRightChild().getT() == Node.Type.num){
            visit(node.GetLeftChild());
            visit(node.GetRightChild());
            codeBuilder.append("fadd \n");
        }
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
        for (Node n : node.GetChildren()) {
            visit(n);
        }
        return null;
    }

    @Override
    public Object visit(CollectionNode node) {
        for (Node n : node.GetChildren()) visit(n);
        return null;
    }

    @Override
    public Object visit(BoolLit node) {
        //Bools are represented as integers, nonzero is true, zero is false
        if(node.value.toLowerCase().equals("true")) codeBuilder.append("iconst_1\n");
        else codeBuilder.append("iconst_0\n");
        return null;
    }

    @Override
    public Object visit(BreakNode node) {
        //returns control
        codeBuilder.append("return \n");
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
        //Not active use generic expr node instead with actual types
        return null;
    }

    @Override
    public Object visit(ParenNode node) {
        return null;
    }

    @Override
    public Object visit(IDNode node) {

        if(node._parent instanceof ReferenceNode) {
            //used for the method name ie methodname(params)
            codeBuilder.append(node.GetID());
        }
        else {
            //This is used for method params ie methodname(params)
            //The jvm already stores the params, so they are simply added to internally keep track of them
            String name = node.GetID();
            ActiveVars.put(name, ActiveIndex);
            ActiveIndex++;
        }
        return null;
    }

    @Override
    public Object visit(IfNode node) {
        return null;
    }

    @Override
    public Object visit(LoadNode node) {
        return null;
    }

    @Override
    public Object visit(LoopNode node) {
        return null;
    }

    @Override
    public Object visit(MethodInvocationNode node) {

        //Creates a reference to the class
        codeBuilder.append(String.format("new %s\n",fullyQualifiedClassName));
        //Duplicates the TOS element, the class reference
        codeBuilder.append("dup\n");
        //Invokes the constructor for the class, and consumes a reference to the class
        codeBuilder.append(String.format("invokespecial %s/<init>()V\n", fullyQualifiedClassName));

        //Insert arguments on stack before the call to the method
        ArrayList<Node> args = node.GetChildren();
        for (int i = 0; i < args.size(); i++) {
            Node n = args.get(i);
            visit(n);
        }
        //invokes class method witht the TOS elements
        codeBuilder.append(String.format("invokevirtual %s/", fullyQualifiedClassName));
        //visit the leftchild for name of method
        visit(node.GetLeftChild());
        //Insert formal param types
        codeBuilder.append("(");
        for (int i = 0; i < args.size(); i++) {
            Node n = args.get(i);
            codeBuilder.append(GetFormalJVMType(n));
        }
        codeBuilder.append(")");
        //Insert formal return type
        codeBuilder.append(GetFormalJVMType(node));
        codeBuilder.append("\n");
        return null;
    }

    @Override
    public Object visit(NumLit node) {
        codeBuilder.append(String.format("ldc %f\n", node._value));
        //As long as the ldc takes a numeral with .0 accuracy, its considered float
        //if(node._value % 1 == 0) codeBuilder.append("i2f\n");
        return null;
    }

    @Override
    public Object visit(ProgNode node) {
        robotName = node._id;
        emitHeader();
        for (Node n : node.GetChildren()
                ) { visit(n);
        }
        return null;
    }

    @Override
    public Object visit(ReturnNode node) {
        //Loads value onto stack, then uses appropiate f/i/a/return
        visit(node.GetLeftChild());
        String type = GetJVMSimpleType(node.GetLeftChild());
        codeBuilder.append(type);
        codeBuilder.append("return ");
        codeBuilder.append("\n");
        return null;
    }

    @Override
    public Object visit(SignalNode node) {
        return null;
    }

    @Override
    public Object visit(StringLit node) {
        codeBuilder.append(String.format("ldc %s\n", node.text));
        return null;
    }

    // TODO: 20/05/2016 this will have to be renamed maybe to formalparamtypes
    private String GetFormalJVMType(Node node)
    {
        //Types, B byte, F float, C character, D double,  J long,  S short, Z boolean
        String type = null;
        switch (node.getT())
        {
            case bool:
                type = "Z";
                break;
            case num:
                type = "F";
                break;
            case string:
                type = "Ljava/lang/String;";
                break;
            case Void:
                type = "V";
                break;
            default:
                type = "";
                break;
        }
        return type;
    }


    private String GetJVMSimpleType(Node node)
    {
        String type;
        switch(node.getT())  {
            case bool:
                type = "i";
                break;
            case num:
                type = "f";
                break;
            case string:
                type = "a";
                break;
            case Coord:
                type = "a";
                break;
            case Void:
                type = "";
                break;
            default:
                type = "";
                break;
        }
        return type;
    }
    
    



}

package Visitors;

import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.*;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;
import ObsidiCodeAntlr.*;
import Utility.ErrorHandling;

//The generic type must be the super class of the returned node, in this case Node.
public class BuildASTVisitor extends ObsidiCodeBaseVisitor<Node> {
	public static int line = 0;

	private void giveContextToNodes(CollectionNode declarations, int type)
	{
		//A list to store declarations of correct type
		ArrayList<Node> decls = new ArrayList<Node>();

		for(Node decl : declarations.GetChildren())
		{
			IDNode id = null;
			Node initialization = null;

			if(decl instanceof ListDcl)
			{
				decls.add(decl);
				break;
			}
			
			//Found an IDNode, meaning there's no initialization
			if(decl instanceof IDNode)
			{
				IDNode dn = (IDNode) decl;
				initialization = null;
			}
			//Found an assignment node, meaning that the variable has been initialized
			else if (decl instanceof AssignNode)
			{
				AssignNode an = (AssignNode) decl;
				initialization = an.GetRightChild();
				id = ((ReferenceNode) decl.GetLeftChild()).GetId();
			}
			else if (decl instanceof ReferenceNode)
			{
				ReferenceNode rn = (ReferenceNode) decl;
				id = rn.GetId();
				initialization = null;
			}
			
			switch(type) {
			case ObsidiCodeParser.NUM:
				decls.add(new NumDcl(id, initialization));
				break;
			case ObsidiCodeParser.STRING:
				decls.add(new StringDcl(id, initialization));
				break;
			case ObsidiCodeParser.BOOL:
				decls.add(new BoolDcl(id, initialization));
				break;
			case ObsidiCodeParser.COORD:
				decls.add(new CoordDcl(id, initialization));
				break;
			}
		}

		declarations.SetChildren(decls);
	}
	
	@Override
	public Node visitProg(ObsidiCodeParser.ProgContext ctx) {
		line = ctx.getStart().getLine();
		ProgNode pn = (ProgNode) visit(ctx.roboDcl());
		Node load = visit(ctx.loads());
		if (load != null)
			pn.AddNode(load);
		pn.AddNode(visit(ctx.roboBodyDcl()));

		return pn;
	}

	@Override
	public Node visitLiteral(ObsidiCodeParser.LiteralContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.NumLit() != null)
			return new NumLit(Float.parseFloat(ctx.NumLit().getText()));
		else if(ctx.CoordLit() != null){
			String coord = ctx.CoordLit().getText();
			//Remove parentheses
			coord = coord.replace("(", "");
			coord = coord.replace(")", "");
			//Trim white-space
			coord = coord.trim();
			//And split on the comma
			String[] splitCoords = coord.split(",");
			//Create a new CoordLit from the found values
			return new CoordLit(splitCoords);
		}
		else if(ctx.StringLit() != null)
			return new StringLit(ctx.StringLit().getText());
		else
			return new BoolLit(ctx.getChild(0).getText());
	}

	@Override
	public Node visitTypeNameMethodInvoc(ObsidiCodeParser.TypeNameMethodInvocContext ctx) {
		line = ctx.getStart().getLine();
		return new DotNode(visit(ctx.meth), ctx.parent.getText()); // Fix dis error monday!
	}

	@Override
	public Node visitTypeNameIdentifier(ObsidiCodeParser.TypeNameIdentifierContext ctx) {
		line = ctx.getStart().getLine();
		String id = ctx.id.getText();
		Node ref;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.TypeNameContext)
			ref = new DotNode(visit(ctx.parent), id);
		else
			ref = new ReferenceNode( ctx.id.getText() );
		
		return ref;
	}

	@Override
	public Node visitTypePrefix(ObsidiCodeParser.TypePrefixContext ctx) {
		return null;
	}

	@Override
	public Node visitLambdaLoad(ObsidiCodeParser.LambdaLoadContext ctx) {
		return null;
	}

	@Override
	public Node visitLambdaLoadNewLine(ObsidiCodeParser.LambdaLoadNewLineContext ctx) {
		line = ctx.getStart().getLine();
		return super.visitLambdaLoadNewLine(ctx);
	}

	@Override
	public Node visitNonLambdaLoad(ObsidiCodeParser.NonLambdaLoadContext ctx) {
		line = ctx.getStart().getLine();
		LoadNode ln = (LoadNode) visit(ctx.recursion);

		//The child was empty i.e. last step of recursion
		if(ln == null)
			ln = new LoadNode();

		ln.AddNode(new ProgNode(new ArrayList<Node>(), ctx.load_id.getText()));
		return ln;
	}

	@Override
	public Node visitRoboDcl(ObsidiCodeParser.RoboDclContext ctx) {
		line = ctx.getStart().getLine();
		String robotName = ctx.id.getText();
		ArrayList<Node> stmts = new ArrayList<>();
		return new ProgNode(stmts, robotName);
	}

	@Override
	public Node visitRoboBodyDcl(ObsidiCodeParser.RoboBodyDclContext ctx) {
		line = ctx.getStart().getLine();
		CollectionNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.RoboBodyDclContext)
			//There are still more global-scope declarations to be processed
			bn = (CollectionNode) visit(ctx.recursion);
		else
			//The last node is being processed, create new list
			bn = new CollectionNode();
		
		//Add both nodes of the given context, if they're not empty statements
		Node n = visit(ctx.dcl);
		if(n != null)
			bn.AddNode(n);
		
		return bn;
	}

	@Override
	public Node visitMemberDeclNotLambda(ObsidiCodeParser.MemberDeclNotLambdaContext ctx) {
		line = ctx.getStart().getLine();
		//Not an empty statement - parse it!
		if(ctx.met_dcl != null)
			return visit(ctx.met_dcl);

		return visit(ctx.dcl);
	}

	@Override
	public Node visitMemberDclLambda(ObsidiCodeParser.MemberDclLambdaContext ctx) {
		line = ctx.getStart().getLine();
		return null;
	}

	@Override
	public Node visitFieldDcl(ObsidiCodeParser.FieldDclContext ctx) {
		line = ctx.getStart().getLine();
		//Find the identifier and value of given declaration
		CollectionNode decls = (CollectionNode) visit(ctx.dcl_list);
		
		giveContextToNodes(decls, ctx.t.type.getType());
		return decls;
	}

	@Override
	public Node visitVariableDclList(ObsidiCodeParser.VariableDclListContext ctx) {
		line = ctx.getStart().getLine();
		CollectionNode declarations;
		
		/*The strategy used here (and all of the other recursively defined rules is
		 *to have the base case (here the rule variableDclList -> variableDcl) generate a BlockNode to
		 *contain all the nodes from further up the tree.
		 *Thereby by visiting the first rule (here variableDclList -> variableDclList, primary) 
		 *the recursion will return a BlockNode containing all nodes in the tree below. The only 
		 *thing to do now is to add the primary and return the BlockNode.
		*/
		if(ctx.getChild(0) instanceof ObsidiCodeParser.VariableDclContext)
			//Only one declaration left
			declarations = new CollectionNode();
		else
			//still more declarations to process
			declarations = (CollectionNode) visit(ctx.list);
		declarations.AddNode(visit(ctx.single));
			
		return declarations;
	}

	@Override
	public Node visitVariableDcl(ObsidiCodeParser.VariableDclContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.VariableInitializerContext)
			return visit(ctx.var_init);
		else
			return new ListDcl(new IDNode(ctx.id.getText()), (CollectionNode) visit(ctx.list_init));
	}

	@Override
	public Node visitVariableInitializer(ObsidiCodeParser.VariableInitializerContext ctx) {
		line = ctx.getStart().getLine();
		Node n = visit(ctx.expr);
		
		if(n instanceof AssignNode || n instanceof ReferenceNode)
		{
			return n;
		}
		else {
			System.out.println("Could not figure out what to do"); //Shitty error-handling again!
			ErrorHandling.Error("Found no AssignNodes or ReferenceNodes in ", n);
			return null;
		}
	}

	@Override
	public Node visitListInitializer(ObsidiCodeParser.ListInitializerContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) != null)
			return visit(ctx.list);

		return null;
	}

	@Override
	public Node visitLitList(ObsidiCodeParser.LitListContext ctx) {
		line = ctx.getStart().getLine();
		CollectionNode cn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.PrimaryContext)
			//Last variable of the list
			cn = new CollectionNode();
		else
			cn = (CollectionNode) visit(ctx.list);
			//Omit the comma
		cn.AddNode(visit(ctx.single));

		return cn;
	}

	@Override
	public Node visitMethodDcl(ObsidiCodeParser.MethodDclContext ctx) {
		line = ctx.getStart().getLine();

		MethodDcl dcl = null;
		if(ctx.header != null)
			dcl = (MethodDcl) visit(ctx.header);
		else if(ctx.hearDcl() != null)
			dcl = (HearDcl) visit(ctx.hearDcl());
		if(dcl != null)
			dcl.AddBody((BlockNode) visit(ctx.body));
		return dcl;
	}

	@Override
	public Node visitMethodHeader(ObsidiCodeParser.MethodHeaderContext ctx) {
		line = ctx.getStart().getLine();
		Node.Type t;
		CollectionNode cn = (CollectionNode) visit(ctx.declarator); //Stores params
		
		if(ctx.getChild(0).getText().equals("VOID"))
			t = Node.Type.Void;
		else {
			switch(ctx.t.type.getType()){
			case ObsidiCodeParser.NUM:
				t = Node.Type.num;
				break;
			case ObsidiCodeParser.STRING:
				t = Node.Type.string;
				break;
			case ObsidiCodeParser.COORD:
				t = Node.Type.coord;
				break;
			case ObsidiCodeParser.BOOL:
				t = Node.Type.bool;
				break;
			default :
				t = null;
			}
		}

		ArrayList<Node> params;
		if(cn != null)
			params = cn.GetChildren();
		else
			params = new ArrayList<Node>();

		//null is the body, added higher in the tree
		return new MethodDcl(ctx.declarator.id.getText(), params, t, null);
	}

	@Override
	public Node visitMethodDeclarator(ObsidiCodeParser.MethodDeclaratorContext ctx) {
		line = ctx.getStart().getLine();
		//Find the params and return them (id is handled in visitMethodHeader
		return visit(ctx.params);
	}

	@Override
	public Node visitMethodBody(ObsidiCodeParser.MethodBodyContext ctx) {
		line = ctx.getStart().getLine();
		//Just skip this and don't mind the 'END' identifier part.
		return visit(ctx.body);
	}

	@Override
	public Node visitHearDcl(ObsidiCodeParser.HearDclContext ctx) {
		line = ctx.getStart().getLine();
		//Find parameters
		CollectionNode params = (CollectionNode) visit(ctx.params);
		
		//Find the body
		BlockNode body = (BlockNode) visit(ctx.body);
		
		//Return a new HearDcl, which collects all the found information
		return new HearDcl(ctx.id.getText(), params.GetChildren(), body);
	}

	@Override
	public Node visitBlock(ObsidiCodeParser.BlockContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.BlockStmtListContext)
			return visit(ctx.list);
		
		return null;
	}

	@Override
	public Node visitBlockStmtList(ObsidiCodeParser.BlockStmtListContext ctx) {
		line = ctx.getStart().getLine();
		BlockNode bn;
		if(ctx.getChild(0) instanceof ObsidiCodeParser.BlockStmtListContext)
			bn = (BlockNode) visit(ctx.list);
		else
			bn = new BlockNode();

		Node res = visit(ctx.stmt);
		if(res != null)
			bn.AddNode(res);
		return bn;
	}

	@Override
	public Node visitStatement(ObsidiCodeParser.StatementContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.t != null)
		{
			CollectionNode cn = (CollectionNode) visit(ctx.dcl);
			giveContextToNodes(cn, ctx.t.type.getType());

			return cn;
		}
		else
		{
			if(ctx.skipIf != null)
				return visit(ctx.skipIf);
			else if(ctx.skipLoop != null)
				return visit(ctx.skipLoop);
			else
				return visit(ctx.skipNoSub);
		}
	}

	@Override
	public Node visitNoSubLambda(ObsidiCodeParser.NoSubLambdaContext ctx) {
		return null;
	}

	@Override
	public Node visitNoSubSkip(ObsidiCodeParser.NoSubSkipContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.skipSignal != null)
			return visit(ctx.skipSignal);
		else if (ctx.skipExpr != null)
			return visit(ctx.skipExpr);
		//Should not reach this point!
		return null;
	}

	@Override
	public Node visitNoSubBrk(ObsidiCodeParser.NoSubBrkContext ctx) {
		line = ctx.getStart().getLine();
		return new BreakNode();
	}

	@Override
	public Node visitNoSubRet(ObsidiCodeParser.NoSubRetContext ctx) {
		line = ctx.getStart().getLine();
		return new ReturnNode((ExprNode) visit(ctx.expr));
	}

	@Override
	public Node visitSignalStmt(ObsidiCodeParser.SignalStmtContext ctx) {
		line = ctx.getStart().getLine();
		//Find the id of the signal
		IDNode id = new IDNode(ctx.id.getText());
		
		//Find all the arguments and store them in a block node
		CollectionNode args = (CollectionNode) visit(ctx.arguments);
		
		return new SignalNode(id, args);
	}

	@Override
	public Node visitExprStmt(ObsidiCodeParser.ExprStmtContext ctx) {
		line = ctx.getStart().getLine();
		// Will always just need to visit the first child
		if(ctx.meth_invoc != null)
			return visit(ctx.meth_invoc);
		else
			return visit(ctx.assExpr);
	}

	@Override
	public Node visitMethodInvocation(ObsidiCodeParser.MethodInvocationContext ctx) {
		line = ctx.getStart().getLine();
		ReferenceNode id = (ReferenceNode) visit(ctx.id);
		
		CollectionNode args = (CollectionNode) visit(ctx.args);
		ArrayList<Node> argList;
		if(args == null)
			argList = new ArrayList<>();
		else
			argList = args.GetChildren();

		return new MethodInvocationNode(id.GetId(), argList);
	}

	@Override
	public Node visitIfStmt(ObsidiCodeParser.IfStmtContext ctx) {
		line = ctx.getStart().getLine();
		Node expr = visit(ctx.expr);
		BlockNode body = (BlockNode) visit(ctx.body);
		IfNode elseIf = (IfNode) visit(ctx.elseIfStmt);
		BlockNode elseRes = (BlockNode) visit(ctx.elseStmt);
		
		ArrayList<Node> listOfIfNodes = new ArrayList<Node>();
		listOfIfNodes.add(expr);
		listOfIfNodes.add(body);
		if(elseIf != null)
			listOfIfNodes.add(elseIf);
		if(elseRes != null)
		{
			ElseNode en = new ElseNode(elseRes);
			listOfIfNodes.add(en);
		}
		
		return new IfNode(listOfIfNodes);
	}

	@Override
	public Node visitElseIf(ObsidiCodeParser.ElseIfContext ctx) {
		line = ctx.getStart().getLine();
		//Generate nodes for each of the parts of the else-if
		IfNode recursion = (IfNode) visit(ctx.recursion);
		Node condition = visit(ctx.expr);
		BlockNode body = (BlockNode) visit(ctx.body);
		
		//Add to list
		ArrayList<Node> al = new ArrayList<Node>();
		if(recursion != null)
			al.add(recursion);
		al.add(condition);
		if(body != null)
			al.add(body);
		
		return new IfNode(al);
	}

	@Override
	public Node visitNoElseIf(ObsidiCodeParser.NoElseIfContext ctx) {
		return null;
	}

	@Override
	public Node visitElse(ObsidiCodeParser.ElseContext ctx) {
		line = ctx.getStart().getLine();
		//Generate nodes for all parts of the statement
		line = line +2;
		BlockNode bn = (BlockNode) visit(ctx.body) ;
		
		return bn;
	}

	@Override
	public Node visitNoElse(ObsidiCodeParser.NoElseContext ctx) {
		return null;
	}

	@Override
	public Node visitLoopStmt(ObsidiCodeParser.LoopStmtContext ctx) {
		line = ctx.getStart().getLine();
		//Just skip this rule and handle the next
		if(ctx.ever != null)
			return visit(ctx.ever);
		else
			return visit(ctx.rep);
	}

	@Override
	public Node visitRepeatStmt(ObsidiCodeParser.RepeatStmtContext ctx) {
		line = ctx.getStart().getLine();
		//Generate nodes for expression and body part
		ExprNode expr = (ExprNode) visit(ctx.expr);
		BlockNode bn = (BlockNode) visit(ctx.body);
		
		return new LoopNode(expr, bn);
	}

	@Override
	public Node visitForeverStmt(ObsidiCodeParser.ForeverStmtContext ctx) {
		line = ctx.getStart().getLine();
		//Generate a loop node, that has 'false' as ExprNode
		ExprNode expr = new BoolLit("FALSE");
		BlockNode bn = (BlockNode) visit(ctx.body);
		
		return new LoopNode(expr, bn);
	}

	@Override
	public Node visitFormalArgs(ObsidiCodeParser.FormalArgsContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ArgsListContext)
			return visit(ctx.list);
		
		return null;
	}

	@Override
	public Node visitArgsList(ObsidiCodeParser.ArgsListContext ctx) {
		line = ctx.getStart().getLine();
		CollectionNode cn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ArgsListContext)
			cn = (CollectionNode) visit(ctx.argsList());
		else
			cn = new CollectionNode();
		cn.AddNode(visit(ctx.expression()));
		
		return cn;
	}

	@Override
	public Node visitFormalParams(ObsidiCodeParser.FormalParamsContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.list != null)
			return visit(ctx.list);

		return null;
	}

	@Override
	public Node visitParamsList(ObsidiCodeParser.ParamsListContext ctx) {
		line = ctx.getStart().getLine();
		CollectionNode cn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ParamContext)
			//Only one param, instantiate list and add parameter
			cn = new CollectionNode();
		else
			//Recurse to find all params and add the current
			cn = (CollectionNode) visit(ctx.list);

		cn.AddNode(visit(ctx.p));

		return cn;
	}

	@Override
	public Node visitParam(ObsidiCodeParser.ParamContext ctx) {
		line = ctx.getStart().getLine();
		Node decl = null;
		switch(ctx.t.type.getType()){
		case ObsidiCodeParser.NUM:
			decl = new NumDcl(ctx.id.getText(), null);
			break;
		case ObsidiCodeParser.COORD:
			decl = new CoordDcl(ctx.id.getText(), null);
			break;
		case ObsidiCodeParser.BOOL:
			decl = new BoolDcl(ctx.id.getText(), null);
			break;
		case ObsidiCodeParser.STRING:
			decl = new StringDcl(ctx.id.getText(), null);
			break;
		}
		return decl;
	}

	@Override
	public Node visitExpression(ObsidiCodeParser.ExpressionContext ctx) {
		line = ctx.getStart().getLine();
		return visit(ctx.assignmentExpression());
	}

	@Override
	public Node visitAssignmentExpression(ObsidiCodeParser.AssignmentExpressionContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.skipAss != null)
			return visit(ctx.skipAss);
		else
			return visit(ctx.skipCond);
	}

	@Override
	public Node visitAssignment(ObsidiCodeParser.AssignmentContext ctx) {
		line = ctx.getStart().getLine();
		//Generate a node for lhs and rhs
		Node lhs = visit(ctx.lhs);
		Node expr = visit(ctx.expr);
		
		return new AssignNode(lhs, expr);
	}

	@Override
	public Node visitLeftHandSide(ObsidiCodeParser.LeftHandSideContext ctx) {
		line = ctx.getStart().getLine();
		Node access = visit(ctx.tn);
		ExprNode optExt = (ExprNode) visit(ctx.ext);
		
		if(access instanceof ReferenceNode && optExt != null)
			((ReferenceNode) access).GetId().AddExtension(optExt);
		
		return access;
	}

	@Override
	public Node visitListOpt(ObsidiCodeParser.ListOptContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.expr != null)
			return visit(ctx.expr);
		
		return null;
	}

	@Override
	public Node visitConditionalExpression(ObsidiCodeParser.ConditionalExpressionContext ctx) {
		line = ctx.getStart().getLine();
		return visit(ctx.or);
	}

	@Override
	public Node visitConditionOrExpression(ObsidiCodeParser.ConditionOrExpressionContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ConditionAndExpressionContext)
			return visit(ctx.and);
		else
			return new OrNode(visit(ctx.or), visit(ctx.and));
	}

	@Override
	public Node visitConditionAndExpression(ObsidiCodeParser.ConditionAndExpressionContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.XOrExpressionContext)
			return visit(ctx.xor);
		else
			return new AndNode(visit(ctx.and), visit(ctx.xor));
	}

	@Override
	public Node visitXOrExpression(ObsidiCodeParser.XOrExpressionContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.EqualityExpressionContext)
			return visit(ctx.eq);
		else
			return new XorNode(visit(ctx.xor), visit(ctx.eq));
	}

	@Override
	public Node visitEqualityExpression(ObsidiCodeParser.EqualityExpressionContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.RelationalExpressionContext)
			return visit(ctx.rel);
		else{
			BinaryNode bn = (BinaryNode)visit(ctx.eq_end);
			bn.SetLeftmostNode(visit(ctx.eq));
			return bn;
		}
	}

	@Override
	public Node visitEqualityExpressionEnd(ObsidiCodeParser.EqualityExpressionEndContext ctx) {
		line = ctx.getStart().getLine();
		switch(ctx.eq_mod.getType())
		{
		case ObsidiCodeParser.EQ_MOD_IS:
			return new IsNode(null, visit(ctx.rel));
		case ObsidiCodeParser.EQ_MOD_NOT:
			return new NotNode(null, visit(ctx.rel));
		}
		
		return null;
	}

	@Override
	public Node visitRelationalExpression(ObsidiCodeParser.RelationalExpressionContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.AdditiveExpressionContext)
			return visit(ctx.add);
		else {
			BinaryNode bn = (BinaryNode) visit(ctx.rel_end);
			bn.SetLeftmostNode(visit(ctx.rel));
			return bn;
		}
	}

	@Override
	public Node visitRelationalExpressionEnd(ObsidiCodeParser.RelationalExpressionEndContext ctx) {
		line = ctx.getStart().getLine();
		switch(ctx.relational_key.getType())
		{
		case ObsidiCodeParser.RELATIONAL_KEY_GT:
			return new GreaterNode(null, visit(ctx.add));
		case ObsidiCodeParser.RELATIONAL_KEY_LT:
			return new LessNode(null, visit(ctx.add));
		case ObsidiCodeParser.RELATIONAL_KEY_LTE:
			return new LessEqualNode(null, visit(ctx.add));
		case ObsidiCodeParser.RELATIONAL_KEY_GTE:
			return new GreaterEqualNode(null, visit(ctx.add));
		}
		return null;
	}

	@Override
	public Node visitAdditiveExpression(ObsidiCodeParser.AdditiveExpressionContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.MultiExprContext)
			return visit(ctx.mult);
		else {
			BinaryNode bn = (BinaryNode) visit(ctx.add_end);
			bn.SetLeftmostNode(visit(ctx.add));
			return bn;
		}
	}

	@Override
	public Node visitAdditiveExpressionEnd(ObsidiCodeParser.AdditiveExpressionEndContext ctx) {
		line = ctx.getStart().getLine();
		switch(ctx.op.getType()) {
		case ObsidiCodeParser.OP_MINUS:
			return new MinusNode(null, visit(ctx.mult));
		case ObsidiCodeParser.OP_PLUS:
			return new PlusNode(null, visit(ctx.mult));
		}
		
		return null;
	}

	@Override
	public Node visitMultiExpr(ObsidiCodeParser.MultiExprContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.UnaryExprContext)
			return visit(ctx.un);
		else {
			BinaryNode bn = (BinaryNode) visit(ctx.mult_end);
			bn.SetLeftmostNode(visit(ctx.mult));
			return bn;
		}
	}

	@Override
	public Node visitMultiExprEnd(ObsidiCodeParser.MultiExprEndContext ctx) {
		line = ctx.getStart().getLine();
		switch(ctx.op.getType()){
		case ObsidiCodeParser.OP_DIV:
			return new DivNode(null, visit(ctx.un));
		case ObsidiCodeParser.OP_MULT:
			return new MultNode(null, visit(ctx.un));
		}
		return null;
	}

	@Override
	public Node visitUnaryExpr(ObsidiCodeParser.UnaryExprContext ctx) {
		line = ctx.getStart().getLine();
		if(ctx.getChild(0) instanceof ObsidiCodeParser.PrimaryContext)
			return visit(ctx.prim);
		else
			return new UnaryMinusNode(visit(ctx.unaryExpr()));
	}

	@Override
	public Node visitPrimaryLiteral(ObsidiCodeParser.PrimaryLiteralContext ctx) {
		line = ctx.getStart().getLine();
		return visit(ctx.literal());
	}

	@Override
	public Node visitParenExpr(ObsidiCodeParser.ParenExprContext ctx) {
		line = ctx.getStart().getLine();
		return visit(ctx.expression());
	}

	@Override
	public Node visitPrimaryIdRef(ObsidiCodeParser.PrimaryIdRefContext ctx) {
		line = ctx.getStart().getLine();
		return visit(ctx.lhs);
	}

	@Override
	public Node visitPrimaryMethodInvoc(ObsidiCodeParser.PrimaryMethodInvocContext ctx) {
		line = ctx.getStart().getLine();
		return visit(ctx.methodInvocation());
	}	
}

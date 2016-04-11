import java.util.ArrayList;
import java.util.List;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.*;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

//The generic type must be the super class of the returned node, in this case Node.
public class BuildASTVisitor extends ObsidiCodeBaseVisitor<Node>{

	private void giveContextToNodes(BlockNode bn, int type)
	{
		//This switch could be implemented a lot better with generics, give it a go!
		for (Node decl : bn.GetStatements())
		{
			IDNode id = null;
			ExprNode initialization = null;
			
			//Remove the node from the list and replace it with a declaration with a type
			bn.GetStatements().remove(decl);
			
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
				initialization = (ExprNode) an.GetRightChild();
			}
			
			switch(type) {
			case ObsidiCodeParser.NUM:
				bn.AddNode(new NumDcl(id, initialization));
				break;
			case ObsidiCodeParser.STRING:
				bn.AddNode(new StringDcl(id, initialization));
				break;
			case ObsidiCodeParser.BOOL:
				bn.AddNode(new BoolDcl(id, initialization));
				break;
			case ObsidiCodeParser.COORD:
				bn.AddNode(new CoordDcl(id, initialization));
				break;
			}
		}
	}
	
	@Override
	public Node visitProg(ObsidiCodeParser.ProgContext ctx) {
		ProgNode pn = (ProgNode) visit(ctx.roboDcl());
		pn.AddNode(visit(ctx.loads()));
		
		return pn;
	}

	@Override
	public Node visitLiteral(ObsidiCodeParser.LiteralContext ctx) {
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
	public Node visitTypeName(ObsidiCodeParser.TypeNameContext ctx) {
		ReferenceNode ref = new ReferenceNode( ctx.id.getText() );
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.TypeNameContext)
			visit(ctx.parent);
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
	public Node visitNonLambdaLoad(ObsidiCodeParser.NonLambdaLoadContext ctx) {
		LoadNode ln = (LoadNode) visit(ctx.recursion);

		//The child was empty i.e. last step of recursion
		if(ln == null)
			ln = new LoadNode();

		ln.AddNode(new ProgNode(new ArrayList<Node>(), ctx.load_id.getText()));
		return ln;
	}

	@Override
	public Node visitRoboDcl(ObsidiCodeParser.RoboDclContext ctx) {
		String robotName = ctx.id.getText();
		System.out.println("The name of the program is: " + robotName); //<------- for TESTING 

		System.out.println("Initializing list...");
		ArrayList<Node> stmts = new ArrayList<>(10);

		return new ProgNode(stmts, robotName);
	}

	@Override
	public Node visitRoboBodyDcl(ObsidiCodeParser.RoboBodyDclContext ctx) {
		BlockNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.RoboBodyDclContext){
			//There are still more global-scope declarations to be processed
			bn = (BlockNode) visit(ctx.recursion);
		}
		else
		{
			//The last node is being processed, create new list
			bn = new BlockNode(new ArrayList<Node>());
		}
		
		//Add both nodes of the given context, if they're not empty statements
		Node n = visit(ctx.dcl);
		if(n != null)
			bn.AddNode(n);
		
		return bn;
	}

	@Override
	public Node visitMemberDcl(ObsidiCodeParser.MemberDclContext ctx) {
		//Find out if it's an empty statement
		if(ctx.getChild(0).getText().equals("\n"))
			return null;
		else if(ctx.getChild(0) instanceof ObsidiCodeParser.FieldDclContext)
			return visit(ctx.dcl);
		
		//Not an empty statement - parse it!
		return visit(ctx.met_dcl);
	}

	@Override
	public Node visitFieldDcl(ObsidiCodeParser.FieldDclContext ctx) {		
		//Find the identifier and value of given declaration
		BlockNode bn = (BlockNode) visit(ctx.dcl_list);
		
		giveContextToNodes(bn, ctx.t.type.getType());
		
		return bn;
	}

	@Override
	public Node visitVariableDclList(ObsidiCodeParser.VariableDclListContext ctx) {
		BlockNode declarations;
		
		/*The strategy used here (and all of the other recursively defined rules is
		 *to have the base case (here the rule variableDclList -> variableDcl) generate a BlockNode to
		 *contain all the nodes from further up the tree.
		 *Thereby by visiting the first rule (here variableDclList -> variableDclList, primary) 
		 *the recursion will return a BlockNode containing all nodes in the tree below. The only 
		 *thing to do now is to add the primary and return the BlockNode.
		*/
		if(ctx.getChild(0) instanceof ObsidiCodeParser.VariableDclContext)
		{
			//Only one declaration left
			declarations = new BlockNode();
			declarations.AddNode(visit(ctx.single));
		}
		else {
			//still more declarations to process
			declarations = (BlockNode) visit(ctx.list);
			declarations.AddNode(visit(ctx.single));
		}
			
		return declarations;
	}

	@Override
	public Node visitVariableDcl(ObsidiCodeParser.VariableDclContext ctx) {
		if(ctx.getChild(0) instanceof ObsidiCodeParser.VariableInitializerContext)
			return visit(ctx.var_init);
		else {
			//Still needs code to initialize lists!!!
			return null; //Actually some list!
		}
	}

	@Override
	public Node visitVariableInitializer(ObsidiCodeParser.VariableInitializerContext ctx) {
		Node n = visit(ctx.expr);
		
		if(n instanceof AssignNode || n instanceof IDNode)
		{
			return n;
		}
		else {
			System.out.println("Could not figure out what to do"); //Shitty error-handling again!
			return null;
		}
	}

	@Override
	public Node visitListInitializer(ObsidiCodeParser.ListInitializerContext ctx) {
		return visit(ctx.list);
		
		//Again still need code to process lists.
	}

	@Override
	public Node visitLitList(ObsidiCodeParser.LitListContext ctx) {
		BlockNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.PrimaryContext)
		{
			//Last variable of the list
			bn = new BlockNode();
			bn.AddNode(visit(ctx.single));
		}
		else
		{
			bn = (BlockNode) visit(ctx.list);
			//Omit the comma
			bn.AddNode(visit(ctx.single));
		}
		
		return bn;
	}

	@Override
	public Node visitMethodDcl(ObsidiCodeParser.MethodDclContext ctx) {
		MethodDcl dcl = (MethodDcl) visit(ctx.header);
		dcl.AddBody((BlockNode) visit(ctx.body));
		return dcl;
	}

	@Override
	public Node visitMethodHeader(ObsidiCodeParser.MethodHeaderContext ctx) {
		Node.Type t;
		BlockNode bn = (BlockNode) visit(ctx.declarator); //Stores identifier and params
		
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
			
		return new MethodDcl(ctx.declarator.id.getText(), bn.GetStatements(), t, null);
	}

	@Override
	public Node visitMethodDeclarator(ObsidiCodeParser.MethodDeclaratorContext ctx) {
		//Find the params and return them (id is handled in visitMethodHeader
		return (BlockNode) visit(ctx.params);
	}

	@Override
	public Node visitMethodBody(ObsidiCodeParser.MethodBodyContext ctx) {
		//Just skip this and don't mind the 'END' identifier part.
		return visit(ctx.body);
	}

	@Override
	public Node visitHearDcl(ObsidiCodeParser.HearDclContext ctx) {
		//Find parameters
		BlockNode params = (BlockNode) visit(ctx.params);
		
		//Find the body
		BlockNode body = (BlockNode) visit(ctx.body);
		
		//Return a new HearDcl, which collects all the found information
		return new HearDcl(ctx.id.getText(), params.GetStatements(), body);
	}

	@Override
	public Node visitBlock(ObsidiCodeParser.BlockContext ctx) {
		if(ctx.getChild(0) instanceof ObsidiCodeParser.BlockStmtListContext)
			return visit(ctx.list);
		
		return null;
	}

	@Override
	public Node visitBlockStmtList(ObsidiCodeParser.BlockStmtListContext ctx) {
		BlockNode bn;
		if(ctx.getChild(0) instanceof ObsidiCodeParser.BlockStmtListContext){
			bn = (BlockNode) visit(ctx.list);
			bn.AddNode(visit(ctx.stmt));
		}
		else
		{
			bn = new BlockNode();
			bn.AddNode(visit(ctx.stmt));
		}
		return bn;
	}

	@Override
	public Node visitStmtDeclaration(ObsidiCodeParser.StmtDeclarationContext ctx) {
		BlockNode bn = (BlockNode) visit(ctx.dcl);
		
		giveContextToNodes(bn, ctx.t.type.getType());
		
		return super.visitStmtDeclaration(ctx);
	}

	@Override
	public Node visitStmtSkip(ObsidiCodeParser.StmtSkipContext ctx) {
		if(ctx.skipIf != null)
			return visit(ctx.skipIf);
		else if(ctx.skipLoop != null)
			return visit(ctx.skipLoop);
		else
			return visit(ctx.skipNoSub);
	}

	@Override
	public Node visitNoSubLambda(ObsidiCodeParser.NoSubLambdaContext ctx) {
		return null;
	}

	@Override
	public Node visitNoSubSkip(ObsidiCodeParser.NoSubSkipContext ctx) {
		if(ctx.skipSignal != null)
			return visit(ctx.skipSignal);
		else if (ctx.skipExpr != null)
			return visit(ctx.skipExpr);
		//Should not reach this point!
		return null;
	}

	@Override
	public Node visitNoSubBrk(ObsidiCodeParser.NoSubBrkContext ctx) {
		return new BreakNode();
	}

	@Override
	public Node visitNoSubRet(ObsidiCodeParser.NoSubRetContext ctx) {
		return new ReturnNode((ExprNode) visit(ctx.expr));
	}

	@Override
	public Node visitSignalStmt(ObsidiCodeParser.SignalStmtContext ctx) {
		//Find the id of the signal
		IDNode id = new IDNode(ctx.id.getText());
		
		//Find all the arguments and store them in a block node
		BlockNode args = (BlockNode) visit(ctx.arguments);
		
		return new SignalNode(id, args);
	}

	@Override
	public Node visitExprStmt(ObsidiCodeParser.ExprStmtContext ctx) {
		// Will always just need to visit the first child
		if(ctx.meth_invoc != null)
			return visit(ctx.meth_invoc);
		else
			return visit(ctx.assExpr);
	}

	@Override
	public Node visitMethodInvocation(ObsidiCodeParser.MethodInvocationContext ctx) {
		IDNode id = (IDNode) visit(ctx.id);
		
		BlockNode args = (BlockNode) visit(ctx.args);
		
		return new MethodInvocationNode(id, args);
	}

	@Override
	public Node visitIfStmt(ObsidiCodeParser.IfStmtContext ctx) {
		ExprNode expr = (ExprNode) visit(ctx.expr);
		BlockNode body = (BlockNode) visit(ctx.body);
		IfNode elseIf = (IfNode) visit(ctx.elseIfStmt);
		ElseNode elseN = (ElseNode) visit(ctx.elseStmt);
		
		ArrayList<Node> listOfIfNodes = new ArrayList<Node>();
		listOfIfNodes.add(expr);
		listOfIfNodes.add(body);
		if(elseIf != null)
			listOfIfNodes.add(elseIf);
		if(elseN != null)
			listOfIfNodes.add(elseN);
		
		return new IfNode(listOfIfNodes);
	}

	@Override
	public Node visitElseIf(ObsidiCodeParser.ElseIfContext ctx) {
		//Generate nodes for each of the parts of the else-if
		IfNode recursion = (IfNode) visit(ctx.recursion);
		ExprNode condition = (ExprNode) visit(ctx.expr);
		BlockNode body = (BlockNode) visit(ctx.body);
		
		//Add to list
		ArrayList<Node> al = new ArrayList<Node>();
		if(recursion != null)
			al.add(recursion);
		al.add(condition);
		al.add(body);
		
		return new IfNode(al);
	}

	@Override
	public Node visitNoElseIf(ObsidiCodeParser.NoElseIfContext ctx) {
		return null;
	}

	@Override
	public Node visitElse(ObsidiCodeParser.ElseContext ctx) {
		//Generate nodes for all parts of the statement
		BlockNode bn = (BlockNode) visit(ctx.body);
		
		return bn;
	}

	@Override
	public Node visitNoElse(ObsidiCodeParser.NoElseContext ctx) {
		return null;
	}

	@Override
	public Node visitLoopStmt(ObsidiCodeParser.LoopStmtContext ctx) {
		//Just skip this rule and handle the next
		if(ctx.ever != null)
			return visit(ctx.ever);
		else
			return visit(ctx.rep);
	}

	@Override
	public Node visitRepeatStmt(ObsidiCodeParser.RepeatStmtContext ctx) {
		//Generate nodes for expression and body part
		ExprNode expr = (ExprNode) visit(ctx.expr);
		BlockNode bn = (BlockNode) visit(ctx.body);
		
		return new LoopNode(expr, bn);
	}

	@Override
	public Node visitForeverStmt(ObsidiCodeParser.ForeverStmtContext ctx) {
		//Generate a loop node, that has 'false' as ExprNode
		ExprNode expr = new BoolLit("FALSE");
		BlockNode bn = (BlockNode) visit(ctx.body);
		
		return new LoopNode(expr, bn);
	}

	@Override
	public Node visitFormalArgs(ObsidiCodeParser.FormalArgsContext ctx) {
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ArgsListContext)
			return visit(ctx.list);
		
		return null;
	}

	@Override
	public Node visitArgsList(ObsidiCodeParser.ArgsListContext ctx) {
		BlockNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ArgsListContext)
			bn = (BlockNode) visit(ctx.argsList());
		else
			bn = new BlockNode();
		bn.AddNode(visit(ctx.expression()));
		
		return bn;
	}

	@Override
	public Node visitFormalParams(ObsidiCodeParser.FormalParamsContext ctx) {
		return visit(ctx.list);
	}

	@Override
	public Node visitParamsList(ObsidiCodeParser.ParamsListContext ctx) {
		BlockNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ParamContext)
		{
			//Only one param, instantiate list and add parameter
			bn = new BlockNode();
			bn.AddNode(visit(ctx.p));
		}
		else
		{
			//Recurse to find all params and add the current
			bn = (BlockNode) visit(ctx.list);
			bn.AddNode(visit(ctx.p));
		}
		
		return bn;
	}

	@Override
	public Node visitParam(ObsidiCodeParser.ParamContext ctx) {
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
		return visit(ctx.assignmentExpression());
	}

	@Override
	public Node visitAssignmentExpression(ObsidiCodeParser.AssignmentExpressionContext ctx) {
		if(ctx.skipAss != null)
			return visit(ctx.skipAss);
		else
			return visit(ctx.skipCond);
	}

	@Override
	public Node visitAssignment(ObsidiCodeParser.AssignmentContext ctx) {
		//Generate a node for lhs and rhs
		IDNode lhs = (IDNode) visit(ctx.lhs);
		ExprNode expr = (ExprNode) visit(ctx.expr);
		
		return new AssignNode(lhs, expr);
	}

	@Override
	public Node visitLeftHandSide(ObsidiCodeParser.LeftHandSideContext ctx) {
		ReferenceNode ref = (ReferenceNode) visit(ctx.tn);
		ExprNode optExt = (ExprNode) visit(ctx.ext);
		
		if(optExt != null)
			ref.GetId().AddExtension(optExt);
		
		return ref;
	}

	@Override
	public Node visitListOpt(ObsidiCodeParser.ListOptContext ctx) {
		if(ctx.expr != null)
			return visit(ctx.expr);
		
		return null;
	}

	@Override
	public Node visitConditionalExpression(ObsidiCodeParser.ConditionalExpressionContext ctx) {
		return visit(ctx.or);
	}

	@Override
	public Node visitConditionOrExpression(ObsidiCodeParser.ConditionOrExpressionContext ctx) {
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ConditionAndExpressionContext)
			return visit(ctx.and);
		else
			return new OrNode(visit(ctx.or), visit(ctx.and));
	}

	@Override
	public Node visitConditionAndExpression(ObsidiCodeParser.ConditionAndExpressionContext ctx) {
		if(ctx.getChild(0) instanceof ObsidiCodeParser.XOrExpressionContext)
			return visit(ctx.xor);
		else
			return new AndNode(visit(ctx.and), visit(ctx.xor));
	}

	@Override
	public Node visitXOrExpression(ObsidiCodeParser.XOrExpressionContext ctx) {
		if(ctx.getChild(0) instanceof ObsidiCodeParser.EqualityExpressionContext)
			return visit(ctx.eq);
		else
			return new XorNode(visit(ctx.xor), visit(ctx.eq));
	}

	@Override
	public Node visitEqualityExpression(ObsidiCodeParser.EqualityExpressionContext ctx) {
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
		if(ctx.getChild(0) instanceof ObsidiCodeParser.PrimaryContext)
			return visit(ctx.prim);
		else
			return new UnaryMinusNode(visit(ctx.unaryExpr()));
	}

	@Override
	public Node visitPrimaryLiteral(ObsidiCodeParser.PrimaryLiteralContext ctx) {
		return visit(ctx.literal());
	}

	@Override
	public Node visitParenExpr(ObsidiCodeParser.ParenExprContext ctx) {
		return visit(ctx.expression());
	}

	@Override
	public Node visitPrimaryIdRef(ObsidiCodeParser.PrimaryIdRefContext ctx) {
		return visit(ctx.lhs);
	}

	@Override
	public Node visitPrimaryMethodInvoc(ObsidiCodeParser.PrimaryMethodInvocContext ctx) {
		return visit(ctx.methodInvocation());
	}	
}

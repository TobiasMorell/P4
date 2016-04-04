import java.util.ArrayList;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

import ASTNodes.Declarations.*;
import ASTNodes.GeneralNodes.*;
import ASTNodes.Operators.*;
import ASTNodes.SyntaxNodes.*;

//The generic type must be the super class of the returned node, in this case Node.
public class BuildASTVisitor extends ObsidiCodeBaseVisitor<Node>{

	@Override
	public Node visitProg(ObsidiCodeParser.ProgContext ctx) {
		ProgNode pn = (ProgNode) visit(ctx.roboDcl());
		pn.AddNode(visit(ctx.loads()));
		
		return pn;
	}

	@Override
	public Node visitLiteral(ObsidiCodeParser.LiteralContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLiteral(ctx);
	}

	@Override
	public Node visitTypeName(ObsidiCodeParser.TypeNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTypeName(ctx);
	}

	@Override
	public Node visitType(ObsidiCodeParser.TypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitType(ctx);
	}

	@Override
	public Node visitPrimitiveType(ObsidiCodeParser.PrimitiveTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrimitiveType(ctx);
	}

	@Override
	public Node visitReferenceType(ObsidiCodeParser.ReferenceTypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReferenceType(ctx);
	}

	@Override
	public Node visitLoads(ObsidiCodeParser.LoadsContext ctx) {
		LoadNode ln;
		if(ctx.getChild(1) != null)
			ln = (LoadNode) visit(ctx.getChild(0));
		else
			ln = new LoadNode();
		
		ln.AddNode(new ProgNode(new ArrayList<Node>(), ctx.getChild(3).getText()));
		return ln;
	}

	@Override
	public Node visitRoboDcl(ObsidiCodeParser.RoboDclContext ctx) {
		String robotName = ctx.getChild(0).getText();
		System.out.println("The name of the program is: " + robotName); //<------- for TESTING 
		
		return new ProgNode(new ArrayList<Node>(), robotName);
	}

	@Override
	public Node visitRoboBodyDcl(ObsidiCodeParser.RoboBodyDclContext ctx) {
		BlockNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.RoboBodyDclContext){
			//There are still more global-scope declarations to be processed
			bn = (BlockNode) visit(ctx.getChild(0));
		}
		else
		{
			//The last node is being processed, create new list
			bn = new BlockNode(new ArrayList<Node>());
		}
		
		//Add both nodes of the given context, if they're not empty statements
		Node n = visit(ctx.getChild(0));
		if(n != null)
			bn.AddNode(n);
		
		n = visit(ctx.getChild(1));
		if(n != null)
			bn.AddNode(n);
		
		return bn;
	}

	@Override
	public Node visitMemberDcl(ObsidiCodeParser.MemberDclContext ctx) {
		//Find out if it's an empty statement
		if(ctx.getChild(0).getText().equals("\n"))
			return null;
		
		//Not an empty statement - parse it!
		return visit(ctx.getChild(0));
	}

	@Override
	public Node visitFieldDcl(ObsidiCodeParser.FieldDclContext ctx) {
		String type = ctx.getChild(0).getChild(0).getText();
		
		//Find the identifier and value of given declaration
		BlockNode bn = (BlockNode) visit(ctx.getChild(1));
		
		/*switch(type) {
		case "NUM":
			
			break;
		case "STRING":
			
			break;
		case "COORD":
			
			break;
		case "BOOL":
			
			break;
		default:
			ctx.addErrorNode((Token) ctx.getChild(0).getChild(0));
			break;
		}*/
		
		return super.visitFieldDcl(ctx);
	}

	@Override
	public Node visitVariableDclList(ObsidiCodeParser.VariableDclListContext ctx) {
		BlockNode declarations;
		// Recurse through all the declarations
		if(ctx.getChild(0) instanceof ObsidiCodeParser.VariableDclContext)
		{
			//Only one declaration left
			declarations = new BlockNode();
			declarations.AddNode(visit(ctx.getChild(0)));
		}
		else {
			//still more declarations to process
			declarations = (BlockNode) visit(ctx.getChild(0));
			declarations.AddNode(visit(ctx.getChild(1)));
		}
			
		return declarations;
	}

	@Override
	public Node visitVariableDcl(ObsidiCodeParser.VariableDclContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Node visitVariableInitializer(ObsidiCodeParser.VariableInitializerContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Node visitListInitializer(ObsidiCodeParser.ListInitializerContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Node visitLitList(ObsidiCodeParser.LitListContext ctx) {
		BlockNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.PrimaryContext)
		{
			//Last variable of the list
			bn = new BlockNode();
			bn.AddNode(visit(ctx.getChild(0)));
		}
		else
		{
			bn = (BlockNode) visit(ctx.getChild(0));
			//Omit the comma
			bn.AddNode(visit(ctx.getChild(2)));
		}
		
		return bn;
	}

	@Override
	public Node visitMethodDcl(ObsidiCodeParser.MethodDclContext ctx) {
		return new MethodDcl(visit(ctx.getChild(0)), visit(ctx.getChild(1)));
	}

	@Override
	public Node visitMethodHeader(ObsidiCodeParser.MethodHeaderContext ctx) {
		Node declIdentifier;
		BlockNode bn = (BlockNode) visit(ctx.getChild(1)); //Stores identifier and params
		Node id = bn.GetLeftChild();
		Node params = new BlockNode(bn.GetStatements());
		
		if(ctx.getChild(0).getText().equals("VOID"))
			declIdentifier = new DeclarationNode(id, params);
		else {
			switch(ctx.t.type_key.getType()){
			case ObsidiCodeParser.TYPE_KEY_NUM:
				declIdentifier = new NumDcl(id, params);
				break;
			case ObsidiCodeParser.TYPE_KEY_STRING:
				declIdentifier = new StringDcl(id, params);
				break;
			case ObsidiCodeParser.TYPE_KEY_COORD:
				declIdentifier = new CoordDcl(id, params);
				break;
			case ObsidiCodeParser.TYPE_KEY_BOOL:
				declIdentifier = new BoolDcl(id, params);
				break;
			default :
				declIdentifier = new IDNode("Couldn't parse the node!"); //Really bad error handling, should be fixed
			}
		}
			
		return declIdentifier;
	}

	@Override
	public Node visitMethodDeclarator(ObsidiCodeParser.MethodDeclaratorContext ctx) {
		//Instantiate block node with method id as left child
		BlockNode bn = new BlockNode(ctx.getChild(0).getText(), new ArrayList<Node>());
		
		//Find the params
		if(ctx.getChild(2) instanceof ObsidiCodeParser.FormalParamsContext)
		{
			//Get all method params in a new BlockNode and add them to the bn variable
			BlockNode tempParams = (BlockNode) visit(ctx.getChild(2));
			for (Node n : tempParams.GetStatements())
				bn.AddNode(n);
		}
		
		return bn;
	}

	@Override
	public Node visitMethodBody(ObsidiCodeParser.MethodBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethodBody(ctx);
	}

	@Override
	public Node visitHearDcl(ObsidiCodeParser.HearDclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitHearDcl(ctx);
	}

	@Override
	public Node visitBlock(ObsidiCodeParser.BlockContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBlock(ctx);
	}

	@Override
	public Node visitBlockStmtList(ObsidiCodeParser.BlockStmtListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBlockStmtList(ctx);
	}

	@Override
	public Node visitStatement(ObsidiCodeParser.StatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStatement(ctx);
	}

	@Override
	public Node visitStmtNoSub(ObsidiCodeParser.StmtNoSubContext ctx) {
		// TODO Auto-generated method stub
		return super.visitStmtNoSub(ctx);
	}

	@Override
	public Node visitSignalStmt(ObsidiCodeParser.SignalStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSignalStmt(ctx);
	}

	@Override
	public Node visitExprStmt(ObsidiCodeParser.ExprStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExprStmt(ctx);
	}

	@Override
	public Node visitMethodInvocation(ObsidiCodeParser.MethodInvocationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethodInvocation(ctx);
	}

	@Override
	public Node visitIfStmt(ObsidiCodeParser.IfStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIfStmt(ctx);
	}

	@Override
	public Node visitElseIfOpt(ObsidiCodeParser.ElseIfOptContext ctx) {
		// TODO Auto-generated method stub
		return super.visitElseIfOpt(ctx);
	}

	@Override
	public Node visitElseOpt(ObsidiCodeParser.ElseOptContext ctx) {
		// TODO Auto-generated method stub
		return super.visitElseOpt(ctx);
	}

	@Override
	public Node visitLoopStmt(ObsidiCodeParser.LoopStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLoopStmt(ctx);
	}

	@Override
	public Node visitRepeatStmt(ObsidiCodeParser.RepeatStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRepeatStmt(ctx);
	}

	@Override
	public Node visitForeverStmt(ObsidiCodeParser.ForeverStmtContext ctx) {
		// TODO Auto-generated method stub
		return super.visitForeverStmt(ctx);
	}

	@Override
	public Node visitFormalArgs(ObsidiCodeParser.FormalArgsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFormalArgs(ctx);
	}

	@Override
	public Node visitArgsList(ObsidiCodeParser.ArgsListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArgsList(ctx);
	}

	@Override
	public Node visitFormalParams(ObsidiCodeParser.FormalParamsContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Node visitParamsList(ObsidiCodeParser.ParamsListContext ctx) {
		BlockNode bn;
		
		if(ctx.getChild(0) instanceof ObsidiCodeParser.ParamContext)
		{
			//Only one param, instantiate list and add parameter
			bn = new BlockNode();
			bn.AddNode(visit(ctx.getChild(0)));
		}
		else
		{
			//Recurse to find all params and add the current
			bn = (BlockNode) visit(ctx.getChild(0));
			bn.AddNode(visit(ctx.getChild(1)));
		}
		
		return bn;
	}

	@Override
	public Node visitParam(ObsidiCodeParser.ParamContext ctx) {
		Node decl = new DeclarationNode(null, null);
		switch(ctx.t.type_key.getType()){
		case ObsidiCodeParser.TYPE_KEY_NUM:
			decl = new NumDcl(ctx.id.getText(), null);
			break;
		case ObsidiCodeParser.TYPE_KEY_COORD:
			decl = new CoordDcl(ctx.id.getText(), null);
			break;
		case ObsidiCodeParser.TYPE_KEY_BOOL:
			decl = new BoolDcl(ctx.id.getText(), null);
			break;
		case ObsidiCodeParser.TYPE_KEY_STRING:
			decl = new StringDcl(ctx.id.getText(), null);
			break;
		}
		return decl;
	}

	@Override
	public Node visitExpression(ObsidiCodeParser.ExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpression(ctx);
	}

	@Override
	public Node visitAssignmentExpression(ObsidiCodeParser.AssignmentExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignmentExpression(ctx);
	}

	@Override
	public Node visitAssignment(ObsidiCodeParser.AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignment(ctx);
	}

	@Override
	public Node visitLeftHandSide(ObsidiCodeParser.LeftHandSideContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLeftHandSide(ctx);
	}

	@Override
	public Node visitListOpt(ObsidiCodeParser.ListOptContext ctx) {
		// TODO Auto-generated method stub
		return super.visitListOpt(ctx);
	}

	@Override
	public Node visitConditionalExpression(ObsidiCodeParser.ConditionalExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConditionalExpression(ctx);
	}

	@Override
	public Node visitConditionOrExpression(ObsidiCodeParser.ConditionOrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConditionOrExpression(ctx);
	}

	@Override
	public Node visitConditionAndExpression(ObsidiCodeParser.ConditionAndExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConditionAndExpression(ctx);
	}

	@Override
	public Node visitXOrExpression(ObsidiCodeParser.XOrExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitXOrExpression(ctx);
	}

	@Override
	public Node visitEqualityExpression(ObsidiCodeParser.EqualityExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualityExpression(ctx);
	}

	@Override
	public Node visitEqualityExpressionEnd(ObsidiCodeParser.EqualityExpressionEndContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualityExpressionEnd(ctx);
	}

	@Override
	public Node visitRelationalExpression(ObsidiCodeParser.RelationalExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRelationalExpression(ctx);
	}

	@Override
	public Node visitRelationalExpressionEnd(ObsidiCodeParser.RelationalExpressionEndContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRelationalExpressionEnd(ctx);
	}

	@Override
	public Node visitAdditiveExpression(ObsidiCodeParser.AdditiveExpressionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAdditiveExpression(ctx);
	}

	@Override
	public Node visitAdditiveExpressionEnd(ObsidiCodeParser.AdditiveExpressionEndContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAdditiveExpressionEnd(ctx);
	}

	@Override
	public Node visitMultiExpr(ObsidiCodeParser.MultiExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiExpr(ctx);
	}

	@Override
	public Node visitMultiExprEnd(ObsidiCodeParser.MultiExprEndContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiExprEnd(ctx);
	}

	@Override
	public Node visitUnaryExpr(ObsidiCodeParser.UnaryExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnaryExpr(ctx);
	}

	@Override
	public Node visitPrimary(ObsidiCodeParser.PrimaryContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrimary(ctx);
	}

	
	
}

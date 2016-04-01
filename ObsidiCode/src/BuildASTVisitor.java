import ASTNodes.Node;

//The generic type must be the super class of the returned node, in this case Node.
public class BuildASTVisitor extends ObsidiCodeBaseVisitor<Node>{

	@Override
	public Node visitProg(ObsidiCodeParser.ProgContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProg(ctx);
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
		// TODO Auto-generated method stub
		return super.visitLoads(ctx);
	}

	@Override
	public Node visitRoboDcl(ObsidiCodeParser.RoboDclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRoboDcl(ctx);
	}

	@Override
	public Node visitRoboBodyDcl(ObsidiCodeParser.RoboBodyDclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRoboBodyDcl(ctx);
	}

	@Override
	public Node visitMemberDcl(ObsidiCodeParser.MemberDclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMemberDcl(ctx);
	}

	@Override
	public Node visitFieldDcl(ObsidiCodeParser.FieldDclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFieldDcl(ctx);
	}

	@Override
	public Node visitVariableDclList(ObsidiCodeParser.VariableDclListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableDclList(ctx);
	}

	@Override
	public Node visitVariableDcl(ObsidiCodeParser.VariableDclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableDcl(ctx);
	}

	@Override
	public Node visitVariableInitializer(ObsidiCodeParser.VariableInitializerContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVariableInitializer(ctx);
	}

	@Override
	public Node visitListInitializer(ObsidiCodeParser.ListInitializerContext ctx) {
		// TODO Auto-generated method stub
		return super.visitListInitializer(ctx);
	}

	@Override
	public Node visitLitList(ObsidiCodeParser.LitListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLitList(ctx);
	}

	@Override
	public Node visitMethodDcl(ObsidiCodeParser.MethodDclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethodDcl(ctx);
	}

	@Override
	public Node visitMethodHeader(ObsidiCodeParser.MethodHeaderContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethodHeader(ctx);
	}

	@Override
	public Node visitMethodDeclarator(ObsidiCodeParser.MethodDeclaratorContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethodDeclarator(ctx);
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
		// TODO Auto-generated method stub
		return super.visitFormalParams(ctx);
	}

	@Override
	public Node visitParamsList(ObsidiCodeParser.ParamsListContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParamsList(ctx);
	}

	@Override
	public Node visitParam(ObsidiCodeParser.ParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam(ctx);
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

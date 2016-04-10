// Generated from /home/morell/Documents/GitHub/P4/ObsidiCode/ObsidiCode.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ObsidiCodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ObsidiCodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ObsidiCodeParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ObsidiCodeParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(ObsidiCodeParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#typePrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrefix(ObsidiCodeParser.TypePrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lambdaLoad}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaLoad(ObsidiCodeParser.LambdaLoadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nonLambdaLoad}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonLambdaLoad(ObsidiCodeParser.NonLambdaLoadContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#roboDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoboDcl(ObsidiCodeParser.RoboDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#roboBodyDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoboBodyDcl(ObsidiCodeParser.RoboBodyDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#memberDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDcl(ObsidiCodeParser.MemberDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#fieldDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDcl(ObsidiCodeParser.FieldDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#variableDclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDclList(ObsidiCodeParser.VariableDclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#variableDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDcl(ObsidiCodeParser.VariableDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#variableInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInitializer(ObsidiCodeParser.VariableInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#listInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListInitializer(ObsidiCodeParser.ListInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#litList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitList(ObsidiCodeParser.LitListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#methodDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDcl(ObsidiCodeParser.MethodDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#methodHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodHeader(ObsidiCodeParser.MethodHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclarator(ObsidiCodeParser.MethodDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(ObsidiCodeParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#hearDcl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHearDcl(ObsidiCodeParser.HearDclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ObsidiCodeParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#blockStmtList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmtList(ObsidiCodeParser.BlockStmtListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtDeclaration}
	 * labeled alternative in {@link ObsidiCodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtDeclaration(ObsidiCodeParser.StmtDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtSkip}
	 * labeled alternative in {@link ObsidiCodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtSkip(ObsidiCodeParser.StmtSkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noSubLambda}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoSubLambda(ObsidiCodeParser.NoSubLambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noSubSkip}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoSubSkip(ObsidiCodeParser.NoSubSkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noSubBrk}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoSubBrk(ObsidiCodeParser.NoSubBrkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noSubRet}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoSubRet(ObsidiCodeParser.NoSubRetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#signalStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignalStmt(ObsidiCodeParser.SignalStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(ObsidiCodeParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#methodInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodInvocation(ObsidiCodeParser.MethodInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(ObsidiCodeParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elseIf}
	 * labeled alternative in {@link ObsidiCodeParser#elseIfOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIf(ObsidiCodeParser.ElseIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noElseIf}
	 * labeled alternative in {@link ObsidiCodeParser#elseIfOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoElseIf(ObsidiCodeParser.NoElseIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code else}
	 * labeled alternative in {@link ObsidiCodeParser#elseOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(ObsidiCodeParser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noElse}
	 * labeled alternative in {@link ObsidiCodeParser#elseOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoElse(ObsidiCodeParser.NoElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#loopStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStmt(ObsidiCodeParser.LoopStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#repeatStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStmt(ObsidiCodeParser.RepeatStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#foreverStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeverStmt(ObsidiCodeParser.ForeverStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#formalArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArgs(ObsidiCodeParser.FormalArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#argsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgsList(ObsidiCodeParser.ArgsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(ObsidiCodeParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#paramsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamsList(ObsidiCodeParser.ParamsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(ObsidiCodeParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ObsidiCodeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(ObsidiCodeParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ObsidiCodeParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#leftHandSide}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftHandSide(ObsidiCodeParser.LeftHandSideContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#listOpt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListOpt(ObsidiCodeParser.ListOptContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(ObsidiCodeParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#conditionOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionOrExpression(ObsidiCodeParser.ConditionOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#conditionAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionAndExpression(ObsidiCodeParser.ConditionAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#xOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXOrExpression(ObsidiCodeParser.XOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(ObsidiCodeParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#equalityExpressionEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpressionEnd(ObsidiCodeParser.EqualityExpressionEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(ObsidiCodeParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#relationalExpressionEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpressionEnd(ObsidiCodeParser.RelationalExpressionEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(ObsidiCodeParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#additiveExpressionEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpressionEnd(ObsidiCodeParser.AdditiveExpressionEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#multiExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExpr(ObsidiCodeParser.MultiExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#multiExprEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExprEnd(ObsidiCodeParser.MultiExprEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link ObsidiCodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(ObsidiCodeParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryLiteral(ObsidiCodeParser.PrimaryLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ObsidiCodeParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryIdRef}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryIdRef(ObsidiCodeParser.PrimaryIdRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryMethodInvoc}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryMethodInvoc(ObsidiCodeParser.PrimaryMethodInvocContext ctx);
}
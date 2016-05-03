// Generated from /home/ohshi/Workspace/P4/ObsidiCode/ObsidiCode.g4 by ANTLR 4.5.1
package ObsidiCodeAntlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ObsidiCodeParser}.
 */
public interface ObsidiCodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ObsidiCodeParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ObsidiCodeParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaLoad}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 */
	void enterLambdaLoad(ObsidiCodeParser.LambdaLoadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaLoad}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 */
	void exitLambdaLoad(ObsidiCodeParser.LambdaLoadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaLoadNewLine}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 */
	void enterLambdaLoadNewLine(ObsidiCodeParser.LambdaLoadNewLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaLoadNewLine}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 */
	void exitLambdaLoadNewLine(ObsidiCodeParser.LambdaLoadNewLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nonLambdaLoad}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 */
	void enterNonLambdaLoad(ObsidiCodeParser.NonLambdaLoadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nonLambdaLoad}
	 * labeled alternative in {@link ObsidiCodeParser#loads}.
	 * @param ctx the parse tree
	 */
	void exitNonLambdaLoad(ObsidiCodeParser.NonLambdaLoadContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ObsidiCodeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ObsidiCodeParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeNameMethodInvoc}
	 * labeled alternative in {@link ObsidiCodeParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeNameMethodInvoc(ObsidiCodeParser.TypeNameMethodInvocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeNameMethodInvoc}
	 * labeled alternative in {@link ObsidiCodeParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeNameMethodInvoc(ObsidiCodeParser.TypeNameMethodInvocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeNameIdentifier}
	 * labeled alternative in {@link ObsidiCodeParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeNameIdentifier(ObsidiCodeParser.TypeNameIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeNameIdentifier}
	 * labeled alternative in {@link ObsidiCodeParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeNameIdentifier(ObsidiCodeParser.TypeNameIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void enterTypePrefix(ObsidiCodeParser.TypePrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#typePrefix}.
	 * @param ctx the parse tree
	 */
	void exitTypePrefix(ObsidiCodeParser.TypePrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#roboDcl}.
	 * @param ctx the parse tree
	 */
	void enterRoboDcl(ObsidiCodeParser.RoboDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#roboDcl}.
	 * @param ctx the parse tree
	 */
	void exitRoboDcl(ObsidiCodeParser.RoboDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#roboBodyDcl}.
	 * @param ctx the parse tree
	 */
	void enterRoboBodyDcl(ObsidiCodeParser.RoboBodyDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#roboBodyDcl}.
	 * @param ctx the parse tree
	 */
	void exitRoboBodyDcl(ObsidiCodeParser.RoboBodyDclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberDeclNotLambda}
	 * labeled alternative in {@link ObsidiCodeParser#memberDcl}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclNotLambda(ObsidiCodeParser.MemberDeclNotLambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberDeclNotLambda}
	 * labeled alternative in {@link ObsidiCodeParser#memberDcl}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclNotLambda(ObsidiCodeParser.MemberDeclNotLambdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberDclLambda}
	 * labeled alternative in {@link ObsidiCodeParser#memberDcl}.
	 * @param ctx the parse tree
	 */
	void enterMemberDclLambda(ObsidiCodeParser.MemberDclLambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberDclLambda}
	 * labeled alternative in {@link ObsidiCodeParser#memberDcl}.
	 * @param ctx the parse tree
	 */
	void exitMemberDclLambda(ObsidiCodeParser.MemberDclLambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#fieldDcl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDcl(ObsidiCodeParser.FieldDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#fieldDcl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDcl(ObsidiCodeParser.FieldDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#variableDclList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDclList(ObsidiCodeParser.VariableDclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#variableDclList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDclList(ObsidiCodeParser.VariableDclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#variableDcl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDcl(ObsidiCodeParser.VariableDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#variableDcl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDcl(ObsidiCodeParser.VariableDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(ObsidiCodeParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(ObsidiCodeParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#listInitializer}.
	 * @param ctx the parse tree
	 */
	void enterListInitializer(ObsidiCodeParser.ListInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#listInitializer}.
	 * @param ctx the parse tree
	 */
	void exitListInitializer(ObsidiCodeParser.ListInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#litList}.
	 * @param ctx the parse tree
	 */
	void enterLitList(ObsidiCodeParser.LitListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#litList}.
	 * @param ctx the parse tree
	 */
	void exitLitList(ObsidiCodeParser.LitListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#methodDcl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDcl(ObsidiCodeParser.MethodDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#methodDcl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDcl(ObsidiCodeParser.MethodDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#hearDcl}.
	 * @param ctx the parse tree
	 */
	void enterHearDcl(ObsidiCodeParser.HearDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#hearDcl}.
	 * @param ctx the parse tree
	 */
	void exitHearDcl(ObsidiCodeParser.HearDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(ObsidiCodeParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(ObsidiCodeParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(ObsidiCodeParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(ObsidiCodeParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(ObsidiCodeParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(ObsidiCodeParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ObsidiCodeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ObsidiCodeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#blockStmtList}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmtList(ObsidiCodeParser.BlockStmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#blockStmtList}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmtList(ObsidiCodeParser.BlockStmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ObsidiCodeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ObsidiCodeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noSubLambda}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void enterNoSubLambda(ObsidiCodeParser.NoSubLambdaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noSubLambda}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void exitNoSubLambda(ObsidiCodeParser.NoSubLambdaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noSubSkip}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void enterNoSubSkip(ObsidiCodeParser.NoSubSkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noSubSkip}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void exitNoSubSkip(ObsidiCodeParser.NoSubSkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noSubBrk}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void enterNoSubBrk(ObsidiCodeParser.NoSubBrkContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noSubBrk}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void exitNoSubBrk(ObsidiCodeParser.NoSubBrkContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noSubRet}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void enterNoSubRet(ObsidiCodeParser.NoSubRetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noSubRet}
	 * labeled alternative in {@link ObsidiCodeParser#stmtNoSub}.
	 * @param ctx the parse tree
	 */
	void exitNoSubRet(ObsidiCodeParser.NoSubRetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#signalStmt}.
	 * @param ctx the parse tree
	 */
	void enterSignalStmt(ObsidiCodeParser.SignalStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#signalStmt}.
	 * @param ctx the parse tree
	 */
	void exitSignalStmt(ObsidiCodeParser.SignalStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(ObsidiCodeParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(ObsidiCodeParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(ObsidiCodeParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(ObsidiCodeParser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(ObsidiCodeParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(ObsidiCodeParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elseIf}
	 * labeled alternative in {@link ObsidiCodeParser#elseIfOpt}.
	 * @param ctx the parse tree
	 */
	void enterElseIf(ObsidiCodeParser.ElseIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elseIf}
	 * labeled alternative in {@link ObsidiCodeParser#elseIfOpt}.
	 * @param ctx the parse tree
	 */
	void exitElseIf(ObsidiCodeParser.ElseIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noElseIf}
	 * labeled alternative in {@link ObsidiCodeParser#elseIfOpt}.
	 * @param ctx the parse tree
	 */
	void enterNoElseIf(ObsidiCodeParser.NoElseIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noElseIf}
	 * labeled alternative in {@link ObsidiCodeParser#elseIfOpt}.
	 * @param ctx the parse tree
	 */
	void exitNoElseIf(ObsidiCodeParser.NoElseIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code else}
	 * labeled alternative in {@link ObsidiCodeParser#elseOpt}.
	 * @param ctx the parse tree
	 */
	void enterElse(ObsidiCodeParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code else}
	 * labeled alternative in {@link ObsidiCodeParser#elseOpt}.
	 * @param ctx the parse tree
	 */
	void exitElse(ObsidiCodeParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noElse}
	 * labeled alternative in {@link ObsidiCodeParser#elseOpt}.
	 * @param ctx the parse tree
	 */
	void enterNoElse(ObsidiCodeParser.NoElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noElse}
	 * labeled alternative in {@link ObsidiCodeParser#elseOpt}.
	 * @param ctx the parse tree
	 */
	void exitNoElse(ObsidiCodeParser.NoElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopStmt(ObsidiCodeParser.LoopStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#loopStmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopStmt(ObsidiCodeParser.LoopStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#repeatStmt}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStmt(ObsidiCodeParser.RepeatStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#repeatStmt}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStmt(ObsidiCodeParser.RepeatStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#foreverStmt}.
	 * @param ctx the parse tree
	 */
	void enterForeverStmt(ObsidiCodeParser.ForeverStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#foreverStmt}.
	 * @param ctx the parse tree
	 */
	void exitForeverStmt(ObsidiCodeParser.ForeverStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#formalArgs}.
	 * @param ctx the parse tree
	 */
	void enterFormalArgs(ObsidiCodeParser.FormalArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#formalArgs}.
	 * @param ctx the parse tree
	 */
	void exitFormalArgs(ObsidiCodeParser.FormalArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#argsList}.
	 * @param ctx the parse tree
	 */
	void enterArgsList(ObsidiCodeParser.ArgsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#argsList}.
	 * @param ctx the parse tree
	 */
	void exitArgsList(ObsidiCodeParser.ArgsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void enterFormalParams(ObsidiCodeParser.FormalParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void exitFormalParams(ObsidiCodeParser.FormalParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#paramsList}.
	 * @param ctx the parse tree
	 */
	void enterParamsList(ObsidiCodeParser.ParamsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#paramsList}.
	 * @param ctx the parse tree
	 */
	void exitParamsList(ObsidiCodeParser.ParamsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ObsidiCodeParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ObsidiCodeParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ObsidiCodeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ObsidiCodeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(ObsidiCodeParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(ObsidiCodeParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ObsidiCodeParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ObsidiCodeParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(ObsidiCodeParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(ObsidiCodeParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#listOpt}.
	 * @param ctx the parse tree
	 */
	void enterListOpt(ObsidiCodeParser.ListOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#listOpt}.
	 * @param ctx the parse tree
	 */
	void exitListOpt(ObsidiCodeParser.ListOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(ObsidiCodeParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(ObsidiCodeParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#conditionOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionOrExpression(ObsidiCodeParser.ConditionOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#conditionOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionOrExpression(ObsidiCodeParser.ConditionOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#conditionAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionAndExpression(ObsidiCodeParser.ConditionAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#conditionAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionAndExpression(ObsidiCodeParser.ConditionAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#xOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterXOrExpression(ObsidiCodeParser.XOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#xOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitXOrExpression(ObsidiCodeParser.XOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(ObsidiCodeParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(ObsidiCodeParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#equalityExpressionEnd}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpressionEnd(ObsidiCodeParser.EqualityExpressionEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#equalityExpressionEnd}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpressionEnd(ObsidiCodeParser.EqualityExpressionEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(ObsidiCodeParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(ObsidiCodeParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#relationalExpressionEnd}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpressionEnd(ObsidiCodeParser.RelationalExpressionEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#relationalExpressionEnd}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpressionEnd(ObsidiCodeParser.RelationalExpressionEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(ObsidiCodeParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(ObsidiCodeParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#additiveExpressionEnd}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpressionEnd(ObsidiCodeParser.AdditiveExpressionEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#additiveExpressionEnd}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpressionEnd(ObsidiCodeParser.AdditiveExpressionEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#multiExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiExpr(ObsidiCodeParser.MultiExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#multiExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiExpr(ObsidiCodeParser.MultiExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#multiExprEnd}.
	 * @param ctx the parse tree
	 */
	void enterMultiExprEnd(ObsidiCodeParser.MultiExprEndContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#multiExprEnd}.
	 * @param ctx the parse tree
	 */
	void exitMultiExprEnd(ObsidiCodeParser.MultiExprEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link ObsidiCodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(ObsidiCodeParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(ObsidiCodeParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryLiteral(ObsidiCodeParser.PrimaryLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryLiteral}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryLiteral(ObsidiCodeParser.PrimaryLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(ObsidiCodeParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(ObsidiCodeParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryIdRef}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryIdRef(ObsidiCodeParser.PrimaryIdRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryIdRef}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryIdRef(ObsidiCodeParser.PrimaryIdRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryMethodInvoc}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryMethodInvoc(ObsidiCodeParser.PrimaryMethodInvocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryMethodInvoc}
	 * labeled alternative in {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryMethodInvoc(ObsidiCodeParser.PrimaryMethodInvocContext ctx);
}
// Generated from ObsidiCode.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ObsidiCodeParser}.
 */
public interface ObsidiCodeListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link ObsidiCodeParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(ObsidiCodeParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(ObsidiCodeParser.TypeNameContext ctx);
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
	 * Enter a parse tree produced by {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(ObsidiCodeParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ObsidiCodeParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(ObsidiCodeParser.PrimaryContext ctx);
}
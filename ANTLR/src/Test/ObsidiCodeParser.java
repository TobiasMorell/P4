// Generated from ObsidiCode.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ObsidiCodeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, Identifier=23, NumLit=24, 
		CoordLit=25, StringLit=26, WS=27;
	public static final int
		RULE_expression = 0, RULE_literal = 1, RULE_typeName = 2, RULE_assignmentExpression = 3, 
		RULE_assignment = 4, RULE_leftHandSide = 5, RULE_listOpt = 6, RULE_conditionalExpression = 7, 
		RULE_conditionOrExpression = 8, RULE_conditionAndExpression = 9, RULE_xOrExpression = 10, 
		RULE_equalityExpression = 11, RULE_equalityExpressionEnd = 12, RULE_relationalExpression = 13, 
		RULE_relationalExpressionEnd = 14, RULE_additiveExpression = 15, RULE_additiveExpressionEnd = 16, 
		RULE_multiExpr = 17, RULE_multiExprEnd = 18, RULE_unaryExpr = 19, RULE_primary = 20;
	public static final String[] ruleNames = {
		"expression", "literal", "typeName", "assignmentExpression", "assignment", 
		"leftHandSide", "listOpt", "conditionalExpression", "conditionOrExpression", 
		"conditionAndExpression", "xOrExpression", "equalityExpression", "equalityExpressionEnd", 
		"relationalExpression", "relationalExpressionEnd", "additiveExpression", 
		"additiveExpressionEnd", "multiExpr", "multiExprEnd", "unaryExpr", "primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'TRUE'", "'FALSE'", "'\"'", "'='", "'.'", "'['", "']'", "'OR'", 
		"'AND'", "'XOR'", "'IS'", "'NOT'", "'LESS_THAN'", "'GREATER_THAN'", "'LESS_THAN_EQUAL'", 
		"'GREATER_THAN_EQUAL'", "'+'", "'-'", "'*'", "'/'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "Identifier", 
		"NumLit", "CoordLit", "StringLit", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ObsidiCode.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ObsidiCodeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			assignmentExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NumLit() { return getToken(ObsidiCodeParser.NumLit, 0); }
		public TerminalNode CoordLit() { return getToken(ObsidiCodeParser.CoordLit, 0); }
		public TerminalNode StringLit() { return getToken(ObsidiCodeParser.StringLit, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_literal);
		try {
			setState(51);
			switch (_input.LA(1)) {
			case NumLit:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(NumLit);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				match(T__1);
				}
				break;
			case CoordLit:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(CoordLit);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				match(T__2);
				setState(49);
				match(StringLit);
				setState(50);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		return typeName(0);
	}

	private TypeNameContext typeName(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeNameContext _localctx = new TypeNameContext(_ctx, _parentState);
		TypeNameContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_typeName, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(54);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(56);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(57);
					match(T__4);
					setState(58);
					match(Identifier);
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignmentExpression);
		try {
			setState(66);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			leftHandSide();
			setState(69);
			match(T__3);
			setState(70);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftHandSideContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ListOptContext listOpt() {
			return getRuleContext(ListOptContext.class,0);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitLeftHandSide(this);
		}
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_leftHandSide);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			typeName(0);
			setState(73);
			listOpt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListOptContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ListOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listOpt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterListOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitListOpt(this);
		}
	}

	public final ListOptContext listOpt() throws RecognitionException {
		ListOptContext _localctx = new ListOptContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_listOpt);
		try {
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				match(T__5);
				setState(76);
				expression();
				setState(77);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public ConditionOrExpressionContext conditionOrExpression() {
			return getRuleContext(ConditionOrExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitConditionalExpression(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			conditionOrExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionOrExpressionContext extends ParserRuleContext {
		public ConditionAndExpressionContext conditionAndExpression() {
			return getRuleContext(ConditionAndExpressionContext.class,0);
		}
		public ConditionOrExpressionContext conditionOrExpression() {
			return getRuleContext(ConditionOrExpressionContext.class,0);
		}
		public ConditionOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterConditionOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitConditionOrExpression(this);
		}
	}

	public final ConditionOrExpressionContext conditionOrExpression() throws RecognitionException {
		return conditionOrExpression(0);
	}

	private ConditionOrExpressionContext conditionOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionOrExpressionContext _localctx = new ConditionOrExpressionContext(_ctx, _parentState);
		ConditionOrExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_conditionOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(85);
			conditionAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionOrExpression);
					setState(87);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(88);
					match(T__7);
					setState(89);
					conditionAndExpression(0);
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionAndExpressionContext extends ParserRuleContext {
		public XOrExpressionContext xOrExpression() {
			return getRuleContext(XOrExpressionContext.class,0);
		}
		public ConditionAndExpressionContext conditionAndExpression() {
			return getRuleContext(ConditionAndExpressionContext.class,0);
		}
		public ConditionAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterConditionAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitConditionAndExpression(this);
		}
	}

	public final ConditionAndExpressionContext conditionAndExpression() throws RecognitionException {
		return conditionAndExpression(0);
	}

	private ConditionAndExpressionContext conditionAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionAndExpressionContext _localctx = new ConditionAndExpressionContext(_ctx, _parentState);
		ConditionAndExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_conditionAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(96);
			xOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionAndExpression);
					setState(98);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(99);
					match(T__8);
					setState(100);
					xOrExpression(0);
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class XOrExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public XOrExpressionContext xOrExpression() {
			return getRuleContext(XOrExpressionContext.class,0);
		}
		public XOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterXOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitXOrExpression(this);
		}
	}

	public final XOrExpressionContext xOrExpression() throws RecognitionException {
		return xOrExpression(0);
	}

	private XOrExpressionContext xOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XOrExpressionContext _localctx = new XOrExpressionContext(_ctx, _parentState);
		XOrExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_xOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new XOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_xOrExpression);
					setState(109);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(110);
					match(T__9);
					setState(111);
					equalityExpression(0);
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityExpressionEndContext equalityExpressionEnd() {
			return getRuleContext(EqualityExpressionEndContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitEqualityExpression(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(118);
			relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
					setState(120);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(121);
					equalityExpressionEnd();
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionEndContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpressionEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterEqualityExpressionEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitEqualityExpressionEnd(this);
		}
	}

	public final EqualityExpressionEndContext equalityExpressionEnd() throws RecognitionException {
		EqualityExpressionEndContext _localctx = new EqualityExpressionEndContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_equalityExpressionEnd);
		try {
			setState(131);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(T__10);
				setState(128);
				relationalExpression(0);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__11);
				setState(130);
				relationalExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public RelationalExpressionEndContext relationalExpressionEnd() {
			return getRuleContext(RelationalExpressionEndContext.class,0);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitRelationalExpression(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(134);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelationalExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
					setState(136);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(137);
					relationalExpressionEnd();
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationalExpressionEndContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public RelationalExpressionEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpressionEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterRelationalExpressionEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitRelationalExpressionEnd(this);
		}
	}

	public final RelationalExpressionEndContext relationalExpressionEnd() throws RecognitionException {
		RelationalExpressionEndContext _localctx = new RelationalExpressionEndContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_relationalExpressionEnd);
		try {
			setState(151);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(T__12);
				setState(144);
				additiveExpression(0);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(T__13);
				setState(146);
				additiveExpression(0);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(147);
				match(T__14);
				setState(148);
				additiveExpression(0);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(T__15);
				setState(150);
				additiveExpression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiExprContext multiExpr() {
			return getRuleContext(MultiExprContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public AdditiveExpressionEndContext additiveExpressionEnd() {
			return getRuleContext(AdditiveExpressionEndContext.class,0);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(154);
			multiExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
					setState(156);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(157);
					additiveExpressionEnd();
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExpressionEndContext extends ParserRuleContext {
		public MultiExprContext multiExpr() {
			return getRuleContext(MultiExprContext.class,0);
		}
		public AdditiveExpressionEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpressionEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterAdditiveExpressionEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitAdditiveExpressionEnd(this);
		}
	}

	public final AdditiveExpressionEndContext additiveExpressionEnd() throws RecognitionException {
		AdditiveExpressionEndContext _localctx = new AdditiveExpressionEndContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_additiveExpressionEnd);
		try {
			setState(167);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(T__16);
				setState(164);
				multiExpr(0);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(T__17);
				setState(166);
				multiExpr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public MultiExprContext multiExpr() {
			return getRuleContext(MultiExprContext.class,0);
		}
		public MultiExprEndContext multiExprEnd() {
			return getRuleContext(MultiExprEndContext.class,0);
		}
		public MultiExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMultiExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMultiExpr(this);
		}
	}

	public final MultiExprContext multiExpr() throws RecognitionException {
		return multiExpr(0);
	}

	private MultiExprContext multiExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiExprContext _localctx = new MultiExprContext(_ctx, _parentState);
		MultiExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_multiExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(170);
			unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiExpr);
					setState(172);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(173);
					multiExprEnd();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiExprEndContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public MultiExprEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiExprEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMultiExprEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMultiExprEnd(this);
		}
	}

	public final MultiExprEndContext multiExprEnd() throws RecognitionException {
		MultiExprEndContext _localctx = new MultiExprEndContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multiExprEnd);
		try {
			setState(183);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(T__18);
				setState(180);
				unaryExpr();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(T__19);
				setState(182);
				unaryExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExprContext extends ParserRuleContext {
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitUnaryExpr(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryExpr);
		try {
			setState(190);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(T__16);
				setState(186);
				unaryExpr();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				match(T__17);
				setState(188);
				unaryExpr();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__20:
			case Identifier:
			case NumLit:
			case CoordLit:
				enterOuterAlt(_localctx, 3);
				{
				setState(189);
				primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ListOptContext listOpt() {
			return getRuleContext(ListOptContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primary);
		try {
			setState(200);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case NumLit:
			case CoordLit:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				literal();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(T__20);
				setState(194);
				expression();
				setState(195);
				match(T__21);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				typeName(0);
				setState(198);
				listOpt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return typeName_sempred((TypeNameContext)_localctx, predIndex);
		case 8:
			return conditionOrExpression_sempred((ConditionOrExpressionContext)_localctx, predIndex);
		case 9:
			return conditionAndExpression_sempred((ConditionAndExpressionContext)_localctx, predIndex);
		case 10:
			return xOrExpression_sempred((XOrExpressionContext)_localctx, predIndex);
		case 11:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 13:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 15:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 17:
			return multiExpr_sempred((MultiExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean typeName_sempred(TypeNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionOrExpression_sempred(ConditionOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionAndExpression_sempred(ConditionAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xOrExpression_sempred(XOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiExpr_sempred(MultiExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00cd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3\66\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4>\n\4\f\4\16\4A\13\4\3\5"+
		"\3\5\5\5E\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bS\n\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n]\n\n\f\n\16\n`\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13h\n\13\f\13\16\13k\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\fs\n\f\f\f\16\fv\13\f\3\r\3\r\3\r\3\r\3\r\7\r}\n\r\f\r\16\r\u0080\13"+
		"\r\3\16\3\16\3\16\3\16\5\16\u0086\n\16\3\17\3\17\3\17\3\17\3\17\7\17\u008d"+
		"\n\17\f\17\16\17\u0090\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u009a\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u00a1\n\21\f\21\16\21\u00a4"+
		"\13\21\3\22\3\22\3\22\3\22\5\22\u00aa\n\22\3\23\3\23\3\23\3\23\3\23\7"+
		"\23\u00b1\n\23\f\23\16\23\u00b4\13\23\3\24\3\24\3\24\3\24\5\24\u00ba\n"+
		"\24\3\25\3\25\3\25\3\25\3\25\5\25\u00c1\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u00cb\n\26\3\26\2\n\6\22\24\26\30\34 $\27\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\2\u00cf\2,\3\2\2\2\4\65\3\2\2"+
		"\2\6\67\3\2\2\2\bD\3\2\2\2\nF\3\2\2\2\fJ\3\2\2\2\16R\3\2\2\2\20T\3\2\2"+
		"\2\22V\3\2\2\2\24a\3\2\2\2\26l\3\2\2\2\30w\3\2\2\2\32\u0085\3\2\2\2\34"+
		"\u0087\3\2\2\2\36\u0099\3\2\2\2 \u009b\3\2\2\2\"\u00a9\3\2\2\2$\u00ab"+
		"\3\2\2\2&\u00b9\3\2\2\2(\u00c0\3\2\2\2*\u00ca\3\2\2\2,-\5\b\5\2-\3\3\2"+
		"\2\2.\66\7\32\2\2/\66\7\3\2\2\60\66\7\4\2\2\61\66\7\33\2\2\62\63\7\5\2"+
		"\2\63\64\7\34\2\2\64\66\7\6\2\2\65.\3\2\2\2\65/\3\2\2\2\65\60\3\2\2\2"+
		"\65\61\3\2\2\2\65\62\3\2\2\2\66\5\3\2\2\2\678\b\4\1\289\7\31\2\29?\3\2"+
		"\2\2:;\f\3\2\2;<\7\7\2\2<>\7\31\2\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3"+
		"\2\2\2@\7\3\2\2\2A?\3\2\2\2BE\5\20\t\2CE\5\n\6\2DB\3\2\2\2DC\3\2\2\2E"+
		"\t\3\2\2\2FG\5\f\7\2GH\7\6\2\2HI\5\2\2\2I\13\3\2\2\2JK\5\6\4\2KL\5\16"+
		"\b\2L\r\3\2\2\2MN\7\b\2\2NO\5\2\2\2OP\7\t\2\2PS\3\2\2\2QS\3\2\2\2RM\3"+
		"\2\2\2RQ\3\2\2\2S\17\3\2\2\2TU\5\22\n\2U\21\3\2\2\2VW\b\n\1\2WX\5\24\13"+
		"\2X^\3\2\2\2YZ\f\3\2\2Z[\7\n\2\2[]\5\24\13\2\\Y\3\2\2\2]`\3\2\2\2^\\\3"+
		"\2\2\2^_\3\2\2\2_\23\3\2\2\2`^\3\2\2\2ab\b\13\1\2bc\5\26\f\2ci\3\2\2\2"+
		"de\f\3\2\2ef\7\13\2\2fh\5\26\f\2gd\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2"+
		"\2j\25\3\2\2\2ki\3\2\2\2lm\b\f\1\2mn\5\30\r\2nt\3\2\2\2op\f\3\2\2pq\7"+
		"\f\2\2qs\5\30\r\2ro\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\27\3\2\2\2"+
		"vt\3\2\2\2wx\b\r\1\2xy\5\34\17\2y~\3\2\2\2z{\f\3\2\2{}\5\32\16\2|z\3\2"+
		"\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\31\3\2\2\2\u0080~\3\2\2"+
		"\2\u0081\u0082\7\r\2\2\u0082\u0086\5\34\17\2\u0083\u0084\7\16\2\2\u0084"+
		"\u0086\5\34\17\2\u0085\u0081\3\2\2\2\u0085\u0083\3\2\2\2\u0086\33\3\2"+
		"\2\2\u0087\u0088\b\17\1\2\u0088\u0089\5 \21\2\u0089\u008e\3\2\2\2\u008a"+
		"\u008b\f\3\2\2\u008b\u008d\5\36\20\2\u008c\u008a\3\2\2\2\u008d\u0090\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\35\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\7\17\2\2\u0092\u009a\5 \21\2\u0093\u0094\7"+
		"\20\2\2\u0094\u009a\5 \21\2\u0095\u0096\7\21\2\2\u0096\u009a\5 \21\2\u0097"+
		"\u0098\7\22\2\2\u0098\u009a\5 \21\2\u0099\u0091\3\2\2\2\u0099\u0093\3"+
		"\2\2\2\u0099\u0095\3\2\2\2\u0099\u0097\3\2\2\2\u009a\37\3\2\2\2\u009b"+
		"\u009c\b\21\1\2\u009c\u009d\5$\23\2\u009d\u00a2\3\2\2\2\u009e\u009f\f"+
		"\3\2\2\u009f\u00a1\5\"\22\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3!\3\2\2\2\u00a4\u00a2\3\2\2\2"+
		"\u00a5\u00a6\7\23\2\2\u00a6\u00aa\5$\23\2\u00a7\u00a8\7\24\2\2\u00a8\u00aa"+
		"\5$\23\2\u00a9\u00a5\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa#\3\2\2\2\u00ab"+
		"\u00ac\b\23\1\2\u00ac\u00ad\5(\25\2\u00ad\u00b2\3\2\2\2\u00ae\u00af\f"+
		"\3\2\2\u00af\u00b1\5&\24\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3%\3\2\2\2\u00b4\u00b2\3\2\2\2"+
		"\u00b5\u00b6\7\25\2\2\u00b6\u00ba\5(\25\2\u00b7\u00b8\7\26\2\2\u00b8\u00ba"+
		"\5(\25\2\u00b9\u00b5\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\'\3\2\2\2\u00bb"+
		"\u00bc\7\23\2\2\u00bc\u00c1\5(\25\2\u00bd\u00be\7\24\2\2\u00be\u00c1\5"+
		"(\25\2\u00bf\u00c1\5*\26\2\u00c0\u00bb\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1)\3\2\2\2\u00c2\u00cb\5\4\3\2\u00c3\u00c4\7\27\2\2"+
		"\u00c4\u00c5\5\2\2\2\u00c5\u00c6\7\30\2\2\u00c6\u00cb\3\2\2\2\u00c7\u00c8"+
		"\5\6\4\2\u00c8\u00c9\5\16\b\2\u00c9\u00cb\3\2\2\2\u00ca\u00c2\3\2\2\2"+
		"\u00ca\u00c3\3\2\2\2\u00ca\u00c7\3\2\2\2\u00cb+\3\2\2\2\23\65?DR^it~\u0085"+
		"\u008e\u0099\u00a2\u00a9\u00b2\u00b9\u00c0\u00ca";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
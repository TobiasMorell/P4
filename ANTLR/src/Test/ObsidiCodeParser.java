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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, Identifier=50, NumLit=51, CoordLit=52, 
		StringLit=53, WS=54, COMMENT=55, EOLCOMMENT=56;
	public static final int
		RULE_prog = 0, RULE_literal = 1, RULE_typeName = 2, RULE_type = 3, RULE_primitiveType = 4, 
		RULE_referenceType = 5, RULE_loads = 6, RULE_roboDcl = 7, RULE_roboBodyDcl = 8, 
		RULE_memberDcl = 9, RULE_fieldDcl = 10, RULE_variableDclList = 11, RULE_variableDcl = 12, 
		RULE_variableInitializer = 13, RULE_listInitializer = 14, RULE_litList = 15, 
		RULE_methodDcl = 16, RULE_methodHeader = 17, RULE_methodDeclarator = 18, 
		RULE_methodBody = 19, RULE_hearDcl = 20, RULE_block = 21, RULE_blockStmtList = 22, 
		RULE_statement = 23, RULE_stmtNoSub = 24, RULE_signalStmt = 25, RULE_exprStmt = 26, 
		RULE_methodInvocation = 27, RULE_ifStmt = 28, RULE_elseIfOpt = 29, RULE_elseOpt = 30, 
		RULE_loopStmt = 31, RULE_repeatStmt = 32, RULE_foreverStmt = 33, RULE_formalArgs = 34, 
		RULE_argsList = 35, RULE_formalParams = 36, RULE_paramsList = 37, RULE_param = 38, 
		RULE_expression = 39, RULE_assignmentExpression = 40, RULE_assignment = 41, 
		RULE_leftHandSide = 42, RULE_listOpt = 43, RULE_conditionalExpression = 44, 
		RULE_conditionOrExpression = 45, RULE_conditionAndExpression = 46, RULE_xOrExpression = 47, 
		RULE_equalityExpression = 48, RULE_equalityExpressionEnd = 49, RULE_relationalExpression = 50, 
		RULE_relationalExpressionEnd = 51, RULE_additiveExpression = 52, RULE_additiveExpressionEnd = 53, 
		RULE_multiExpr = 54, RULE_multiExprEnd = 55, RULE_unaryExpr = 56, RULE_primary = 57;
	public static final String[] ruleNames = {
		"prog", "literal", "typeName", "type", "primitiveType", "referenceType", 
		"loads", "roboDcl", "roboBodyDcl", "memberDcl", "fieldDcl", "variableDclList", 
		"variableDcl", "variableInitializer", "listInitializer", "litList", "methodDcl", 
		"methodHeader", "methodDeclarator", "methodBody", "hearDcl", "block", 
		"blockStmtList", "statement", "stmtNoSub", "signalStmt", "exprStmt", "methodInvocation", 
		"ifStmt", "elseIfOpt", "elseOpt", "loopStmt", "repeatStmt", "foreverStmt", 
		"formalArgs", "argsList", "formalParams", "paramsList", "param", "expression", 
		"assignmentExpression", "assignment", "leftHandSide", "listOpt", "conditionalExpression", 
		"conditionOrExpression", "conditionAndExpression", "xOrExpression", "equalityExpression", 
		"equalityExpressionEnd", "relationalExpression", "relationalExpressionEnd", 
		"additiveExpression", "additiveExpressionEnd", "multiExpr", "multiExprEnd", 
		"unaryExpr", "primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'TRUE'", "'FALSE'", "'.'", "'NUM'", "'BOOL'", "'STRING'", "'COORD'", 
		"'LIST'", "'LOAD'", "'('", "')'", "'\n'", "':'", "','", "'END'", "'VOID'", 
		"'HEAR'", "'END HEAR'", "'BREAK'", "'RETURN'", "'SIGNAL'", "'IF'", "'END IF'", 
		"'elseIfOpt'", "'elseOpt'", "'ELSE IF'", "'END ELSEIF'", "'ELSE'", "'END Else'", 
		"'REPEAT UNTIL'", "'END REPEAT'", "'FOREVER'", "'END FOREVER'", "'='", 
		"'['", "']'", "'OR'", "'AND'", "'XOR'", "'IS'", "'NOT'", "'LESS_THAN'", 
		"'GREATER_THAN'", "'LESS_THAN_EQUAL'", "'GREATER_THAN_EQUAL'", "'+'", 
		"'-'", "'*'", "'/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "Identifier", "NumLit", "CoordLit", "StringLit", "WS", "COMMENT", 
		"EOLCOMMENT"
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
	public static class ProgContext extends ParserRuleContext {
		public RoboDclContext roboDcl() {
			return getRuleContext(RoboDclContext.class,0);
		}
		public LoadsContext loads() {
			return getRuleContext(LoadsContext.class,0);
		}
		public RoboBodyDclContext roboBodyDcl() {
			return getRuleContext(RoboBodyDclContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			roboDcl();
			setState(117);
			loads(0);
			setState(118);
			roboBodyDcl(0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << NumLit) | (1L << CoordLit) | (1L << StringLit))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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
			setState(123);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeNameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeName);
					setState(125);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(126);
					match(T__2);
					setState(127);
					match(Identifier);
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class TypeContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(135);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				referenceType();
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				primitiveType();
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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

	public static class ReferenceTypeContext extends ParserRuleContext {
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitReferenceType(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_referenceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
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

	public static class LoadsContext extends ParserRuleContext {
		public LoadsContext loads() {
			return getRuleContext(LoadsContext.class,0);
		}
		public TerminalNode StringLit() { return getToken(ObsidiCodeParser.StringLit, 0); }
		public LoadsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loads; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterLoads(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitLoads(this);
		}
	}

	public final LoadsContext loads() throws RecognitionException {
		return loads(0);
	}

	private LoadsContext loads(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LoadsContext _localctx = new LoadsContext(_ctx, _parentState);
		LoadsContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_loads, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LoadsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_loads);
					setState(142);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(143);
					match(T__8);
					setState(144);
					match(T__9);
					setState(145);
					match(StringLit);
					setState(146);
					match(T__10);
					setState(147);
					match(T__11);
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class RoboDclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public RoboDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roboDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterRoboDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitRoboDcl(this);
		}
	}

	public final RoboDclContext roboDcl() throws RecognitionException {
		RoboDclContext _localctx = new RoboDclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_roboDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(Identifier);
			setState(154);
			match(T__12);
			setState(155);
			match(T__11);
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

	public static class RoboBodyDclContext extends ParserRuleContext {
		public MemberDclContext memberDcl() {
			return getRuleContext(MemberDclContext.class,0);
		}
		public RoboBodyDclContext roboBodyDcl() {
			return getRuleContext(RoboBodyDclContext.class,0);
		}
		public RoboBodyDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roboBodyDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterRoboBodyDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitRoboBodyDcl(this);
		}
	}

	public final RoboBodyDclContext roboBodyDcl() throws RecognitionException {
		return roboBodyDcl(0);
	}

	private RoboBodyDclContext roboBodyDcl(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RoboBodyDclContext _localctx = new RoboBodyDclContext(_ctx, _parentState);
		RoboBodyDclContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_roboBodyDcl, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(158);
			memberDcl();
			}
			_ctx.stop = _input.LT(-1);
			setState(164);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RoboBodyDclContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_roboBodyDcl);
					setState(160);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(161);
					memberDcl();
					}
					} 
				}
				setState(166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class MemberDclContext extends ParserRuleContext {
		public FieldDclContext fieldDcl() {
			return getRuleContext(FieldDclContext.class,0);
		}
		public MethodDclContext methodDcl() {
			return getRuleContext(MethodDclContext.class,0);
		}
		public MemberDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMemberDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMemberDcl(this);
		}
	}

	public final MemberDclContext memberDcl() throws RecognitionException {
		MemberDclContext _localctx = new MemberDclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_memberDcl);
		try {
			setState(170);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				fieldDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				methodDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(T__11);
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

	public static class FieldDclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDclListContext variableDclList() {
			return getRuleContext(VariableDclListContext.class,0);
		}
		public FieldDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterFieldDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitFieldDcl(this);
		}
	}

	public final FieldDclContext fieldDcl() throws RecognitionException {
		FieldDclContext _localctx = new FieldDclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_fieldDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			type();
			setState(173);
			variableDclList(0);
			setState(174);
			match(T__11);
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

	public static class VariableDclListContext extends ParserRuleContext {
		public VariableDclContext variableDcl() {
			return getRuleContext(VariableDclContext.class,0);
		}
		public VariableDclListContext variableDclList() {
			return getRuleContext(VariableDclListContext.class,0);
		}
		public VariableDclListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDclList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterVariableDclList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitVariableDclList(this);
		}
	}

	public final VariableDclListContext variableDclList() throws RecognitionException {
		return variableDclList(0);
	}

	private VariableDclListContext variableDclList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariableDclListContext _localctx = new VariableDclListContext(_ctx, _parentState);
		VariableDclListContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_variableDclList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(177);
			variableDcl();
			}
			_ctx.stop = _input.LT(-1);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariableDclListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_variableDclList);
					setState(179);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(180);
					match(T__13);
					setState(181);
					variableDcl();
					}
					} 
				}
				setState(186);
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

	public static class VariableDclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public ListInitializerContext listInitializer() {
			return getRuleContext(ListInitializerContext.class,0);
		}
		public VariableDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterVariableDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitVariableDcl(this);
		}
	}

	public final VariableDclContext variableDcl() throws RecognitionException {
		VariableDclContext _localctx = new VariableDclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variableDcl);
		try {
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(Identifier);
				setState(188);
				variableInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(Identifier);
				setState(190);
				listInitializer();
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

	public static class VariableInitializerContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitVariableInitializer(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableInitializer);
		try {
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				assignmentExpression();
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

	public static class ListInitializerContext extends ParserRuleContext {
		public LitListContext litList() {
			return getRuleContext(LitListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public ListInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterListInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitListInitializer(this);
		}
	}

	public final ListInitializerContext listInitializer() throws RecognitionException {
		ListInitializerContext _localctx = new ListInitializerContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_listInitializer);
		try {
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				litList(0);
				setState(198);
				match(T__14);
				setState(199);
				match(Identifier);
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

	public static class LitListContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public LitListContext litList() {
			return getRuleContext(LitListContext.class,0);
		}
		public LitListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_litList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterLitList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitLitList(this);
		}
	}

	public final LitListContext litList() throws RecognitionException {
		return litList(0);
	}

	private LitListContext litList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LitListContext _localctx = new LitListContext(_ctx, _parentState);
		LitListContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_litList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(205);
			primary();
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LitListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_litList);
					setState(207);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(208);
					match(T__13);
					setState(209);
					primary();
					}
					} 
				}
				setState(214);
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

	public static class MethodDclContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public HearDclContext hearDcl() {
			return getRuleContext(HearDclContext.class,0);
		}
		public MethodDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMethodDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMethodDcl(this);
		}
	}

	public final MethodDclContext methodDcl() throws RecognitionException {
		MethodDclContext _localctx = new MethodDclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_methodDcl);
		try {
			setState(219);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				methodHeader();
				setState(216);
				methodBody();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				hearDcl();
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

	public static class MethodHeaderContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MethodDeclaratorContext methodDeclarator() {
			return getRuleContext(MethodDeclaratorContext.class,0);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMethodHeader(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_methodHeader);
		try {
			setState(226);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				type();
				setState(222);
				methodDeclarator();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				match(T__15);
				setState(225);
				methodDeclarator();
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

	public static class MethodDeclaratorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMethodDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMethodDeclarator(this);
		}
	}

	public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
		MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_methodDeclarator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(Identifier);
			setState(229);
			match(T__9);
			setState(230);
			formalParams();
			setState(231);
			match(T__10);
			setState(232);
			match(T__11);
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

	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			block();
			setState(235);
			match(T__14);
			setState(236);
			match(Identifier);
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

	public static class HearDclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public HearDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hearDcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterHearDcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitHearDcl(this);
		}
	}

	public final HearDclContext hearDcl() throws RecognitionException {
		HearDclContext _localctx = new HearDclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_hearDcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__16);
			setState(239);
			match(Identifier);
			setState(240);
			match(T__9);
			setState(241);
			formalParams();
			setState(242);
			match(T__10);
			setState(243);
			match(T__11);
			setState(244);
			block();
			setState(245);
			match(T__17);
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

	public static class BlockContext extends ParserRuleContext {
		public BlockStmtListContext blockStmtList() {
			return getRuleContext(BlockStmtListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_block);
		try {
			setState(249);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__9:
			case T__11:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__29:
			case T__31:
			case T__45:
			case T__46:
			case Identifier:
			case NumLit:
			case CoordLit:
			case StringLit:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				blockStmtList(0);
				}
				break;
			case T__14:
			case T__17:
			case T__22:
			case T__26:
			case T__28:
			case T__30:
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class BlockStmtListContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStmtListContext blockStmtList() {
			return getRuleContext(BlockStmtListContext.class,0);
		}
		public BlockStmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterBlockStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitBlockStmtList(this);
		}
	}

	public final BlockStmtListContext blockStmtList() throws RecognitionException {
		return blockStmtList(0);
	}

	private BlockStmtListContext blockStmtList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BlockStmtListContext _localctx = new BlockStmtListContext(_ctx, _parentState);
		BlockStmtListContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_blockStmtList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(252);
			statement();
			setState(253);
			match(T__11);
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BlockStmtListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_blockStmtList);
					setState(255);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(256);
					statement();
					setState(257);
					match(T__11);
					}
					} 
				}
				setState(263);
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

	public static class StatementContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDclListContext variableDclList() {
			return getRuleContext(VariableDclListContext.class,0);
		}
		public StmtNoSubContext stmtNoSub() {
			return getRuleContext(StmtNoSubContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public LoopStmtContext loopStmt() {
			return getRuleContext(LoopStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_statement);
		try {
			setState(270);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				type();
				setState(265);
				variableDclList(0);
				}
				break;
			case T__0:
			case T__1:
			case T__9:
			case T__11:
			case T__18:
			case T__19:
			case T__20:
			case T__45:
			case T__46:
			case Identifier:
			case NumLit:
			case CoordLit:
			case StringLit:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				stmtNoSub();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(268);
				ifStmt();
				}
				break;
			case T__29:
			case T__31:
				enterOuterAlt(_localctx, 4);
				{
				setState(269);
				loopStmt();
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

	public static class StmtNoSubContext extends ParserRuleContext {
		public SignalStmtContext signalStmt() {
			return getRuleContext(SignalStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StmtNoSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtNoSub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterStmtNoSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitStmtNoSub(this);
		}
	}

	public final StmtNoSubContext stmtNoSub() throws RecognitionException {
		StmtNoSubContext _localctx = new StmtNoSubContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_stmtNoSub);
		try {
			setState(278);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				signalStmt();
				}
				break;
			case T__0:
			case T__1:
			case T__9:
			case T__45:
			case T__46:
			case Identifier:
			case NumLit:
			case CoordLit:
			case StringLit:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				exprStmt();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				match(T__18);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(276);
				match(T__19);
				setState(277);
				expression();
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

	public static class SignalStmtContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public SignalStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signalStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterSignalStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitSignalStmt(this);
		}
	}

	public final SignalStmtContext signalStmt() throws RecognitionException {
		SignalStmtContext _localctx = new SignalStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_signalStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__20);
			setState(281);
			match(Identifier);
			setState(282);
			match(T__9);
			setState(283);
			argsList(0);
			setState(284);
			match(T__10);
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

	public static class ExprStmtContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitExprStmt(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_exprStmt);
		try {
			setState(288);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				assignmentExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				methodInvocation();
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

	public static class MethodInvocationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public FormalArgsContext formalArgs() {
			return getRuleContext(FormalArgsContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitMethodInvocation(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_methodInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			typeName(0);
			setState(291);
			match(T__9);
			setState(292);
			formalArgs();
			setState(293);
			match(T__10);
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

	public static class IfStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__21);
			setState(296);
			match(T__9);
			setState(297);
			expression();
			setState(298);
			match(T__10);
			setState(299);
			match(T__11);
			setState(300);
			block();
			setState(301);
			match(T__22);
			setState(302);
			match(T__23);
			setState(303);
			match(T__24);
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

	public static class ElseIfOptContext extends ParserRuleContext {
		public ElseIfOptContext elseIfOpt() {
			return getRuleContext(ElseIfOptContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfOpt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterElseIfOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitElseIfOpt(this);
		}
	}

	public final ElseIfOptContext elseIfOpt() throws RecognitionException {
		return elseIfOpt(0);
	}

	private ElseIfOptContext elseIfOpt(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ElseIfOptContext _localctx = new ElseIfOptContext(_ctx, _parentState);
		ElseIfOptContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_elseIfOpt, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ElseIfOptContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_elseIfOpt);
					setState(306);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(307);
					match(T__25);
					setState(308);
					match(T__9);
					setState(309);
					expression();
					setState(310);
					match(T__10);
					setState(311);
					match(T__11);
					setState(312);
					block();
					setState(313);
					match(T__26);
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class ElseOptContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseOpt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterElseOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitElseOpt(this);
		}
	}

	public final ElseOptContext elseOpt() throws RecognitionException {
		ElseOptContext _localctx = new ElseOptContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_elseOpt);
		try {
			setState(326);
			switch (_input.LA(1)) {
			case T__27:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				match(T__27);
				setState(321);
				match(T__11);
				setState(322);
				block();
				setState(323);
				match(T__28);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class LoopStmtContext extends ParserRuleContext {
		public RepeatStmtContext repeatStmt() {
			return getRuleContext(RepeatStmtContext.class,0);
		}
		public ForeverStmtContext foreverStmt() {
			return getRuleContext(ForeverStmtContext.class,0);
		}
		public LoopStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterLoopStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitLoopStmt(this);
		}
	}

	public final LoopStmtContext loopStmt() throws RecognitionException {
		LoopStmtContext _localctx = new LoopStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_loopStmt);
		try {
			setState(330);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				repeatStmt();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				foreverStmt();
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

	public static class RepeatStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RepeatStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterRepeatStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitRepeatStmt(this);
		}
	}

	public final RepeatStmtContext repeatStmt() throws RecognitionException {
		RepeatStmtContext _localctx = new RepeatStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_repeatStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(T__29);
			setState(333);
			match(T__9);
			setState(334);
			expression();
			setState(335);
			match(T__10);
			setState(336);
			match(T__11);
			setState(337);
			block();
			setState(338);
			match(T__30);
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

	public static class ForeverStmtContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForeverStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreverStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterForeverStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitForeverStmt(this);
		}
	}

	public final ForeverStmtContext foreverStmt() throws RecognitionException {
		ForeverStmtContext _localctx = new ForeverStmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_foreverStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__31);
			setState(341);
			match(T__11);
			setState(342);
			block();
			setState(343);
			match(T__32);
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

	public static class FormalArgsContext extends ParserRuleContext {
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public FormalArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterFormalArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitFormalArgs(this);
		}
	}

	public final FormalArgsContext formalArgs() throws RecognitionException {
		FormalArgsContext _localctx = new FormalArgsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_formalArgs);
		try {
			setState(347);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__9:
			case T__45:
			case T__46:
			case Identifier:
			case NumLit:
			case CoordLit:
			case StringLit:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				argsList(0);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ArgsListContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgsListContext argsList() {
			return getRuleContext(ArgsListContext.class,0);
		}
		public ArgsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterArgsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitArgsList(this);
		}
	}

	public final ArgsListContext argsList() throws RecognitionException {
		return argsList(0);
	}

	private ArgsListContext argsList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgsListContext _localctx = new ArgsListContext(_ctx, _parentState);
		ArgsListContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_argsList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(350);
			expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgsListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argsList);
					setState(352);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(353);
					match(T__13);
					setState(354);
					expression();
					}
					} 
				}
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class FormalParamsContext extends ParserRuleContext {
		public ParamsListContext paramsList() {
			return getRuleContext(ParamsListContext.class,0);
		}
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterFormalParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitFormalParams(this);
		}
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_formalParams);
		try {
			setState(362);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(360);
				paramsList(0);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class ParamsListContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public ParamsListContext paramsList() {
			return getRuleContext(ParamsListContext.class,0);
		}
		public ParamsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterParamsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitParamsList(this);
		}
	}

	public final ParamsListContext paramsList() throws RecognitionException {
		return paramsList(0);
	}

	private ParamsListContext paramsList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParamsListContext _localctx = new ParamsListContext(_ctx, _parentState);
		ParamsListContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_paramsList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(365);
			param();
			}
			_ctx.stop = _input.LT(-1);
			setState(372);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParamsListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_paramsList);
					setState(367);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(368);
					match(T__13);
					setState(369);
					param();
					}
					} 
				}
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class ParamContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ObsidiCodeParser.Identifier, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ObsidiCodeListener ) ((ObsidiCodeListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			type();
			setState(376);
			match(Identifier);
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
		enterRule(_localctx, 78, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
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
		enterRule(_localctx, 80, RULE_assignmentExpression);
		try {
			setState(382);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(380);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(381);
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
		enterRule(_localctx, 82, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			leftHandSide();
			setState(385);
			match(T__33);
			setState(386);
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
		enterRule(_localctx, 84, RULE_leftHandSide);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			typeName(0);
			setState(389);
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
		enterRule(_localctx, 86, RULE_listOpt);
		try {
			setState(396);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				match(T__34);
				setState(392);
				expression();
				setState(393);
				match(T__35);
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
		enterRule(_localctx, 88, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
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
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_conditionOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(401);
			conditionAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionOrExpression);
					setState(403);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(404);
					match(T__36);
					setState(405);
					conditionAndExpression(0);
					}
					} 
				}
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_conditionAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(412);
			xOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(419);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionAndExpression);
					setState(414);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(415);
					match(T__37);
					setState(416);
					xOrExpression(0);
					}
					} 
				}
				setState(421);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		int _startState = 94;
		enterRecursionRule(_localctx, 94, RULE_xOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(423);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new XOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_xOrExpression);
					setState(425);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(426);
					match(T__38);
					setState(427);
					equalityExpression(0);
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(434);
			relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
					setState(436);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(437);
					equalityExpressionEnd();
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		enterRule(_localctx, 98, RULE_equalityExpressionEnd);
		try {
			setState(447);
			switch (_input.LA(1)) {
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				match(T__39);
				setState(444);
				relationalExpression(0);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				match(T__40);
				setState(446);
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
		int _startState = 100;
		enterRecursionRule(_localctx, 100, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(450);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(456);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelationalExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
					setState(452);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(453);
					relationalExpressionEnd();
					}
					} 
				}
				setState(458);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 102, RULE_relationalExpressionEnd);
		try {
			setState(467);
			switch (_input.LA(1)) {
			case T__41:
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				match(T__41);
				setState(460);
				additiveExpression(0);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 2);
				{
				setState(461);
				match(T__42);
				setState(462);
				additiveExpression(0);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 3);
				{
				setState(463);
				match(T__43);
				setState(464);
				additiveExpression(0);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 4);
				{
				setState(465);
				match(T__44);
				setState(466);
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
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(470);
			multiExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(476);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
					setState(472);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(473);
					additiveExpressionEnd();
					}
					} 
				}
				setState(478);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		enterRule(_localctx, 106, RULE_additiveExpressionEnd);
		try {
			setState(483);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				match(T__45);
				setState(480);
				multiExpr(0);
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				match(T__46);
				setState(482);
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
		int _startState = 108;
		enterRecursionRule(_localctx, 108, RULE_multiExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(486);
			unaryExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(492);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultiExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiExpr);
					setState(488);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(489);
					multiExprEnd();
					}
					} 
				}
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		enterRule(_localctx, 110, RULE_multiExprEnd);
		try {
			setState(499);
			switch (_input.LA(1)) {
			case T__47:
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				match(T__47);
				setState(496);
				unaryExpr();
				}
				break;
			case T__48:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				match(T__48);
				setState(498);
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
		enterRule(_localctx, 112, RULE_unaryExpr);
		try {
			setState(506);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(501);
				match(T__45);
				setState(502);
				unaryExpr();
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
				match(T__46);
				setState(504);
				unaryExpr();
				}
				break;
			case T__0:
			case T__1:
			case T__9:
			case Identifier:
			case NumLit:
			case CoordLit:
			case StringLit:
				enterOuterAlt(_localctx, 3);
				{
				setState(505);
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
		enterRule(_localctx, 114, RULE_primary);
		try {
			setState(516);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case NumLit:
			case CoordLit:
			case StringLit:
				enterOuterAlt(_localctx, 1);
				{
				setState(508);
				literal();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
				match(T__9);
				setState(510);
				expression();
				setState(511);
				match(T__10);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(513);
				typeName(0);
				setState(514);
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
		case 6:
			return loads_sempred((LoadsContext)_localctx, predIndex);
		case 8:
			return roboBodyDcl_sempred((RoboBodyDclContext)_localctx, predIndex);
		case 11:
			return variableDclList_sempred((VariableDclListContext)_localctx, predIndex);
		case 15:
			return litList_sempred((LitListContext)_localctx, predIndex);
		case 22:
			return blockStmtList_sempred((BlockStmtListContext)_localctx, predIndex);
		case 29:
			return elseIfOpt_sempred((ElseIfOptContext)_localctx, predIndex);
		case 35:
			return argsList_sempred((ArgsListContext)_localctx, predIndex);
		case 37:
			return paramsList_sempred((ParamsListContext)_localctx, predIndex);
		case 45:
			return conditionOrExpression_sempred((ConditionOrExpressionContext)_localctx, predIndex);
		case 46:
			return conditionAndExpression_sempred((ConditionAndExpressionContext)_localctx, predIndex);
		case 47:
			return xOrExpression_sempred((XOrExpressionContext)_localctx, predIndex);
		case 48:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 50:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 52:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 54:
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
	private boolean loads_sempred(LoadsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean roboBodyDcl_sempred(RoboBodyDclContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean variableDclList_sempred(VariableDclListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean litList_sempred(LitListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean blockStmtList_sempred(BlockStmtListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean elseIfOpt_sempred(ElseIfOptContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean argsList_sempred(ArgsListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean paramsList_sempred(ParamsListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean conditionOrExpression_sempred(ConditionOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionAndExpression_sempred(ConditionAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean xOrExpression_sempred(XOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiExpr_sempred(MultiExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3:\u0209\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0083\n\4\f\4\16\4\u0086\13\4"+
		"\3\5\3\5\5\5\u008a\n\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b"+
		"\u0097\n\b\f\b\16\b\u009a\13\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u00a5\n\n\f\n\16\n\u00a8\13\n\3\13\3\13\3\13\5\13\u00ad\n\13\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b9\n\r\f\r\16\r\u00bc\13\r\3\16"+
		"\3\16\3\16\3\16\5\16\u00c2\n\16\3\17\3\17\5\17\u00c6\n\17\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u00cd\n\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00d5"+
		"\n\21\f\21\16\21\u00d8\13\21\3\22\3\22\3\22\3\22\5\22\u00de\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00e5\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\5\27\u00fc\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0106\n"+
		"\30\f\30\16\30\u0109\13\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0111\n"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0119\n\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\5\34\u0123\n\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\7\37\u013e\n\37\f\37\16\37\u0141\13\37\3 \3 \3 \3"+
		" \3 \3 \5 \u0149\n \3!\3!\5!\u014d\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3$\3$\5$\u015e\n$\3%\3%\3%\3%\3%\3%\7%\u0166\n%\f%\16"+
		"%\u0169\13%\3&\3&\5&\u016d\n&\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0175\n\'\f"+
		"\'\16\'\u0178\13\'\3(\3(\3(\3)\3)\3*\3*\5*\u0181\n*\3+\3+\3+\3+\3,\3,"+
		"\3,\3-\3-\3-\3-\3-\5-\u018f\n-\3.\3.\3/\3/\3/\3/\3/\3/\7/\u0199\n/\f/"+
		"\16/\u019c\13/\3\60\3\60\3\60\3\60\3\60\3\60\7\60\u01a4\n\60\f\60\16\60"+
		"\u01a7\13\60\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u01af\n\61\f\61\16\61"+
		"\u01b2\13\61\3\62\3\62\3\62\3\62\3\62\7\62\u01b9\n\62\f\62\16\62\u01bc"+
		"\13\62\3\63\3\63\3\63\3\63\5\63\u01c2\n\63\3\64\3\64\3\64\3\64\3\64\7"+
		"\64\u01c9\n\64\f\64\16\64\u01cc\13\64\3\65\3\65\3\65\3\65\3\65\3\65\3"+
		"\65\3\65\5\65\u01d6\n\65\3\66\3\66\3\66\3\66\3\66\7\66\u01dd\n\66\f\66"+
		"\16\66\u01e0\13\66\3\67\3\67\3\67\3\67\5\67\u01e6\n\67\38\38\38\38\38"+
		"\78\u01ed\n8\f8\168\u01f0\138\39\39\39\39\59\u01f6\n9\3:\3:\3:\3:\3:\5"+
		":\u01fd\n:\3;\3;\3;\3;\3;\3;\3;\3;\5;\u0207\n;\3;\2\22\6\16\22\30 .<H"+
		"L\\^`bfjn<\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt\2\5\4\2\3\4\65\67\3\2\6\7\3\2\b\n\u01ff"+
		"\2v\3\2\2\2\4z\3\2\2\2\6|\3\2\2\2\b\u0089\3\2\2\2\n\u008b\3\2\2\2\f\u008d"+
		"\3\2\2\2\16\u008f\3\2\2\2\20\u009b\3\2\2\2\22\u009f\3\2\2\2\24\u00ac\3"+
		"\2\2\2\26\u00ae\3\2\2\2\30\u00b2\3\2\2\2\32\u00c1\3\2\2\2\34\u00c5\3\2"+
		"\2\2\36\u00cc\3\2\2\2 \u00ce\3\2\2\2\"\u00dd\3\2\2\2$\u00e4\3\2\2\2&\u00e6"+
		"\3\2\2\2(\u00ec\3\2\2\2*\u00f0\3\2\2\2,\u00fb\3\2\2\2.\u00fd\3\2\2\2\60"+
		"\u0110\3\2\2\2\62\u0118\3\2\2\2\64\u011a\3\2\2\2\66\u0122\3\2\2\28\u0124"+
		"\3\2\2\2:\u0129\3\2\2\2<\u0133\3\2\2\2>\u0148\3\2\2\2@\u014c\3\2\2\2B"+
		"\u014e\3\2\2\2D\u0156\3\2\2\2F\u015d\3\2\2\2H\u015f\3\2\2\2J\u016c\3\2"+
		"\2\2L\u016e\3\2\2\2N\u0179\3\2\2\2P\u017c\3\2\2\2R\u0180\3\2\2\2T\u0182"+
		"\3\2\2\2V\u0186\3\2\2\2X\u018e\3\2\2\2Z\u0190\3\2\2\2\\\u0192\3\2\2\2"+
		"^\u019d\3\2\2\2`\u01a8\3\2\2\2b\u01b3\3\2\2\2d\u01c1\3\2\2\2f\u01c3\3"+
		"\2\2\2h\u01d5\3\2\2\2j\u01d7\3\2\2\2l\u01e5\3\2\2\2n\u01e7\3\2\2\2p\u01f5"+
		"\3\2\2\2r\u01fc\3\2\2\2t\u0206\3\2\2\2vw\5\20\t\2wx\5\16\b\2xy\5\22\n"+
		"\2y\3\3\2\2\2z{\t\2\2\2{\5\3\2\2\2|}\b\4\1\2}~\7\64\2\2~\u0084\3\2\2\2"+
		"\177\u0080\f\3\2\2\u0080\u0081\7\5\2\2\u0081\u0083\7\64\2\2\u0082\177"+
		"\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\7\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u008a\5\f\7\2\u0088\u008a\5\n\6\2"+
		"\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\t\3\2\2\2\u008b\u008c\t"+
		"\3\2\2\u008c\13\3\2\2\2\u008d\u008e\t\4\2\2\u008e\r\3\2\2\2\u008f\u0098"+
		"\b\b\1\2\u0090\u0091\f\4\2\2\u0091\u0092\7\13\2\2\u0092\u0093\7\f\2\2"+
		"\u0093\u0094\7\67\2\2\u0094\u0095\7\r\2\2\u0095\u0097\7\16\2\2\u0096\u0090"+
		"\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\17\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7\64\2\2\u009c\u009d\7\17"+
		"\2\2\u009d\u009e\7\16\2\2\u009e\21\3\2\2\2\u009f\u00a0\b\n\1\2\u00a0\u00a1"+
		"\5\24\13\2\u00a1\u00a6\3\2\2\2\u00a2\u00a3\f\4\2\2\u00a3\u00a5\5\24\13"+
		"\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7"+
		"\3\2\2\2\u00a7\23\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ad\5\26\f\2\u00aa"+
		"\u00ad\5\"\22\2\u00ab\u00ad\7\16\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3"+
		"\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\25\3\2\2\2\u00ae\u00af\5\b\5\2\u00af"+
		"\u00b0\5\30\r\2\u00b0\u00b1\7\16\2\2\u00b1\27\3\2\2\2\u00b2\u00b3\b\r"+
		"\1\2\u00b3\u00b4\5\32\16\2\u00b4\u00ba\3\2\2\2\u00b5\u00b6\f\3\2\2\u00b6"+
		"\u00b7\7\20\2\2\u00b7\u00b9\5\32\16\2\u00b8\u00b5\3\2\2\2\u00b9\u00bc"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\31\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bd\u00be\7\64\2\2\u00be\u00c2\5\34\17\2\u00bf\u00c0"+
		"\7\64\2\2\u00c0\u00c2\5\36\20\2\u00c1\u00bd\3\2\2\2\u00c1\u00bf\3\2\2"+
		"\2\u00c2\33\3\2\2\2\u00c3\u00c6\5R*\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3"+
		"\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\35\3\2\2\2\u00c7\u00c8\5 \21\2\u00c8"+
		"\u00c9\7\21\2\2\u00c9\u00ca\7\64\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00cd\3"+
		"\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\37\3\2\2\2\u00ce"+
		"\u00cf\b\21\1\2\u00cf\u00d0\5t;\2\u00d0\u00d6\3\2\2\2\u00d1\u00d2\f\4"+
		"\2\2\u00d2\u00d3\7\20\2\2\u00d3\u00d5\5t;\2\u00d4\u00d1\3\2\2\2\u00d5"+
		"\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7!\3\2\2\2"+
		"\u00d8\u00d6\3\2\2\2\u00d9\u00da\5$\23\2\u00da\u00db\5(\25\2\u00db\u00de"+
		"\3\2\2\2\u00dc\u00de\5*\26\2\u00dd\u00d9\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"#\3\2\2\2\u00df\u00e0\5\b\5\2\u00e0\u00e1\5&\24\2\u00e1\u00e5\3\2\2\2"+
		"\u00e2\u00e3\7\22\2\2\u00e3\u00e5\5&\24\2\u00e4\u00df\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e5%\3\2\2\2\u00e6\u00e7\7\64\2\2\u00e7\u00e8\7\f\2\2\u00e8"+
		"\u00e9\5J&\2\u00e9\u00ea\7\r\2\2\u00ea\u00eb\7\16\2\2\u00eb\'\3\2\2\2"+
		"\u00ec\u00ed\5,\27\2\u00ed\u00ee\7\21\2\2\u00ee\u00ef\7\64\2\2\u00ef)"+
		"\3\2\2\2\u00f0\u00f1\7\23\2\2\u00f1\u00f2\7\64\2\2\u00f2\u00f3\7\f\2\2"+
		"\u00f3\u00f4\5J&\2\u00f4\u00f5\7\r\2\2\u00f5\u00f6\7\16\2\2\u00f6\u00f7"+
		"\5,\27\2\u00f7\u00f8\7\24\2\2\u00f8+\3\2\2\2\u00f9\u00fc\5.\30\2\u00fa"+
		"\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc-\3\2\2\2"+
		"\u00fd\u00fe\b\30\1\2\u00fe\u00ff\5\60\31\2\u00ff\u0100\7\16\2\2\u0100"+
		"\u0107\3\2\2\2\u0101\u0102\f\4\2\2\u0102\u0103\5\60\31\2\u0103\u0104\7"+
		"\16\2\2\u0104\u0106\3\2\2\2\u0105\u0101\3\2\2\2\u0106\u0109\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108/\3\2\2\2\u0109\u0107\3\2\2\2"+
		"\u010a\u010b\5\b\5\2\u010b\u010c\5\30\r\2\u010c\u0111\3\2\2\2\u010d\u0111"+
		"\5\62\32\2\u010e\u0111\5:\36\2\u010f\u0111\5@!\2\u0110\u010a\3\2\2\2\u0110"+
		"\u010d\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u0111\61\3\2\2"+
		"\2\u0112\u0119\3\2\2\2\u0113\u0119\5\64\33\2\u0114\u0119\5\66\34\2\u0115"+
		"\u0119\7\25\2\2\u0116\u0117\7\26\2\2\u0117\u0119\5P)\2\u0118\u0112\3\2"+
		"\2\2\u0118\u0113\3\2\2\2\u0118\u0114\3\2\2\2\u0118\u0115\3\2\2\2\u0118"+
		"\u0116\3\2\2\2\u0119\63\3\2\2\2\u011a\u011b\7\27\2\2\u011b\u011c\7\64"+
		"\2\2\u011c\u011d\7\f\2\2\u011d\u011e\5H%\2\u011e\u011f\7\r\2\2\u011f\65"+
		"\3\2\2\2\u0120\u0123\5R*\2\u0121\u0123\58\35\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0121\3\2\2\2\u0123\67\3\2\2\2\u0124\u0125\5\6\4\2\u0125\u0126\7\f\2"+
		"\2\u0126\u0127\5F$\2\u0127\u0128\7\r\2\2\u01289\3\2\2\2\u0129\u012a\7"+
		"\30\2\2\u012a\u012b\7\f\2\2\u012b\u012c\5P)\2\u012c\u012d\7\r\2\2\u012d"+
		"\u012e\7\16\2\2\u012e\u012f\5,\27\2\u012f\u0130\7\31\2\2\u0130\u0131\7"+
		"\32\2\2\u0131\u0132\7\33\2\2\u0132;\3\2\2\2\u0133\u013f\b\37\1\2\u0134"+
		"\u0135\f\4\2\2\u0135\u0136\7\34\2\2\u0136\u0137\7\f\2\2\u0137\u0138\5"+
		"P)\2\u0138\u0139\7\r\2\2\u0139\u013a\7\16\2\2\u013a\u013b\5,\27\2\u013b"+
		"\u013c\7\35\2\2\u013c\u013e\3\2\2\2\u013d\u0134\3\2\2\2\u013e\u0141\3"+
		"\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140=\3\2\2\2\u0141\u013f"+
		"\3\2\2\2\u0142\u0143\7\36\2\2\u0143\u0144\7\16\2\2\u0144\u0145\5,\27\2"+
		"\u0145\u0146\7\37\2\2\u0146\u0149\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0142"+
		"\3\2\2\2\u0148\u0147\3\2\2\2\u0149?\3\2\2\2\u014a\u014d\5B\"\2\u014b\u014d"+
		"\5D#\2\u014c\u014a\3\2\2\2\u014c\u014b\3\2\2\2\u014dA\3\2\2\2\u014e\u014f"+
		"\7 \2\2\u014f\u0150\7\f\2\2\u0150\u0151\5P)\2\u0151\u0152\7\r\2\2\u0152"+
		"\u0153\7\16\2\2\u0153\u0154\5,\27\2\u0154\u0155\7!\2\2\u0155C\3\2\2\2"+
		"\u0156\u0157\7\"\2\2\u0157\u0158\7\16\2\2\u0158\u0159\5,\27\2\u0159\u015a"+
		"\7#\2\2\u015aE\3\2\2\2\u015b\u015e\5H%\2\u015c\u015e\3\2\2\2\u015d\u015b"+
		"\3\2\2\2\u015d\u015c\3\2\2\2\u015eG\3\2\2\2\u015f\u0160\b%\1\2\u0160\u0161"+
		"\5P)\2\u0161\u0167\3\2\2\2\u0162\u0163\f\4\2\2\u0163\u0164\7\20\2\2\u0164"+
		"\u0166\5P)\2\u0165\u0162\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2"+
		"\2\u0167\u0168\3\2\2\2\u0168I\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016d"+
		"\5L\'\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016b\3\2\2\2\u016d"+
		"K\3\2\2\2\u016e\u016f\b\'\1\2\u016f\u0170\5N(\2\u0170\u0176\3\2\2\2\u0171"+
		"\u0172\f\4\2\2\u0172\u0173\7\20\2\2\u0173\u0175\5N(\2\u0174\u0171\3\2"+
		"\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"M\3\2\2\2\u0178\u0176\3\2\2\2\u0179\u017a\5\b\5\2\u017a\u017b\7\64\2\2"+
		"\u017bO\3\2\2\2\u017c\u017d\5R*\2\u017dQ\3\2\2\2\u017e\u0181\5Z.\2\u017f"+
		"\u0181\5T+\2\u0180\u017e\3\2\2\2\u0180\u017f\3\2\2\2\u0181S\3\2\2\2\u0182"+
		"\u0183\5V,\2\u0183\u0184\7$\2\2\u0184\u0185\5P)\2\u0185U\3\2\2\2\u0186"+
		"\u0187\5\6\4\2\u0187\u0188\5X-\2\u0188W\3\2\2\2\u0189\u018a\7%\2\2\u018a"+
		"\u018b\5P)\2\u018b\u018c\7&\2\2\u018c\u018f\3\2\2\2\u018d\u018f\3\2\2"+
		"\2\u018e\u0189\3\2\2\2\u018e\u018d\3\2\2\2\u018fY\3\2\2\2\u0190\u0191"+
		"\5\\/\2\u0191[\3\2\2\2\u0192\u0193\b/\1\2\u0193\u0194\5^\60\2\u0194\u019a"+
		"\3\2\2\2\u0195\u0196\f\3\2\2\u0196\u0197\7\'\2\2\u0197\u0199\5^\60\2\u0198"+
		"\u0195\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019b]\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\b\60\1\2\u019e\u019f"+
		"\5`\61\2\u019f\u01a5\3\2\2\2\u01a0\u01a1\f\3\2\2\u01a1\u01a2\7(\2\2\u01a2"+
		"\u01a4\5`\61\2\u01a3\u01a0\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2"+
		"\2\2\u01a5\u01a6\3\2\2\2\u01a6_\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01a9"+
		"\b\61\1\2\u01a9\u01aa\5b\62\2\u01aa\u01b0\3\2\2\2\u01ab\u01ac\f\3\2\2"+
		"\u01ac\u01ad\7)\2\2\u01ad\u01af\5b\62\2\u01ae\u01ab\3\2\2\2\u01af\u01b2"+
		"\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1a\3\2\2\2\u01b2"+
		"\u01b0\3\2\2\2\u01b3\u01b4\b\62\1\2\u01b4\u01b5\5f\64\2\u01b5\u01ba\3"+
		"\2\2\2\u01b6\u01b7\f\3\2\2\u01b7\u01b9\5d\63\2\u01b8\u01b6\3\2\2\2\u01b9"+
		"\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bbc\3\2\2\2"+
		"\u01bc\u01ba\3\2\2\2\u01bd\u01be\7*\2\2\u01be\u01c2\5f\64\2\u01bf\u01c0"+
		"\7+\2\2\u01c0\u01c2\5f\64\2\u01c1\u01bd\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2"+
		"e\3\2\2\2\u01c3\u01c4\b\64\1\2\u01c4\u01c5\5j\66\2\u01c5\u01ca\3\2\2\2"+
		"\u01c6\u01c7\f\3\2\2\u01c7\u01c9\5h\65\2\u01c8\u01c6\3\2\2\2\u01c9\u01cc"+
		"\3\2\2\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cbg\3\2\2\2\u01cc"+
		"\u01ca\3\2\2\2\u01cd\u01ce\7,\2\2\u01ce\u01d6\5j\66\2\u01cf\u01d0\7-\2"+
		"\2\u01d0\u01d6\5j\66\2\u01d1\u01d2\7.\2\2\u01d2\u01d6\5j\66\2\u01d3\u01d4"+
		"\7/\2\2\u01d4\u01d6\5j\66\2\u01d5\u01cd\3\2\2\2\u01d5\u01cf\3\2\2\2\u01d5"+
		"\u01d1\3\2\2\2\u01d5\u01d3\3\2\2\2\u01d6i\3\2\2\2\u01d7\u01d8\b\66\1\2"+
		"\u01d8\u01d9\5n8\2\u01d9\u01de\3\2\2\2\u01da\u01db\f\3\2\2\u01db\u01dd"+
		"\5l\67\2\u01dc\u01da\3\2\2\2\u01dd\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de"+
		"\u01df\3\2\2\2\u01dfk\3\2\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e2\7\60\2\2"+
		"\u01e2\u01e6\5n8\2\u01e3\u01e4\7\61\2\2\u01e4\u01e6\5n8\2\u01e5\u01e1"+
		"\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6m\3\2\2\2\u01e7\u01e8\b8\1\2\u01e8\u01e9"+
		"\5r:\2\u01e9\u01ee\3\2\2\2\u01ea\u01eb\f\3\2\2\u01eb\u01ed\5p9\2\u01ec"+
		"\u01ea\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2"+
		"\2\2\u01efo\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f2\7\62\2\2\u01f2\u01f6"+
		"\5r:\2\u01f3\u01f4\7\63\2\2\u01f4\u01f6\5r:\2\u01f5\u01f1\3\2\2\2\u01f5"+
		"\u01f3\3\2\2\2\u01f6q\3\2\2\2\u01f7\u01f8\7\60\2\2\u01f8\u01fd\5r:\2\u01f9"+
		"\u01fa\7\61\2\2\u01fa\u01fd\5r:\2\u01fb\u01fd\5t;\2\u01fc\u01f7\3\2\2"+
		"\2\u01fc\u01f9\3\2\2\2\u01fc\u01fb\3\2\2\2\u01fds\3\2\2\2\u01fe\u0207"+
		"\5\4\3\2\u01ff\u0200\7\f\2\2\u0200\u0201\5P)\2\u0201\u0202\7\r\2\2\u0202"+
		"\u0207\3\2\2\2\u0203\u0204\5\6\4\2\u0204\u0205\5X-\2\u0205\u0207\3\2\2"+
		"\2\u0206\u01fe\3\2\2\2\u0206\u01ff\3\2\2\2\u0206\u0203\3\2\2\2\u0207u"+
		"\3\2\2\2)\u0084\u0089\u0098\u00a6\u00ac\u00ba\u00c1\u00c5\u00cc\u00d6"+
		"\u00dd\u00e4\u00fb\u0107\u0110\u0118\u0122\u013f\u0148\u014c\u015d\u0167"+
		"\u016c\u0176\u0180\u018e\u019a\u01a5\u01b0\u01ba\u01c1\u01ca\u01d5\u01de"+
		"\u01e5\u01ee\u01f5\u01fc\u0206";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
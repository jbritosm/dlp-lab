// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, INT_CONSTANT=34, REAL_CONSTANT=35, CHAR_CONSTANT=36, 
		ID=37, WS=38, COMMENTS=39;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_statement = 2, RULE_body = 3, 
		RULE_variable_definition = 4, RULE_type_simple = 5, RULE_type_complex = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "statement", "body", "variable_definition", 
			"type_simple", "type_complex"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'['", "']'", "'.'", "'-'", "'!'", "'*'", 
			"'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'=<'", "'!='", "'=='", "'&&'", 
			"'||'", "'print'", "';'", "'input'", "'='", "'if'", "':'", "'else'", 
			"'{'", "'}'", "'int'", "'double'", "'char'", "'struct'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "INT_CONSTANT", 
			"REAL_CONSTANT", "CHAR_CONSTANT", "ID", "WS", "COMMENTS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			expression(0);
			setState(15);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(18);
				match(INT_CONSTANT);
				}
				break;
			case 2:
				{
				setState(19);
				match(CHAR_CONSTANT);
				}
				break;
			case 3:
				{
				setState(20);
				match(REAL_CONSTANT);
				}
				break;
			case 4:
				{
				setState(21);
				match(ID);
				setState(22);
				match(T__0);
				setState(33);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__6:
				case T__7:
				case INT_CONSTANT:
				case REAL_CONSTANT:
				case CHAR_CONSTANT:
				case ID:
					{
					{
					setState(28);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(23);
							expression(0);
							setState(24);
							match(T__1);
							}
							} 
						}
						setState(30);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
					}
					setState(31);
					expression(0);
					}
					}
					break;
				case T__2:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(35);
				match(T__2);
				}
				break;
			case 5:
				{
				setState(36);
				match(ID);
				}
				break;
			case 6:
				{
				setState(37);
				match(T__0);
				setState(38);
				expression(0);
				setState(39);
				match(T__2);
				}
				break;
			case 7:
				{
				setState(41);
				match(T__0);
				setState(42);
				type_simple();
				setState(43);
				match(T__2);
				setState(44);
				expression(7);
				}
				break;
			case 8:
				{
				setState(46);
				match(T__6);
				setState(47);
				expression(6);
				}
				break;
			case 9:
				{
				setState(48);
				match(T__7);
				setState(49);
				expression(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(52);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(53);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3584L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(54);
						expression(5);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(55);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(56);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__11) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(57);
						expression(4);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(58);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(59);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 516096L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(60);
						expression(3);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(61);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(62);
						_la = _input.LA(1);
						if ( !(_la==T__18 || _la==T__19) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(63);
						expression(2);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(64);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(65);
						match(T__3);
						setState(66);
						expression(0);
						setState(67);
						match(T__4);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(69);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(70);
						match(T__5);
						setState(71);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(76);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			int _alt;
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(T__20);
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(78);
						expression(0);
						setState(79);
						match(T__1);
						}
						} 
					}
					setState(85);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(86);
				expression(0);
				setState(87);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(T__22);
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(90);
						expression(0);
						setState(91);
						match(T__1);
						}
						} 
					}
					setState(97);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(98);
				expression(0);
				setState(99);
				match(T__21);
				}
				break;
			case T__0:
			case T__6:
			case T__7:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				expression(0);
				setState(102);
				match(T__23);
				setState(103);
				expression(0);
				setState(104);
				match(T__21);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(T__24);
				setState(107);
				expression(0);
				setState(108);
				match(T__25);
				setState(109);
				body();
				setState(114);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__26:
					{
					setState(110);
					match(T__26);
					setState(111);
					match(T__25);
					setState(112);
					body();
					}
					break;
				case T__0:
				case T__6:
				case T__7:
				case T__20:
				case T__21:
				case T__22:
				case T__24:
				case T__28:
				case INT_CONSTANT:
				case REAL_CONSTANT:
				case CHAR_CONSTANT:
				case ID:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__6:
			case T__7:
			case T__20:
			case T__22:
			case T__24:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				{
				setState(118);
				statement();
				}
				break;
			case T__27:
				{
				{
				setState(119);
				match(T__27);
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(120);
					statement();
					}
					}
					setState(123); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 257742078338L) != 0 );
				setState(125);
				match(T__28);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(129);
			match(T__21);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_definitionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Type_complexContext type_complex() {
			return getRuleContext(Type_complexContext.class,0);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVariable_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable_definition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(131);
					match(ID);
					setState(132);
					match(T__1);
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(138);
			match(ID);
			setState(139);
			match(T__25);
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
			case T__30:
			case T__31:
				{
				setState(140);
				type_simple();
				}
				break;
			case T__3:
			case T__32:
				{
				setState(141);
				type_complex();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(144);
			match(T__21);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Type_simpleContext extends ParserRuleContext {
		public Type_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_simple; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType_simple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_simpleContext type_simple() throws RecognitionException {
		Type_simpleContext _localctx = new Type_simpleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type_simple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7516192768L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Type_complexContext extends ParserRuleContext {
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Type_complexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_complex; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType_complex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_complexContext type_complex() throws RecognitionException {
		Type_complexContext _localctx = new Type_complexContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type_complex);
		int _la;
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(T__32);
				setState(149);
				match(T__27);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(150);
					variable_definition();
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(156);
				match(T__28);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(T__3);
				setState(158);
				match(INT_CONSTANT);
				setState(159);
				match(T__4);
				setState(160);
				type_simple();
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
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'\u00a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001b\b\u0001\n"+
		"\u0001\f\u0001\u001e\t\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00013\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001I\b\u0001\n\u0001\f\u0001L\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002R\b\u0002\n\u0002\f\u0002"+
		"U\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002^\b\u0002\n\u0002\f\u0002a\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002s\b\u0002"+
		"\u0003\u0002u\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"z\b\u0003\u000b\u0003\f\u0003{\u0001\u0003\u0001\u0003\u0003\u0003\u0080"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004\u0086"+
		"\b\u0004\n\u0004\f\u0004\u0089\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u008f\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0098\b\u0006"+
		"\n\u0006\f\u0006\u009b\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00a2\b\u0006\u0001\u0006\u0000\u0001\u0002"+
		"\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0005\u0001\u0000\t\u000b\u0002"+
		"\u0000\u0007\u0007\f\f\u0001\u0000\r\u0012\u0001\u0000\u0013\u0014\u0001"+
		"\u0000\u001e \u00b8\u0000\u000e\u0001\u0000\u0000\u0000\u00022\u0001\u0000"+
		"\u0000\u0000\u0004t\u0001\u0000\u0000\u0000\u0006\u007f\u0001\u0000\u0000"+
		"\u0000\b\u0087\u0001\u0000\u0000\u0000\n\u0092\u0001\u0000\u0000\u0000"+
		"\f\u00a1\u0001\u0000\u0000\u0000\u000e\u000f\u0003\u0002\u0001\u0000\u000f"+
		"\u0010\u0005\u0000\u0000\u0001\u0010\u0001\u0001\u0000\u0000\u0000\u0011"+
		"\u0012\u0006\u0001\uffff\uffff\u0000\u00123\u0005\"\u0000\u0000\u0013"+
		"3\u0005$\u0000\u0000\u00143\u0005#\u0000\u0000\u0015\u0016\u0005%\u0000"+
		"\u0000\u0016!\u0005\u0001\u0000\u0000\u0017\u0018\u0003\u0002\u0001\u0000"+
		"\u0018\u0019\u0005\u0002\u0000\u0000\u0019\u001b\u0001\u0000\u0000\u0000"+
		"\u001a\u0017\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000\u0000\u0000"+
		"\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000"+
		"\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000"+
		"\u001f\"\u0003\u0002\u0001\u0000 \"\u0001\u0000\u0000\u0000!\u001c\u0001"+
		"\u0000\u0000\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000"+
		"#3\u0005\u0003\u0000\u0000$3\u0005%\u0000\u0000%&\u0005\u0001\u0000\u0000"+
		"&\'\u0003\u0002\u0001\u0000\'(\u0005\u0003\u0000\u0000(3\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0001\u0000\u0000*+\u0003\n\u0005\u0000+,\u0005\u0003\u0000"+
		"\u0000,-\u0003\u0002\u0001\u0007-3\u0001\u0000\u0000\u0000./\u0005\u0007"+
		"\u0000\u0000/3\u0003\u0002\u0001\u000601\u0005\b\u0000\u000013\u0003\u0002"+
		"\u0001\u00052\u0011\u0001\u0000\u0000\u00002\u0013\u0001\u0000\u0000\u0000"+
		"2\u0014\u0001\u0000\u0000\u00002\u0015\u0001\u0000\u0000\u00002$\u0001"+
		"\u0000\u0000\u00002%\u0001\u0000\u0000\u00002)\u0001\u0000\u0000\u0000"+
		"2.\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u00003J\u0001\u0000\u0000"+
		"\u000045\n\u0004\u0000\u000056\u0007\u0000\u0000\u00006I\u0003\u0002\u0001"+
		"\u000578\n\u0003\u0000\u000089\u0007\u0001\u0000\u00009I\u0003\u0002\u0001"+
		"\u0004:;\n\u0002\u0000\u0000;<\u0007\u0002\u0000\u0000<I\u0003\u0002\u0001"+
		"\u0003=>\n\u0001\u0000\u0000>?\u0007\u0003\u0000\u0000?I\u0003\u0002\u0001"+
		"\u0002@A\n\t\u0000\u0000AB\u0005\u0004\u0000\u0000BC\u0003\u0002\u0001"+
		"\u0000CD\u0005\u0005\u0000\u0000DI\u0001\u0000\u0000\u0000EF\n\b\u0000"+
		"\u0000FG\u0005\u0006\u0000\u0000GI\u0005%\u0000\u0000H4\u0001\u0000\u0000"+
		"\u0000H7\u0001\u0000\u0000\u0000H:\u0001\u0000\u0000\u0000H=\u0001\u0000"+
		"\u0000\u0000H@\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000IL\u0001"+
		"\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"K\u0003\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MS\u0005\u0015"+
		"\u0000\u0000NO\u0003\u0002\u0001\u0000OP\u0005\u0002\u0000\u0000PR\u0001"+
		"\u0000\u0000\u0000QN\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000"+
		"\u0000US\u0001\u0000\u0000\u0000VW\u0003\u0002\u0001\u0000WX\u0005\u0016"+
		"\u0000\u0000Xu\u0001\u0000\u0000\u0000Y_\u0005\u0017\u0000\u0000Z[\u0003"+
		"\u0002\u0001\u0000[\\\u0005\u0002\u0000\u0000\\^\u0001\u0000\u0000\u0000"+
		"]Z\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000bc\u0003\u0002\u0001\u0000cd\u0005\u0016\u0000\u0000du\u0001"+
		"\u0000\u0000\u0000ef\u0003\u0002\u0001\u0000fg\u0005\u0018\u0000\u0000"+
		"gh\u0003\u0002\u0001\u0000hi\u0005\u0016\u0000\u0000iu\u0001\u0000\u0000"+
		"\u0000jk\u0005\u0019\u0000\u0000kl\u0003\u0002\u0001\u0000lm\u0005\u001a"+
		"\u0000\u0000mr\u0003\u0006\u0003\u0000no\u0005\u001b\u0000\u0000op\u0005"+
		"\u001a\u0000\u0000ps\u0003\u0006\u0003\u0000qs\u0001\u0000\u0000\u0000"+
		"rn\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000su\u0001\u0000\u0000"+
		"\u0000tM\u0001\u0000\u0000\u0000tY\u0001\u0000\u0000\u0000te\u0001\u0000"+
		"\u0000\u0000tj\u0001\u0000\u0000\u0000u\u0005\u0001\u0000\u0000\u0000"+
		"v\u0080\u0003\u0004\u0002\u0000wy\u0005\u001c\u0000\u0000xz\u0003\u0004"+
		"\u0002\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}~\u0005\u001d\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007fv\u0001"+
		"\u0000\u0000\u0000\u007fw\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005\u0016\u0000\u0000\u0082\u0007\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0005%\u0000\u0000\u0084\u0086\u0005\u0002\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005%\u0000\u0000\u008b\u008e\u0005\u001a\u0000\u0000"+
		"\u008c\u008f\u0003\n\u0005\u0000\u008d\u008f\u0003\f\u0006\u0000\u008e"+
		"\u008c\u0001\u0000\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0016\u0000\u0000\u0091"+
		"\t\u0001\u0000\u0000\u0000\u0092\u0093\u0007\u0004\u0000\u0000\u0093\u000b"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0005!\u0000\u0000\u0095\u0099\u0005"+
		"\u001c\u0000\u0000\u0096\u0098\u0003\b\u0004\u0000\u0097\u0096\u0001\u0000"+
		"\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009c\u0001\u0000"+
		"\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u00a2\u0005\u001d"+
		"\u0000\u0000\u009d\u009e\u0005\u0004\u0000\u0000\u009e\u009f\u0005\"\u0000"+
		"\u0000\u009f\u00a0\u0005\u0005\u0000\u0000\u00a0\u00a2\u0003\n\u0005\u0000"+
		"\u00a1\u0094\u0001\u0000\u0000\u0000\u00a1\u009d\u0001\u0000\u0000\u0000"+
		"\u00a2\r\u0001\u0000\u0000\u0000\u000f\u001c!2HJS_rt{\u007f\u0087\u008e"+
		"\u0099\u00a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
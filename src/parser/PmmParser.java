// Generated from C:/Users/Jusco/IdeaProjects/dlp-lab/src/parser\Pmm.g4 by ANTLR 4.12.0
package parser;

    import ast.astnode.*;
    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.functioninvocation.*;

    import errorhandler.*;

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
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, INT_CONSTANT=38, 
		REAL_CONSTANT=39, CHAR_CONSTANT=40, ID=41, WS=42, COMMENTS=43;
	public static final int
		RULE_program = 0, RULE_expression = 1, RULE_statement = 2, RULE_function_definition = 3, 
		RULE_function_body = 4, RULE_function_arguments = 5, RULE_function_parameter_definition = 6, 
		RULE_parameter_definition = 7, RULE_body = 8, RULE_variable_definition = 9, 
		RULE_type = 10, RULE_type_simple = 11, RULE_type_complex = 12, RULE_void_type = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "expression", "statement", "function_definition", "function_body", 
			"function_arguments", "function_parameter_definition", "parameter_definition", 
			"body", "variable_definition", "type", "type_simple", "type_complex", 
			"void_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "':'", "'['", "']'", "'.'", "'-'", 
			"'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'=<'", "'!='", 
			"'=='", "'&&'", "'||'", "'print'", "','", "';'", "'input'", "'='", "'if'", 
			"'else'", "'while'", "'return'", "'{'", "'}'", "'int'", "'double'", "'char'", 
			"'struct'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID", "WS", 
			"COMMENTS"
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
	public String getGrammarFileName() { return "Pmm.g4"; }

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
		public Program ast;
		public List<Definition> definitions = new ArrayList<>();
		public FunctionDefinition main;
		public Variable_definitionContext variable_definition;
		public Function_definitionContext function_definition;
		public Token DEF;
		public Token MAIN;
		public Function_parameter_definitionContext function_parameter_definition;
		public Void_typeContext void_type;
		public Function_bodyContext function_body;
		public Function_parameter_definitionContext function_parameter_definition() {
			return getRuleContext(Function_parameter_definitionContext.class,0);
		}
		public Void_typeContext void_type() {
			return getRuleContext(Void_typeContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public List<Function_definitionContext> function_definition() {
			return getRuleContexts(Function_definitionContext.class);
		}
		public Function_definitionContext function_definition(int i) {
			return getRuleContext(Function_definitionContext.class,i);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(34);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(28);
						((ProgramContext)_localctx).variable_definition = variable_definition();
						 _localctx.definitions.addAll(((ProgramContext)_localctx).variable_definition.ast); 
						}
						break;
					case T__0:
						{
						setState(31);
						((ProgramContext)_localctx).function_definition = function_definition();
						 _localctx.definitions.add(((ProgramContext)_localctx).function_definition.ast); 
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(39);
			((ProgramContext)_localctx).DEF = match(T__0);
			setState(40);
			((ProgramContext)_localctx).MAIN = match(T__1);
			setState(41);
			match(T__2);
			setState(42);
			((ProgramContext)_localctx).function_parameter_definition = function_parameter_definition();
			setState(43);
			match(T__3);
			setState(44);
			match(T__4);
			setState(45);
			((ProgramContext)_localctx).void_type = void_type();
			setState(46);
			((ProgramContext)_localctx).function_body = function_body();

			                                             ((ProgramContext)_localctx).main =  new FunctionDefinition(
			                                                 new FunctionType(((ProgramContext)_localctx).function_parameter_definition.ast, ((ProgramContext)_localctx).void_type.ast),
			                                                 ((ProgramContext)_localctx).MAIN.getText(),
			                                                 ((ProgramContext)_localctx).function_body.ast,
			                                                 ((ProgramContext)_localctx).DEF.getLine(),
			                                                 ((ProgramContext)_localctx).DEF.getCharPositionInLine() + 1
			                                             );
			                                             
			 _localctx.definitions.add(_localctx.main); 
			 ((ProgramContext)_localctx).ast =  new Program(_localctx.definitions); 
			setState(50);
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
		public Expression ast;
		public ExpressionContext exp1;
		public Token ID;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token REAL_CONSTANT;
		public Function_argumentsContext fi;
		public ExpressionContext expression;
		public Type_simpleContext type_simple;
		public Token OP;
		public ExpressionContext exp2;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public Function_argumentsContext function_arguments() {
			return getRuleContext(Function_argumentsContext.class,0);
		}
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(53);
				((ExpressionContext)_localctx).ID = match(ID);

				                        ((ExpressionContext)_localctx).ast =  new VariableExpression(((ExpressionContext)_localctx).ID.getText()
				                        , ((ExpressionContext)_localctx).ID.getLine()
				                        , ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1);
				    
				}
				break;
			case 2:
				{
				setState(55);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);

				                        ((ExpressionContext)_localctx).ast =  new IntLiteralExpression(LexerHelper.lexemeToInt(((ExpressionContext)_localctx).INT_CONSTANT.getText())
				                        , ((ExpressionContext)_localctx).INT_CONSTANT.getLine()
				                        , ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1);
				    
				}
				break;
			case 3:
				{
				setState(57);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);

				                        ((ExpressionContext)_localctx).ast =  new CharLiteralExpression(LexerHelper.lexemeToChar(((ExpressionContext)_localctx).CHAR_CONSTANT.getText())
				                        , ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine()
				                        , ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1);
				    
				}
				break;
			case 4:
				{
				setState(59);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);

				                        ((ExpressionContext)_localctx).ast =  new RealLiteralExpression(LexerHelper.lexemeToReal(((ExpressionContext)_localctx).REAL_CONSTANT.getText())
				                        , ((ExpressionContext)_localctx).REAL_CONSTANT.getLine()
				                        , ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1);
				    
				}
				break;
			case 5:
				{
				setState(61);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(62);
				match(T__2);
				setState(63);
				((ExpressionContext)_localctx).fi = function_arguments();
				setState(64);
				match(T__3);

				                        ((ExpressionContext)_localctx).ast =  new FunctionInvocation(
				                        new VariableExpression(((ExpressionContext)_localctx).ID.getText(), ((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1)
				                        , ((ExpressionContext)_localctx).fi.ast
				                        , ((ExpressionContext)_localctx).ID.getLine()
				                        , ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1
				                        );
				    
				}
				break;
			case 6:
				{
				setState(67);
				match(T__2);
				setState(68);
				((ExpressionContext)_localctx).expression = expression(0);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).expression.ast; 
				setState(70);
				match(T__3);
				}
				break;
			case 7:
				{
				setState(72);
				match(T__2);
				setState(73);
				((ExpressionContext)_localctx).type_simple = type_simple();
				setState(74);
				match(T__3);
				setState(75);
				((ExpressionContext)_localctx).expression = expression(7);

				                    ((ExpressionContext)_localctx).ast =  new CastExpression(
				                    ((ExpressionContext)_localctx).type_simple.ast
				                    , ((ExpressionContext)_localctx).expression.ast
				                    , ((ExpressionContext)_localctx).type_simple.ast.getLine()
				                    , ((ExpressionContext)_localctx).type_simple.ast.getColumn());
				                     
				}
				break;
			case 8:
				{
				setState(78);
				match(T__8);
				setState(79);
				((ExpressionContext)_localctx).exp1 = ((ExpressionContext)_localctx).expression = expression(6);

				                    ((ExpressionContext)_localctx).ast =  new UnaryMinusExpression(
				                    ((ExpressionContext)_localctx).exp1.ast
				                    , ((ExpressionContext)_localctx).exp1.ast.getLine()
				                    , ((ExpressionContext)_localctx).exp1.ast.getColumn());
				                     
				}
				break;
			case 9:
				{
				setState(82);
				match(T__9);
				setState(83);
				((ExpressionContext)_localctx).exp1 = ((ExpressionContext)_localctx).expression = expression(5);

				                    ((ExpressionContext)_localctx).ast =  new NotExpression(((ExpressionContext)_localctx).exp1.ast
				                    , ((ExpressionContext)_localctx).exp1.ast.getLine()
				                    , ((ExpressionContext)_localctx).exp1.ast.getColumn());
				                     
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(120);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(118);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(88);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(89);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14336L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(90);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(5);

						                                ((ExpressionContext)_localctx).ast =  new ArithmeticExpression(
						                                ((ExpressionContext)_localctx).OP.getText()
						                                , ((ExpressionContext)_localctx).exp1.ast
						                                , ((ExpressionContext)_localctx).exp2.ast
						                                , ((ExpressionContext)_localctx).exp1.ast.getLine()
						                                , ((ExpressionContext)_localctx).exp1.ast.getColumn());
						                                 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(94);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__13) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(95);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(4);

						                              ((ExpressionContext)_localctx).ast =  new ArithmeticExpression(
						                              ((ExpressionContext)_localctx).OP.getText()
						                              , ((ExpressionContext)_localctx).exp1.ast
						                              , ((ExpressionContext)_localctx).exp2.ast
						                              , ((ExpressionContext)_localctx).exp1.ast.getLine()
						                              , ((ExpressionContext)_localctx).exp1.ast.getColumn());
						                               
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(98);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(99);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2064384L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(100);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(3);

						                              ((ExpressionContext)_localctx).ast =  new ArithmeticComparisonExpression(
						                              ((ExpressionContext)_localctx).OP.getText()
						                              , ((ExpressionContext)_localctx).exp1.ast
						                              , ((ExpressionContext)_localctx).exp2.ast
						                              , ((ExpressionContext)_localctx).exp1.ast.getLine()
						                              , ((ExpressionContext)_localctx).exp1.ast.getColumn());
						                              
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(104);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(2);

						                              ((ExpressionContext)_localctx).ast =  new LogicComparisonExpression(
						                              ((ExpressionContext)_localctx).OP.getText()
						                              , ((ExpressionContext)_localctx).exp1.ast
						                              , ((ExpressionContext)_localctx).exp2.ast
						                              , ((ExpressionContext)_localctx).exp1.ast.getLine()
						                              , ((ExpressionContext)_localctx).exp1.ast.getColumn());
						                              
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(108);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(109);
						match(T__5);
						setState(110);
						((ExpressionContext)_localctx).exp2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(111);
						match(T__6);

						                              ((ExpressionContext)_localctx).ast =  new ArrayIndexExpression(
						                                  ((ExpressionContext)_localctx).exp1.ast
						                                  , ((ExpressionContext)_localctx).exp2.ast
						                                  , ((ExpressionContext)_localctx).exp1.ast.getLine()
						                                  , ((ExpressionContext)_localctx).exp1.ast.getColumn());
						                                   
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.exp1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(114);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(115);
						match(T__7);
						setState(116);
						((ExpressionContext)_localctx).ID = match(ID);

						                              ((ExpressionContext)_localctx).ast =  new FieldAccessExpression(
						                              ((ExpressionContext)_localctx).exp1.ast
						                              , ((ExpressionContext)_localctx).ID.getText()
						                              , ((ExpressionContext)_localctx).exp1.ast.getLine()
						                              , ((ExpressionContext)_localctx).exp1.ast.getColumn());
						                               
						}
						break;
					}
					} 
				}
				setState(122);
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
		public Statement ast;
		public List<Expression> exps = new ArrayList<>();
		public List<Statement> elseBody = new ArrayList<>();
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public Token IF;
		public BodyContext ifB;
		public BodyContext elseB;
		public Token WHILE;
		public BodyContext wB;
		public Token RETURN;
		public Token ID;
		public Function_argumentsContext fArgs;
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
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Function_argumentsContext function_arguments() {
			return getRuleContext(Function_argumentsContext.class,0);
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
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(T__22);
				setState(124);
				((StatementContext)_localctx).exp1 = expression(0);
				 _localctx.exps.add(((StatementContext)_localctx).exp1.ast); 
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(126);
					match(T__23);
					setState(127);
					((StatementContext)_localctx).exp2 = expression(0);
					 _localctx.exps.add(((StatementContext)_localctx).exp2.ast); 
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(T__24);
				 ((StatementContext)_localctx).ast =  new PrintStatement(_localctx.exps, ((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn()); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(T__25);
				setState(139);
				((StatementContext)_localctx).exp1 = expression(0);
				 _localctx.exps.add(((StatementContext)_localctx).exp1.ast); 
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(141);
					match(T__23);
					setState(142);
					((StatementContext)_localctx).exp2 = expression(0);
					 _localctx.exps.add(((StatementContext)_localctx).exp2.ast); 
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__24);
				 ((StatementContext)_localctx).ast =  new ReadStatement(_localctx.exps, ((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn()); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(154);
				match(T__26);
				setState(155);
				((StatementContext)_localctx).exp2 = expression(0);
				 ((StatementContext)_localctx).ast =  new AssignmentStatement(((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).exp2.ast, ((StatementContext)_localctx).exp1.ast.getLine(), ((StatementContext)_localctx).exp1.ast.getColumn()); 
				setState(157);
				match(T__24);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				((StatementContext)_localctx).IF = match(T__27);
				setState(160);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(161);
				match(T__4);
				setState(162);
				((StatementContext)_localctx).ifB = body();
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(163);
					match(T__28);
					setState(164);
					match(T__4);
					setState(165);
					((StatementContext)_localctx).elseB = body();
					 ((StatementContext)_localctx).elseBody =  ((StatementContext)_localctx).elseB.ast; 
					}
					break;
				case 2:
					{
					 ((StatementContext)_localctx).ast =  _localctx.ast; 
					}
					break;
				}
				 ((StatementContext)_localctx).ast =  new IfElseStatement(((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).ifB.ast, _localctx.elseBody, ((StatementContext)_localctx).IF.getLine(), ((StatementContext)_localctx).IF.getCharPositionInLine() + 1); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				((StatementContext)_localctx).WHILE = match(T__29);
				setState(174);
				((StatementContext)_localctx).exp1 = expression(0);
				setState(175);
				match(T__4);
				setState(176);
				((StatementContext)_localctx).wB = body();
				 ((StatementContext)_localctx).ast =  new WhileStatement(((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).wB.ast, ((StatementContext)_localctx).WHILE.getLine(), ((StatementContext)_localctx).WHILE.getCharPositionInLine() + 1); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179);
				((StatementContext)_localctx).RETURN = match(T__30);
				setState(180);
				((StatementContext)_localctx).exp1 = expression(0);
				 ((StatementContext)_localctx).ast =  new ReturnStatement(((StatementContext)_localctx).exp1.ast, ((StatementContext)_localctx).RETURN.getLine(), ((StatementContext)_localctx).RETURN.getCharPositionInLine() + 1); 
				setState(182);
				match(T__24);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(184);
				((StatementContext)_localctx).ID = match(ID);
				setState(185);
				match(T__2);
				setState(186);
				((StatementContext)_localctx).fArgs = function_arguments();
				setState(187);
				match(T__3);
				 ((StatementContext)_localctx).ast =  new FunctionInvocation(new VariableExpression(((StatementContext)_localctx).ID.getText(), ((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine() + 1), ((StatementContext)_localctx).fArgs.ast, ((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine() + 1); 
				setState(189);
				match(T__24);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Type returnType;
		public Token DEF;
		public Token ID;
		public Function_parameter_definitionContext funcParDef;
		public Type_simpleContext ts;
		public Void_typeContext vt;
		public Function_bodyContext funcB;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Function_parameter_definitionContext function_parameter_definition() {
			return getRuleContext(Function_parameter_definitionContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Void_typeContext void_type() {
			return getRuleContext(Void_typeContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunction_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			((Function_definitionContext)_localctx).DEF = match(T__0);
			setState(194);
			((Function_definitionContext)_localctx).ID = match(ID);
			setState(195);
			match(T__2);
			setState(196);
			((Function_definitionContext)_localctx).funcParDef = function_parameter_definition();
			setState(197);
			match(T__3);
			setState(198);
			match(T__4);
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				{
				setState(199);
				((Function_definitionContext)_localctx).ts = type_simple();
				 ((Function_definitionContext)_localctx).returnType =  ((Function_definitionContext)_localctx).ts.ast; 
				}
				break;
			case T__31:
				{
				setState(202);
				((Function_definitionContext)_localctx).vt = void_type();
				 ((Function_definitionContext)_localctx).returnType =  ((Function_definitionContext)_localctx).vt.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(207);
			((Function_definitionContext)_localctx).funcB = function_body();

			                    ((Function_definitionContext)_localctx).ast =  new FunctionDefinition(
			                                            new FunctionType(((Function_definitionContext)_localctx).funcParDef.ast, _localctx.returnType),
			                                            ((Function_definitionContext)_localctx).ID.getText(),
			                                            ((Function_definitionContext)_localctx).funcB.ast,
			                                            ((Function_definitionContext)_localctx).DEF.getLine(),
			                                            ((Function_definitionContext)_localctx).DEF.getCharPositionInLine() + 1
			                    );
			                    
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
	public static class Function_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<>();
		public Variable_definitionContext varDef;
		public StatementContext st;
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunction_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_body);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__31);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(211);
					((Function_bodyContext)_localctx).varDef = variable_definition();
					 _localctx.ast.addAll(((Function_bodyContext)_localctx).varDef.ast); 
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4126733764104L) != 0)) {
				{
				{
				setState(219);
				((Function_bodyContext)_localctx).st = statement();
				 _localctx.ast.add(((Function_bodyContext)_localctx).st.ast); 
				}
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(227);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Function_argumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext exp1;
		public ExpressionContext exp2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Function_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_arguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunction_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_argumentsContext function_arguments() throws RecognitionException {
		Function_argumentsContext _localctx = new Function_argumentsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_arguments);
		int _la;
		try {
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__8:
			case T__9:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(229);
				((Function_argumentsContext)_localctx).exp1 = expression(0);
				 _localctx.ast.add(((Function_argumentsContext)_localctx).exp1.ast); 
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(231);
					match(T__23);
					setState(232);
					((Function_argumentsContext)_localctx).exp2 = expression(0);
					 _localctx.ast.add(((Function_argumentsContext)_localctx).exp2.ast); 
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				 ((Function_argumentsContext)_localctx).ast =  _localctx.ast; 
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
	public static class Function_parameter_definitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public Parameter_definitionContext ar1;
		public Parameter_definitionContext ar2;
		public List<Parameter_definitionContext> parameter_definition() {
			return getRuleContexts(Parameter_definitionContext.class);
		}
		public Parameter_definitionContext parameter_definition(int i) {
			return getRuleContext(Parameter_definitionContext.class,i);
		}
		public Function_parameter_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameter_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitFunction_parameter_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parameter_definitionContext function_parameter_definition() throws RecognitionException {
		Function_parameter_definitionContext _localctx = new Function_parameter_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_parameter_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(243);
				((Function_parameter_definitionContext)_localctx).ar1 = parameter_definition();
				 _localctx.ast.add(((Function_parameter_definitionContext)_localctx).ar1.ast); 
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(245);
					match(T__23);
					setState(246);
					((Function_parameter_definitionContext)_localctx).ar2 = parameter_definition();
					 _localctx.ast.add(((Function_parameter_definitionContext)_localctx).ar2.ast); 
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				{
				 ((Function_parameter_definitionContext)_localctx).ast =  _localctx.ast; 
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Parameter_definitionContext extends ParserRuleContext {
		public VariableDefinition ast;
		public Token ID;
		public Type_simpleContext t1;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Parameter_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_definition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitParameter_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_definitionContext parameter_definition() throws RecognitionException {
		Parameter_definitionContext _localctx = new Parameter_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			((Parameter_definitionContext)_localctx).ID = match(ID);
			setState(258);
			match(T__4);
			setState(259);
			((Parameter_definitionContext)_localctx).t1 = type_simple();

			                    ((Parameter_definitionContext)_localctx).ast =  new VariableDefinition(((Parameter_definitionContext)_localctx).t1.ast
			                    , ((Parameter_definitionContext)_localctx).ID.getText()
			                    , ((Parameter_definitionContext)_localctx).ID.getLine()
			                    , ((Parameter_definitionContext)_localctx).ID.getCharPositionInLine() + 1);
			                     
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
		public List<Statement> ast = new ArrayList<>();
		public StatementContext st1;
		public StatementContext st2;
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
		enterRule(_localctx, 16, RULE_body);
		int _la;
		try {
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__8:
			case T__9:
			case T__22:
			case T__25:
			case T__27:
			case T__29:
			case T__30:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				((BodyContext)_localctx).st1 = statement();
				 _localctx.ast.add(((BodyContext)_localctx).st1.ast); 
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(T__31);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4126733764104L) != 0)) {
					{
					{
					setState(266);
					((BodyContext)_localctx).st2 = statement();
					 _localctx.ast.add(((BodyContext)_localctx).st2.ast); 
					}
					}
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(274);
				match(T__32);
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
	public static class Variable_definitionContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<>();
		public Token ID1;
		public Token ID2;
		public TypeContext t;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		enterRule(_localctx, 18, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			((Variable_definitionContext)_localctx).ID1 = match(ID);
			 _localctx.ast.add(new VariableDefinition(null, ((Variable_definitionContext)_localctx).ID1.getText(), ((Variable_definitionContext)_localctx).ID1.getLine(), ((Variable_definitionContext)_localctx).ID1.getCharPositionInLine() + 1)); 
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(279);
				match(T__23);
				setState(280);
				((Variable_definitionContext)_localctx).ID2 = match(ID);

				            for (VariableDefinition varDef: _localctx.ast)
				                if(varDef.getName().equals(((Variable_definitionContext)_localctx).ID2.getText()))
				                    new ErrorType("Repeated identifier in variable definition: " + varDef.getName() + ".", ((Variable_definitionContext)_localctx).ID2.getLine(), ((Variable_definitionContext)_localctx).ID2.getCharPositionInLine() + 1);

				            _localctx.ast.add(new VariableDefinition(null, ((Variable_definitionContext)_localctx).ID2.getText(), ((Variable_definitionContext)_localctx).ID2.getLine(), ((Variable_definitionContext)_localctx).ID2.getCharPositionInLine() + 1));
				        
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287);
			match(T__4);
			setState(288);
			((Variable_definitionContext)_localctx).t = type();
			 for(VariableDefinition def: _localctx.ast) { def.setType(((Variable_definitionContext)_localctx).t.ast); } 
			setState(290);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Type_simpleContext type_simple;
		public Type_complexContext type_complex;
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Type_complexContext type_complex() {
			return getRuleContext(Type_complexContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((TypeContext)_localctx).type_simple = type_simple();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_simple.ast; 
				}
				break;
			case T__5:
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				((TypeContext)_localctx).type_complex = type_complex();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).type_complex.ast; 
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
	public static class Type_simpleContext extends ParserRuleContext {
		public Type ast;
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
		enterRule(_localctx, 22, RULE_type_simple);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				match(T__33);
				 ((Type_simpleContext)_localctx).ast =  IntType.getInstance(); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				match(T__34);
				 ((Type_simpleContext)_localctx).ast =  RealType.getInstance(); 
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				match(T__35);
				 ((Type_simpleContext)_localctx).ast =  CharType.getInstance(); 
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
	public static class Type_complexContext extends ParserRuleContext {
		public Type ast;
		public List<RecordField> recordFields = new ArrayList<>();
		public Token INT_CONSTANT;
		public TypeContext t1;
		public Variable_definitionContext varDef;
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
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
		enterRule(_localctx, 24, RULE_type_complex);
		int _la;
		try {
			setState(326);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(T__5);
				setState(309);
				((Type_complexContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(310);
				match(T__6);
				setState(311);
				((Type_complexContext)_localctx).t1 = type();
				 ((Type_complexContext)_localctx).ast =  new ArrayType(((Type_complexContext)_localctx).t1.ast, LexerHelper.lexemeToInt(((Type_complexContext)_localctx).INT_CONSTANT.getText())); 
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(T__36);
				setState(315);
				match(T__31);
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ID) {
					{
					{
					setState(316);
					((Type_complexContext)_localctx).varDef = variable_definition();

					            for(VariableDefinition def : ((Type_complexContext)_localctx).varDef.ast) {

					                for(RecordField rf: _localctx.recordFields)
					                    if(rf.getName().equals(def.getName()))
					                        new ErrorType("Repeated identifier in struct: " + rf.getName() + ".", def.getLine(), def.getColumn());

					                _localctx.recordFields.add(new RecordField(def.getName(), def.getType(), def.getLine(), def.getColumn()));
					            }

					        
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(324);
				match(T__32);
				 ((Type_complexContext)_localctx).ast =  new RecordType(_localctx.recordFields); 
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
	public static class Void_typeContext extends ParserRuleContext {
		public Type ast;
		public Void_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_void_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PmmVisitor ) return ((PmmVisitor<? extends T>)visitor).visitVoid_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Void_typeContext void_type() throws RecognitionException {
		Void_typeContext _localctx = new Void_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_void_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((Void_typeContext)_localctx).ast =  VoidType.getInstance(); 
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
		"\u0004\u0001+\u014b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0005\u0000#\b\u0000\n\u0000\f\u0000&\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"W\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001w\b\u0001\n\u0001\f\u0001z\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u0083\b\u0002\n\u0002\f\u0002\u0086\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0092\b\u0002\n\u0002\f\u0002"+
		"\u0095\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\u00aa\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u00c0\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u00ce\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u00d7\b\u0004\n\u0004\f\u0004\u00da\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u00df\b\u0004\n\u0004\f\u0004\u00e2\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005\u00ec\b\u0005\n\u0005\f\u0005\u00ef\t\u0005\u0001"+
		"\u0005\u0003\u0005\u00f2\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00fa\b\u0006\n\u0006\f\u0006"+
		"\u00fd\t\u0006\u0001\u0006\u0003\u0006\u0100\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u010e\b\b\n\b\f\b\u0111\t\b\u0001\b"+
		"\u0003\b\u0114\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u011b"+
		"\b\t\n\t\f\t\u011e\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u012b\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0133\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0140\b\f\n\f\f\f\u0143\t\f\u0001"+
		"\f\u0001\f\u0003\f\u0147\b\f\u0001\r\u0001\r\u0001\r\u0000\u0001\u0002"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0004\u0001\u0000\u000b\r\u0002\u0000\t\t\u000e\u000e\u0001"+
		"\u0000\u000f\u0014\u0001\u0000\u0015\u0016\u0164\u0000$\u0001\u0000\u0000"+
		"\u0000\u0002V\u0001\u0000\u0000\u0000\u0004\u00bf\u0001\u0000\u0000\u0000"+
		"\u0006\u00c1\u0001\u0000\u0000\u0000\b\u00d2\u0001\u0000\u0000\u0000\n"+
		"\u00f1\u0001\u0000\u0000\u0000\f\u00ff\u0001\u0000\u0000\u0000\u000e\u0101"+
		"\u0001\u0000\u0000\u0000\u0010\u0113\u0001\u0000\u0000\u0000\u0012\u0115"+
		"\u0001\u0000\u0000\u0000\u0014\u012a\u0001\u0000\u0000\u0000\u0016\u0132"+
		"\u0001\u0000\u0000\u0000\u0018\u0146\u0001\u0000\u0000\u0000\u001a\u0148"+
		"\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0012\t\u0000\u001d\u001e\u0006"+
		"\u0000\uffff\uffff\u0000\u001e#\u0001\u0000\u0000\u0000\u001f \u0003\u0006"+
		"\u0003\u0000 !\u0006\u0000\uffff\uffff\u0000!#\u0001\u0000\u0000\u0000"+
		"\"\u001c\u0001\u0000\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000#&\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%\'\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\'(\u0005\u0001\u0000"+
		"\u0000()\u0005\u0002\u0000\u0000)*\u0005\u0003\u0000\u0000*+\u0003\f\u0006"+
		"\u0000+,\u0005\u0004\u0000\u0000,-\u0005\u0005\u0000\u0000-.\u0003\u001a"+
		"\r\u0000./\u0003\b\u0004\u0000/0\u0006\u0000\uffff\uffff\u000001\u0006"+
		"\u0000\uffff\uffff\u000012\u0006\u0000\uffff\uffff\u000023\u0005\u0000"+
		"\u0000\u00013\u0001\u0001\u0000\u0000\u000045\u0006\u0001\uffff\uffff"+
		"\u000056\u0005)\u0000\u00006W\u0006\u0001\uffff\uffff\u000078\u0005&\u0000"+
		"\u00008W\u0006\u0001\uffff\uffff\u00009:\u0005(\u0000\u0000:W\u0006\u0001"+
		"\uffff\uffff\u0000;<\u0005\'\u0000\u0000<W\u0006\u0001\uffff\uffff\u0000"+
		"=>\u0005)\u0000\u0000>?\u0005\u0003\u0000\u0000?@\u0003\n\u0005\u0000"+
		"@A\u0005\u0004\u0000\u0000AB\u0006\u0001\uffff\uffff\u0000BW\u0001\u0000"+
		"\u0000\u0000CD\u0005\u0003\u0000\u0000DE\u0003\u0002\u0001\u0000EF\u0006"+
		"\u0001\uffff\uffff\u0000FG\u0005\u0004\u0000\u0000GW\u0001\u0000\u0000"+
		"\u0000HI\u0005\u0003\u0000\u0000IJ\u0003\u0016\u000b\u0000JK\u0005\u0004"+
		"\u0000\u0000KL\u0003\u0002\u0001\u0007LM\u0006\u0001\uffff\uffff\u0000"+
		"MW\u0001\u0000\u0000\u0000NO\u0005\t\u0000\u0000OP\u0003\u0002\u0001\u0006"+
		"PQ\u0006\u0001\uffff\uffff\u0000QW\u0001\u0000\u0000\u0000RS\u0005\n\u0000"+
		"\u0000ST\u0003\u0002\u0001\u0005TU\u0006\u0001\uffff\uffff\u0000UW\u0001"+
		"\u0000\u0000\u0000V4\u0001\u0000\u0000\u0000V7\u0001\u0000\u0000\u0000"+
		"V9\u0001\u0000\u0000\u0000V;\u0001\u0000\u0000\u0000V=\u0001\u0000\u0000"+
		"\u0000VC\u0001\u0000\u0000\u0000VH\u0001\u0000\u0000\u0000VN\u0001\u0000"+
		"\u0000\u0000VR\u0001\u0000\u0000\u0000Wx\u0001\u0000\u0000\u0000XY\n\u0004"+
		"\u0000\u0000YZ\u0007\u0000\u0000\u0000Z[\u0003\u0002\u0001\u0005[\\\u0006"+
		"\u0001\uffff\uffff\u0000\\w\u0001\u0000\u0000\u0000]^\n\u0003\u0000\u0000"+
		"^_\u0007\u0001\u0000\u0000_`\u0003\u0002\u0001\u0004`a\u0006\u0001\uffff"+
		"\uffff\u0000aw\u0001\u0000\u0000\u0000bc\n\u0002\u0000\u0000cd\u0007\u0002"+
		"\u0000\u0000de\u0003\u0002\u0001\u0003ef\u0006\u0001\uffff\uffff\u0000"+
		"fw\u0001\u0000\u0000\u0000gh\n\u0001\u0000\u0000hi\u0007\u0003\u0000\u0000"+
		"ij\u0003\u0002\u0001\u0002jk\u0006\u0001\uffff\uffff\u0000kw\u0001\u0000"+
		"\u0000\u0000lm\n\t\u0000\u0000mn\u0005\u0006\u0000\u0000no\u0003\u0002"+
		"\u0001\u0000op\u0005\u0007\u0000\u0000pq\u0006\u0001\uffff\uffff\u0000"+
		"qw\u0001\u0000\u0000\u0000rs\n\b\u0000\u0000st\u0005\b\u0000\u0000tu\u0005"+
		")\u0000\u0000uw\u0006\u0001\uffff\uffff\u0000vX\u0001\u0000\u0000\u0000"+
		"v]\u0001\u0000\u0000\u0000vb\u0001\u0000\u0000\u0000vg\u0001\u0000\u0000"+
		"\u0000vl\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000wz\u0001\u0000"+
		"\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y\u0003"+
		"\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{|\u0005\u0017\u0000"+
		"\u0000|}\u0003\u0002\u0001\u0000}\u0084\u0006\u0002\uffff\uffff\u0000"+
		"~\u007f\u0005\u0018\u0000\u0000\u007f\u0080\u0003\u0002\u0001\u0000\u0080"+
		"\u0081\u0006\u0002\uffff\uffff\u0000\u0081\u0083\u0001\u0000\u0000\u0000"+
		"\u0082~\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005\u0019\u0000\u0000\u0088\u0089\u0006\u0002\uffff\uffff\u0000"+
		"\u0089\u00c0\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u001a\u0000\u0000"+
		"\u008b\u008c\u0003\u0002\u0001\u0000\u008c\u0093\u0006\u0002\uffff\uffff"+
		"\u0000\u008d\u008e\u0005\u0018\u0000\u0000\u008e\u008f\u0003\u0002\u0001"+
		"\u0000\u008f\u0090\u0006\u0002\uffff\uffff\u0000\u0090\u0092\u0001\u0000"+
		"\u0000\u0000\u0091\u008d\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005\u0019\u0000\u0000\u0097\u0098\u0006\u0002"+
		"\uffff\uffff\u0000\u0098\u00c0\u0001\u0000\u0000\u0000\u0099\u009a\u0003"+
		"\u0002\u0001\u0000\u009a\u009b\u0005\u001b\u0000\u0000\u009b\u009c\u0003"+
		"\u0002\u0001\u0000\u009c\u009d\u0006\u0002\uffff\uffff\u0000\u009d\u009e"+
		"\u0005\u0019\u0000\u0000\u009e\u00c0\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0005\u001c\u0000\u0000\u00a0\u00a1\u0003\u0002\u0001\u0000\u00a1\u00a2"+
		"\u0005\u0005\u0000\u0000\u00a2\u00a9\u0003\u0010\b\u0000\u00a3\u00a4\u0005"+
		"\u001d\u0000\u0000\u00a4\u00a5\u0005\u0005\u0000\u0000\u00a5\u00a6\u0003"+
		"\u0010\b\u0000\u00a6\u00a7\u0006\u0002\uffff\uffff\u0000\u00a7\u00aa\u0001"+
		"\u0000\u0000\u0000\u00a8\u00aa\u0006\u0002\uffff\uffff\u0000\u00a9\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006\u0002\uffff\uffff\u0000\u00ac"+
		"\u00c0\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u001e\u0000\u0000\u00ae"+
		"\u00af\u0003\u0002\u0001\u0000\u00af\u00b0\u0005\u0005\u0000\u0000\u00b0"+
		"\u00b1\u0003\u0010\b\u0000\u00b1\u00b2\u0006\u0002\uffff\uffff\u0000\u00b2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u001f\u0000\u0000\u00b4"+
		"\u00b5\u0003\u0002\u0001\u0000\u00b5\u00b6\u0006\u0002\uffff\uffff\u0000"+
		"\u00b6\u00b7\u0005\u0019\u0000\u0000\u00b7\u00c0\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0005)\u0000\u0000\u00b9\u00ba\u0005\u0003\u0000\u0000\u00ba"+
		"\u00bb\u0003\n\u0005\u0000\u00bb\u00bc\u0005\u0004\u0000\u0000\u00bc\u00bd"+
		"\u0006\u0002\uffff\uffff\u0000\u00bd\u00be\u0005\u0019\u0000\u0000\u00be"+
		"\u00c0\u0001\u0000\u0000\u0000\u00bf{\u0001\u0000\u0000\u0000\u00bf\u008a"+
		"\u0001\u0000\u0000\u0000\u00bf\u0099\u0001\u0000\u0000\u0000\u00bf\u009f"+
		"\u0001\u0000\u0000\u0000\u00bf\u00ad\u0001\u0000\u0000\u0000\u00bf\u00b3"+
		"\u0001\u0000\u0000\u0000\u00bf\u00b8\u0001\u0000\u0000\u0000\u00c0\u0005"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005\u0001\u0000\u0000\u00c2\u00c3"+
		"\u0005)\u0000\u0000\u00c3\u00c4\u0005\u0003\u0000\u0000\u00c4\u00c5\u0003"+
		"\f\u0006\u0000\u00c5\u00c6\u0005\u0004\u0000\u0000\u00c6\u00cd\u0005\u0005"+
		"\u0000\u0000\u00c7\u00c8\u0003\u0016\u000b\u0000\u00c8\u00c9\u0006\u0003"+
		"\uffff\uffff\u0000\u00c9\u00ce\u0001\u0000\u0000\u0000\u00ca\u00cb\u0003"+
		"\u001a\r\u0000\u00cb\u00cc\u0006\u0003\uffff\uffff\u0000\u00cc\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cd\u00c7\u0001\u0000\u0000\u0000\u00cd\u00ca\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0003"+
		"\b\u0004\u0000\u00d0\u00d1\u0006\u0003\uffff\uffff\u0000\u00d1\u0007\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d8\u0005 \u0000\u0000\u00d3\u00d4\u0003\u0012"+
		"\t\u0000\u00d4\u00d5\u0006\u0004\uffff\uffff\u0000\u00d5\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d3\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000"+
		"\u0000\u0000\u00d9\u00e0\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0003\u0004\u0002\u0000\u00dc\u00dd\u0006\u0004"+
		"\uffff\uffff\u0000\u00dd\u00df\u0001\u0000\u0000\u0000\u00de\u00db\u0001"+
		"\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"+
		"!\u0000\u0000\u00e4\t\u0001\u0000\u0000\u0000\u00e5\u00e6\u0003\u0002"+
		"\u0001\u0000\u00e6\u00ed\u0006\u0005\uffff\uffff\u0000\u00e7\u00e8\u0005"+
		"\u0018\u0000\u0000\u00e8\u00e9\u0003\u0002\u0001\u0000\u00e9\u00ea\u0006"+
		"\u0005\uffff\uffff\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb\u00e7"+
		"\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000\u0000\u0000\u00ed\u00eb"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f2"+
		"\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f2"+
		"\u0006\u0005\uffff\uffff\u0000\u00f1\u00e5\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f2\u000b\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0003\u000e\u0007\u0000\u00f4\u00fb\u0006\u0006\uffff\uffff\u0000"+
		"\u00f5\u00f6\u0005\u0018\u0000\u0000\u00f6\u00f7\u0003\u000e\u0007\u0000"+
		"\u00f7\u00f8\u0006\u0006\uffff\uffff\u0000\u00f8\u00fa\u0001\u0000\u0000"+
		"\u0000\u00f9\u00f5\u0001\u0000\u0000\u0000\u00fa\u00fd\u0001\u0000\u0000"+
		"\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000"+
		"\u0000\u00fc\u0100\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fe\u0100\u0006\u0006\uffff\uffff\u0000\u00ff\u00f3\u0001\u0000"+
		"\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100\r\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0005)\u0000\u0000\u0102\u0103\u0005\u0005\u0000\u0000"+
		"\u0103\u0104\u0003\u0016\u000b\u0000\u0104\u0105\u0006\u0007\uffff\uffff"+
		"\u0000\u0105\u000f\u0001\u0000\u0000\u0000\u0106\u0107\u0003\u0004\u0002"+
		"\u0000\u0107\u0108\u0006\b\uffff\uffff\u0000\u0108\u0114\u0001\u0000\u0000"+
		"\u0000\u0109\u010f\u0005 \u0000\u0000\u010a\u010b\u0003\u0004\u0002\u0000"+
		"\u010b\u010c\u0006\b\uffff\uffff\u0000\u010c\u010e\u0001\u0000\u0000\u0000"+
		"\u010d\u010a\u0001\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000\u0000"+
		"\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000"+
		"\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000\u0000"+
		"\u0112\u0114\u0005!\u0000\u0000\u0113\u0106\u0001\u0000\u0000\u0000\u0113"+
		"\u0109\u0001\u0000\u0000\u0000\u0114\u0011\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0005)\u0000\u0000\u0116\u011c\u0006\t\uffff\uffff\u0000\u0117"+
		"\u0118\u0005\u0018\u0000\u0000\u0118\u0119\u0005)\u0000\u0000\u0119\u011b"+
		"\u0006\t\uffff\uffff\u0000\u011a\u0117\u0001\u0000\u0000\u0000\u011b\u011e"+
		"\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d"+
		"\u0001\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e\u011c"+
		"\u0001\u0000\u0000\u0000\u011f\u0120\u0005\u0005\u0000\u0000\u0120\u0121"+
		"\u0003\u0014\n\u0000\u0121\u0122\u0006\t\uffff\uffff\u0000\u0122\u0123"+
		"\u0005\u0019\u0000\u0000\u0123\u0013\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0003\u0016\u000b\u0000\u0125\u0126\u0006\n\uffff\uffff\u0000\u0126\u012b"+
		"\u0001\u0000\u0000\u0000\u0127\u0128\u0003\u0018\f\u0000\u0128\u0129\u0006"+
		"\n\uffff\uffff\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0124\u0001"+
		"\u0000\u0000\u0000\u012a\u0127\u0001\u0000\u0000\u0000\u012b\u0015\u0001"+
		"\u0000\u0000\u0000\u012c\u012d\u0005\"\u0000\u0000\u012d\u0133\u0006\u000b"+
		"\uffff\uffff\u0000\u012e\u012f\u0005#\u0000\u0000\u012f\u0133\u0006\u000b"+
		"\uffff\uffff\u0000\u0130\u0131\u0005$\u0000\u0000\u0131\u0133\u0006\u000b"+
		"\uffff\uffff\u0000\u0132\u012c\u0001\u0000\u0000\u0000\u0132\u012e\u0001"+
		"\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0133\u0017\u0001"+
		"\u0000\u0000\u0000\u0134\u0135\u0005\u0006\u0000\u0000\u0135\u0136\u0005"+
		"&\u0000\u0000\u0136\u0137\u0005\u0007\u0000\u0000\u0137\u0138\u0003\u0014"+
		"\n\u0000\u0138\u0139\u0006\f\uffff\uffff\u0000\u0139\u0147\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0005%\u0000\u0000\u013b\u0141\u0005 \u0000\u0000"+
		"\u013c\u013d\u0003\u0012\t\u0000\u013d\u013e\u0006\f\uffff\uffff\u0000"+
		"\u013e\u0140\u0001\u0000\u0000\u0000\u013f\u013c\u0001\u0000\u0000\u0000"+
		"\u0140\u0143\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0144\u0001\u0000\u0000\u0000"+
		"\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u0145\u0005!\u0000\u0000\u0145"+
		"\u0147\u0006\f\uffff\uffff\u0000\u0146\u0134\u0001\u0000\u0000\u0000\u0146"+
		"\u013a\u0001\u0000\u0000\u0000\u0147\u0019\u0001\u0000\u0000\u0000\u0148"+
		"\u0149\u0006\r\uffff\uffff\u0000\u0149\u001b\u0001\u0000\u0000\u0000\u0017"+
		"\"$Vvx\u0084\u0093\u00a9\u00bf\u00cd\u00d8\u00e0\u00ed\u00f1\u00fb\u00ff"+
		"\u010f\u0113\u011c\u012a\u0132\u0141\u0146";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
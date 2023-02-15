// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT_CONSTANT=1, REAL_CONSTANT=2, CHAR_CONSTANT=3, ID=4, WS=5, COMMENTS=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "INT_CONSTANT", "DOT", "EXPONENT", "MANTISSA", "REAL_CONSTANT", 
			"LETTER", "CHAR_CONSTANT", "ID", "WS", "COMMENTS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INT_CONSTANT", "REAL_CONSTANT", "CHAR_CONSTANT", "ID", "WS", "COMMENTS"
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


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0006\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001d"+
		"\b\u0001\n\u0001\f\u0001 \t\u0001\u0003\u0001\"\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0003\u0003(\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004<\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005I\b\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007Y\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0004\b^\b\b\u000b\b\f\b_\u0001\t\u0004\tc\b\t\u000b"+
		"\t\f\td\u0001\t\u0001\t\u0001\n\u0001\n\u0005\nk\b\n\n\n\f\nn\t\n\u0001"+
		"\n\u0003\nq\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\nx\b\n\n"+
		"\n\f\n{\t\n\u0001\n\u0001\n\u0001\n\u0003\n\u0080\b\n\u0001\n\u0001\n"+
		"\u0002ly\u0000\u000b\u0001\u0000\u0003\u0001\u0005\u0000\u0007\u0000\t"+
		"\u0000\u000b\u0002\r\u0000\u000f\u0003\u0011\u0004\u0013\u0005\u0015\u0006"+
		"\u0001\u0000\b\u0001\u000009\u0001\u000019\u0002\u0000EEee\u0002\u0000"+
		"++--\u0002\u0000AZaz\u0002\u0000nntt\u0003\u0000\t\n\r\r  \u0001\u0001"+
		"\n\n\u008f\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003!\u0001\u0000\u0000"+
		"\u0000\u0005#\u0001\u0000\u0000\u0000\u0007%\u0001\u0000\u0000\u0000\t"+
		";\u0001\u0000\u0000\u0000\u000bH\u0001\u0000\u0000\u0000\rJ\u0001\u0000"+
		"\u0000\u0000\u000fX\u0001\u0000\u0000\u0000\u0011]\u0001\u0000\u0000\u0000"+
		"\u0013b\u0001\u0000\u0000\u0000\u0015\u007f\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0007\u0000\u0000\u0000\u0018\u0002\u0001\u0000\u0000\u0000\u0019"+
		"\"\u00050\u0000\u0000\u001a\u001e\u0007\u0001\u0000\u0000\u001b\u001d"+
		"\u0003\u0001\u0000\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d \u0001"+
		"\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001"+
		"\u0000\u0000\u0000\u001f\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000"+
		"\u0000\u0000!\u0019\u0001\u0000\u0000\u0000!\u001a\u0001\u0000\u0000\u0000"+
		"\"\u0004\u0001\u0000\u0000\u0000#$\u0005.\u0000\u0000$\u0006\u0001\u0000"+
		"\u0000\u0000%\'\u0007\u0002\u0000\u0000&(\u0007\u0003\u0000\u0000\'&\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000"+
		")*\u0003\u0003\u0001\u0000*\b\u0001\u0000\u0000\u0000+,\u0003\u0003\u0001"+
		"\u0000,-\u0003\u0005\u0002\u0000-.\u0003\u0003\u0001\u0000./\u0003\u0007"+
		"\u0003\u0000/<\u0001\u0000\u0000\u000001\u0003\u0003\u0001\u000012\u0003"+
		"\u0005\u0002\u000023\u0003\u0007\u0003\u00003<\u0001\u0000\u0000\u0000"+
		"45\u0003\u0005\u0002\u000056\u0003\u0003\u0001\u000067\u0003\u0007\u0003"+
		"\u00007<\u0001\u0000\u0000\u000089\u0003\u0003\u0001\u00009:\u0003\u0007"+
		"\u0003\u0000:<\u0001\u0000\u0000\u0000;+\u0001\u0000\u0000\u0000;0\u0001"+
		"\u0000\u0000\u0000;4\u0001\u0000\u0000\u0000;8\u0001\u0000\u0000\u0000"+
		"<\n\u0001\u0000\u0000\u0000=>\u0003\u0003\u0001\u0000>?\u0003\u0005\u0002"+
		"\u0000?@\u0003\u0003\u0001\u0000@I\u0001\u0000\u0000\u0000AB\u0003\u0003"+
		"\u0001\u0000BC\u0003\u0005\u0002\u0000CI\u0001\u0000\u0000\u0000DE\u0003"+
		"\u0005\u0002\u0000EF\u0003\u0003\u0001\u0000FI\u0001\u0000\u0000\u0000"+
		"GI\u0003\t\u0004\u0000H=\u0001\u0000\u0000\u0000HA\u0001\u0000\u0000\u0000"+
		"HD\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000I\f\u0001\u0000\u0000"+
		"\u0000JK\u0007\u0004\u0000\u0000K\u000e\u0001\u0000\u0000\u0000LM\u0005"+
		"\'\u0000\u0000MN\t\u0000\u0000\u0000NY\u0005\'\u0000\u0000OP\u0005\'\u0000"+
		"\u0000PQ\u0005\\\u0000\u0000QR\u0007\u0005\u0000\u0000RY\u0005\'\u0000"+
		"\u0000ST\u0005\'\u0000\u0000TU\u0005\\\u0000\u0000UV\u0003\u0003\u0001"+
		"\u0000VW\u0005\'\u0000\u0000WY\u0001\u0000\u0000\u0000XL\u0001\u0000\u0000"+
		"\u0000XO\u0001\u0000\u0000\u0000XS\u0001\u0000\u0000\u0000Y\u0010\u0001"+
		"\u0000\u0000\u0000Z^\u0005_\u0000\u0000[^\u0003\r\u0006\u0000\\^\u0003"+
		"\u0001\u0000\u0000]Z\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000"+
		"]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`\u0012\u0001\u0000\u0000\u0000ac\u0007"+
		"\u0006\u0000\u0000ba\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000"+
		"\u0000fg\u0006\t\u0000\u0000g\u0014\u0001\u0000\u0000\u0000hl\u0005#\u0000"+
		"\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"+
		"\u0000lm\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mp\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000oq\u0007\u0007\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000q\u0080\u0001\u0000\u0000\u0000rs\u0005\"\u0000\u0000"+
		"st\u0005\"\u0000\u0000tu\u0005\"\u0000\u0000uy\u0001\u0000\u0000\u0000"+
		"vx\t\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"yz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|}\u0005\"\u0000\u0000}~\u0005\"\u0000"+
		"\u0000~\u0080\u0005\"\u0000\u0000\u007fh\u0001\u0000\u0000\u0000\u007f"+
		"r\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0006\n\u0000\u0000\u0082\u0016\u0001\u0000\u0000\u0000\u000e\u0000\u001e"+
		"!\';HX]_dlpy\u007f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
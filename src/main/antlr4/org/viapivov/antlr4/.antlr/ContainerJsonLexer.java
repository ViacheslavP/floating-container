// Generated from /home/viacheslav/Projects/JavaPlayground/simplecontainer/src/main/antlr4/org/viapivov/antlr4/ContainerJson.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ContainerJsonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, CLASS_NAME=5, STRING=6, PRIMITIVE=7, NUMBER=8, 
		SINGLE_STRING=9, DOUBLE_STRING=10, BOOL=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "CLASS_NAME", "STRING", "PRIMITIVE", 
			"NUMBER", "SINGLE_STRING", "DOUBLE_STRING", "BOOL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "','", "'}'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "CLASS_NAME", "STRING", "PRIMITIVE", "NUMBER", 
			"SINGLE_STRING", "DOUBLE_STRING", "BOOL", "WS"
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


	public ContainerJsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ContainerJson.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16j\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6:\n\6\3\7\3\7\5\7>\n\7\3\b\3\b\5\bB\n\b\3\t\6\tE\n\t\r\t\16\tF\3\n"+
		"\3\n\6\nK\n\n\r\n\16\nL\3\n\3\n\3\13\3\13\6\13S\n\13\r\13\16\13T\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fb\n\f\3\r\6\re\n\r\r\r\16"+
		"\rf\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\3\2\6\3\2\62;\3\2))\3\2$$\5\2\13\f\17\17\"\"\2q\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33"+
		"\3\2\2\2\5\35\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\139\3\2\2\2\r=\3\2\2\2\17"+
		"A\3\2\2\2\21D\3\2\2\2\23H\3\2\2\2\25P\3\2\2\2\27a\3\2\2\2\31d\3\2\2\2"+
		"\33\34\7}\2\2\34\4\3\2\2\2\35\36\7.\2\2\36\6\3\2\2\2\37 \7\177\2\2 \b"+
		"\3\2\2\2!\"\7<\2\2\"\n\3\2\2\2#$\7$\2\2$%\7e\2\2%&\7n\2\2&\'\7c\2\2\'"+
		"(\7u\2\2()\7u\2\2)*\7P\2\2*+\7c\2\2+,\7o\2\2,-\7g\2\2-:\7$\2\2./\7)\2"+
		"\2/\60\7e\2\2\60\61\7n\2\2\61\62\7c\2\2\62\63\7u\2\2\63\64\7u\2\2\64\65"+
		"\7P\2\2\65\66\7c\2\2\66\67\7o\2\2\678\7g\2\28:\7)\2\29#\3\2\2\29.\3\2"+
		"\2\2:\f\3\2\2\2;>\5\23\n\2<>\5\25\13\2=;\3\2\2\2=<\3\2\2\2>\16\3\2\2\2"+
		"?B\5\r\7\2@B\5\21\t\2A?\3\2\2\2A@\3\2\2\2B\20\3\2\2\2CE\t\2\2\2DC\3\2"+
		"\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\22\3\2\2\2HJ\7)\2\2IK\n\3\2\2JI\3"+
		"\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7)\2\2O\24\3\2\2\2PR"+
		"\7$\2\2QS\n\4\2\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW"+
		"\7$\2\2W\26\3\2\2\2XY\7v\2\2YZ\7t\2\2Z[\7w\2\2[b\7g\2\2\\]\7h\2\2]^\7"+
		"c\2\2^_\7n\2\2_`\7u\2\2`b\7g\2\2aX\3\2\2\2a\\\3\2\2\2b\30\3\2\2\2ce\t"+
		"\5\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\b\r\2\2i\32"+
		"\3\2\2\2\13\29=AFLTaf\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
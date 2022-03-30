// Generated from C:/programs/semester4/Math-language/src/main/java/bogac\Board.g4 by ANTLR 4.9.2
package bogac.bogac;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTDCL=1, BOOLDCL=2, STRINGDCL=3, DESIGNDCL=4, IDENTIFIER=5, INT=6, BOOL=7, 
		STRING=8, MOD=9, PLUS=10, MINUS=11, MULT=12, DIV=13, EXP=14, ASSIGN=15, 
		GTH=16, LTH=17, GTHEQL=18, LTHEQL=19, EQL=20, NEQL=21, NOT=22, AND=23, 
		OR=24, SETUPBLC=25, RULESBLC=26, GMLOOPBLC=27, IF=28, ELSEIF=29, ELSE=30, 
		RETURN=31, FOR=32, FOREACH=33, WHILE=34, FROM=35, SPECIAL=36, UNI_DIR=37, 
		BI_DIR=38, STATIC_DIR=39, CHOICE=40, ACTION=41, PRINT=42, LPAREN=43, RPAREN=44, 
		LBRACE=45, RBRACE=46, COMMA=47, NEWLINE=48, WS=49, EOL=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INTDCL", "BOOLDCL", "STRINGDCL", "DESIGNDCL", "IDENTIFIER", "INT", "BOOL", 
			"STRING", "MOD", "PLUS", "MINUS", "MULT", "DIV", "EXP", "ASSIGN", "GTH", 
			"LTH", "GTHEQL", "LTHEQL", "EQL", "NEQL", "NOT", "AND", "OR", "SETUPBLC", 
			"RULESBLC", "GMLOOPBLC", "IF", "ELSEIF", "ELSE", "RETURN", "FOR", "FOREACH", 
			"WHILE", "FROM", "SPECIAL", "UNI_DIR", "BI_DIR", "STATIC_DIR", "CHOICE", 
			"ACTION", "PRINT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "NEWLINE", 
			"WS", "EOL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'bool'", "'str'", "'design'", null, null, null, null, 
			"'%'", "'+'", "'-'", "'*'", "'/'", "'^'", "'='", "'>'", "'<'", "'>='", 
			"'<='", "'=='", "'!='", null, null, null, "'SETUP'", "'RULES'", "'GMLOOP'", 
			"'if'", "'elseif'", "'else'", "'return'", "'for'", "'foreach'", "'while'", 
			"'from'", "'special'", "'uni'", "'bi'", "'static'", "'choice'", "'action'", 
			"'print'", "'('", "')'", "'{'", "'}'", "','", "'\n'", null, "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INTDCL", "BOOLDCL", "STRINGDCL", "DESIGNDCL", "IDENTIFIER", "INT", 
			"BOOL", "STRING", "MOD", "PLUS", "MINUS", "MULT", "DIV", "EXP", "ASSIGN", 
			"GTH", "LTH", "GTHEQL", "LTHEQL", "EQL", "NEQL", "NOT", "AND", "OR", 
			"SETUPBLC", "RULESBLC", "GMLOOPBLC", "IF", "ELSEIF", "ELSE", "RETURN", 
			"FOR", "FOREACH", "WHILE", "FROM", "SPECIAL", "UNI_DIR", "BI_DIR", "STATIC_DIR", 
			"CHOICE", "ACTION", "PRINT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"COMMA", "NEWLINE", "WS", "EOL"
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


	public BoardLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Board.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u0156\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\7\6~\n\6\f\6\16\6\u0081\13\6\3\6\6\6\u0084\n\6\r\6\16\6"+
		"\u0085\3\6\6\6\u0089\n\6\r\6\16\6\u008a\7\6\u008d\n\6\f\6\16\6\u0090\13"+
		"\6\3\7\6\7\u0093\n\7\r\7\16\7\u0094\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u00a0\n\b\3\t\3\t\6\t\u00a4\n\t\r\t\16\t\u00a5\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\5\27\u00cc\n\27\3\30\3\30\3\30\3\30\3\30\5\30\u00d3\n"+
		"\30\3\31\3\31\3\31\3\31\5\31\u00d9\n\31\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*"+
		"\3+\3+\3+\3+\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\3\63\3\63\2\2\64\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64\3\2\7\4\2C\\c|\5\2\62;C\\c|\3\2\62;\4\2\f\f``\5\2\13\f\17"+
		"\17\"\"\2\u015f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\3g\3\2\2\2\5k\3\2\2\2\7p\3"+
		"\2\2\2\tt\3\2\2\2\13{\3\2\2\2\r\u0092\3\2\2\2\17\u009f\3\2\2\2\21\u00a1"+
		"\3\2\2\2\23\u00a9\3\2\2\2\25\u00ab\3\2\2\2\27\u00ad\3\2\2\2\31\u00af\3"+
		"\2\2\2\33\u00b1\3\2\2\2\35\u00b3\3\2\2\2\37\u00b5\3\2\2\2!\u00b7\3\2\2"+
		"\2#\u00b9\3\2\2\2%\u00bb\3\2\2\2\'\u00be\3\2\2\2)\u00c1\3\2\2\2+\u00c4"+
		"\3\2\2\2-\u00cb\3\2\2\2/\u00d2\3\2\2\2\61\u00d8\3\2\2\2\63\u00da\3\2\2"+
		"\2\65\u00e0\3\2\2\2\67\u00e6\3\2\2\29\u00ed\3\2\2\2;\u00f0\3\2\2\2=\u00f7"+
		"\3\2\2\2?\u00fc\3\2\2\2A\u0103\3\2\2\2C\u0107\3\2\2\2E\u010f\3\2\2\2G"+
		"\u0115\3\2\2\2I\u011a\3\2\2\2K\u0122\3\2\2\2M\u0126\3\2\2\2O\u0129\3\2"+
		"\2\2Q\u0130\3\2\2\2S\u0137\3\2\2\2U\u013e\3\2\2\2W\u0144\3\2\2\2Y\u0146"+
		"\3\2\2\2[\u0148\3\2\2\2]\u014a\3\2\2\2_\u014c\3\2\2\2a\u014e\3\2\2\2c"+
		"\u0150\3\2\2\2e\u0154\3\2\2\2gh\7k\2\2hi\7p\2\2ij\7v\2\2j\4\3\2\2\2kl"+
		"\7d\2\2lm\7q\2\2mn\7q\2\2no\7n\2\2o\6\3\2\2\2pq\7u\2\2qr\7v\2\2rs\7t\2"+
		"\2s\b\3\2\2\2tu\7f\2\2uv\7g\2\2vw\7u\2\2wx\7k\2\2xy\7i\2\2yz\7p\2\2z\n"+
		"\3\2\2\2{\177\t\2\2\2|~\t\3\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\u008e\3\2\2\2\u0081\177\3\2\2\2\u0082\u0084\7"+
		"a\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0089\t\3\2\2\u0088\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008d\3\2\2\2\u008c\u0083\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\f\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093"+
		"\t\4\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\16\3\2\2\2\u0096\u0097\7V\2\2\u0097\u0098\7t\2\2"+
		"\u0098\u0099\7w\2\2\u0099\u00a0\7g\2\2\u009a\u009b\7H\2\2\u009b\u009c"+
		"\7c\2\2\u009c\u009d\7n\2\2\u009d\u009e\7u\2\2\u009e\u00a0\7g\2\2\u009f"+
		"\u0096\3\2\2\2\u009f\u009a\3\2\2\2\u00a0\20\3\2\2\2\u00a1\u00a3\7$\2\2"+
		"\u00a2\u00a4\t\5\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7$\2\2\u00a8"+
		"\22\3\2\2\2\u00a9\u00aa\7\'\2\2\u00aa\24\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac"+
		"\26\3\2\2\2\u00ad\u00ae\7/\2\2\u00ae\30\3\2\2\2\u00af\u00b0\7,\2\2\u00b0"+
		"\32\3\2\2\2\u00b1\u00b2\7\61\2\2\u00b2\34\3\2\2\2\u00b3\u00b4\7`\2\2\u00b4"+
		"\36\3\2\2\2\u00b5\u00b6\7?\2\2\u00b6 \3\2\2\2\u00b7\u00b8\7@\2\2\u00b8"+
		"\"\3\2\2\2\u00b9\u00ba\7>\2\2\u00ba$\3\2\2\2\u00bb\u00bc\7@\2\2\u00bc"+
		"\u00bd\7?\2\2\u00bd&\3\2\2\2\u00be\u00bf\7>\2\2\u00bf\u00c0\7?\2\2\u00c0"+
		"(\3\2\2\2\u00c1\u00c2\7?\2\2\u00c2\u00c3\7?\2\2\u00c3*\3\2\2\2\u00c4\u00c5"+
		"\7#\2\2\u00c5\u00c6\7?\2\2\u00c6,\3\2\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9"+
		"\7q\2\2\u00c9\u00cc\7v\2\2\u00ca\u00cc\7#\2\2\u00cb\u00c7\3\2\2\2\u00cb"+
		"\u00ca\3\2\2\2\u00cc.\3\2\2\2\u00cd\u00ce\7c\2\2\u00ce\u00cf\7p\2\2\u00cf"+
		"\u00d3\7f\2\2\u00d0\u00d1\7(\2\2\u00d1\u00d3\7(\2\2\u00d2\u00cd\3\2\2"+
		"\2\u00d2\u00d0\3\2\2\2\u00d3\60\3\2\2\2\u00d4\u00d5\7q\2\2\u00d5\u00d9"+
		"\7t\2\2\u00d6\u00d7\7~\2\2\u00d7\u00d9\7~\2\2\u00d8\u00d4\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d9\62\3\2\2\2\u00da\u00db\7U\2\2\u00db\u00dc\7G\2\2"+
		"\u00dc\u00dd\7V\2\2\u00dd\u00de\7W\2\2\u00de\u00df\7R\2\2\u00df\64\3\2"+
		"\2\2\u00e0\u00e1\7T\2\2\u00e1\u00e2\7W\2\2\u00e2\u00e3\7N\2\2\u00e3\u00e4"+
		"\7G\2\2\u00e4\u00e5\7U\2\2\u00e5\66\3\2\2\2\u00e6\u00e7\7I\2\2\u00e7\u00e8"+
		"\7O\2\2\u00e8\u00e9\7N\2\2\u00e9\u00ea\7Q\2\2\u00ea\u00eb\7Q\2\2\u00eb"+
		"\u00ec\7R\2\2\u00ec8\3\2\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7h\2\2\u00ef"+
		":\3\2\2\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7u\2\2\u00f3"+
		"\u00f4\7g\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7h\2\2\u00f6<\3\2\2\2\u00f7"+
		"\u00f8\7g\2\2\u00f8\u00f9\7n\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7g\2\2"+
		"\u00fb>\3\2\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7v\2"+
		"\2\u00ff\u0100\7w\2\2\u0100\u0101\7t\2\2\u0101\u0102\7p\2\2\u0102@\3\2"+
		"\2\2\u0103\u0104\7h\2\2\u0104\u0105\7q\2\2\u0105\u0106\7t\2\2\u0106B\3"+
		"\2\2\2\u0107\u0108\7h\2\2\u0108\u0109\7q\2\2\u0109\u010a\7t\2\2\u010a"+
		"\u010b\7g\2\2\u010b\u010c\7c\2\2\u010c\u010d\7e\2\2\u010d\u010e\7j\2\2"+
		"\u010eD\3\2\2\2\u010f\u0110\7y\2\2\u0110\u0111\7j\2\2\u0111\u0112\7k\2"+
		"\2\u0112\u0113\7n\2\2\u0113\u0114\7g\2\2\u0114F\3\2\2\2\u0115\u0116\7"+
		"h\2\2\u0116\u0117\7t\2\2\u0117\u0118\7q\2\2\u0118\u0119\7o\2\2\u0119H"+
		"\3\2\2\2\u011a\u011b\7u\2\2\u011b\u011c\7r\2\2\u011c\u011d\7g\2\2\u011d"+
		"\u011e\7e\2\2\u011e\u011f\7k\2\2\u011f\u0120\7c\2\2\u0120\u0121\7n\2\2"+
		"\u0121J\3\2\2\2\u0122\u0123\7w\2\2\u0123\u0124\7p\2\2\u0124\u0125\7k\2"+
		"\2\u0125L\3\2\2\2\u0126\u0127\7d\2\2\u0127\u0128\7k\2\2\u0128N\3\2\2\2"+
		"\u0129\u012a\7u\2\2\u012a\u012b\7v\2\2\u012b\u012c\7c\2\2\u012c\u012d"+
		"\7v\2\2\u012d\u012e\7k\2\2\u012e\u012f\7e\2\2\u012fP\3\2\2\2\u0130\u0131"+
		"\7e\2\2\u0131\u0132\7j\2\2\u0132\u0133\7q\2\2\u0133\u0134\7k\2\2\u0134"+
		"\u0135\7e\2\2\u0135\u0136\7g\2\2\u0136R\3\2\2\2\u0137\u0138\7c\2\2\u0138"+
		"\u0139\7e\2\2\u0139\u013a\7v\2\2\u013a\u013b\7k\2\2\u013b\u013c\7q\2\2"+
		"\u013c\u013d\7p\2\2\u013dT\3\2\2\2\u013e\u013f\7r\2\2\u013f\u0140\7t\2"+
		"\2\u0140\u0141\7k\2\2\u0141\u0142\7p\2\2\u0142\u0143\7v\2\2\u0143V\3\2"+
		"\2\2\u0144\u0145\7*\2\2\u0145X\3\2\2\2\u0146\u0147\7+\2\2\u0147Z\3\2\2"+
		"\2\u0148\u0149\7}\2\2\u0149\\\3\2\2\2\u014a\u014b\7\177\2\2\u014b^\3\2"+
		"\2\2\u014c\u014d\7.\2\2\u014d`\3\2\2\2\u014e\u014f\7\f\2\2\u014fb\3\2"+
		"\2\2\u0150\u0151\t\6\2\2\u0151\u0152\3\2\2\2\u0152\u0153\b\62\2\2\u0153"+
		"d\3\2\2\2\u0154\u0155\7=\2\2\u0155f\3\2\2\2\r\2\177\u0085\u008a\u008e"+
		"\u0094\u009f\u00a5\u00cb\u00d2\u00d8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
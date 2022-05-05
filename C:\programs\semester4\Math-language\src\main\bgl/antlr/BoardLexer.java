// Generated from /Users/jsaad/Documents/Github/Math-language/src/main/bgl/Board.g4 by ANTLR 4.9.2
package antlr;
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
		SETUPBLC=1, RULESBLC=2, GAMELOOPBLC=3, INTDCL=4, BOOLDCL=5, STRDCL=6, 
		LISTDCL=7, DESIGNDCL=8, SPECIALDCL=9, ACTIONDCL=10, CHOICEDCL=11, PATHDCL=12, 
		GRIDDCL=13, VOIDDCL=14, INT=15, BOOL=16, STR=17, IF=18, ELSEIF=19, ELSE=20, 
		FOR=21, FOREACH=22, WHILE=23, RETURN=24, BREAK=25, MOD=26, PLUS=27, MINUS=28, 
		MULT=29, DIV=30, EXP=31, ASSIGN=32, GTH=33, LTH=34, GTHEQL=35, LTHEQL=36, 
		EQL=37, NEQL=38, NOT=39, AND=40, OR=41, FROM=42, TILE_EVENT=43, IN=44, 
		UNI_DIR=45, BI_DIR=46, STATIC_DIR=47, PRINT=48, LPAREN=49, RPAREN=50, 
		LSBRACE=51, RSBRACE=52, LBRACE=53, RBRACE=54, QUOTE=55, COLON=56, EOL=57, 
		DOT=58, COMMA=59, IDENTIFIER=60, NEWLINE=61, WS=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SETUPBLC", "RULESBLC", "GAMELOOPBLC", "INTDCL", "BOOLDCL", "STRDCL", 
			"LISTDCL", "DESIGNDCL", "SPECIALDCL", "ACTIONDCL", "CHOICEDCL", "PATHDCL", 
			"GRIDDCL", "VOIDDCL", "INT", "BOOL", "STR", "IF", "ELSEIF", "ELSE", "FOR", 
			"FOREACH", "WHILE", "RETURN", "BREAK", "MOD", "PLUS", "MINUS", "MULT", 
			"DIV", "EXP", "ASSIGN", "GTH", "LTH", "GTHEQL", "LTHEQL", "EQL", "NEQL", 
			"NOT", "AND", "OR", "FROM", "TILE_EVENT", "IN", "UNI_DIR", "BI_DIR", 
			"STATIC_DIR", "PRINT", "LPAREN", "RPAREN", "LSBRACE", "RSBRACE", "LBRACE", 
			"RBRACE", "QUOTE", "COLON", "EOL", "DOT", "COMMA", "IDENTIFIER", "NEWLINE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'SETUP'", "'RULES'", "'GAMELOOP'", "'int'", "'bool'", "'str'", 
			"'list'", "'design'", "'special'", "'action'", "'choice'", "'path'", 
			"'grid'", "'void'", null, null, null, "'if'", "'elseif'", "'else'", "'for'", 
			"'foreach'", "'while'", "'return'", "'break'", "'%'", "'+'", "'-'", "'*'", 
			"'/'", "'^'", "'='", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", null, 
			null, null, "'from'", null, "'in'", "'uni'", "'bi'", "'static'", "'print'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'\"'", "':'", "';'", "'.'", 
			"','", null, "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SETUPBLC", "RULESBLC", "GAMELOOPBLC", "INTDCL", "BOOLDCL", "STRDCL", 
			"LISTDCL", "DESIGNDCL", "SPECIALDCL", "ACTIONDCL", "CHOICEDCL", "PATHDCL", 
			"GRIDDCL", "VOIDDCL", "INT", "BOOL", "STR", "IF", "ELSEIF", "ELSE", "FOR", 
			"FOREACH", "WHILE", "RETURN", "BREAK", "MOD", "PLUS", "MINUS", "MULT", 
			"DIV", "EXP", "ASSIGN", "GTH", "LTH", "GTHEQL", "LTHEQL", "EQL", "NEQL", 
			"NOT", "AND", "OR", "FROM", "TILE_EVENT", "IN", "UNI_DIR", "BI_DIR", 
			"STATIC_DIR", "PRINT", "LPAREN", "RPAREN", "LSBRACE", "RSBRACE", "LBRACE", 
			"RBRACE", "QUOTE", "COLON", "EOL", "DOT", "COMMA", "IDENTIFIER", "NEWLINE", 
			"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01b2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\6\20\u00d4\n\20\r\20\16\20\u00d5\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u00e1\n\21\3\22\3\22\3\22\3\22\7\22\u00e7"+
		"\n\22\f\22\16\22\u00ea\13\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\5(\u013e\n(\3)\3)\3)\3"+
		")\3)\5)\u0145\n)\3*\3*\3*\3*\5*\u014b\n*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0166\n,\3-\3-\3-\3"+
		".\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\7=\u0197\n=\f=\16=\u019a\13"+
		"=\3=\6=\u019d\n=\r=\16=\u019e\3=\6=\u01a2\n=\r=\16=\u01a3\7=\u01a6\n="+
		"\f=\16=\u01a9\13=\3>\3>\3>\3>\3?\3?\3?\3?\2\2@\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\3\2\b"+
		"\3\2\62;\4\2$$^^\6\2\f\f\17\17$$^^\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17"+
		"\"\"\2\u01be\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3"+
		"\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2"+
		"\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2"+
		"y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3\177\3\2\2\2\5\u0085\3\2\2\2\7\u008b"+
		"\3\2\2\2\t\u0094\3\2\2\2\13\u0098\3\2\2\2\r\u009d\3\2\2\2\17\u00a1\3\2"+
		"\2\2\21\u00a6\3\2\2\2\23\u00ad\3\2\2\2\25\u00b5\3\2\2\2\27\u00bc\3\2\2"+
		"\2\31\u00c3\3\2\2\2\33\u00c8\3\2\2\2\35\u00cd\3\2\2\2\37\u00d3\3\2\2\2"+
		"!\u00e0\3\2\2\2#\u00e2\3\2\2\2%\u00ed\3\2\2\2\'\u00f0\3\2\2\2)\u00f7\3"+
		"\2\2\2+\u00fc\3\2\2\2-\u0100\3\2\2\2/\u0108\3\2\2\2\61\u010e\3\2\2\2\63"+
		"\u0115\3\2\2\2\65\u011b\3\2\2\2\67\u011d\3\2\2\29\u011f\3\2\2\2;\u0121"+
		"\3\2\2\2=\u0123\3\2\2\2?\u0125\3\2\2\2A\u0127\3\2\2\2C\u0129\3\2\2\2E"+
		"\u012b\3\2\2\2G\u012d\3\2\2\2I\u0130\3\2\2\2K\u0133\3\2\2\2M\u0136\3\2"+
		"\2\2O\u013d\3\2\2\2Q\u0144\3\2\2\2S\u014a\3\2\2\2U\u014c\3\2\2\2W\u0165"+
		"\3\2\2\2Y\u0167\3\2\2\2[\u016a\3\2\2\2]\u016e\3\2\2\2_\u0171\3\2\2\2a"+
		"\u0178\3\2\2\2c\u017e\3\2\2\2e\u0180\3\2\2\2g\u0182\3\2\2\2i\u0184\3\2"+
		"\2\2k\u0186\3\2\2\2m\u0188\3\2\2\2o\u018a\3\2\2\2q\u018c\3\2\2\2s\u018e"+
		"\3\2\2\2u\u0190\3\2\2\2w\u0192\3\2\2\2y\u0194\3\2\2\2{\u01aa\3\2\2\2}"+
		"\u01ae\3\2\2\2\177\u0080\7U\2\2\u0080\u0081\7G\2\2\u0081\u0082\7V\2\2"+
		"\u0082\u0083\7W\2\2\u0083\u0084\7R\2\2\u0084\4\3\2\2\2\u0085\u0086\7T"+
		"\2\2\u0086\u0087\7W\2\2\u0087\u0088\7N\2\2\u0088\u0089\7G\2\2\u0089\u008a"+
		"\7U\2\2\u008a\6\3\2\2\2\u008b\u008c\7I\2\2\u008c\u008d\7C\2\2\u008d\u008e"+
		"\7O\2\2\u008e\u008f\7G\2\2\u008f\u0090\7N\2\2\u0090\u0091\7Q\2\2\u0091"+
		"\u0092\7Q\2\2\u0092\u0093\7R\2\2\u0093\b\3\2\2\2\u0094\u0095\7k\2\2\u0095"+
		"\u0096\7p\2\2\u0096\u0097\7v\2\2\u0097\n\3\2\2\2\u0098\u0099\7d\2\2\u0099"+
		"\u009a\7q\2\2\u009a\u009b\7q\2\2\u009b\u009c\7n\2\2\u009c\f\3\2\2\2\u009d"+
		"\u009e\7u\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7t\2\2\u00a0\16\3\2\2\2\u00a1"+
		"\u00a2\7n\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7u\2\2\u00a4\u00a5\7v\2\2"+
		"\u00a5\20\3\2\2\2\u00a6\u00a7\7f\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7"+
		"u\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7i\2\2\u00ab\u00ac\7p\2\2\u00ac\22"+
		"\3\2\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7r\2\2\u00af\u00b0\7g\2\2\u00b0"+
		"\u00b1\7e\2\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7n\2\2"+
		"\u00b4\24\3\2\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\7"+
		"v\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7p\2\2\u00bb\26"+
		"\3\2\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be\7j\2\2\u00be\u00bf\7q\2\2\u00bf"+
		"\u00c0\7k\2\2\u00c0\u00c1\7e\2\2\u00c1\u00c2\7g\2\2\u00c2\30\3\2\2\2\u00c3"+
		"\u00c4\7r\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7j\2\2"+
		"\u00c7\32\3\2\2\2\u00c8\u00c9\7i\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7"+
		"k\2\2\u00cb\u00cc\7f\2\2\u00cc\34\3\2\2\2\u00cd\u00ce\7x\2\2\u00ce\u00cf"+
		"\7q\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7f\2\2\u00d1\36\3\2\2\2\u00d2\u00d4"+
		"\t\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6 \3\2\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7t\2\2\u00d9"+
		"\u00da\7w\2\2\u00da\u00e1\7g\2\2\u00db\u00dc\7h\2\2\u00dc\u00dd\7c\2\2"+
		"\u00dd\u00de\7n\2\2\u00de\u00df\7u\2\2\u00df\u00e1\7g\2\2\u00e0\u00d7"+
		"\3\2\2\2\u00e0\u00db\3\2\2\2\u00e1\"\3\2\2\2\u00e2\u00e8\7$\2\2\u00e3"+
		"\u00e4\7^\2\2\u00e4\u00e7\t\3\2\2\u00e5\u00e7\n\4\2\2\u00e6\u00e3\3\2"+
		"\2\2\u00e6\u00e5\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7$"+
		"\2\2\u00ec$\3\2\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7h\2\2\u00ef&\3\2\2"+
		"\2\u00f0\u00f1\7g\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7u\2\2\u00f3\u00f4"+
		"\7g\2\2\u00f4\u00f5\7k\2\2\u00f5\u00f6\7h\2\2\u00f6(\3\2\2\2\u00f7\u00f8"+
		"\7g\2\2\u00f8\u00f9\7n\2\2\u00f9\u00fa\7u\2\2\u00fa\u00fb\7g\2\2\u00fb"+
		"*\3\2\2\2\u00fc\u00fd\7h\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7t\2\2\u00ff"+
		",\3\2\2\2\u0100\u0101\7h\2\2\u0101\u0102\7q\2\2\u0102\u0103\7t\2\2\u0103"+
		"\u0104\7g\2\2\u0104\u0105\7c\2\2\u0105\u0106\7e\2\2\u0106\u0107\7j\2\2"+
		"\u0107.\3\2\2\2\u0108\u0109\7y\2\2\u0109\u010a\7j\2\2\u010a\u010b\7k\2"+
		"\2\u010b\u010c\7n\2\2\u010c\u010d\7g\2\2\u010d\60\3\2\2\2\u010e\u010f"+
		"\7t\2\2\u010f\u0110\7g\2\2\u0110\u0111\7v\2\2\u0111\u0112\7w\2\2\u0112"+
		"\u0113\7t\2\2\u0113\u0114\7p\2\2\u0114\62\3\2\2\2\u0115\u0116\7d\2\2\u0116"+
		"\u0117\7t\2\2\u0117\u0118\7g\2\2\u0118\u0119\7c\2\2\u0119\u011a\7m\2\2"+
		"\u011a\64\3\2\2\2\u011b\u011c\7\'\2\2\u011c\66\3\2\2\2\u011d\u011e\7-"+
		"\2\2\u011e8\3\2\2\2\u011f\u0120\7/\2\2\u0120:\3\2\2\2\u0121\u0122\7,\2"+
		"\2\u0122<\3\2\2\2\u0123\u0124\7\61\2\2\u0124>\3\2\2\2\u0125\u0126\7`\2"+
		"\2\u0126@\3\2\2\2\u0127\u0128\7?\2\2\u0128B\3\2\2\2\u0129\u012a\7@\2\2"+
		"\u012aD\3\2\2\2\u012b\u012c\7>\2\2\u012cF\3\2\2\2\u012d\u012e\7@\2\2\u012e"+
		"\u012f\7?\2\2\u012fH\3\2\2\2\u0130\u0131\7>\2\2\u0131\u0132\7?\2\2\u0132"+
		"J\3\2\2\2\u0133\u0134\7?\2\2\u0134\u0135\7?\2\2\u0135L\3\2\2\2\u0136\u0137"+
		"\7#\2\2\u0137\u0138\7?\2\2\u0138N\3\2\2\2\u0139\u013a\7p\2\2\u013a\u013b"+
		"\7q\2\2\u013b\u013e\7v\2\2\u013c\u013e\7#\2\2\u013d\u0139\3\2\2\2\u013d"+
		"\u013c\3\2\2\2\u013eP\3\2\2\2\u013f\u0140\7c\2\2\u0140\u0141\7p\2\2\u0141"+
		"\u0145\7f\2\2\u0142\u0143\7(\2\2\u0143\u0145\7(\2\2\u0144\u013f\3\2\2"+
		"\2\u0144\u0142\3\2\2\2\u0145R\3\2\2\2\u0146\u0147\7q\2\2\u0147\u014b\7"+
		"t\2\2\u0148\u0149\7~\2\2\u0149\u014b\7~\2\2\u014a\u0146\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014bT\3\2\2\2\u014c\u014d\7h\2\2\u014d\u014e\7t\2\2\u014e"+
		"\u014f\7q\2\2\u014f\u0150\7o\2\2\u0150V\3\2\2\2\u0151\u0152\7q\2\2\u0152"+
		"\u0153\7p\2\2\u0153\u0154\7N\2\2\u0154\u0155\7c\2\2\u0155\u0156\7p\2\2"+
		"\u0156\u0166\7f\2\2\u0157\u0158\7q\2\2\u0158\u0159\7p\2\2\u0159\u015a"+
		"\7N\2\2\u015a\u015b\7g\2\2\u015b\u015c\7c\2\2\u015c\u015d\7x\2\2\u015d"+
		"\u0166\7g\2\2\u015e\u015f\7q\2\2\u015f\u0160\7p\2\2\u0160\u0161\7X\2\2"+
		"\u0161\u0162\7k\2\2\u0162\u0163\7u\2\2\u0163\u0164\7k\2\2\u0164\u0166"+
		"\7v\2\2\u0165\u0151\3\2\2\2\u0165\u0157\3\2\2\2\u0165\u015e\3\2\2\2\u0166"+
		"X\3\2\2\2\u0167\u0168\7k\2\2\u0168\u0169\7p\2\2\u0169Z\3\2\2\2\u016a\u016b"+
		"\7w\2\2\u016b\u016c\7p\2\2\u016c\u016d\7k\2\2\u016d\\\3\2\2\2\u016e\u016f"+
		"\7d\2\2\u016f\u0170\7k\2\2\u0170^\3\2\2\2\u0171\u0172\7u\2\2\u0172\u0173"+
		"\7v\2\2\u0173\u0174\7c\2\2\u0174\u0175\7v\2\2\u0175\u0176\7k\2\2\u0176"+
		"\u0177\7e\2\2\u0177`\3\2\2\2\u0178\u0179\7r\2\2\u0179\u017a\7t\2\2\u017a"+
		"\u017b\7k\2\2\u017b\u017c\7p\2\2\u017c\u017d\7v\2\2\u017db\3\2\2\2\u017e"+
		"\u017f\7*\2\2\u017fd\3\2\2\2\u0180\u0181\7+\2\2\u0181f\3\2\2\2\u0182\u0183"+
		"\7]\2\2\u0183h\3\2\2\2\u0184\u0185\7_\2\2\u0185j\3\2\2\2\u0186\u0187\7"+
		"}\2\2\u0187l\3\2\2\2\u0188\u0189\7\177\2\2\u0189n\3\2\2\2\u018a\u018b"+
		"\7$\2\2\u018bp\3\2\2\2\u018c\u018d\7<\2\2\u018dr\3\2\2\2\u018e\u018f\7"+
		"=\2\2\u018ft\3\2\2\2\u0190\u0191\7\60\2\2\u0191v\3\2\2\2\u0192\u0193\7"+
		".\2\2\u0193x\3\2\2\2\u0194\u0198\t\5\2\2\u0195\u0197\t\6\2\2\u0196\u0195"+
		"\3\2\2\2\u0197\u019a\3\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199"+
		"\u01a7\3\2\2\2\u019a\u0198\3\2\2\2\u019b\u019d\7a\2\2\u019c\u019b\3\2"+
		"\2\2\u019d\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f"+
		"\u01a1\3\2\2\2\u01a0\u01a2\t\6\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2"+
		"\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5"+
		"\u019c\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2"+
		"\2\2\u01a8z\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ab\7\f\2\2\u01ab\u01ac"+
		"\3\2\2\2\u01ac\u01ad\b>\2\2\u01ad|\3\2\2\2\u01ae\u01af\t\7\2\2\u01af\u01b0"+
		"\3\2\2\2\u01b0\u01b1\b?\2\2\u01b1~\3\2\2\2\17\2\u00d5\u00e0\u00e6\u00e8"+
		"\u013d\u0144\u014a\u0165\u0198\u019e\u01a3\u01a7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
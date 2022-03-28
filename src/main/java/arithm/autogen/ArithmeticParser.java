// Generated from /Users/jsaad/Documents/Github/Math-language/src/main/java/arithm/Arithmetic.g4 by ANTLR 4.9.2
package arithm.autogen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArithmeticParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FLOAT=1, INT=2, MOD=3, PLUS=4, MINUS=5, MULT=6, DIV=7, LPAREN=8, RPAREN=9, 
		WS=10, EOL=11;
	public static final int
		RULE_prog = 0, RULE_statements = 1, RULE_statement = 2, RULE_modulus = 3, 
		RULE_addOrSub = 4, RULE_multOrDiv = 5, RULE_atom = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "statements", "statement", "modulus", "addOrSub", "multOrDiv", 
			"atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'%'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", null, 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FLOAT", "INT", "MOD", "PLUS", "MINUS", "MULT", "DIV", "LPAREN", 
			"RPAREN", "WS", "EOL"
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
	public String getGrammarFileName() { return "Arithmetic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArithmeticParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			statements();
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOL() { return getToken(ArithmeticParser.EOL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		try {
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				statement();
				setState(17);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				statement();
				setState(20);
				match(EOL);
				setState(21);
				statements();
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

	public static class StatementContext extends ParserRuleContext {
		public ModulusContext modulus() {
			return getRuleContext(ModulusContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			modulus(0);
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

	public static class ModulusContext extends ParserRuleContext {
		public AddOrSubContext addOrSub() {
			return getRuleContext(AddOrSubContext.class,0);
		}
		public ModulusContext modulus() {
			return getRuleContext(ModulusContext.class,0);
		}
		public TerminalNode MOD() { return getToken(ArithmeticParser.MOD, 0); }
		public ModulusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modulus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitModulus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModulusContext modulus() throws RecognitionException {
		return modulus(0);
	}

	private ModulusContext modulus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ModulusContext _localctx = new ModulusContext(_ctx, _parentState);
		ModulusContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_modulus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(28);
			addOrSub(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ModulusContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_modulus);
					setState(30);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(31);
					match(MOD);
					setState(32);
					addOrSub(0);
					}
					} 
				}
				setState(37);
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

	public static class AddOrSubContext extends ParserRuleContext {
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public AddOrSubContext addOrSub() {
			return getRuleContext(AddOrSubContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(ArithmeticParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ArithmeticParser.MINUS, 0); }
		public AddOrSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOrSub; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAddOrSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddOrSubContext addOrSub() throws RecognitionException {
		return addOrSub(0);
	}

	private AddOrSubContext addOrSub(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddOrSubContext _localctx = new AddOrSubContext(_ctx, _parentState);
		AddOrSubContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_addOrSub, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(39);
			multOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(47);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new AddOrSubContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addOrSub);
						setState(41);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(42);
						match(PLUS);
						setState(43);
						multOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new AddOrSubContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addOrSub);
						setState(44);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(45);
						match(MINUS);
						setState(46);
						multOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(51);
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

	public static class MultOrDivContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public MultOrDivContext multOrDiv() {
			return getRuleContext(MultOrDivContext.class,0);
		}
		public TerminalNode MULT() { return getToken(ArithmeticParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(ArithmeticParser.DIV, 0); }
		public MultOrDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOrDiv; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitMultOrDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultOrDivContext multOrDiv() throws RecognitionException {
		return multOrDiv(0);
	}

	private MultOrDivContext multOrDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultOrDivContext _localctx = new MultOrDivContext(_ctx, _parentState);
		MultOrDivContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_multOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(53);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(61);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(55);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(56);
						match(MULT);
						setState(57);
						atom();
						}
						break;
					case 2:
						{
						_localctx = new MultOrDivContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multOrDiv);
						setState(58);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(59);
						match(DIV);
						setState(60);
						atom();
						}
						break;
					}
					} 
				}
				setState(65);
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

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(ArithmeticParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(ArithmeticParser.INT, 0); }
		public TerminalNode LPAREN() { return getToken(ArithmeticParser.LPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ArithmeticParser.RPAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ArithmeticVisitor ) return ((ArithmeticVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atom);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(FLOAT);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(INT);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				match(LPAREN);
				setState(69);
				statement();
				setState(70);
				match(RPAREN);
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
		case 3:
			return modulus_sempred((ModulusContext)_localctx, predIndex);
		case 4:
			return addOrSub_sempred((AddOrSubContext)_localctx, predIndex);
		case 5:
			return multOrDiv_sempred((MultOrDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean modulus_sempred(ModulusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean addOrSub_sempred(AddOrSubContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multOrDiv_sempred(MultOrDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rM\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\32\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5$\n\5\f\5\16\5"+
		"\'\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\62\n\6\f\6\16\6\65\13"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7@\n\7\f\7\16\7C\13\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\bK\n\b\3\b\2\5\b\n\f\t\2\4\6\b\n\f\16\2\2\2M\2\20\3"+
		"\2\2\2\4\31\3\2\2\2\6\33\3\2\2\2\b\35\3\2\2\2\n(\3\2\2\2\f\66\3\2\2\2"+
		"\16J\3\2\2\2\20\21\5\4\3\2\21\3\3\2\2\2\22\23\5\6\4\2\23\24\7\r\2\2\24"+
		"\32\3\2\2\2\25\26\5\6\4\2\26\27\7\r\2\2\27\30\5\4\3\2\30\32\3\2\2\2\31"+
		"\22\3\2\2\2\31\25\3\2\2\2\32\5\3\2\2\2\33\34\5\b\5\2\34\7\3\2\2\2\35\36"+
		"\b\5\1\2\36\37\5\n\6\2\37%\3\2\2\2 !\f\4\2\2!\"\7\5\2\2\"$\5\n\6\2# \3"+
		"\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\t\3\2\2\2\'%\3\2\2\2()\b\6\1\2"+
		")*\5\f\7\2*\63\3\2\2\2+,\f\5\2\2,-\7\6\2\2-\62\5\f\7\2./\f\4\2\2/\60\7"+
		"\7\2\2\60\62\5\f\7\2\61+\3\2\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\13\3\2\2\2\65\63\3\2\2\2\66\67\b\7\1\2\678\5\16\b"+
		"\28A\3\2\2\29:\f\5\2\2:;\7\b\2\2;@\5\16\b\2<=\f\4\2\2=>\7\t\2\2>@\5\16"+
		"\b\2?9\3\2\2\2?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\r\3\2\2\2CA\3"+
		"\2\2\2DK\7\3\2\2EK\7\4\2\2FG\7\n\2\2GH\5\6\4\2HI\7\13\2\2IK\3\2\2\2JD"+
		"\3\2\2\2JE\3\2\2\2JF\3\2\2\2K\17\3\2\2\2\t\31%\61\63?AJ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
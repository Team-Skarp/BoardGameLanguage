// Generated from C:/programs/semester4/Math-language/src/main/java/bogac\Board.g4 by ANTLR 4.9.2
package bogac;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BoardParser extends Parser {
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
	public static final int
		RULE_game = 0, RULE_setup = 1, RULE_rules = 2, RULE_gameloop = 3, RULE_statements = 4, 
		RULE_declerations = 5, RULE_assignment = 6, RULE_expr = 7, RULE_aexpr = 8, 
		RULE_addOrSub = 9, RULE_multDivMod = 10, RULE_pow = 11, RULE_atom = 12, 
		RULE_bexpr = 13, RULE_dcltype = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"game", "setup", "rules", "gameloop", "statements", "declerations", "assignment", 
			"expr", "aexpr", "addOrSub", "multDivMod", "pow", "atom", "bexpr", "dcltype"
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

	@Override
	public String getGrammarFileName() { return "Board.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BoardParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class GameContext extends ParserRuleContext {
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public RulesContext rules() {
			return getRuleContext(RulesContext.class,0);
		}
		public GameloopContext gameloop() {
			return getRuleContext(GameloopContext.class,0);
		}
		public GameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_game; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitGame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameContext game() throws RecognitionException {
		GameContext _localctx = new GameContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_game);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			setup();
			setState(31);
			rules();
			setState(32);
			gameloop();
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

	public static class SetupContext extends ParserRuleContext {
		public TerminalNode SETUPBLC() { return getToken(BoardParser.SETUPBLC, 0); }
		public TerminalNode LBRACE() { return getToken(BoardParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BoardParser.RBRACE, 0); }
		public List<DeclerationsContext> declerations() {
			return getRuleContexts(DeclerationsContext.class);
		}
		public DeclerationsContext declerations(int i) {
			return getRuleContext(DeclerationsContext.class,i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(SETUPBLC);
			setState(35);
			match(LBRACE);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRINGDCL) | (1L << DESIGNDCL))) != 0)) {
				{
				{
				setState(36);
				declerations();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EOF) {
				{
				{
				setState(42);
				statements();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(RBRACE);
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

	public static class RulesContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BoardParser.EOF, 0); }
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rules);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class GameloopContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BoardParser.EOF, 0); }
		public GameloopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gameloop; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitGameloop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameloopContext gameloop() throws RecognitionException {
		GameloopContext _localctx = new GameloopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_gameloop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
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

	public static class StatementsContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BoardParser.EOF, 0); }
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
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

	public static class DeclerationsContext extends ParserRuleContext {
		public DcltypeContext dcltype() {
			return getRuleContext(DcltypeContext.class,0);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(BoardParser.COMMA, 0); }
		public DeclerationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declerations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitDeclerations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclerationsContext declerations() throws RecognitionException {
		DeclerationsContext _localctx = new DeclerationsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declerations);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				dcltype();
				setState(57);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				dcltype();
				setState(60);
				assignment();
				setState(61);
				match(COMMA);
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(62);
					assignment();
					}
					}
					setState(65); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IDENTIFIER );
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
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(IDENTIFIER);
			setState(70);
			match(ASSIGN);
			setState(71);
			expr();
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

	public static class ExprContext extends ParserRuleContext {
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public BexprContext bexpr() {
			return getRuleContext(BexprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				aexpr();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				bexpr();
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

	public static class AexprContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public List<AddOrSubContext> addOrSub() {
			return getRuleContexts(AddOrSubContext.class);
		}
		public AddOrSubContext addOrSub(int i) {
			return getRuleContext(AddOrSubContext.class,i);
		}
		public AexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitAexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexprContext aexpr() throws RecognitionException {
		AexprContext _localctx = new AexprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_aexpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				addOrSub(0);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT || _la==LPAREN );
			setState(82);
			match(EOL);
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

	public static class AddOrSubContext extends ParserRuleContext {
		public MultDivModContext multDivMod() {
			return getRuleContext(MultDivModContext.class,0);
		}
		public AddOrSubContext addOrSub() {
			return getRuleContext(AddOrSubContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(BoardParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BoardParser.MINUS, 0); }
		public AddOrSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOrSub; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitAddOrSub(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_addOrSub, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(85);
			multDivMod(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AddOrSubContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addOrSub);
						setState(87);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(88);
						match(PLUS);
						setState(89);
						multDivMod(0);
						}
						break;
					case 2:
						{
						_localctx = new AddOrSubContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_addOrSub);
						setState(90);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(91);
						match(MINUS);
						setState(92);
						multDivMod(0);
						}
						break;
					}
					} 
				}
				setState(97);
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

	public static class MultDivModContext extends ParserRuleContext {
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public MultDivModContext multDivMod() {
			return getRuleContext(MultDivModContext.class,0);
		}
		public TerminalNode MULT() { return getToken(BoardParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(BoardParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(BoardParser.MOD, 0); }
		public MultDivModContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multDivMod; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultDivModContext multDivMod() throws RecognitionException {
		return multDivMod(0);
	}

	private MultDivModContext multDivMod(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultDivModContext _localctx = new MultDivModContext(_ctx, _parentState);
		MultDivModContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_multDivMod, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(99);
			pow(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(110);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivModContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multDivMod);
						setState(101);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(102);
						match(MULT);
						setState(103);
						pow(0);
						}
						break;
					case 2:
						{
						_localctx = new MultDivModContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multDivMod);
						setState(104);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(105);
						match(DIV);
						setState(106);
						pow(0);
						}
						break;
					case 3:
						{
						_localctx = new MultDivModContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multDivMod);
						setState(107);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(108);
						match(MOD);
						setState(109);
						pow(0);
						}
						break;
					}
					} 
				}
				setState(114);
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

	public static class PowContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public TerminalNode EXP() { return getToken(BoardParser.EXP, 0); }
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowContext pow() throws RecognitionException {
		return pow(0);
	}

	private PowContext pow(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PowContext _localctx = new PowContext(_ctx, _parentState);
		PowContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_pow, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(116);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(123);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PowContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pow);
					setState(118);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(119);
					match(EXP);
					setState(120);
					atom();
					}
					} 
				}
				setState(125);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public TerminalNode INT() { return getToken(BoardParser.INT, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public AexprContext aexpr() {
			return getRuleContext(AexprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(INT);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				match(LPAREN);
				setState(128);
				aexpr();
				setState(129);
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

	public static class BexprContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BoardParser.EOF, 0); }
		public BexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitBexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexprContext bexpr() throws RecognitionException {
		BexprContext _localctx = new BexprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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

	public static class DcltypeContext extends ParserRuleContext {
		public TerminalNode INTDCL() { return getToken(BoardParser.INTDCL, 0); }
		public TerminalNode BOOLDCL() { return getToken(BoardParser.BOOLDCL, 0); }
		public TerminalNode STRINGDCL() { return getToken(BoardParser.STRINGDCL, 0); }
		public TerminalNode DESIGNDCL() { return getToken(BoardParser.DESIGNDCL, 0); }
		public DcltypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcltype; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitDcltype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DcltypeContext dcltype() throws RecognitionException {
		DcltypeContext _localctx = new DcltypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_dcltype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRINGDCL) | (1L << DESIGNDCL))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return addOrSub_sempred((AddOrSubContext)_localctx, predIndex);
		case 10:
			return multDivMod_sempred((MultDivModContext)_localctx, predIndex);
		case 11:
			return pow_sempred((PowContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean addOrSub_sempred(AddOrSubContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multDivMod_sempred(MultDivModContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean pow_sempred(PowContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u008c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7B\n\7\r\7\16"+
		"\7C\5\7F\n\7\3\b\3\b\3\b\3\b\3\t\3\t\5\tN\n\t\3\n\6\nQ\n\n\r\n\16\nR\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13`\n\13\f\13\16"+
		"\13c\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\fq\n\f\f"+
		"\f\16\ft\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u0086\n\16\3\17\3\17\3\20\3\20\3\20\2\5\24\26"+
		"\30\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\3\3\2\3\6\2\u0089\2 \3"+
		"\2\2\2\4$\3\2\2\2\6\64\3\2\2\2\b\66\3\2\2\2\n8\3\2\2\2\fE\3\2\2\2\16G"+
		"\3\2\2\2\20M\3\2\2\2\22P\3\2\2\2\24V\3\2\2\2\26d\3\2\2\2\30u\3\2\2\2\32"+
		"\u0085\3\2\2\2\34\u0087\3\2\2\2\36\u0089\3\2\2\2 !\5\4\3\2!\"\5\6\4\2"+
		"\"#\5\b\5\2#\3\3\2\2\2$%\7\33\2\2%)\7/\2\2&(\5\f\7\2\'&\3\2\2\2(+\3\2"+
		"\2\2)\'\3\2\2\2)*\3\2\2\2*/\3\2\2\2+)\3\2\2\2,.\5\n\6\2-,\3\2\2\2.\61"+
		"\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\60\2"+
		"\2\63\5\3\2\2\2\64\65\7\2\2\3\65\7\3\2\2\2\66\67\7\2\2\3\67\t\3\2\2\2"+
		"89\7\2\2\39\13\3\2\2\2:;\5\36\20\2;<\5\16\b\2<F\3\2\2\2=>\5\36\20\2>?"+
		"\5\16\b\2?A\7\61\2\2@B\5\16\b\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2"+
		"\2DF\3\2\2\2E:\3\2\2\2E=\3\2\2\2F\r\3\2\2\2GH\7\7\2\2HI\7\21\2\2IJ\5\20"+
		"\t\2J\17\3\2\2\2KN\5\22\n\2LN\5\34\17\2MK\3\2\2\2ML\3\2\2\2N\21\3\2\2"+
		"\2OQ\5\24\13\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\64"+
		"\2\2U\23\3\2\2\2VW\b\13\1\2WX\5\26\f\2Xa\3\2\2\2YZ\f\5\2\2Z[\7\f\2\2["+
		"`\5\26\f\2\\]\f\4\2\2]^\7\r\2\2^`\5\26\f\2_Y\3\2\2\2_\\\3\2\2\2`c\3\2"+
		"\2\2a_\3\2\2\2ab\3\2\2\2b\25\3\2\2\2ca\3\2\2\2de\b\f\1\2ef\5\30\r\2fr"+
		"\3\2\2\2gh\f\6\2\2hi\7\16\2\2iq\5\30\r\2jk\f\5\2\2kl\7\17\2\2lq\5\30\r"+
		"\2mn\f\4\2\2no\7\13\2\2oq\5\30\r\2pg\3\2\2\2pj\3\2\2\2pm\3\2\2\2qt\3\2"+
		"\2\2rp\3\2\2\2rs\3\2\2\2s\27\3\2\2\2tr\3\2\2\2uv\b\r\1\2vw\5\32\16\2w"+
		"}\3\2\2\2xy\f\4\2\2yz\7\20\2\2z|\5\32\16\2{x\3\2\2\2|\177\3\2\2\2}{\3"+
		"\2\2\2}~\3\2\2\2~\31\3\2\2\2\177}\3\2\2\2\u0080\u0086\7\b\2\2\u0081\u0082"+
		"\7-\2\2\u0082\u0083\5\22\n\2\u0083\u0084\7.\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0080\3\2\2\2\u0085\u0081\3\2\2\2\u0086\33\3\2\2\2\u0087\u0088\7\2\2"+
		"\3\u0088\35\3\2\2\2\u0089\u008a\t\2\2\2\u008a\37\3\2\2\2\16)/CEMR_apr"+
		"}\u0085";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
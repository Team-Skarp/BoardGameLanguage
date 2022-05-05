// Generated from /Users/Markus/Documents/GitHub/Math-language/src/main/bgl/Board.g4 by ANTLR 4.10.1
package antlr;
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
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, SETUPBLC=2, RULESBLC=3, GAMELOOPBLC=4, INTDCL=5, BOOLDCL=6, STRDCL=7, 
		LISTDCL=8, DESIGNDCL=9, SPECIALDCL=10, ACTIONDCL=11, CHOICEDCL=12, PATHDCL=13, 
		GRIDDCL=14, VOIDDCL=15, INT=16, BOOL=17, STR=18, IF=19, ELSEIF=20, ELSE=21, 
		FOR=22, FOREACH=23, WHILE=24, RETURN=25, BREAK=26, MOD=27, PLUS=28, MINUS=29, 
		MULT=30, DIV=31, EXP=32, ASSIGN=33, GTH=34, LTH=35, GTHEQL=36, LTHEQL=37, 
		EQL=38, NEQL=39, NOT=40, AND=41, OR=42, FROM=43, TILE_EVENT=44, IN=45, 
		UNI_DIR=46, BI_DIR=47, STATIC_DIR=48, PRINT=49, INPUT=50, LPAREN=51, RPAREN=52, 
		LSBRACE=53, RSBRACE=54, LBRACE=55, RBRACE=56, QUOTE=57, COLON=58, EOL=59, 
		DOT=60, COMMA=61, IDENTIFIER=62, NEWLINE=63, WS=64;
	public static final int
		RULE_game = 0, RULE_setup = 1, RULE_rules = 2, RULE_gameloop = 3, RULE_setupBlock = 4, 
		RULE_normalBlock = 5, RULE_rulesBlock = 6, RULE_gameloopBlock = 7, RULE_normalDeclaration = 8, 
		RULE_setupDeclaration = 9, RULE_uniqueDeclaration = 10, RULE_designDeclaration = 11, 
		RULE_designDefinition = 12, RULE_integerDeclaration = 13, RULE_sequentialDeclaration = 14, 
		RULE_booleanDeclaration = 15, RULE_stringDeclaration = 16, RULE_listDeclaration = 17, 
		RULE_listType = 18, RULE_listElement = 19, RULE_pathDeclaration = 20, 
		RULE_gridDeclaration = 21, RULE_specialDeclaration = 22, RULE_choiceDeclaration = 23, 
		RULE_actionDeclaration = 24, RULE_actionDefinition = 25, RULE_actionCall = 26, 
		RULE_returnType = 27, RULE_assignmentStatement = 28, RULE_intAssigment = 29, 
		RULE_booleanAssigment = 30, RULE_stringAssigment = 31, RULE_dotAssignment = 32, 
		RULE_choiceAssignment = 33, RULE_actionAssignment = 34, RULE_designBody = 35, 
		RULE_fieldRow = 36, RULE_primitiveType = 37, RULE_primitiveValue = 38, 
		RULE_formalParameters = 39, RULE_statement = 40, RULE_expression = 41, 
		RULE_arithmeticExpression = 42, RULE_booleanExpression = 43, RULE_additive = 44, 
		RULE_multiplicative = 45, RULE_pow = 46, RULE_unaryMinus = 47, RULE_arithmeticAtom = 48, 
		RULE_logor = 49, RULE_logand = 50, RULE_equality = 51, RULE_relational = 52, 
		RULE_negation = 53, RULE_booleanAtom = 54, RULE_ifStatement = 55, RULE_elseStatement = 56, 
		RULE_elseifStatement = 57, RULE_whileStatement = 58, RULE_foreach = 59, 
		RULE_print = 60, RULE_input = 61;
	private static String[] makeRuleNames() {
		return new String[] {
			"game", "setup", "rules", "gameloop", "setupBlock", "normalBlock", "rulesBlock", 
			"gameloopBlock", "normalDeclaration", "setupDeclaration", "uniqueDeclaration", 
			"designDeclaration", "designDefinition", "integerDeclaration", "sequentialDeclaration", 
			"booleanDeclaration", "stringDeclaration", "listDeclaration", "listType", 
			"listElement", "pathDeclaration", "gridDeclaration", "specialDeclaration", 
			"choiceDeclaration", "actionDeclaration", "actionDefinition", "actionCall", 
			"returnType", "assignmentStatement", "intAssigment", "booleanAssigment", 
			"stringAssigment", "dotAssignment", "choiceAssignment", "actionAssignment", 
			"designBody", "fieldRow", "primitiveType", "primitiveValue", "formalParameters", 
			"statement", "expression", "arithmeticExpression", "booleanExpression", 
			"additive", "multiplicative", "pow", "unaryMinus", "arithmeticAtom", 
			"logor", "logand", "equality", "relational", "negation", "booleanAtom", 
			"ifStatement", "elseStatement", "elseifStatement", "whileStatement", 
			"foreach", "print", "input"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'NOT IMPLEMENTED'", "'SETUP'", "'RULES'", "'GAMELOOP'", "'int'", 
			"'bool'", "'str'", "'list'", "'design'", "'special'", "'action'", "'choice'", 
			"'path'", "'grid'", "'void'", null, null, null, "'if'", "'elseif'", "'else'", 
			"'for'", "'foreach'", "'while'", "'return'", "'break'", "'%'", "'+'", 
			"'-'", "'*'", "'/'", "'^'", "'='", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", null, null, null, "'from'", null, "'in'", "'uni'", "'bi'", "'static'", 
			"'print'", "'input'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'\"'", 
			"':'", "';'", "'.'", "','", null, "'\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "SETUPBLC", "RULESBLC", "GAMELOOPBLC", "INTDCL", "BOOLDCL", 
			"STRDCL", "LISTDCL", "DESIGNDCL", "SPECIALDCL", "ACTIONDCL", "CHOICEDCL", 
			"PATHDCL", "GRIDDCL", "VOIDDCL", "INT", "BOOL", "STR", "IF", "ELSEIF", 
			"ELSE", "FOR", "FOREACH", "WHILE", "RETURN", "BREAK", "MOD", "PLUS", 
			"MINUS", "MULT", "DIV", "EXP", "ASSIGN", "GTH", "LTH", "GTHEQL", "LTHEQL", 
			"EQL", "NEQL", "NOT", "AND", "OR", "FROM", "TILE_EVENT", "IN", "UNI_DIR", 
			"BI_DIR", "STATIC_DIR", "PRINT", "INPUT", "LPAREN", "RPAREN", "LSBRACE", 
			"RSBRACE", "LBRACE", "RBRACE", "QUOTE", "COLON", "EOL", "DOT", "COMMA", 
			"IDENTIFIER", "NEWLINE", "WS"
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
			setState(124);
			setup();
			setState(125);
			rules();
			setState(126);
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
		public SetupBlockContext setupBlock() {
			return getRuleContext(SetupBlockContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(SETUPBLC);
			setState(129);
			setupBlock();
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
		public TerminalNode RULESBLC() { return getToken(BoardParser.RULESBLC, 0); }
		public RulesBlockContext rulesBlock() {
			return getRuleContext(RulesBlockContext.class,0);
		}
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
			setState(131);
			match(RULESBLC);
			setState(132);
			rulesBlock();
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
		public TerminalNode GAMELOOPBLC() { return getToken(BoardParser.GAMELOOPBLC, 0); }
		public GameloopBlockContext gameloopBlock() {
			return getRuleContext(GameloopBlockContext.class,0);
		}
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
			setState(134);
			match(GAMELOOPBLC);
			setState(135);
			gameloopBlock();
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

	public static class SetupBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BoardParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BoardParser.RBRACE, 0); }
		public List<NormalDeclarationContext> normalDeclaration() {
			return getRuleContexts(NormalDeclarationContext.class);
		}
		public NormalDeclarationContext normalDeclaration(int i) {
			return getRuleContext(NormalDeclarationContext.class,i);
		}
		public List<SetupDeclarationContext> setupDeclaration() {
			return getRuleContexts(SetupDeclarationContext.class);
		}
		public SetupDeclarationContext setupDeclaration(int i) {
			return getRuleContext(SetupDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<SetupBlockContext> setupBlock() {
			return getRuleContexts(SetupBlockContext.class);
		}
		public SetupBlockContext setupBlock(int i) {
			return getRuleContext(SetupBlockContext.class,i);
		}
		public SetupBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setupBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitSetupBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupBlockContext setupBlock() throws RecognitionException {
		SetupBlockContext _localctx = new SetupBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_setupBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(LBRACE);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << LISTDCL) | (1L << DESIGNDCL) | (1L << PATHDCL) | (1L << GRIDDCL) | (1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << INPUT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(142);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(138);
					normalDeclaration();
					}
					break;
				case 2:
					{
					setState(139);
					setupDeclaration();
					}
					break;
				case 3:
					{
					setState(140);
					statement();
					}
					break;
				case 4:
					{
					setState(141);
					setupBlock();
					}
					break;
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(147);
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

	public static class NormalBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BoardParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BoardParser.RBRACE, 0); }
		public List<NormalDeclarationContext> normalDeclaration() {
			return getRuleContexts(NormalDeclarationContext.class);
		}
		public NormalDeclarationContext normalDeclaration(int i) {
			return getRuleContext(NormalDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<NormalBlockContext> normalBlock() {
			return getRuleContexts(NormalBlockContext.class);
		}
		public NormalBlockContext normalBlock(int i) {
			return getRuleContext(NormalBlockContext.class,i);
		}
		public NormalBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitNormalBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalBlockContext normalBlock() throws RecognitionException {
		NormalBlockContext _localctx = new NormalBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_normalBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(LBRACE);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << LISTDCL) | (1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << INPUT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(153);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(150);
					normalDeclaration();
					}
					break;
				case 2:
					{
					setState(151);
					statement();
					}
					break;
				case 3:
					{
					setState(152);
					normalBlock();
					}
					break;
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
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

	public static class RulesBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BoardParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BoardParser.RBRACE, 0); }
		public List<UniqueDeclarationContext> uniqueDeclaration() {
			return getRuleContexts(UniqueDeclarationContext.class);
		}
		public UniqueDeclarationContext uniqueDeclaration(int i) {
			return getRuleContext(UniqueDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<RulesBlockContext> rulesBlock() {
			return getRuleContexts(RulesBlockContext.class);
		}
		public RulesBlockContext rulesBlock(int i) {
			return getRuleContext(RulesBlockContext.class,i);
		}
		public RulesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulesBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitRulesBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesBlockContext rulesBlock() throws RecognitionException {
		RulesBlockContext _localctx = new RulesBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rulesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(LBRACE);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SPECIALDCL) | (1L << ACTIONDCL) | (1L << CHOICEDCL) | (1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << INPUT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(161);
					uniqueDeclaration();
					}
					break;
				case 2:
					{
					setState(162);
					statement();
					}
					break;
				case 3:
					{
					setState(163);
					rulesBlock();
					}
					break;
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
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

	public static class GameloopBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BoardParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BoardParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<GameloopBlockContext> gameloopBlock() {
			return getRuleContexts(GameloopBlockContext.class);
		}
		public GameloopBlockContext gameloopBlock(int i) {
			return getRuleContext(GameloopBlockContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public ActionAssignmentContext actionAssignment() {
			return getRuleContext(ActionAssignmentContext.class,0);
		}
		public GameloopBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gameloopBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitGameloopBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameloopBlockContext gameloopBlock() throws RecognitionException {
		GameloopBlockContext _localctx = new GameloopBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_gameloopBlock);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				match(LBRACE);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << INPUT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(172);
						statement();
						}
						break;
					case 2:
						{
						setState(173);
						gameloopBlock();
						}
						break;
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(RBRACE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(IDENTIFIER);
				setState(181);
				match(ASSIGN);
				setState(182);
				actionAssignment();
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

	public static class NormalDeclarationContext extends ParserRuleContext {
		public TerminalNode INTDCL() { return getToken(BoardParser.INTDCL, 0); }
		public IntegerDeclarationContext integerDeclaration() {
			return getRuleContext(IntegerDeclarationContext.class,0);
		}
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public TerminalNode BOOLDCL() { return getToken(BoardParser.BOOLDCL, 0); }
		public BooleanDeclarationContext booleanDeclaration() {
			return getRuleContext(BooleanDeclarationContext.class,0);
		}
		public TerminalNode STRDCL() { return getToken(BoardParser.STRDCL, 0); }
		public StringDeclarationContext stringDeclaration() {
			return getRuleContext(StringDeclarationContext.class,0);
		}
		public TerminalNode LISTDCL() { return getToken(BoardParser.LISTDCL, 0); }
		public ListDeclarationContext listDeclaration() {
			return getRuleContext(ListDeclarationContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public DesignDeclarationContext designDeclaration() {
			return getRuleContext(DesignDeclarationContext.class,0);
		}
		public SequentialDeclarationContext sequentialDeclaration() {
			return getRuleContext(SequentialDeclarationContext.class,0);
		}
		public NormalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitNormalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormalDeclarationContext normalDeclaration() throws RecognitionException {
		NormalDeclarationContext _localctx = new NormalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_normalDeclaration);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(INTDCL);
				setState(186);
				integerDeclaration();
				setState(187);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(BOOLDCL);
				setState(190);
				booleanDeclaration();
				setState(191);
				match(EOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(STRDCL);
				setState(194);
				stringDeclaration();
				setState(195);
				match(EOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(LISTDCL);
				setState(198);
				listDeclaration();
				setState(199);
				match(EOL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				match(IDENTIFIER);
				setState(202);
				designDeclaration();
				setState(203);
				match(EOL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(205);
				sequentialDeclaration();
				setState(206);
				match(EOL);
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

	public static class SetupDeclarationContext extends ParserRuleContext {
		public PathDeclarationContext pathDeclaration() {
			return getRuleContext(PathDeclarationContext.class,0);
		}
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public GridDeclarationContext gridDeclaration() {
			return getRuleContext(GridDeclarationContext.class,0);
		}
		public DesignDefinitionContext designDefinition() {
			return getRuleContext(DesignDefinitionContext.class,0);
		}
		public SetupDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setupDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitSetupDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupDeclarationContext setupDeclaration() throws RecognitionException {
		SetupDeclarationContext _localctx = new SetupDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_setupDeclaration);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PATHDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				pathDeclaration();
				setState(211);
				match(EOL);
				}
				break;
			case GRIDDCL:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				gridDeclaration();
				setState(214);
				match(EOL);
				}
				break;
			case DESIGNDCL:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				designDefinition();
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

	public static class UniqueDeclarationContext extends ParserRuleContext {
		public SpecialDeclarationContext specialDeclaration() {
			return getRuleContext(SpecialDeclarationContext.class,0);
		}
		public ActionDefinitionContext actionDefinition() {
			return getRuleContext(ActionDefinitionContext.class,0);
		}
		public ChoiceDeclarationContext choiceDeclaration() {
			return getRuleContext(ChoiceDeclarationContext.class,0);
		}
		public UniqueDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniqueDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitUniqueDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniqueDeclarationContext uniqueDeclaration() throws RecognitionException {
		UniqueDeclarationContext _localctx = new UniqueDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_uniqueDeclaration);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SPECIALDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				specialDeclaration();
				}
				break;
			case ACTIONDCL:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				actionDefinition();
				}
				break;
			case CHOICEDCL:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				choiceDeclaration();
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

	public static class DesignDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BoardParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BoardParser.COMMA, i);
		}
		public DesignDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitDesignDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignDeclarationContext designDeclaration() throws RecognitionException {
		DesignDeclarationContext _localctx = new DesignDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_designDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(IDENTIFIER);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(225);
					match(COMMA);
					setState(226);
					match(IDENTIFIER);
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class DesignDefinitionContext extends ParserRuleContext {
		public TerminalNode DESIGNDCL() { return getToken(BoardParser.DESIGNDCL, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public DesignBodyContext designBody() {
			return getRuleContext(DesignBodyContext.class,0);
		}
		public TerminalNode FROM() { return getToken(BoardParser.FROM, 0); }
		public DesignDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitDesignDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignDefinitionContext designDefinition() throws RecognitionException {
		DesignDefinitionContext _localctx = new DesignDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_designDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(DESIGNDCL);
			setState(233);
			match(IDENTIFIER);
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(234);
				match(FROM);
				setState(235);
				match(IDENTIFIER);
				}
			}

			setState(238);
			designBody();
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

	public static class IntegerDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public IntegerDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitIntegerDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerDeclarationContext integerDeclaration() throws RecognitionException {
		IntegerDeclarationContext _localctx = new IntegerDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_integerDeclaration);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(IDENTIFIER);
				setState(241);
				match(ASSIGN);
				setState(242);
				arithmeticExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				match(IDENTIFIER);
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

	public static class SequentialDeclarationContext extends ParserRuleContext {
		public TerminalNode INTDCL() { return getToken(BoardParser.INTDCL, 0); }
		public List<IntegerDeclarationContext> integerDeclaration() {
			return getRuleContexts(IntegerDeclarationContext.class);
		}
		public IntegerDeclarationContext integerDeclaration(int i) {
			return getRuleContext(IntegerDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BoardParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BoardParser.COMMA, i);
		}
		public TerminalNode BOOLDCL() { return getToken(BoardParser.BOOLDCL, 0); }
		public List<BooleanDeclarationContext> booleanDeclaration() {
			return getRuleContexts(BooleanDeclarationContext.class);
		}
		public BooleanDeclarationContext booleanDeclaration(int i) {
			return getRuleContext(BooleanDeclarationContext.class,i);
		}
		public TerminalNode STRDCL() { return getToken(BoardParser.STRDCL, 0); }
		public List<StringDeclarationContext> stringDeclaration() {
			return getRuleContexts(StringDeclarationContext.class);
		}
		public StringDeclarationContext stringDeclaration(int i) {
			return getRuleContext(StringDeclarationContext.class,i);
		}
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public List<DesignDeclarationContext> designDeclaration() {
			return getRuleContexts(DesignDeclarationContext.class);
		}
		public DesignDeclarationContext designDeclaration(int i) {
			return getRuleContext(DesignDeclarationContext.class,i);
		}
		public SequentialDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequentialDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitSequentialDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequentialDeclarationContext sequentialDeclaration() throws RecognitionException {
		SequentialDeclarationContext _localctx = new SequentialDeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sequentialDeclaration);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(INTDCL);
				setState(247);
				integerDeclaration();
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(248);
					match(COMMA);
					setState(249);
					integerDeclaration();
					}
					}
					setState(252); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case BOOLDCL:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(BOOLDCL);
				setState(255);
				booleanDeclaration();
				setState(258); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(256);
					match(COMMA);
					setState(257);
					booleanDeclaration();
					}
					}
					setState(260); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case STRDCL:
				enterOuterAlt(_localctx, 3);
				{
				setState(262);
				match(STRDCL);
				setState(263);
				stringDeclaration();
				setState(266); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(264);
					match(COMMA);
					setState(265);
					stringDeclaration();
					}
					}
					setState(268); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(270);
				match(IDENTIFIER);
				setState(271);
				designDeclaration();
				setState(274); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(272);
					match(COMMA);
					setState(273);
					designDeclaration();
					}
					}
					setState(276); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
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

	public static class BooleanDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public BooleanDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitBooleanDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanDeclarationContext booleanDeclaration() throws RecognitionException {
		BooleanDeclarationContext _localctx = new BooleanDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_booleanDeclaration);
		try {
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(IDENTIFIER);
				setState(281);
				match(ASSIGN);
				setState(282);
				booleanExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				match(IDENTIFIER);
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

	public static class StringDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public TerminalNode STR() { return getToken(BoardParser.STR, 0); }
		public StringDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitStringDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringDeclarationContext stringDeclaration() throws RecognitionException {
		StringDeclarationContext _localctx = new StringDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stringDeclaration);
		try {
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(IDENTIFIER);
				setState(287);
				match(ASSIGN);
				setState(288);
				match(STR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(IDENTIFIER);
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

	public static class ListDeclarationContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public TerminalNode LSBRACE() { return getToken(BoardParser.LSBRACE, 0); }
		public TerminalNode RSBRACE() { return getToken(BoardParser.RSBRACE, 0); }
		public List<ListElementContext> listElement() {
			return getRuleContexts(ListElementContext.class);
		}
		public ListElementContext listElement(int i) {
			return getRuleContext(ListElementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BoardParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BoardParser.COMMA, i);
		}
		public ListDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitListDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListDeclarationContext listDeclaration() throws RecognitionException {
		ListDeclarationContext _localctx = new ListDeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listDeclaration);
		int _la;
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(COLON);
				setState(293);
				listType();
				setState(294);
				match(IDENTIFIER);
				setState(295);
				match(ASSIGN);
				setState(296);
				match(LSBRACE);
				setState(308);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << IDENTIFIER))) != 0)) {
						{
						setState(297);
						listElement();
						}
					}

					}
					break;
				case 2:
					{
					setState(300);
					listElement();
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(301);
						match(COMMA);
						setState(302);
						listElement();
						}
						}
						setState(307);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(310);
				match(RSBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(COLON);
				setState(313);
				listType();
				setState(314);
				match(IDENTIFIER);
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

	public static class ListTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode INTDCL() { return getToken(BoardParser.INTDCL, 0); }
		public TerminalNode BOOLDCL() { return getToken(BoardParser.BOOLDCL, 0); }
		public TerminalNode STRDCL() { return getToken(BoardParser.STRDCL, 0); }
		public TerminalNode LISTDCL() { return getToken(BoardParser.LISTDCL, 0); }
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public ListTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTypeContext listType() throws RecognitionException {
		ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_listType);
		try {
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				match(IDENTIFIER);
				}
				break;
			case INTDCL:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(INTDCL);
				}
				break;
			case BOOLDCL:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				match(BOOLDCL);
				}
				break;
			case STRDCL:
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				match(STRDCL);
				}
				break;
			case LISTDCL:
				enterOuterAlt(_localctx, 5);
				{
				setState(322);
				match(LISTDCL);
				setState(323);
				match(COLON);
				setState(324);
				listType();
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

	public static class ListElementContext extends ParserRuleContext {
		public PrimitiveValueContext primitiveValue() {
			return getRuleContext(PrimitiveValueContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public ListElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listElement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitListElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListElementContext listElement() throws RecognitionException {
		ListElementContext _localctx = new ListElementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_listElement);
		try {
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case STR:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				primitiveValue();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				match(IDENTIFIER);
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

	public static class PathDeclarationContext extends ParserRuleContext {
		public TerminalNode PATHDCL() { return getToken(BoardParser.PATHDCL, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode LSBRACE() { return getToken(BoardParser.LSBRACE, 0); }
		public TerminalNode INT() { return getToken(BoardParser.INT, 0); }
		public TerminalNode RSBRACE() { return getToken(BoardParser.RSBRACE, 0); }
		public TerminalNode UNI_DIR() { return getToken(BoardParser.UNI_DIR, 0); }
		public TerminalNode BI_DIR() { return getToken(BoardParser.BI_DIR, 0); }
		public TerminalNode STATIC_DIR() { return getToken(BoardParser.STATIC_DIR, 0); }
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public PathDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitPathDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathDeclarationContext pathDeclaration() throws RecognitionException {
		PathDeclarationContext _localctx = new PathDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pathDeclaration);
		int _la;
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				match(PATHDCL);
				setState(332);
				match(IDENTIFIER);
				setState(333);
				match(LSBRACE);
				setState(334);
				match(INT);
				setState(335);
				match(RSBRACE);
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNI_DIR) | (1L << BI_DIR) | (1L << STATIC_DIR))) != 0)) {
					{
					setState(336);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNI_DIR) | (1L << BI_DIR) | (1L << STATIC_DIR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				match(PATHDCL);
				setState(340);
				match(COLON);
				setState(341);
				match(IDENTIFIER);
				setState(342);
				match(IDENTIFIER);
				setState(343);
				match(LSBRACE);
				setState(344);
				match(INT);
				setState(345);
				match(RSBRACE);
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNI_DIR) | (1L << BI_DIR) | (1L << STATIC_DIR))) != 0)) {
					{
					setState(346);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNI_DIR) | (1L << BI_DIR) | (1L << STATIC_DIR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

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

	public static class GridDeclarationContext extends ParserRuleContext {
		public TerminalNode GRIDDCL() { return getToken(BoardParser.GRIDDCL, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode LSBRACE() { return getToken(BoardParser.LSBRACE, 0); }
		public List<TerminalNode> INT() { return getTokens(BoardParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BoardParser.INT, i);
		}
		public TerminalNode COMMA() { return getToken(BoardParser.COMMA, 0); }
		public TerminalNode RSBRACE() { return getToken(BoardParser.RSBRACE, 0); }
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public GridDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gridDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitGridDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GridDeclarationContext gridDeclaration() throws RecognitionException {
		GridDeclarationContext _localctx = new GridDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_gridDeclaration);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				match(GRIDDCL);
				setState(352);
				match(IDENTIFIER);
				setState(353);
				match(LSBRACE);
				setState(354);
				match(INT);
				setState(355);
				match(COMMA);
				setState(356);
				match(INT);
				setState(357);
				match(RSBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				match(GRIDDCL);
				setState(359);
				match(COLON);
				setState(360);
				match(IDENTIFIER);
				setState(361);
				match(IDENTIFIER);
				setState(362);
				match(LSBRACE);
				setState(363);
				match(INT);
				setState(364);
				match(COMMA);
				setState(365);
				match(INT);
				setState(366);
				match(RSBRACE);
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

	public static class SpecialDeclarationContext extends ParserRuleContext {
		public TerminalNode SPECIALDCL() { return getToken(BoardParser.SPECIALDCL, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode TILE_EVENT() { return getToken(BoardParser.TILE_EVENT, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(BoardParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public RulesBlockContext rulesBlock() {
			return getRuleContext(RulesBlockContext.class,0);
		}
		public SpecialDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitSpecialDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialDeclarationContext specialDeclaration() throws RecognitionException {
		SpecialDeclarationContext _localctx = new SpecialDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_specialDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(SPECIALDCL);
			setState(370);
			match(IDENTIFIER);
			setState(371);
			match(TILE_EVENT);
			setState(372);
			match(LPAREN);
			setState(373);
			match(IDENTIFIER);
			setState(374);
			match(COMMA);
			setState(375);
			match(IDENTIFIER);
			setState(376);
			match(RPAREN);
			setState(377);
			rulesBlock();
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

	public static class ChoiceDeclarationContext extends ParserRuleContext {
		public TerminalNode CHOICEDCL() { return getToken(BoardParser.CHOICEDCL, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public RulesBlockContext rulesBlock() {
			return getRuleContext(RulesBlockContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ChoiceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choiceDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitChoiceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceDeclarationContext choiceDeclaration() throws RecognitionException {
		ChoiceDeclarationContext _localctx = new ChoiceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_choiceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(CHOICEDCL);
			setState(380);
			match(IDENTIFIER);
			setState(381);
			match(LPAREN);
			setState(382);
			match(IDENTIFIER);
			setState(383);
			match(IDENTIFIER);
			setState(384);
			match(RPAREN);
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(385);
				match(COLON);
				setState(386);
				primitiveType();
				}
			}

			setState(389);
			rulesBlock();
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

	public static class ActionDeclarationContext extends ParserRuleContext {
		public TerminalNode ACTIONDCL() { return getToken(BoardParser.ACTIONDCL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public ActionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitActionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionDeclarationContext actionDeclaration() throws RecognitionException {
		ActionDeclarationContext _localctx = new ActionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_actionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(ACTIONDCL);
			setState(392);
			match(IDENTIFIER);
			setState(393);
			match(LPAREN);
			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(394);
				formalParameters();
				}
			}

			setState(397);
			match(RPAREN);
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(398);
				match(COLON);
				setState(399);
				returnType();
				}
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

	public static class ActionDefinitionContext extends ParserRuleContext {
		public TerminalNode ACTIONDCL() { return getToken(BoardParser.ACTIONDCL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public RulesBlockContext rulesBlock() {
			return getRuleContext(RulesBlockContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public ActionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitActionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionDefinitionContext actionDefinition() throws RecognitionException {
		ActionDefinitionContext _localctx = new ActionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_actionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(ACTIONDCL);
			setState(403);
			match(IDENTIFIER);
			setState(404);
			match(LPAREN);
			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(405);
				formalParameters();
				}
			}

			setState(408);
			match(RPAREN);
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(409);
				match(COLON);
				setState(410);
				returnType();
				}
			}

			setState(413);
			rulesBlock();
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

	public static class ActionCallContext extends ParserRuleContext {
		public ActionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitActionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionCallContext actionCall() throws RecognitionException {
		ActionCallContext _localctx = new ActionCallContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_actionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(T__0);
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

	public static class ReturnTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_returnType);
		try {
			setState(419);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTDCL:
			case BOOLDCL:
			case STRDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(417);
				primitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(418);
				match(IDENTIFIER);
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

	public static class AssignmentStatementContext extends ParserRuleContext {
		public IntAssigmentContext intAssigment() {
			return getRuleContext(IntAssigmentContext.class,0);
		}
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public BooleanAssigmentContext booleanAssigment() {
			return getRuleContext(BooleanAssigmentContext.class,0);
		}
		public StringAssigmentContext stringAssigment() {
			return getRuleContext(StringAssigmentContext.class,0);
		}
		public DotAssignmentContext dotAssignment() {
			return getRuleContext(DotAssignmentContext.class,0);
		}
		public ActionAssignmentContext actionAssignment() {
			return getRuleContext(ActionAssignmentContext.class,0);
		}
		public ChoiceAssignmentContext choiceAssignment() {
			return getRuleContext(ChoiceAssignmentContext.class,0);
		}
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_assignmentStatement);
		try {
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(421);
				intAssigment();
				setState(422);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				booleanAssigment();
				setState(425);
				match(EOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(427);
				stringAssigment();
				setState(428);
				match(EOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(430);
				dotAssignment();
				setState(431);
				match(EOL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(433);
				actionAssignment();
				setState(434);
				match(EOL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(436);
				choiceAssignment();
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

	public static class IntAssigmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public IntAssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intAssigment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitIntAssigment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntAssigmentContext intAssigment() throws RecognitionException {
		IntAssigmentContext _localctx = new IntAssigmentContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_intAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(IDENTIFIER);
			setState(440);
			match(ASSIGN);
			setState(441);
			arithmeticExpression();
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

	public static class BooleanAssigmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public BooleanAssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanAssigment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitBooleanAssigment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanAssigmentContext booleanAssigment() throws RecognitionException {
		BooleanAssigmentContext _localctx = new BooleanAssigmentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_booleanAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(IDENTIFIER);
			setState(444);
			match(ASSIGN);
			setState(445);
			booleanExpression();
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

	public static class StringAssigmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public TerminalNode STR() { return getToken(BoardParser.STR, 0); }
		public StringAssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringAssigment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitStringAssigment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringAssigmentContext stringAssigment() throws RecognitionException {
		StringAssigmentContext _localctx = new StringAssigmentContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_stringAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(IDENTIFIER);
			setState(448);
			match(ASSIGN);
			setState(449);
			match(STR);
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

	public static class DotAssignmentContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode DOT() { return getToken(BoardParser.DOT, 0); }
		public TerminalNode ASSIGN() { return getToken(BoardParser.ASSIGN, 0); }
		public List<TerminalNode> STR() { return getTokens(BoardParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(BoardParser.STR, i);
		}
		public List<TerminalNode> INT() { return getTokens(BoardParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BoardParser.INT, i);
		}
		public List<TerminalNode> BOOL() { return getTokens(BoardParser.BOOL); }
		public TerminalNode BOOL(int i) {
			return getToken(BoardParser.BOOL, i);
		}
		public DotAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitDotAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotAssignmentContext dotAssignment() throws RecognitionException {
		DotAssignmentContext _localctx = new DotAssignmentContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_dotAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(IDENTIFIER);
			setState(452);
			match(DOT);
			setState(453);
			match(IDENTIFIER);
			setState(454);
			match(ASSIGN);
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(455);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << IDENTIFIER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ChoiceAssignmentContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BoardParser.LBRACE, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public TerminalNode RBRACE() { return getToken(BoardParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BoardParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BoardParser.COMMA, i);
		}
		public List<TerminalNode> INT() { return getTokens(BoardParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(BoardParser.INT, i);
		}
		public List<TerminalNode> COLON() { return getTokens(BoardParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(BoardParser.COLON, i);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public ChoiceAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_choiceAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitChoiceAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChoiceAssignmentContext choiceAssignment() throws RecognitionException {
		ChoiceAssignmentContext _localctx = new ChoiceAssignmentContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_choiceAssignment);
		int _la;
		try {
			setState(496);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(465);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT) {
					{
					{
					setState(461);
					match(INT);
					setState(462);
					match(COLON);
					}
					}
					setState(467);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(468);
				match(LBRACE);
				setState(469);
				match(IDENTIFIER);
				setState(470);
				match(LPAREN);
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT) {
					{
					{
					setState(471);
					match(INT);
					}
					}
					setState(476);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(477);
				match(RPAREN);
				setState(478);
				match(RBRACE);
				setState(479);
				match(COMMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(480);
				match(IDENTIFIER);
				setState(481);
				match(LPAREN);
				setState(485);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==IDENTIFIER) {
					{
					{
					setState(482);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==IDENTIFIER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(487);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(488);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(489);
				match(IDENTIFIER);
				setState(490);
				match(COLON);
				setState(491);
				match(LBRACE);
				setState(492);
				print();
				setState(493);
				match(RBRACE);
				setState(494);
				match(EOL);
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

	public static class ActionAssignmentContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode DOT() { return getToken(BoardParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BoardParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BoardParser.COMMA, i);
		}
		public ActionAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitActionAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionAssignmentContext actionAssignment() throws RecognitionException {
		ActionAssignmentContext _localctx = new ActionAssignmentContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_actionAssignment);
		int _la;
		try {
			setState(518);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(498);
				match(IDENTIFIER);
				setState(499);
				match(DOT);
				setState(500);
				match(IDENTIFIER);
				setState(501);
				match(LPAREN);
				setState(505);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==IDENTIFIER) {
					{
					{
					setState(502);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==IDENTIFIER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(507);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(508);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
				match(IDENTIFIER);
				setState(510);
				match(LPAREN);
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==IDENTIFIER) {
					{
					{
					setState(511);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==IDENTIFIER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(516);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(517);
				match(RPAREN);
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

	public static class DesignBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BoardParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BoardParser.RBRACE, 0); }
		public List<FieldRowContext> fieldRow() {
			return getRuleContexts(FieldRowContext.class);
		}
		public FieldRowContext fieldRow(int i) {
			return getRuleContext(FieldRowContext.class,i);
		}
		public DesignBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitDesignBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignBodyContext designBody() throws RecognitionException {
		DesignBodyContext _localctx = new DesignBodyContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_designBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(LBRACE);
			setState(522); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(521);
				fieldRow();
				}
				}
				setState(524); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << LISTDCL) | (1L << ACTIONDCL) | (1L << IDENTIFIER))) != 0) );
			setState(526);
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

	public static class FieldRowContext extends ParserRuleContext {
		public TerminalNode INTDCL() { return getToken(BoardParser.INTDCL, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public TerminalNode BOOLDCL() { return getToken(BoardParser.BOOLDCL, 0); }
		public TerminalNode STRDCL() { return getToken(BoardParser.STRDCL, 0); }
		public TerminalNode LISTDCL() { return getToken(BoardParser.LISTDCL, 0); }
		public TerminalNode COLON() { return getToken(BoardParser.COLON, 0); }
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public ActionDeclarationContext actionDeclaration() {
			return getRuleContext(ActionDeclarationContext.class,0);
		}
		public FieldRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldRow; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitFieldRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldRowContext fieldRow() throws RecognitionException {
		FieldRowContext _localctx = new FieldRowContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_fieldRow);
		try {
			setState(549);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				match(INTDCL);
				setState(529);
				match(IDENTIFIER);
				setState(530);
				match(EOL);
				}
				break;
			case BOOLDCL:
				enterOuterAlt(_localctx, 2);
				{
				setState(531);
				match(BOOLDCL);
				setState(532);
				match(IDENTIFIER);
				setState(533);
				match(EOL);
				}
				break;
			case STRDCL:
				enterOuterAlt(_localctx, 3);
				{
				setState(534);
				match(STRDCL);
				setState(535);
				match(IDENTIFIER);
				setState(536);
				match(EOL);
				}
				break;
			case LISTDCL:
				enterOuterAlt(_localctx, 4);
				{
				setState(537);
				match(LISTDCL);
				setState(538);
				match(COLON);
				setState(539);
				listType();
				setState(540);
				match(IDENTIFIER);
				setState(541);
				match(EOL);
				}
				break;
			case ACTIONDCL:
				enterOuterAlt(_localctx, 5);
				{
				setState(543);
				actionDeclaration();
				setState(544);
				match(EOL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(546);
				match(IDENTIFIER);
				setState(547);
				match(IDENTIFIER);
				setState(548);
				match(EOL);
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
		public TerminalNode INTDCL() { return getToken(BoardParser.INTDCL, 0); }
		public TerminalNode BOOLDCL() { return getToken(BoardParser.BOOLDCL, 0); }
		public TerminalNode STRDCL() { return getToken(BoardParser.STRDCL, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL))) != 0)) ) {
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

	public static class PrimitiveValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BoardParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(BoardParser.BOOL, 0); }
		public TerminalNode STR() { return getToken(BoardParser.STR, 0); }
		public PrimitiveValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitPrimitiveValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveValueContext primitiveValue() throws RecognitionException {
		PrimitiveValueContext _localctx = new PrimitiveValueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_primitiveValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR))) != 0)) ) {
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

	public static class FormalParametersContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode COMMA() { return getToken(BoardParser.COMMA, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_formalParameters);
		try {
			setState(569);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(555);
				primitiveType();
				setState(556);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(558);
				primitiveType();
				setState(559);
				match(IDENTIFIER);
				setState(560);
				match(COMMA);
				setState(561);
				formalParameters();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(563);
				match(IDENTIFIER);
				setState(564);
				match(IDENTIFIER);
				setState(565);
				match(COMMA);
				setState(566);
				formalParameters();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(567);
				match(IDENTIFIER);
				setState(568);
				match(IDENTIFIER);
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
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForeachContext foreach() {
			return getRuleContext(ForeachContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_statement);
		try {
			setState(580);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(572);
				whileStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(573);
				foreach();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(574);
				assignmentStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(575);
				print();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(576);
				input();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(577);
				expression();
				setState(578);
				match(EOL);
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

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			booleanExpression();
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

	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_arithmeticExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			additive(0);
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

	public static class BooleanExpressionContext extends ParserRuleContext {
		public LogorContext logor() {
			return getRuleContext(LogorContext.class,0);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			logor(0);
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

	public static class AdditiveContext extends ParserRuleContext {
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public AdditiveContext additive() {
			return getRuleContext(AdditiveContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(BoardParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(BoardParser.MINUS, 0); }
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitAdditive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveContext additive() throws RecognitionException {
		return additive(0);
	}

	private AdditiveContext additive(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveContext _localctx = new AdditiveContext(_ctx, _parentState);
		AdditiveContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_additive, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(589);
			multiplicative(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(599);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(597);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive);
						setState(591);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(592);
						match(PLUS);
						setState(593);
						multiplicative(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive);
						setState(594);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(595);
						match(MINUS);
						setState(596);
						multiplicative(0);
						}
						break;
					}
					} 
				}
				setState(601);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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

	public static class MultiplicativeContext extends ParserRuleContext {
		public PowContext pow() {
			return getRuleContext(PowContext.class,0);
		}
		public MultiplicativeContext multiplicative() {
			return getRuleContext(MultiplicativeContext.class,0);
		}
		public TerminalNode MULT() { return getToken(BoardParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(BoardParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(BoardParser.MOD, 0); }
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitMultiplicative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		return multiplicative(0);
	}

	private MultiplicativeContext multiplicative(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, _parentState);
		MultiplicativeContext _prevctx = _localctx;
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_multiplicative, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(603);
			pow(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(616);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(614);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative);
						setState(605);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(606);
						match(MULT);
						setState(607);
						pow(0);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative);
						setState(608);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(609);
						match(DIV);
						setState(610);
						pow(0);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative);
						setState(611);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(612);
						match(MOD);
						setState(613);
						pow(0);
						}
						break;
					}
					} 
				}
				setState(618);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
		public UnaryMinusContext unaryMinus() {
			return getRuleContext(UnaryMinusContext.class,0);
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
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_pow, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(620);
			unaryMinus();
			}
			_ctx.stop = _input.LT(-1);
			setState(627);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PowContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pow);
					setState(622);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(623);
					match(EXP);
					setState(624);
					unaryMinus();
					}
					} 
				}
				setState(629);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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

	public static class UnaryMinusContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(BoardParser.MINUS, 0); }
		public ArithmeticAtomContext arithmeticAtom() {
			return getRuleContext(ArithmeticAtomContext.class,0);
		}
		public UnaryMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryMinus; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryMinusContext unaryMinus() throws RecognitionException {
		UnaryMinusContext _localctx = new UnaryMinusContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_unaryMinus);
		try {
			setState(633);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(630);
				match(MINUS);
				setState(631);
				arithmeticAtom();
				}
				break;
			case T__0:
			case INT:
			case LPAREN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(632);
				arithmeticAtom();
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

	public static class ArithmeticAtomContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(BoardParser.INT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public ActionCallContext actionCall() {
			return getRuleContext(ActionCallContext.class,0);
		}
		public ArithmeticAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitArithmeticAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticAtomContext arithmeticAtom() throws RecognitionException {
		ArithmeticAtomContext _localctx = new ArithmeticAtomContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_arithmeticAtom);
		try {
			setState(642);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(635);
				match(INT);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(636);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(637);
				match(LPAREN);
				setState(638);
				arithmeticExpression();
				setState(639);
				match(RPAREN);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(641);
				actionCall();
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

	public static class LogorContext extends ParserRuleContext {
		public LogandContext logand() {
			return getRuleContext(LogandContext.class,0);
		}
		public LogorContext logor() {
			return getRuleContext(LogorContext.class,0);
		}
		public TerminalNode OR() { return getToken(BoardParser.OR, 0); }
		public LogorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitLogor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogorContext logor() throws RecognitionException {
		return logor(0);
	}

	private LogorContext logor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogorContext _localctx = new LogorContext(_ctx, _parentState);
		LogorContext _prevctx = _localctx;
		int _startState = 98;
		enterRecursionRule(_localctx, 98, RULE_logor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(645);
			logand(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(652);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logor);
					setState(647);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(648);
					match(OR);
					setState(649);
					logand(0);
					}
					} 
				}
				setState(654);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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

	public static class LogandContext extends ParserRuleContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public LogandContext logand() {
			return getRuleContext(LogandContext.class,0);
		}
		public TerminalNode AND() { return getToken(BoardParser.AND, 0); }
		public LogandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitLogand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogandContext logand() throws RecognitionException {
		return logand(0);
	}

	private LogandContext logand(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogandContext _localctx = new LogandContext(_ctx, _parentState);
		LogandContext _prevctx = _localctx;
		int _startState = 100;
		enterRecursionRule(_localctx, 100, RULE_logand, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(656);
			equality(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(663);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogandContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logand);
					setState(658);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(659);
					match(AND);
					setState(660);
					equality(0);
					}
					} 
				}
				setState(665);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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

	public static class EqualityContext extends ParserRuleContext {
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public TerminalNode EQL() { return getToken(BoardParser.EQL, 0); }
		public TerminalNode NEQL() { return getToken(BoardParser.NEQL, 0); }
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		return equality(0);
	}

	private EqualityContext equality(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityContext _localctx = new EqualityContext(_ctx, _parentState);
		EqualityContext _prevctx = _localctx;
		int _startState = 102;
		enterRecursionRule(_localctx, 102, RULE_equality, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(667);
			relational(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(677);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(675);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(669);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(670);
						match(EQL);
						setState(671);
						relational(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(672);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(673);
						match(NEQL);
						setState(674);
						relational(0);
						}
						break;
					}
					} 
				}
				setState(679);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
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

	public static class RelationalContext extends ParserRuleContext {
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public TerminalNode GTH() { return getToken(BoardParser.GTH, 0); }
		public TerminalNode LTH() { return getToken(BoardParser.LTH, 0); }
		public TerminalNode GTHEQL() { return getToken(BoardParser.GTHEQL, 0); }
		public TerminalNode LTHEQL() { return getToken(BoardParser.LTHEQL, 0); }
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalContext relational() throws RecognitionException {
		return relational(0);
	}

	private RelationalContext relational(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalContext _localctx = new RelationalContext(_ctx, _parentState);
		RelationalContext _prevctx = _localctx;
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_relational, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
			case 1:
				{
				setState(681);
				arithmeticExpression();
				}
				break;
			case 2:
				{
				setState(682);
				negation();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(699);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(697);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(685);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(686);
						match(GTH);
						setState(687);
						arithmeticExpression();
						}
						break;
					case 2:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(688);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(689);
						match(LTH);
						setState(690);
						arithmeticExpression();
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(691);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(692);
						match(GTHEQL);
						setState(693);
						arithmeticExpression();
						}
						break;
					case 4:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(694);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(695);
						match(LTHEQL);
						setState(696);
						arithmeticExpression();
						}
						break;
					}
					} 
				}
				setState(701);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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

	public static class NegationContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(BoardParser.NOT, 0); }
		public BooleanAtomContext booleanAtom() {
			return getRuleContext(BooleanAtomContext.class,0);
		}
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_negation);
		try {
			setState(705);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(702);
				match(NOT);
				setState(703);
				booleanAtom();
				}
				break;
			case T__0:
			case BOOL:
			case LPAREN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(704);
				booleanAtom();
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

	public static class BooleanAtomContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(BoardParser.BOOL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public ActionCallContext actionCall() {
			return getRuleContext(ActionCallContext.class,0);
		}
		public BooleanAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitBooleanAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanAtomContext booleanAtom() throws RecognitionException {
		BooleanAtomContext _localctx = new BooleanAtomContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_booleanAtom);
		try {
			setState(714);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(707);
				match(BOOL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(708);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(709);
				match(LPAREN);
				setState(710);
				booleanExpression();
				setState(711);
				match(RPAREN);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 4);
				{
				setState(713);
				actionCall();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BoardParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public NormalBlockContext normalBlock() {
			return getRuleContext(NormalBlockContext.class,0);
		}
		public List<ElseifStatementContext> elseifStatement() {
			return getRuleContexts(ElseifStatementContext.class);
		}
		public ElseifStatementContext elseifStatement(int i) {
			return getRuleContext(ElseifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
			match(IF);
			setState(717);
			match(LPAREN);
			setState(718);
			booleanExpression();
			setState(719);
			match(RPAREN);
			setState(720);
			normalBlock();
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(721);
				elseifStatement();
				}
				}
				setState(726);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(727);
				elseStatement();
				}
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(BoardParser.ELSE, 0); }
		public NormalBlockContext normalBlock() {
			return getRuleContext(NormalBlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			match(ELSE);
			setState(731);
			normalBlock();
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

	public static class ElseifStatementContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(BoardParser.ELSEIF, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public NormalBlockContext normalBlock() {
			return getRuleContext(NormalBlockContext.class,0);
		}
		public ElseifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitElseifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifStatementContext elseifStatement() throws RecognitionException {
		ElseifStatementContext _localctx = new ElseifStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_elseifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(733);
			match(ELSEIF);
			setState(734);
			match(LPAREN);
			setState(735);
			booleanExpression();
			setState(736);
			match(RPAREN);
			setState(737);
			normalBlock();
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(BoardParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public NormalBlockContext normalBlock() {
			return getRuleContext(NormalBlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			match(WHILE);
			setState(740);
			match(LPAREN);
			setState(741);
			booleanExpression();
			setState(742);
			match(RPAREN);
			setState(743);
			normalBlock();
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

	public static class ForeachContext extends ParserRuleContext {
		public TerminalNode FOREACH() { return getToken(BoardParser.FOREACH, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(BoardParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BoardParser.IDENTIFIER, i);
		}
		public TerminalNode IN() { return getToken(BoardParser.IN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public NormalBlockContext normalBlock() {
			return getRuleContext(NormalBlockContext.class,0);
		}
		public ForeachContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreach; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitForeach(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForeachContext foreach() throws RecognitionException {
		ForeachContext _localctx = new ForeachContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_foreach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(745);
			match(FOREACH);
			setState(746);
			match(LPAREN);
			setState(747);
			match(IDENTIFIER);
			setState(748);
			match(IN);
			setState(749);
			match(IDENTIFIER);
			setState(750);
			match(RPAREN);
			setState(751);
			normalBlock();
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(BoardParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public List<TerminalNode> STR() { return getTokens(BoardParser.STR); }
		public TerminalNode STR(int i) {
			return getToken(BoardParser.STR, i);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BoardParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BoardParser.COMMA, i);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(PRINT);
			setState(754);
			match(LPAREN);
			setState(757);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STR:
				{
				setState(755);
				match(STR);
				}
				break;
			case T__0:
			case INT:
			case BOOL:
			case MINUS:
			case NOT:
			case LPAREN:
			case IDENTIFIER:
				{
				setState(756);
				booleanExpression();
				}
				break;
			case RPAREN:
			case COMMA:
				break;
			default:
				break;
			}
			setState(766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(759);
				match(COMMA);
				setState(762);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STR:
					{
					setState(760);
					match(STR);
					}
					break;
				case T__0:
				case INT:
				case BOOL:
				case MINUS:
				case NOT:
				case LPAREN:
				case IDENTIFIER:
					{
					setState(761);
					booleanExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(768);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(769);
			match(RPAREN);
			setState(770);
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

	public static class InputContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(BoardParser.INPUT, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
			match(INPUT);
			setState(773);
			match(LPAREN);
			setState(774);
			match(IDENTIFIER);
			setState(775);
			match(RPAREN);
			setState(776);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 44:
			return additive_sempred((AdditiveContext)_localctx, predIndex);
		case 45:
			return multiplicative_sempred((MultiplicativeContext)_localctx, predIndex);
		case 46:
			return pow_sempred((PowContext)_localctx, predIndex);
		case 49:
			return logor_sempred((LogorContext)_localctx, predIndex);
		case 50:
			return logand_sempred((LogandContext)_localctx, predIndex);
		case 51:
			return equality_sempred((EqualityContext)_localctx, predIndex);
		case 52:
			return relational_sempred((RelationalContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean additive_sempred(AdditiveContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicative_sempred(MultiplicativeContext _localctx, int predIndex) {
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
	private boolean logor_sempred(LogorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean logand_sempred(LogandContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equality_sempred(EqualityContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relational_sempred(RelationalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001@\u030b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u008f\b\u0004\n\u0004\f\u0004\u0092"+
		"\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u009a\b\u0005\n\u0005\f\u0005\u009d\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u00a5\b\u0006\n\u0006\f\u0006\u00a8\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00af\b\u0007\n\u0007\f\u0007"+
		"\u00b2\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00b8\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00d1"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00da"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u00df\b\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00e4\b\u000b\n\u000b\f\u000b\u00e7\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00ed\b\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00f5\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0004\u000e\u00fb\b\u000e\u000b\u000e\f\u000e\u00fc\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u0103\b\u000e\u000b"+
		"\u000e\f\u000e\u0104\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004"+
		"\u000e\u010b\b\u000e\u000b\u000e\f\u000e\u010c\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0004\u000e\u0113\b\u000e\u000b\u000e\f\u000e"+
		"\u0114\u0003\u000e\u0117\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u011d\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u0123\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u012b\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u0130\b\u0011\n\u0011\f\u0011\u0133\t\u0011"+
		"\u0003\u0011\u0135\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u013d\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u0146\b\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u014a\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0152\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u015c\b\u0014\u0003"+
		"\u0014\u015e\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u0170\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u0184\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u018c\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0191\b\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0197\b\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u019c\b\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u01a4\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u01b6\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0005 \u01c9\b \n \f \u01cc\t \u0001!\u0001"+
		"!\u0005!\u01d0\b!\n!\f!\u01d3\t!\u0001!\u0001!\u0001!\u0001!\u0005!\u01d9"+
		"\b!\n!\f!\u01dc\t!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u01e4"+
		"\b!\n!\f!\u01e7\t!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0003!\u01f1\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u01f8"+
		"\b\"\n\"\f\"\u01fb\t\"\u0001\"\u0001\"\u0001\"\u0001\"\u0005\"\u0201\b"+
		"\"\n\"\f\"\u0204\t\"\u0001\"\u0003\"\u0207\b\"\u0001#\u0001#\u0004#\u020b"+
		"\b#\u000b#\f#\u020c\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u0226\b$\u0001%\u0001%\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u023a\b\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u0245"+
		"\b(\u0001)\u0001)\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001,\u0005,\u0256\b,\n,\f,\u0259\t,\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0005-\u0267\b-\n-\f-\u026a\t-\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0005.\u0272\b.\n.\f.\u0275\t.\u0001/\u0001/\u0001/\u0003/\u027a"+
		"\b/\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00030\u0283\b0\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00051\u028b\b1\n1\f1\u028e\t1\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00052\u0296\b2\n2\f2\u0299\t2\u0001"+
		"3\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00053\u02a4"+
		"\b3\n3\f3\u02a7\t3\u00014\u00014\u00014\u00034\u02ac\b4\u00014\u00014"+
		"\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0001"+
		"4\u00054\u02ba\b4\n4\f4\u02bd\t4\u00015\u00015\u00015\u00035\u02c2\b5"+
		"\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00036\u02cb\b6\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00057\u02d3\b7\n7\f7\u02d6\t7\u0001"+
		"7\u00037\u02d9\b7\u00018\u00018\u00018\u00019\u00019\u00019\u00019\u0001"+
		"9\u00019\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0003"+
		"<\u02f6\b<\u0001<\u0001<\u0001<\u0003<\u02fb\b<\u0005<\u02fd\b<\n<\f<"+
		"\u0300\t<\u0001<\u0001<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0000\u0007XZ\\bdfh>\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\\^`bdfhjlnprtvxz\u0000\u0005\u0001\u0000.0\u0002\u0000\u0010\u0012"+
		">>\u0001\u0000=>\u0001\u0000\u0005\u0007\u0001\u0000\u0010\u0012\u033b"+
		"\u0000|\u0001\u0000\u0000\u0000\u0002\u0080\u0001\u0000\u0000\u0000\u0004"+
		"\u0083\u0001\u0000\u0000\u0000\u0006\u0086\u0001\u0000\u0000\u0000\b\u0089"+
		"\u0001\u0000\u0000\u0000\n\u0095\u0001\u0000\u0000\u0000\f\u00a0\u0001"+
		"\u0000\u0000\u0000\u000e\u00b7\u0001\u0000\u0000\u0000\u0010\u00d0\u0001"+
		"\u0000\u0000\u0000\u0012\u00d9\u0001\u0000\u0000\u0000\u0014\u00de\u0001"+
		"\u0000\u0000\u0000\u0016\u00e0\u0001\u0000\u0000\u0000\u0018\u00e8\u0001"+
		"\u0000\u0000\u0000\u001a\u00f4\u0001\u0000\u0000\u0000\u001c\u0116\u0001"+
		"\u0000\u0000\u0000\u001e\u011c\u0001\u0000\u0000\u0000 \u0122\u0001\u0000"+
		"\u0000\u0000\"\u013c\u0001\u0000\u0000\u0000$\u0145\u0001\u0000\u0000"+
		"\u0000&\u0149\u0001\u0000\u0000\u0000(\u015d\u0001\u0000\u0000\u0000*"+
		"\u016f\u0001\u0000\u0000\u0000,\u0171\u0001\u0000\u0000\u0000.\u017b\u0001"+
		"\u0000\u0000\u00000\u0187\u0001\u0000\u0000\u00002\u0192\u0001\u0000\u0000"+
		"\u00004\u019f\u0001\u0000\u0000\u00006\u01a3\u0001\u0000\u0000\u00008"+
		"\u01b5\u0001\u0000\u0000\u0000:\u01b7\u0001\u0000\u0000\u0000<\u01bb\u0001"+
		"\u0000\u0000\u0000>\u01bf\u0001\u0000\u0000\u0000@\u01c3\u0001\u0000\u0000"+
		"\u0000B\u01f0\u0001\u0000\u0000\u0000D\u0206\u0001\u0000\u0000\u0000F"+
		"\u0208\u0001\u0000\u0000\u0000H\u0225\u0001\u0000\u0000\u0000J\u0227\u0001"+
		"\u0000\u0000\u0000L\u0229\u0001\u0000\u0000\u0000N\u0239\u0001\u0000\u0000"+
		"\u0000P\u0244\u0001\u0000\u0000\u0000R\u0246\u0001\u0000\u0000\u0000T"+
		"\u0248\u0001\u0000\u0000\u0000V\u024a\u0001\u0000\u0000\u0000X\u024c\u0001"+
		"\u0000\u0000\u0000Z\u025a\u0001\u0000\u0000\u0000\\\u026b\u0001\u0000"+
		"\u0000\u0000^\u0279\u0001\u0000\u0000\u0000`\u0282\u0001\u0000\u0000\u0000"+
		"b\u0284\u0001\u0000\u0000\u0000d\u028f\u0001\u0000\u0000\u0000f\u029a"+
		"\u0001\u0000\u0000\u0000h\u02ab\u0001\u0000\u0000\u0000j\u02c1\u0001\u0000"+
		"\u0000\u0000l\u02ca\u0001\u0000\u0000\u0000n\u02cc\u0001\u0000\u0000\u0000"+
		"p\u02da\u0001\u0000\u0000\u0000r\u02dd\u0001\u0000\u0000\u0000t\u02e3"+
		"\u0001\u0000\u0000\u0000v\u02e9\u0001\u0000\u0000\u0000x\u02f1\u0001\u0000"+
		"\u0000\u0000z\u0304\u0001\u0000\u0000\u0000|}\u0003\u0002\u0001\u0000"+
		"}~\u0003\u0004\u0002\u0000~\u007f\u0003\u0006\u0003\u0000\u007f\u0001"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u0002\u0000\u0000\u0081\u0082"+
		"\u0003\b\u0004\u0000\u0082\u0003\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"\u0003\u0000\u0000\u0084\u0085\u0003\f\u0006\u0000\u0085\u0005\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\u0004\u0000\u0000\u0087\u0088\u0003\u000e"+
		"\u0007\u0000\u0088\u0007\u0001\u0000\u0000\u0000\u0089\u0090\u00057\u0000"+
		"\u0000\u008a\u008f\u0003\u0010\b\u0000\u008b\u008f\u0003\u0012\t\u0000"+
		"\u008c\u008f\u0003P(\u0000\u008d\u008f\u0003\b\u0004\u0000\u008e\u008a"+
		"\u0001\u0000\u0000\u0000\u008e\u008b\u0001\u0000\u0000\u0000\u008e\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u0092"+
		"\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0001\u0000\u0000\u0000\u0091\u0093\u0001\u0000\u0000\u0000\u0092\u0090"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u00058\u0000\u0000\u0094\t\u0001"+
		"\u0000\u0000\u0000\u0095\u009b\u00057\u0000\u0000\u0096\u009a\u0003\u0010"+
		"\b\u0000\u0097\u009a\u0003P(\u0000\u0098\u009a\u0003\n\u0005\u0000\u0099"+
		"\u0096\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009e\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u00058\u0000\u0000\u009f\u000b\u0001\u0000\u0000\u0000\u00a0\u00a6"+
		"\u00057\u0000\u0000\u00a1\u00a5\u0003\u0014\n\u0000\u00a2\u00a5\u0003"+
		"P(\u0000\u00a3\u00a5\u0003\f\u0006\u0000\u00a4\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa\u00058\u0000\u0000"+
		"\u00aa\r\u0001\u0000\u0000\u0000\u00ab\u00b0\u00057\u0000\u0000\u00ac"+
		"\u00af\u0003P(\u0000\u00ad\u00af\u0003\u000e\u0007\u0000\u00ae\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b8\u00058\u0000\u0000\u00b4\u00b5\u0005>\u0000"+
		"\u0000\u00b5\u00b6\u0005!\u0000\u0000\u00b6\u00b8\u0003D\"\u0000\u00b7"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b8"+
		"\u000f\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u0005\u0000\u0000\u00ba"+
		"\u00bb\u0003\u001a\r\u0000\u00bb\u00bc\u0005;\u0000\u0000\u00bc\u00d1"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u0006\u0000\u0000\u00be\u00bf"+
		"\u0003\u001e\u000f\u0000\u00bf\u00c0\u0005;\u0000\u0000\u00c0\u00d1\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0005\u0007\u0000\u0000\u00c2\u00c3\u0003"+
		" \u0010\u0000\u00c3\u00c4\u0005;\u0000\u0000\u00c4\u00d1\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0005\b\u0000\u0000\u00c6\u00c7\u0003\"\u0011\u0000"+
		"\u00c7\u00c8\u0005;\u0000\u0000\u00c8\u00d1\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0005>\u0000\u0000\u00ca\u00cb\u0003\u0016\u000b\u0000\u00cb\u00cc"+
		"\u0005;\u0000\u0000\u00cc\u00d1\u0001\u0000\u0000\u0000\u00cd\u00ce\u0003"+
		"\u001c\u000e\u0000\u00ce\u00cf\u0005;\u0000\u0000\u00cf\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d0\u00b9\u0001\u0000\u0000\u0000\u00d0\u00bd\u0001\u0000"+
		"\u0000\u0000\u00d0\u00c1\u0001\u0000\u0000\u0000\u00d0\u00c5\u0001\u0000"+
		"\u0000\u0000\u00d0\u00c9\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000"+
		"\u0000\u0000\u00d1\u0011\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003(\u0014"+
		"\u0000\u00d3\u00d4\u0005;\u0000\u0000\u00d4\u00da\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d6\u0003*\u0015\u0000\u00d6\u00d7\u0005;\u0000\u0000\u00d7\u00da"+
		"\u0001\u0000\u0000\u0000\u00d8\u00da\u0003\u0018\f\u0000\u00d9\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d9\u00d5\u0001\u0000\u0000\u0000\u00d9\u00d8\u0001"+
		"\u0000\u0000\u0000\u00da\u0013\u0001\u0000\u0000\u0000\u00db\u00df\u0003"+
		",\u0016\u0000\u00dc\u00df\u00032\u0019\u0000\u00dd\u00df\u0003.\u0017"+
		"\u0000\u00de\u00db\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000"+
		"\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u0015\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e5\u0005>\u0000\u0000\u00e1\u00e2\u0005=\u0000\u0000\u00e2"+
		"\u00e4\u0005>\u0000\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e6\u0017\u0001\u0000\u0000\u0000\u00e7\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005\t\u0000\u0000\u00e9\u00ec\u0005"+
		">\u0000\u0000\u00ea\u00eb\u0005+\u0000\u0000\u00eb\u00ed\u0005>\u0000"+
		"\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef\u0003F#\u0000\u00ef"+
		"\u0019\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005>\u0000\u0000\u00f1\u00f2"+
		"\u0005!\u0000\u0000\u00f2\u00f5\u0003T*\u0000\u00f3\u00f5\u0005>\u0000"+
		"\u0000\u00f4\u00f0\u0001\u0000\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f5\u001b\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u0005\u0000"+
		"\u0000\u00f7\u00fa\u0003\u001a\r\u0000\u00f8\u00f9\u0005=\u0000\u0000"+
		"\u00f9\u00fb\u0003\u001a\r\u0000\u00fa\u00f8\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fd\u0117\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\u0005\u0006\u0000\u0000\u00ff\u0102\u0003\u001e\u000f\u0000\u0100"+
		"\u0101\u0005=\u0000\u0000\u0101\u0103\u0003\u001e\u000f\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0102"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0117"+
		"\u0001\u0000\u0000\u0000\u0106\u0107\u0005\u0007\u0000\u0000\u0107\u010a"+
		"\u0003 \u0010\u0000\u0108\u0109\u0005=\u0000\u0000\u0109\u010b\u0003 "+
		"\u0010\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000"+
		"\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u0117\u0001\u0000\u0000\u0000\u010e\u010f\u0005>\u0000"+
		"\u0000\u010f\u0112\u0003\u0016\u000b\u0000\u0110\u0111\u0005=\u0000\u0000"+
		"\u0111\u0113\u0003\u0016\u000b\u0000\u0112\u0110\u0001\u0000\u0000\u0000"+
		"\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000"+
		"\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0117\u0001\u0000\u0000\u0000"+
		"\u0116\u00f6\u0001\u0000\u0000\u0000\u0116\u00fe\u0001\u0000\u0000\u0000"+
		"\u0116\u0106\u0001\u0000\u0000\u0000\u0116\u010e\u0001\u0000\u0000\u0000"+
		"\u0117\u001d\u0001\u0000\u0000\u0000\u0118\u0119\u0005>\u0000\u0000\u0119"+
		"\u011a\u0005!\u0000\u0000\u011a\u011d\u0003V+\u0000\u011b\u011d\u0005"+
		">\u0000\u0000\u011c\u0118\u0001\u0000\u0000\u0000\u011c\u011b\u0001\u0000"+
		"\u0000\u0000\u011d\u001f\u0001\u0000\u0000\u0000\u011e\u011f\u0005>\u0000"+
		"\u0000\u011f\u0120\u0005!\u0000\u0000\u0120\u0123\u0005\u0012\u0000\u0000"+
		"\u0121\u0123\u0005>\u0000\u0000\u0122\u011e\u0001\u0000\u0000\u0000\u0122"+
		"\u0121\u0001\u0000\u0000\u0000\u0123!\u0001\u0000\u0000\u0000\u0124\u0125"+
		"\u0005:\u0000\u0000\u0125\u0126\u0003$\u0012\u0000\u0126\u0127\u0005>"+
		"\u0000\u0000\u0127\u0128\u0005!\u0000\u0000\u0128\u0134\u00055\u0000\u0000"+
		"\u0129\u012b\u0003&\u0013\u0000\u012a\u0129\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0001\u0000\u0000\u0000\u012b\u0135\u0001\u0000\u0000\u0000\u012c"+
		"\u0131\u0003&\u0013\u0000\u012d\u012e\u0005=\u0000\u0000\u012e\u0130\u0003"+
		"&\u0013\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u0130\u0133\u0001\u0000"+
		"\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000"+
		"\u0000\u0000\u0132\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000"+
		"\u0000\u0000\u0134\u012a\u0001\u0000\u0000\u0000\u0134\u012c\u0001\u0000"+
		"\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u00056\u0000"+
		"\u0000\u0137\u013d\u0001\u0000\u0000\u0000\u0138\u0139\u0005:\u0000\u0000"+
		"\u0139\u013a\u0003$\u0012\u0000\u013a\u013b\u0005>\u0000\u0000\u013b\u013d"+
		"\u0001\u0000\u0000\u0000\u013c\u0124\u0001\u0000\u0000\u0000\u013c\u0138"+
		"\u0001\u0000\u0000\u0000\u013d#\u0001\u0000\u0000\u0000\u013e\u0146\u0005"+
		">\u0000\u0000\u013f\u0146\u0005\u0005\u0000\u0000\u0140\u0146\u0005\u0006"+
		"\u0000\u0000\u0141\u0146\u0005\u0007\u0000\u0000\u0142\u0143\u0005\b\u0000"+
		"\u0000\u0143\u0144\u0005:\u0000\u0000\u0144\u0146\u0003$\u0012\u0000\u0145"+
		"\u013e\u0001\u0000\u0000\u0000\u0145\u013f\u0001\u0000\u0000\u0000\u0145"+
		"\u0140\u0001\u0000\u0000\u0000\u0145\u0141\u0001\u0000\u0000\u0000\u0145"+
		"\u0142\u0001\u0000\u0000\u0000\u0146%\u0001\u0000\u0000\u0000\u0147\u014a"+
		"\u0003L&\u0000\u0148\u014a\u0005>\u0000\u0000\u0149\u0147\u0001\u0000"+
		"\u0000\u0000\u0149\u0148\u0001\u0000\u0000\u0000\u014a\'\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0005\r\u0000\u0000\u014c\u014d\u0005>\u0000\u0000"+
		"\u014d\u014e\u00055\u0000\u0000\u014e\u014f\u0005\u0010\u0000\u0000\u014f"+
		"\u0151\u00056\u0000\u0000\u0150\u0152\u0007\u0000\u0000\u0000\u0151\u0150"+
		"\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u015e"+
		"\u0001\u0000\u0000\u0000\u0153\u0154\u0005\r\u0000\u0000\u0154\u0155\u0005"+
		":\u0000\u0000\u0155\u0156\u0005>\u0000\u0000\u0156\u0157\u0005>\u0000"+
		"\u0000\u0157\u0158\u00055\u0000\u0000\u0158\u0159\u0005\u0010\u0000\u0000"+
		"\u0159\u015b\u00056\u0000\u0000\u015a\u015c\u0007\u0000\u0000\u0000\u015b"+
		"\u015a\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c"+
		"\u015e\u0001\u0000\u0000\u0000\u015d\u014b\u0001\u0000\u0000\u0000\u015d"+
		"\u0153\u0001\u0000\u0000\u0000\u015e)\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0005\u000e\u0000\u0000\u0160\u0161\u0005>\u0000\u0000\u0161\u0162\u0005"+
		"5\u0000\u0000\u0162\u0163\u0005\u0010\u0000\u0000\u0163\u0164\u0005=\u0000"+
		"\u0000\u0164\u0165\u0005\u0010\u0000\u0000\u0165\u0170\u00056\u0000\u0000"+
		"\u0166\u0167\u0005\u000e\u0000\u0000\u0167\u0168\u0005:\u0000\u0000\u0168"+
		"\u0169\u0005>\u0000\u0000\u0169\u016a\u0005>\u0000\u0000\u016a\u016b\u0005"+
		"5\u0000\u0000\u016b\u016c\u0005\u0010\u0000\u0000\u016c\u016d\u0005=\u0000"+
		"\u0000\u016d\u016e\u0005\u0010\u0000\u0000\u016e\u0170\u00056\u0000\u0000"+
		"\u016f\u015f\u0001\u0000\u0000\u0000\u016f\u0166\u0001\u0000\u0000\u0000"+
		"\u0170+\u0001\u0000\u0000\u0000\u0171\u0172\u0005\n\u0000\u0000\u0172"+
		"\u0173\u0005>\u0000\u0000\u0173\u0174\u0005,\u0000\u0000\u0174\u0175\u0005"+
		"3\u0000\u0000\u0175\u0176\u0005>\u0000\u0000\u0176\u0177\u0005=\u0000"+
		"\u0000\u0177\u0178\u0005>\u0000\u0000\u0178\u0179\u00054\u0000\u0000\u0179"+
		"\u017a\u0003\f\u0006\u0000\u017a-\u0001\u0000\u0000\u0000\u017b\u017c"+
		"\u0005\f\u0000\u0000\u017c\u017d\u0005>\u0000\u0000\u017d\u017e\u0005"+
		"3\u0000\u0000\u017e\u017f\u0005>\u0000\u0000\u017f\u0180\u0005>\u0000"+
		"\u0000\u0180\u0183\u00054\u0000\u0000\u0181\u0182\u0005:\u0000\u0000\u0182"+
		"\u0184\u0003J%\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001"+
		"\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0186\u0003"+
		"\f\u0006\u0000\u0186/\u0001\u0000\u0000\u0000\u0187\u0188\u0005\u000b"+
		"\u0000\u0000\u0188\u0189\u0005>\u0000\u0000\u0189\u018b\u00053\u0000\u0000"+
		"\u018a\u018c\u0003N\'\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018b"+
		"\u018c\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d"+
		"\u0190\u00054\u0000\u0000\u018e\u018f\u0005:\u0000\u0000\u018f\u0191\u0003"+
		"6\u001b\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000"+
		"\u0000\u0000\u01911\u0001\u0000\u0000\u0000\u0192\u0193\u0005\u000b\u0000"+
		"\u0000\u0193\u0194\u0005>\u0000\u0000\u0194\u0196\u00053\u0000\u0000\u0195"+
		"\u0197\u0003N\'\u0000\u0196\u0195\u0001\u0000\u0000\u0000\u0196\u0197"+
		"\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198\u019b"+
		"\u00054\u0000\u0000\u0199\u019a\u0005:\u0000\u0000\u019a\u019c\u00036"+
		"\u001b\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000"+
		"\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019e\u0003\f\u0006"+
		"\u0000\u019e3\u0001\u0000\u0000\u0000\u019f\u01a0\u0005\u0001\u0000\u0000"+
		"\u01a05\u0001\u0000\u0000\u0000\u01a1\u01a4\u0003J%\u0000\u01a2\u01a4"+
		"\u0005>\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a2\u0001"+
		"\u0000\u0000\u0000\u01a47\u0001\u0000\u0000\u0000\u01a5\u01a6\u0003:\u001d"+
		"\u0000\u01a6\u01a7\u0005;\u0000\u0000\u01a7\u01b6\u0001\u0000\u0000\u0000"+
		"\u01a8\u01a9\u0003<\u001e\u0000\u01a9\u01aa\u0005;\u0000\u0000\u01aa\u01b6"+
		"\u0001\u0000\u0000\u0000\u01ab\u01ac\u0003>\u001f\u0000\u01ac\u01ad\u0005"+
		";\u0000\u0000\u01ad\u01b6\u0001\u0000\u0000\u0000\u01ae\u01af\u0003@ "+
		"\u0000\u01af\u01b0\u0005;\u0000\u0000\u01b0\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b1\u01b2\u0003D\"\u0000\u01b2\u01b3\u0005;\u0000\u0000\u01b3\u01b6"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b6\u0003B!\u0000\u01b5\u01a5\u0001\u0000"+
		"\u0000\u0000\u01b5\u01a8\u0001\u0000\u0000\u0000\u01b5\u01ab\u0001\u0000"+
		"\u0000\u0000\u01b5\u01ae\u0001\u0000\u0000\u0000\u01b5\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b4\u0001\u0000\u0000\u0000\u01b69\u0001\u0000\u0000"+
		"\u0000\u01b7\u01b8\u0005>\u0000\u0000\u01b8\u01b9\u0005!\u0000\u0000\u01b9"+
		"\u01ba\u0003T*\u0000\u01ba;\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005"+
		">\u0000\u0000\u01bc\u01bd\u0005!\u0000\u0000\u01bd\u01be\u0003V+\u0000"+
		"\u01be=\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005>\u0000\u0000\u01c0\u01c1"+
		"\u0005!\u0000\u0000\u01c1\u01c2\u0005\u0012\u0000\u0000\u01c2?\u0001\u0000"+
		"\u0000\u0000\u01c3\u01c4\u0005>\u0000\u0000\u01c4\u01c5\u0005<\u0000\u0000"+
		"\u01c5\u01c6\u0005>\u0000\u0000\u01c6\u01ca\u0005!\u0000\u0000\u01c7\u01c9"+
		"\u0007\u0001\u0000\u0000\u01c8\u01c7\u0001\u0000\u0000\u0000\u01c9\u01cc"+
		"\u0001\u0000\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca\u01cb"+
		"\u0001\u0000\u0000\u0000\u01cbA\u0001\u0000\u0000\u0000\u01cc\u01ca\u0001"+
		"\u0000\u0000\u0000\u01cd\u01ce\u0005\u0010\u0000\u0000\u01ce\u01d0\u0005"+
		":\u0000\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d3\u0001\u0000"+
		"\u0000\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d2\u01d4\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d5\u00057\u0000\u0000\u01d5\u01d6\u0005>\u0000\u0000"+
		"\u01d6\u01da\u00053\u0000\u0000\u01d7\u01d9\u0005\u0010\u0000\u0000\u01d8"+
		"\u01d7\u0001\u0000\u0000\u0000\u01d9\u01dc\u0001\u0000\u0000\u0000\u01da"+
		"\u01d8\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db"+
		"\u01dd\u0001\u0000\u0000\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd"+
		"\u01de\u00054\u0000\u0000\u01de\u01df\u00058\u0000\u0000\u01df\u01f1\u0005"+
		"=\u0000\u0000\u01e0\u01e1\u0005>\u0000\u0000\u01e1\u01e5\u00053\u0000"+
		"\u0000\u01e2\u01e4\u0007\u0002\u0000\u0000\u01e3\u01e2\u0001\u0000\u0000"+
		"\u0000\u01e4\u01e7\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e8\u0001\u0000\u0000"+
		"\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e8\u01f1\u00054\u0000\u0000"+
		"\u01e9\u01ea\u0005>\u0000\u0000\u01ea\u01eb\u0005:\u0000\u0000\u01eb\u01ec"+
		"\u00057\u0000\u0000\u01ec\u01ed\u0003x<\u0000\u01ed\u01ee\u00058\u0000"+
		"\u0000\u01ee\u01ef\u0005;\u0000\u0000\u01ef\u01f1\u0001\u0000\u0000\u0000"+
		"\u01f0\u01d1\u0001\u0000\u0000\u0000\u01f0\u01e0\u0001\u0000\u0000\u0000"+
		"\u01f0\u01e9\u0001\u0000\u0000\u0000\u01f1C\u0001\u0000\u0000\u0000\u01f2"+
		"\u01f3\u0005>\u0000\u0000\u01f3\u01f4\u0005<\u0000\u0000\u01f4\u01f5\u0005"+
		">\u0000\u0000\u01f5\u01f9\u00053\u0000\u0000\u01f6\u01f8\u0007\u0002\u0000"+
		"\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000\u01f8\u01fb\u0001\u0000\u0000"+
		"\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01f9\u01fa\u0001\u0000\u0000"+
		"\u0000\u01fa\u01fc\u0001\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000"+
		"\u0000\u01fc\u0207\u00054\u0000\u0000\u01fd\u01fe\u0005>\u0000\u0000\u01fe"+
		"\u0202\u00053\u0000\u0000\u01ff\u0201\u0007\u0002\u0000\u0000\u0200\u01ff"+
		"\u0001\u0000\u0000\u0000\u0201\u0204\u0001\u0000\u0000\u0000\u0202\u0200"+
		"\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203\u0205"+
		"\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000\u0000\u0205\u0207"+
		"\u00054\u0000\u0000\u0206\u01f2\u0001\u0000\u0000\u0000\u0206\u01fd\u0001"+
		"\u0000\u0000\u0000\u0207E\u0001\u0000\u0000\u0000\u0208\u020a\u00057\u0000"+
		"\u0000\u0209\u020b\u0003H$\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020b"+
		"\u020c\u0001\u0000\u0000\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020c"+
		"\u020d\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e"+
		"\u020f\u00058\u0000\u0000\u020fG\u0001\u0000\u0000\u0000\u0210\u0211\u0005"+
		"\u0005\u0000\u0000\u0211\u0212\u0005>\u0000\u0000\u0212\u0226\u0005;\u0000"+
		"\u0000\u0213\u0214\u0005\u0006\u0000\u0000\u0214\u0215\u0005>\u0000\u0000"+
		"\u0215\u0226\u0005;\u0000\u0000\u0216\u0217\u0005\u0007\u0000\u0000\u0217"+
		"\u0218\u0005>\u0000\u0000\u0218\u0226\u0005;\u0000\u0000\u0219\u021a\u0005"+
		"\b\u0000\u0000\u021a\u021b\u0005:\u0000\u0000\u021b\u021c\u0003$\u0012"+
		"\u0000\u021c\u021d\u0005>\u0000\u0000\u021d\u021e\u0005;\u0000\u0000\u021e"+
		"\u0226\u0001\u0000\u0000\u0000\u021f\u0220\u00030\u0018\u0000\u0220\u0221"+
		"\u0005;\u0000\u0000\u0221\u0226\u0001\u0000\u0000\u0000\u0222\u0223\u0005"+
		">\u0000\u0000\u0223\u0224\u0005>\u0000\u0000\u0224\u0226\u0005;\u0000"+
		"\u0000\u0225\u0210\u0001\u0000\u0000\u0000\u0225\u0213\u0001\u0000\u0000"+
		"\u0000\u0225\u0216\u0001\u0000\u0000\u0000\u0225\u0219\u0001\u0000\u0000"+
		"\u0000\u0225\u021f\u0001\u0000\u0000\u0000\u0225\u0222\u0001\u0000\u0000"+
		"\u0000\u0226I\u0001\u0000\u0000\u0000\u0227\u0228\u0007\u0003\u0000\u0000"+
		"\u0228K\u0001\u0000\u0000\u0000\u0229\u022a\u0007\u0004\u0000\u0000\u022a"+
		"M\u0001\u0000\u0000\u0000\u022b\u022c\u0003J%\u0000\u022c\u022d\u0005"+
		">\u0000\u0000\u022d\u023a\u0001\u0000\u0000\u0000\u022e\u022f\u0003J%"+
		"\u0000\u022f\u0230\u0005>\u0000\u0000\u0230\u0231\u0005=\u0000\u0000\u0231"+
		"\u0232\u0003N\'\u0000\u0232\u023a\u0001\u0000\u0000\u0000\u0233\u0234"+
		"\u0005>\u0000\u0000\u0234\u0235\u0005>\u0000\u0000\u0235\u0236\u0005="+
		"\u0000\u0000\u0236\u023a\u0003N\'\u0000\u0237\u0238\u0005>\u0000\u0000"+
		"\u0238\u023a\u0005>\u0000\u0000\u0239\u022b\u0001\u0000\u0000\u0000\u0239"+
		"\u022e\u0001\u0000\u0000\u0000\u0239\u0233\u0001\u0000\u0000\u0000\u0239"+
		"\u0237\u0001\u0000\u0000\u0000\u023aO\u0001\u0000\u0000\u0000\u023b\u0245"+
		"\u0003n7\u0000\u023c\u0245\u0003t:\u0000\u023d\u0245\u0003v;\u0000\u023e"+
		"\u0245\u00038\u001c\u0000\u023f\u0245\u0003x<\u0000\u0240\u0245\u0003"+
		"z=\u0000\u0241\u0242\u0003R)\u0000\u0242\u0243\u0005;\u0000\u0000\u0243"+
		"\u0245\u0001\u0000\u0000\u0000\u0244\u023b\u0001\u0000\u0000\u0000\u0244"+
		"\u023c\u0001\u0000\u0000\u0000\u0244\u023d\u0001\u0000\u0000\u0000\u0244"+
		"\u023e\u0001\u0000\u0000\u0000\u0244\u023f\u0001\u0000\u0000\u0000\u0244"+
		"\u0240\u0001\u0000\u0000\u0000\u0244\u0241\u0001\u0000\u0000\u0000\u0245"+
		"Q\u0001\u0000\u0000\u0000\u0246\u0247\u0003V+\u0000\u0247S\u0001\u0000"+
		"\u0000\u0000\u0248\u0249\u0003X,\u0000\u0249U\u0001\u0000\u0000\u0000"+
		"\u024a\u024b\u0003b1\u0000\u024bW\u0001\u0000\u0000\u0000\u024c\u024d"+
		"\u0006,\uffff\uffff\u0000\u024d\u024e\u0003Z-\u0000\u024e\u0257\u0001"+
		"\u0000\u0000\u0000\u024f\u0250\n\u0003\u0000\u0000\u0250\u0251\u0005\u001c"+
		"\u0000\u0000\u0251\u0256\u0003Z-\u0000\u0252\u0253\n\u0002\u0000\u0000"+
		"\u0253\u0254\u0005\u001d\u0000\u0000\u0254\u0256\u0003Z-\u0000\u0255\u024f"+
		"\u0001\u0000\u0000\u0000\u0255\u0252\u0001\u0000\u0000\u0000\u0256\u0259"+
		"\u0001\u0000\u0000\u0000\u0257\u0255\u0001\u0000\u0000\u0000\u0257\u0258"+
		"\u0001\u0000\u0000\u0000\u0258Y\u0001\u0000\u0000\u0000\u0259\u0257\u0001"+
		"\u0000\u0000\u0000\u025a\u025b\u0006-\uffff\uffff\u0000\u025b\u025c\u0003"+
		"\\.\u0000\u025c\u0268\u0001\u0000\u0000\u0000\u025d\u025e\n\u0004\u0000"+
		"\u0000\u025e\u025f\u0005\u001e\u0000\u0000\u025f\u0267\u0003\\.\u0000"+
		"\u0260\u0261\n\u0003\u0000\u0000\u0261\u0262\u0005\u001f\u0000\u0000\u0262"+
		"\u0267\u0003\\.\u0000\u0263\u0264\n\u0002\u0000\u0000\u0264\u0265\u0005"+
		"\u001b\u0000\u0000\u0265\u0267\u0003\\.\u0000\u0266\u025d\u0001\u0000"+
		"\u0000\u0000\u0266\u0260\u0001\u0000\u0000\u0000\u0266\u0263\u0001\u0000"+
		"\u0000\u0000\u0267\u026a\u0001\u0000\u0000\u0000\u0268\u0266\u0001\u0000"+
		"\u0000\u0000\u0268\u0269\u0001\u0000\u0000\u0000\u0269[\u0001\u0000\u0000"+
		"\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026b\u026c\u0006.\uffff\uffff"+
		"\u0000\u026c\u026d\u0003^/\u0000\u026d\u0273\u0001\u0000\u0000\u0000\u026e"+
		"\u026f\n\u0002\u0000\u0000\u026f\u0270\u0005 \u0000\u0000\u0270\u0272"+
		"\u0003^/\u0000\u0271\u026e\u0001\u0000\u0000\u0000\u0272\u0275\u0001\u0000"+
		"\u0000\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0273\u0274\u0001\u0000"+
		"\u0000\u0000\u0274]\u0001\u0000\u0000\u0000\u0275\u0273\u0001\u0000\u0000"+
		"\u0000\u0276\u0277\u0005\u001d\u0000\u0000\u0277\u027a\u0003`0\u0000\u0278"+
		"\u027a\u0003`0\u0000\u0279\u0276\u0001\u0000\u0000\u0000\u0279\u0278\u0001"+
		"\u0000\u0000\u0000\u027a_\u0001\u0000\u0000\u0000\u027b\u0283\u0005\u0010"+
		"\u0000\u0000\u027c\u0283\u0005>\u0000\u0000\u027d\u027e\u00053\u0000\u0000"+
		"\u027e\u027f\u0003T*\u0000\u027f\u0280\u00054\u0000\u0000\u0280\u0283"+
		"\u0001\u0000\u0000\u0000\u0281\u0283\u00034\u001a\u0000\u0282\u027b\u0001"+
		"\u0000\u0000\u0000\u0282\u027c\u0001\u0000\u0000\u0000\u0282\u027d\u0001"+
		"\u0000\u0000\u0000\u0282\u0281\u0001\u0000\u0000\u0000\u0283a\u0001\u0000"+
		"\u0000\u0000\u0284\u0285\u00061\uffff\uffff\u0000\u0285\u0286\u0003d2"+
		"\u0000\u0286\u028c\u0001\u0000\u0000\u0000\u0287\u0288\n\u0002\u0000\u0000"+
		"\u0288\u0289\u0005*\u0000\u0000\u0289\u028b\u0003d2\u0000\u028a\u0287"+
		"\u0001\u0000\u0000\u0000\u028b\u028e\u0001\u0000\u0000\u0000\u028c\u028a"+
		"\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000\u0000\u0000\u028dc\u0001"+
		"\u0000\u0000\u0000\u028e\u028c\u0001\u0000\u0000\u0000\u028f\u0290\u0006"+
		"2\uffff\uffff\u0000\u0290\u0291\u0003f3\u0000\u0291\u0297\u0001\u0000"+
		"\u0000\u0000\u0292\u0293\n\u0002\u0000\u0000\u0293\u0294\u0005)\u0000"+
		"\u0000\u0294\u0296\u0003f3\u0000\u0295\u0292\u0001\u0000\u0000\u0000\u0296"+
		"\u0299\u0001\u0000\u0000\u0000\u0297\u0295\u0001\u0000\u0000\u0000\u0297"+
		"\u0298\u0001\u0000\u0000\u0000\u0298e\u0001\u0000\u0000\u0000\u0299\u0297"+
		"\u0001\u0000\u0000\u0000\u029a\u029b\u00063\uffff\uffff\u0000\u029b\u029c"+
		"\u0003h4\u0000\u029c\u02a5\u0001\u0000\u0000\u0000\u029d\u029e\n\u0003"+
		"\u0000\u0000\u029e\u029f\u0005&\u0000\u0000\u029f\u02a4\u0003h4\u0000"+
		"\u02a0\u02a1\n\u0002\u0000\u0000\u02a1\u02a2\u0005\'\u0000\u0000\u02a2"+
		"\u02a4\u0003h4\u0000\u02a3\u029d\u0001\u0000\u0000\u0000\u02a3\u02a0\u0001"+
		"\u0000\u0000\u0000\u02a4\u02a7\u0001\u0000\u0000\u0000\u02a5\u02a3\u0001"+
		"\u0000\u0000\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000\u02a6g\u0001\u0000"+
		"\u0000\u0000\u02a7\u02a5\u0001\u0000\u0000\u0000\u02a8\u02a9\u00064\uffff"+
		"\uffff\u0000\u02a9\u02ac\u0003T*\u0000\u02aa\u02ac\u0003j5\u0000\u02ab"+
		"\u02a8\u0001\u0000\u0000\u0000\u02ab\u02aa\u0001\u0000\u0000\u0000\u02ac"+
		"\u02bb\u0001\u0000\u0000\u0000\u02ad\u02ae\n\u0006\u0000\u0000\u02ae\u02af"+
		"\u0005\"\u0000\u0000\u02af\u02ba\u0003T*\u0000\u02b0\u02b1\n\u0005\u0000"+
		"\u0000\u02b1\u02b2\u0005#\u0000\u0000\u02b2\u02ba\u0003T*\u0000\u02b3"+
		"\u02b4\n\u0004\u0000\u0000\u02b4\u02b5\u0005$\u0000\u0000\u02b5\u02ba"+
		"\u0003T*\u0000\u02b6\u02b7\n\u0003\u0000\u0000\u02b7\u02b8\u0005%\u0000"+
		"\u0000\u02b8\u02ba\u0003T*\u0000\u02b9\u02ad\u0001\u0000\u0000\u0000\u02b9"+
		"\u02b0\u0001\u0000\u0000\u0000\u02b9\u02b3\u0001\u0000\u0000\u0000\u02b9"+
		"\u02b6\u0001\u0000\u0000\u0000\u02ba\u02bd\u0001\u0000\u0000\u0000\u02bb"+
		"\u02b9\u0001\u0000\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc"+
		"i\u0001\u0000\u0000\u0000\u02bd\u02bb\u0001\u0000\u0000\u0000\u02be\u02bf"+
		"\u0005(\u0000\u0000\u02bf\u02c2\u0003l6\u0000\u02c0\u02c2\u0003l6\u0000"+
		"\u02c1\u02be\u0001\u0000\u0000\u0000\u02c1\u02c0\u0001\u0000\u0000\u0000"+
		"\u02c2k\u0001\u0000\u0000\u0000\u02c3\u02cb\u0005\u0011\u0000\u0000\u02c4"+
		"\u02cb\u0005>\u0000\u0000\u02c5\u02c6\u00053\u0000\u0000\u02c6\u02c7\u0003"+
		"V+\u0000\u02c7\u02c8\u00054\u0000\u0000\u02c8\u02cb\u0001\u0000\u0000"+
		"\u0000\u02c9\u02cb\u00034\u001a\u0000\u02ca\u02c3\u0001\u0000\u0000\u0000"+
		"\u02ca\u02c4\u0001\u0000\u0000\u0000\u02ca\u02c5\u0001\u0000\u0000\u0000"+
		"\u02ca\u02c9\u0001\u0000\u0000\u0000\u02cbm\u0001\u0000\u0000\u0000\u02cc"+
		"\u02cd\u0005\u0013\u0000\u0000\u02cd\u02ce\u00053\u0000\u0000\u02ce\u02cf"+
		"\u0003V+\u0000\u02cf\u02d0\u00054\u0000\u0000\u02d0\u02d4\u0003\n\u0005"+
		"\u0000\u02d1\u02d3\u0003r9\u0000\u02d2\u02d1\u0001\u0000\u0000\u0000\u02d3"+
		"\u02d6\u0001\u0000\u0000\u0000\u02d4\u02d2\u0001\u0000\u0000\u0000\u02d4"+
		"\u02d5\u0001\u0000\u0000\u0000\u02d5\u02d8\u0001\u0000\u0000\u0000\u02d6"+
		"\u02d4\u0001\u0000\u0000\u0000\u02d7\u02d9\u0003p8\u0000\u02d8\u02d7\u0001"+
		"\u0000\u0000\u0000\u02d8\u02d9\u0001\u0000\u0000\u0000\u02d9o\u0001\u0000"+
		"\u0000\u0000\u02da\u02db\u0005\u0015\u0000\u0000\u02db\u02dc\u0003\n\u0005"+
		"\u0000\u02dcq\u0001\u0000\u0000\u0000\u02dd\u02de\u0005\u0014\u0000\u0000"+
		"\u02de\u02df\u00053\u0000\u0000\u02df\u02e0\u0003V+\u0000\u02e0\u02e1"+
		"\u00054\u0000\u0000\u02e1\u02e2\u0003\n\u0005\u0000\u02e2s\u0001\u0000"+
		"\u0000\u0000\u02e3\u02e4\u0005\u0018\u0000\u0000\u02e4\u02e5\u00053\u0000"+
		"\u0000\u02e5\u02e6\u0003V+\u0000\u02e6\u02e7\u00054\u0000\u0000\u02e7"+
		"\u02e8\u0003\n\u0005\u0000\u02e8u\u0001\u0000\u0000\u0000\u02e9\u02ea"+
		"\u0005\u0017\u0000\u0000\u02ea\u02eb\u00053\u0000\u0000\u02eb\u02ec\u0005"+
		">\u0000\u0000\u02ec\u02ed\u0005-\u0000\u0000\u02ed\u02ee\u0005>\u0000"+
		"\u0000\u02ee\u02ef\u00054\u0000\u0000\u02ef\u02f0\u0003\n\u0005\u0000"+
		"\u02f0w\u0001\u0000\u0000\u0000\u02f1\u02f2\u00051\u0000\u0000\u02f2\u02f5"+
		"\u00053\u0000\u0000\u02f3\u02f6\u0005\u0012\u0000\u0000\u02f4\u02f6\u0003"+
		"V+\u0000\u02f5\u02f3\u0001\u0000\u0000\u0000\u02f5\u02f4\u0001\u0000\u0000"+
		"\u0000\u02f5\u02f6\u0001\u0000\u0000\u0000\u02f6\u02fe\u0001\u0000\u0000"+
		"\u0000\u02f7\u02fa\u0005=\u0000\u0000\u02f8\u02fb\u0005\u0012\u0000\u0000"+
		"\u02f9\u02fb\u0003V+\u0000\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fa\u02f9"+
		"\u0001\u0000\u0000\u0000\u02fb\u02fd\u0001\u0000\u0000\u0000\u02fc\u02f7"+
		"\u0001\u0000\u0000\u0000\u02fd\u0300\u0001\u0000\u0000\u0000\u02fe\u02fc"+
		"\u0001\u0000\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff\u0301"+
		"\u0001\u0000\u0000\u0000\u0300\u02fe\u0001\u0000\u0000\u0000\u0301\u0302"+
		"\u00054\u0000\u0000\u0302\u0303\u0005;\u0000\u0000\u0303y\u0001\u0000"+
		"\u0000\u0000\u0304\u0305\u00052\u0000\u0000\u0305\u0306\u00053\u0000\u0000"+
		"\u0306\u0307\u0005>\u0000\u0000\u0307\u0308\u00054\u0000\u0000\u0308\u0309"+
		"\u0005;\u0000\u0000\u0309{\u0001\u0000\u0000\u0000H\u008e\u0090\u0099"+
		"\u009b\u00a4\u00a6\u00ae\u00b0\u00b7\u00d0\u00d9\u00de\u00e5\u00ec\u00f4"+
		"\u00fc\u0104\u010c\u0114\u0116\u011c\u0122\u012a\u0131\u0134\u013c\u0145"+
		"\u0149\u0151\u015b\u015d\u016f\u0183\u018b\u0190\u0196\u019b\u01a3\u01b5"+
		"\u01ca\u01d1\u01da\u01e5\u01f0\u01f9\u0202\u0206\u020c\u0225\u0239\u0244"+
		"\u0255\u0257\u0266\u0268\u0273\u0279\u0282\u028c\u0297\u02a3\u02a5\u02ab"+
		"\u02b9\u02bb\u02c1\u02ca\u02d4\u02d8\u02f5\u02fa\u02fe";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
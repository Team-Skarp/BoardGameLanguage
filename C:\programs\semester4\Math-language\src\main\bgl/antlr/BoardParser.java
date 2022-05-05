// Generated from /Users/jsaad/Documents/Github/Math-language/src/main/bgl/Board.g4 by ANTLR 4.9.2
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
	public static final int
		RULE_game = 0, RULE_setup = 1, RULE_rules = 2, RULE_gameloop = 3, RULE_setupBlock = 4, 
		RULE_normalBlock = 5, RULE_rulesBlock = 6, RULE_gameloopBlock = 7, RULE_normalDeclaration = 8, 
		RULE_setupDeclaration = 9, RULE_uniqueDeclaration = 10, RULE_designDeclaration = 11, 
		RULE_designDefinition = 12, RULE_integerDeclaration = 13, RULE_sequentialDeclaration = 14, 
		RULE_booleanDeclaration = 15, RULE_stringDeclaration = 16, RULE_listDeclaration = 17, 
		RULE_listType = 18, RULE_listElement = 19, RULE_pathDeclaration = 20, 
		RULE_gridDeclaration = 21, RULE_specialDeclaration = 22, RULE_choiceDeclaration = 23, 
		RULE_actionDeclaration = 24, RULE_actionDefinition = 25, RULE_returnStatement = 26, 
		RULE_actionCall = 27, RULE_returnType = 28, RULE_assignmentStatement = 29, 
		RULE_intAssigment = 30, RULE_booleanAssigment = 31, RULE_stringAssigment = 32, 
		RULE_dotAssignment = 33, RULE_choiceAssignment = 34, RULE_actionAssignment = 35, 
		RULE_designBody = 36, RULE_fieldRow = 37, RULE_primitiveType = 38, RULE_primitiveValue = 39, 
		RULE_formalParameters = 40, RULE_statement = 41, RULE_expression = 42, 
		RULE_arithmeticExpression = 43, RULE_booleanExpression = 44, RULE_additive = 45, 
		RULE_multiplicative = 46, RULE_pow = 47, RULE_unaryMinus = 48, RULE_arithmeticAtom = 49, 
		RULE_logor = 50, RULE_logand = 51, RULE_equality = 52, RULE_relational = 53, 
		RULE_negation = 54, RULE_booleanAtom = 55, RULE_ifStatement = 56, RULE_elseStatement = 57, 
		RULE_elseifStatement = 58, RULE_whileStatement = 59, RULE_foreach = 60, 
		RULE_print = 61;
	private static String[] makeRuleNames() {
		return new String[] {
			"game", "setup", "rules", "gameloop", "setupBlock", "normalBlock", "rulesBlock", 
			"gameloopBlock", "normalDeclaration", "setupDeclaration", "uniqueDeclaration", 
			"designDeclaration", "designDefinition", "integerDeclaration", "sequentialDeclaration", 
			"booleanDeclaration", "stringDeclaration", "listDeclaration", "listType", 
			"listElement", "pathDeclaration", "gridDeclaration", "specialDeclaration", 
			"choiceDeclaration", "actionDeclaration", "actionDefinition", "returnStatement", 
			"actionCall", "returnType", "assignmentStatement", "intAssigment", "booleanAssigment", 
			"stringAssigment", "dotAssignment", "choiceAssignment", "actionAssignment", 
			"designBody", "fieldRow", "primitiveType", "primitiveValue", "formalParameters", 
			"statement", "expression", "arithmeticExpression", "booleanExpression", 
			"additive", "multiplicative", "pow", "unaryMinus", "arithmeticAtom", 
			"logor", "logand", "equality", "relational", "negation", "booleanAtom", 
			"ifStatement", "elseStatement", "elseifStatement", "whileStatement", 
			"foreach", "print"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << LISTDCL) | (1L << DESIGNDCL) | (1L << PATHDCL) | (1L << GRIDDCL) | (1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << RETURN) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << LISTDCL) | (1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << RETURN) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SPECIALDCL) | (1L << ACTIONDCL) | (1L << CHOICEDCL) | (1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << RETURN) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << IF) | (1L << FOREACH) | (1L << WHILE) | (1L << RETURN) | (1L << MINUS) | (1L << NOT) | (1L << PRINT) | (1L << LPAREN) | (1L << LBRACE) | (1L << IDENTIFIER))) != 0)) {
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(BoardParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BoardVisitor ) return ((BoardVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(RETURN);
			setState(416);
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

	public static class ActionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BoardParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(BoardParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BoardParser.RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BoardParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BoardParser.COMMA, i);
		}
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
		enterRule(_localctx, 54, RULE_actionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(IDENTIFIER);
			setState(419);
			match(LPAREN);
			setState(428);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(420);
				expression();
				}
				break;
			case 2:
				{
				setState(421);
				expression();
				setState(424); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(422);
					match(COMMA);
					setState(423);
					expression();
					}
					}
					setState(426); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
				break;
			}
			setState(430);
			match(RPAREN);
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
		enterRule(_localctx, 56, RULE_returnType);
		try {
			setState(434);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTDCL:
			case BOOLDCL:
			case STRDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				primitiveType();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
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
		enterRule(_localctx, 58, RULE_assignmentStatement);
		try {
			setState(452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				intAssigment();
				setState(437);
				match(EOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				booleanAssigment();
				setState(440);
				match(EOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(442);
				stringAssigment();
				setState(443);
				match(EOL);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(445);
				dotAssignment();
				setState(446);
				match(EOL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(448);
				actionAssignment();
				setState(449);
				match(EOL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(451);
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
		enterRule(_localctx, 60, RULE_intAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			match(IDENTIFIER);
			setState(455);
			match(ASSIGN);
			setState(456);
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
		enterRule(_localctx, 62, RULE_booleanAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(IDENTIFIER);
			setState(459);
			match(ASSIGN);
			setState(460);
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
		enterRule(_localctx, 64, RULE_stringAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(IDENTIFIER);
			setState(463);
			match(ASSIGN);
			setState(464);
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
		enterRule(_localctx, 66, RULE_dotAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(IDENTIFIER);
			setState(467);
			match(DOT);
			setState(468);
			match(IDENTIFIER);
			setState(469);
			match(ASSIGN);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STR) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(470);
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
				setState(475);
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
		enterRule(_localctx, 68, RULE_choiceAssignment);
		int _la;
		try {
			setState(511);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT) {
					{
					{
					setState(476);
					match(INT);
					setState(477);
					match(COLON);
					}
					}
					setState(482);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(483);
				match(LBRACE);
				setState(484);
				match(IDENTIFIER);
				setState(485);
				match(LPAREN);
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INT) {
					{
					{
					setState(486);
					match(INT);
					}
					}
					setState(491);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(492);
				match(RPAREN);
				setState(493);
				match(RBRACE);
				setState(494);
				match(COMMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				match(IDENTIFIER);
				setState(496);
				match(LPAREN);
				setState(500);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==IDENTIFIER) {
					{
					{
					setState(497);
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
					setState(502);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(503);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(504);
				match(IDENTIFIER);
				setState(505);
				match(COLON);
				setState(506);
				match(LBRACE);
				setState(507);
				print();
				setState(508);
				match(RBRACE);
				setState(509);
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
		enterRule(_localctx, 70, RULE_actionAssignment);
		int _la;
		try {
			setState(533);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(513);
				match(IDENTIFIER);
				setState(514);
				match(DOT);
				setState(515);
				match(IDENTIFIER);
				setState(516);
				match(LPAREN);
				setState(520);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==IDENTIFIER) {
					{
					{
					setState(517);
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
					setState(522);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(523);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(524);
				match(IDENTIFIER);
				setState(525);
				match(LPAREN);
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA || _la==IDENTIFIER) {
					{
					{
					setState(526);
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
					setState(531);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(532);
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
		enterRule(_localctx, 72, RULE_designBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(LBRACE);
			setState(537); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(536);
				fieldRow();
				}
				}
				setState(539); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTDCL) | (1L << BOOLDCL) | (1L << STRDCL) | (1L << LISTDCL) | (1L << ACTIONDCL) | (1L << IDENTIFIER))) != 0) );
			setState(541);
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
		enterRule(_localctx, 74, RULE_fieldRow);
		try {
			setState(564);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTDCL:
				enterOuterAlt(_localctx, 1);
				{
				setState(543);
				match(INTDCL);
				setState(544);
				match(IDENTIFIER);
				setState(545);
				match(EOL);
				}
				break;
			case BOOLDCL:
				enterOuterAlt(_localctx, 2);
				{
				setState(546);
				match(BOOLDCL);
				setState(547);
				match(IDENTIFIER);
				setState(548);
				match(EOL);
				}
				break;
			case STRDCL:
				enterOuterAlt(_localctx, 3);
				{
				setState(549);
				match(STRDCL);
				setState(550);
				match(IDENTIFIER);
				setState(551);
				match(EOL);
				}
				break;
			case LISTDCL:
				enterOuterAlt(_localctx, 4);
				{
				setState(552);
				match(LISTDCL);
				setState(553);
				match(COLON);
				setState(554);
				listType();
				setState(555);
				match(IDENTIFIER);
				setState(556);
				match(EOL);
				}
				break;
			case ACTIONDCL:
				enterOuterAlt(_localctx, 5);
				{
				setState(558);
				actionDeclaration();
				setState(559);
				match(EOL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 6);
				{
				setState(561);
				match(IDENTIFIER);
				setState(562);
				match(IDENTIFIER);
				setState(563);
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
		enterRule(_localctx, 76, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
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
		enterRule(_localctx, 78, RULE_primitiveValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
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
		enterRule(_localctx, 80, RULE_formalParameters);
		try {
			setState(584);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(570);
				primitiveType();
				setState(571);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(573);
				primitiveType();
				setState(574);
				match(IDENTIFIER);
				setState(575);
				match(COMMA);
				setState(576);
				formalParameters();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(578);
				match(IDENTIFIER);
				setState(579);
				match(IDENTIFIER);
				setState(580);
				match(COMMA);
				setState(581);
				formalParameters();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(582);
				match(IDENTIFIER);
				setState(583);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOL() { return getToken(BoardParser.EOL, 0); }
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
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
		enterRule(_localctx, 82, RULE_statement);
		try {
			setState(597);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				ifStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				whileStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(588);
				foreach();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(589);
				assignmentStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(590);
				print();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(591);
				expression();
				setState(592);
				match(EOL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(594);
				returnStatement();
				setState(595);
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
		enterRule(_localctx, 84, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
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
		enterRule(_localctx, 86, RULE_arithmeticExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
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
		enterRule(_localctx, 88, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
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
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_additive, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(606);
			multiplicative(0);
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
						_localctx = new AdditiveContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive);
						setState(608);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(609);
						match(PLUS);
						setState(610);
						multiplicative(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive);
						setState(611);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(612);
						match(MINUS);
						setState(613);
						multiplicative(0);
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
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_multiplicative, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(620);
			pow(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(633);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(631);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative);
						setState(622);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(623);
						match(MULT);
						setState(624);
						pow(0);
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative);
						setState(625);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(626);
						match(DIV);
						setState(627);
						pow(0);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicative);
						setState(628);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(629);
						match(MOD);
						setState(630);
						pow(0);
						}
						break;
					}
					} 
				}
				setState(635);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
		int _startState = 94;
		enterRecursionRule(_localctx, 94, RULE_pow, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(637);
			unaryMinus();
			}
			_ctx.stop = _input.LT(-1);
			setState(644);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PowContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pow);
					setState(639);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(640);
					match(EXP);
					setState(641);
					unaryMinus();
					}
					} 
				}
				setState(646);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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
		enterRule(_localctx, 96, RULE_unaryMinus);
		try {
			setState(650);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(647);
				match(MINUS);
				setState(648);
				arithmeticAtom();
				}
				break;
			case INT:
			case LPAREN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
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
		enterRule(_localctx, 98, RULE_arithmeticAtom);
		try {
			setState(658);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(652);
				match(INT);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(653);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(654);
				match(LPAREN);
				setState(655);
				arithmeticExpression();
				setState(656);
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
		int _startState = 100;
		enterRecursionRule(_localctx, 100, RULE_logor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(661);
			logand(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(668);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logor);
					setState(663);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(664);
					match(OR);
					setState(665);
					logand(0);
					}
					} 
				}
				setState(670);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
		int _startState = 102;
		enterRecursionRule(_localctx, 102, RULE_logand, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(672);
			equality(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(679);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogandContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logand);
					setState(674);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(675);
					match(AND);
					setState(676);
					equality(0);
					}
					} 
				}
				setState(681);
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
		int _startState = 104;
		enterRecursionRule(_localctx, 104, RULE_equality, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(683);
			relational(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(693);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(691);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,62,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(685);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(686);
						match(EQL);
						setState(687);
						relational(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equality);
						setState(688);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(689);
						match(NEQL);
						setState(690);
						relational(0);
						}
						break;
					}
					} 
				}
				setState(695);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
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
		int _startState = 106;
		enterRecursionRule(_localctx, 106, RULE_relational, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				{
				setState(697);
				arithmeticExpression();
				}
				break;
			case 2:
				{
				setState(698);
				negation();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(715);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(713);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(701);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(702);
						match(GTH);
						setState(703);
						arithmeticExpression();
						}
						break;
					case 2:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(704);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(705);
						match(LTH);
						setState(706);
						arithmeticExpression();
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(707);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(708);
						match(GTHEQL);
						setState(709);
						arithmeticExpression();
						}
						break;
					case 4:
						{
						_localctx = new RelationalContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relational);
						setState(710);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(711);
						match(LTHEQL);
						setState(712);
						arithmeticExpression();
						}
						break;
					}
					} 
				}
				setState(717);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
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
		enterRule(_localctx, 108, RULE_negation);
		try {
			setState(721);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(718);
				match(NOT);
				setState(719);
				booleanAtom();
				}
				break;
			case BOOL:
			case LPAREN:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(720);
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
		enterRule(_localctx, 110, RULE_booleanAtom);
		try {
			setState(730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(723);
				match(BOOL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(724);
				match(IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(725);
				match(LPAREN);
				setState(726);
				booleanExpression();
				setState(727);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(729);
				actionCall();
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
		enterRule(_localctx, 112, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(IF);
			setState(733);
			match(LPAREN);
			setState(734);
			booleanExpression();
			setState(735);
			match(RPAREN);
			setState(736);
			normalBlock();
			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(737);
				elseifStatement();
				}
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(744);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(743);
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
		enterRule(_localctx, 114, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			match(ELSE);
			setState(747);
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
		enterRule(_localctx, 116, RULE_elseifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			match(ELSEIF);
			setState(750);
			match(LPAREN);
			setState(751);
			booleanExpression();
			setState(752);
			match(RPAREN);
			setState(753);
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
		enterRule(_localctx, 118, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			match(WHILE);
			setState(756);
			match(LPAREN);
			setState(757);
			booleanExpression();
			setState(758);
			match(RPAREN);
			setState(759);
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
		enterRule(_localctx, 120, RULE_foreach);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(761);
			match(FOREACH);
			setState(762);
			match(LPAREN);
			setState(763);
			match(IDENTIFIER);
			setState(764);
			match(IN);
			setState(765);
			match(IDENTIFIER);
			setState(766);
			match(RPAREN);
			setState(767);
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
		enterRule(_localctx, 122, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(769);
			match(PRINT);
			setState(770);
			match(LPAREN);
			setState(773);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STR:
				{
				setState(771);
				match(STR);
				}
				break;
			case INT:
			case BOOL:
			case MINUS:
			case NOT:
			case LPAREN:
			case IDENTIFIER:
				{
				setState(772);
				booleanExpression();
				}
				break;
			case RPAREN:
			case COMMA:
				break;
			default:
				break;
			}
			setState(782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(775);
				match(COMMA);
				setState(778);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STR:
					{
					setState(776);
					match(STR);
					}
					break;
				case INT:
				case BOOL:
				case MINUS:
				case NOT:
				case LPAREN:
				case IDENTIFIER:
					{
					setState(777);
					booleanExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(785);
			match(RPAREN);
			setState(786);
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
		case 45:
			return additive_sempred((AdditiveContext)_localctx, predIndex);
		case 46:
			return multiplicative_sempred((MultiplicativeContext)_localctx, predIndex);
		case 47:
			return pow_sempred((PowContext)_localctx, predIndex);
		case 50:
			return logor_sempred((LogorContext)_localctx, predIndex);
		case 51:
			return logand_sempred((LogandContext)_localctx, predIndex);
		case 52:
			return equality_sempred((EqualityContext)_localctx, predIndex);
		case 53:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u0317\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\7\6\u0091\n\6\f\6\16\6\u0094\13\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\7\7\u009c\n\7\f\7\16\7\u009f\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00a7"+
		"\n\b\f\b\16\b\u00aa\13\b\3\b\3\b\3\t\3\t\3\t\7\t\u00b1\n\t\f\t\16\t\u00b4"+
		"\13\t\3\t\3\t\3\t\3\t\5\t\u00ba\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00d3\n"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00dc\n\13\3\f\3\f\3\f\5\f"+
		"\u00e1\n\f\3\r\3\r\3\r\7\r\u00e6\n\r\f\r\16\r\u00e9\13\r\3\16\3\16\3\16"+
		"\3\16\5\16\u00ef\n\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00f7\n\17\3"+
		"\20\3\20\3\20\3\20\6\20\u00fd\n\20\r\20\16\20\u00fe\3\20\3\20\3\20\3\20"+
		"\6\20\u0105\n\20\r\20\16\20\u0106\3\20\3\20\3\20\3\20\6\20\u010d\n\20"+
		"\r\20\16\20\u010e\3\20\3\20\3\20\3\20\6\20\u0115\n\20\r\20\16\20\u0116"+
		"\5\20\u0119\n\20\3\21\3\21\3\21\3\21\5\21\u011f\n\21\3\22\3\22\3\22\3"+
		"\22\5\22\u0125\n\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u012d\n\23\3\23"+
		"\3\23\3\23\7\23\u0132\n\23\f\23\16\23\u0135\13\23\5\23\u0137\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u013f\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\5\24\u0148\n\24\3\25\3\25\5\25\u014c\n\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\5\26\u0154\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u015e\n\26\5\26\u0160\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0172\n\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\5\31\u0186\n\31\3\31\3\31\3\32\3\32\3\32\3\32\5\32\u018e\n\32\3"+
		"\32\3\32\3\32\5\32\u0193\n\32\3\33\3\33\3\33\3\33\5\33\u0199\n\33\3\33"+
		"\3\33\3\33\5\33\u019e\n\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\6\35\u01ab\n\35\r\35\16\35\u01ac\5\35\u01af\n\35\3\35\3\35"+
		"\3\36\3\36\5\36\u01b5\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u01c7\n\37\3 \3 \3 \3 \3!\3!"+
		"\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\7#\u01da\n#\f#\16#\u01dd\13#\3$"+
		"\3$\7$\u01e1\n$\f$\16$\u01e4\13$\3$\3$\3$\3$\7$\u01ea\n$\f$\16$\u01ed"+
		"\13$\3$\3$\3$\3$\3$\3$\7$\u01f5\n$\f$\16$\u01f8\13$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\5$\u0202\n$\3%\3%\3%\3%\3%\7%\u0209\n%\f%\16%\u020c\13%\3%\3%\3"+
		"%\3%\7%\u0212\n%\f%\16%\u0215\13%\3%\5%\u0218\n%\3&\3&\6&\u021c\n&\r&"+
		"\16&\u021d\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0237\n\'\3(\3(\3)\3)\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u024b\n*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\5+\u0258\n+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\7/\u0269"+
		"\n/\f/\16/\u026c\13/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\7\60\u027a\n\60\f\60\16\60\u027d\13\60\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\7\61\u0285\n\61\f\61\16\61\u0288\13\61\3\62\3\62\3\62\5\62"+
		"\u028d\n\62\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u0295\n\63\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\7\64\u029d\n\64\f\64\16\64\u02a0\13\64\3\65\3\65\3"+
		"\65\3\65\3\65\3\65\7\65\u02a8\n\65\f\65\16\65\u02ab\13\65\3\66\3\66\3"+
		"\66\3\66\3\66\3\66\3\66\3\66\3\66\7\66\u02b6\n\66\f\66\16\66\u02b9\13"+
		"\66\3\67\3\67\3\67\5\67\u02be\n\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\7\67\u02cc\n\67\f\67\16\67\u02cf\13\67\38\3"+
		"8\38\58\u02d4\n8\39\39\39\39\39\39\39\59\u02dd\n9\3:\3:\3:\3:\3:\3:\7"+
		":\u02e5\n:\f:\16:\u02e8\13:\3:\5:\u02eb\n:\3;\3;\3;\3<\3<\3<\3<\3<\3<"+
		"\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\5?\u0308\n?\3?"+
		"\3?\3?\5?\u030d\n?\7?\u030f\n?\f?\16?\u0312\13?\3?\3?\3?\3?\2\t\\^`fh"+
		"jl@\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFHJLNPRTVXZ\\^`bdfhjlnprtvxz|\2\7\3\2/\61\4\2\21\23>>\3\2=>\3\2\6\b\3"+
		"\2\21\23\2\u0349\2~\3\2\2\2\4\u0082\3\2\2\2\6\u0085\3\2\2\2\b\u0088\3"+
		"\2\2\2\n\u008b\3\2\2\2\f\u0097\3\2\2\2\16\u00a2\3\2\2\2\20\u00b9\3\2\2"+
		"\2\22\u00d2\3\2\2\2\24\u00db\3\2\2\2\26\u00e0\3\2\2\2\30\u00e2\3\2\2\2"+
		"\32\u00ea\3\2\2\2\34\u00f6\3\2\2\2\36\u0118\3\2\2\2 \u011e\3\2\2\2\"\u0124"+
		"\3\2\2\2$\u013e\3\2\2\2&\u0147\3\2\2\2(\u014b\3\2\2\2*\u015f\3\2\2\2,"+
		"\u0171\3\2\2\2.\u0173\3\2\2\2\60\u017d\3\2\2\2\62\u0189\3\2\2\2\64\u0194"+
		"\3\2\2\2\66\u01a1\3\2\2\28\u01a4\3\2\2\2:\u01b4\3\2\2\2<\u01c6\3\2\2\2"+
		">\u01c8\3\2\2\2@\u01cc\3\2\2\2B\u01d0\3\2\2\2D\u01d4\3\2\2\2F\u0201\3"+
		"\2\2\2H\u0217\3\2\2\2J\u0219\3\2\2\2L\u0236\3\2\2\2N\u0238\3\2\2\2P\u023a"+
		"\3\2\2\2R\u024a\3\2\2\2T\u0257\3\2\2\2V\u0259\3\2\2\2X\u025b\3\2\2\2Z"+
		"\u025d\3\2\2\2\\\u025f\3\2\2\2^\u026d\3\2\2\2`\u027e\3\2\2\2b\u028c\3"+
		"\2\2\2d\u0294\3\2\2\2f\u0296\3\2\2\2h\u02a1\3\2\2\2j\u02ac\3\2\2\2l\u02bd"+
		"\3\2\2\2n\u02d3\3\2\2\2p\u02dc\3\2\2\2r\u02de\3\2\2\2t\u02ec\3\2\2\2v"+
		"\u02ef\3\2\2\2x\u02f5\3\2\2\2z\u02fb\3\2\2\2|\u0303\3\2\2\2~\177\5\4\3"+
		"\2\177\u0080\5\6\4\2\u0080\u0081\5\b\5\2\u0081\3\3\2\2\2\u0082\u0083\7"+
		"\3\2\2\u0083\u0084\5\n\6\2\u0084\5\3\2\2\2\u0085\u0086\7\4\2\2\u0086\u0087"+
		"\5\16\b\2\u0087\7\3\2\2\2\u0088\u0089\7\5\2\2\u0089\u008a\5\20\t\2\u008a"+
		"\t\3\2\2\2\u008b\u0092\7\67\2\2\u008c\u0091\5\22\n\2\u008d\u0091\5\24"+
		"\13\2\u008e\u0091\5T+\2\u008f\u0091\5\n\6\2\u0090\u008c\3\2\2\2\u0090"+
		"\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2"+
		"\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0095\u0096\78\2\2\u0096\13\3\2\2\2\u0097\u009d\7\67\2"+
		"\2\u0098\u009c\5\22\n\2\u0099\u009c\5T+\2\u009a\u009c\5\f\7\2\u009b\u0098"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u00a0\u00a1\78\2\2\u00a1\r\3\2\2\2\u00a2\u00a8\7\67\2\2\u00a3\u00a7"+
		"\5\26\f\2\u00a4\u00a7\5T+\2\u00a5\u00a7\5\16\b\2\u00a6\u00a3\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab"+
		"\u00ac\78\2\2\u00ac\17\3\2\2\2\u00ad\u00b2\7\67\2\2\u00ae\u00b1\5T+\2"+
		"\u00af\u00b1\5\20\t\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b4"+
		"\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4"+
		"\u00b2\3\2\2\2\u00b5\u00ba\78\2\2\u00b6\u00b7\7>\2\2\u00b7\u00b8\7\"\2"+
		"\2\u00b8\u00ba\5H%\2\u00b9\u00ad\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\21"+
		"\3\2\2\2\u00bb\u00bc\7\6\2\2\u00bc\u00bd\5\34\17\2\u00bd\u00be\7;\2\2"+
		"\u00be\u00d3\3\2\2\2\u00bf\u00c0\7\7\2\2\u00c0\u00c1\5 \21\2\u00c1\u00c2"+
		"\7;\2\2\u00c2\u00d3\3\2\2\2\u00c3\u00c4\7\b\2\2\u00c4\u00c5\5\"\22\2\u00c5"+
		"\u00c6\7;\2\2\u00c6\u00d3\3\2\2\2\u00c7\u00c8\7\t\2\2\u00c8\u00c9\5$\23"+
		"\2\u00c9\u00ca\7;\2\2\u00ca\u00d3\3\2\2\2\u00cb\u00cc\7>\2\2\u00cc\u00cd"+
		"\5\30\r\2\u00cd\u00ce\7;\2\2\u00ce\u00d3\3\2\2\2\u00cf\u00d0\5\36\20\2"+
		"\u00d0\u00d1\7;\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00bb\3\2\2\2\u00d2\u00bf"+
		"\3\2\2\2\u00d2\u00c3\3\2\2\2\u00d2\u00c7\3\2\2\2\u00d2\u00cb\3\2\2\2\u00d2"+
		"\u00cf\3\2\2\2\u00d3\23\3\2\2\2\u00d4\u00d5\5*\26\2\u00d5\u00d6\7;\2\2"+
		"\u00d6\u00dc\3\2\2\2\u00d7\u00d8\5,\27\2\u00d8\u00d9\7;\2\2\u00d9\u00dc"+
		"\3\2\2\2\u00da\u00dc\5\32\16\2\u00db\u00d4\3\2\2\2\u00db\u00d7\3\2\2\2"+
		"\u00db\u00da\3\2\2\2\u00dc\25\3\2\2\2\u00dd\u00e1\5.\30\2\u00de\u00e1"+
		"\5\64\33\2\u00df\u00e1\5\60\31\2\u00e0\u00dd\3\2\2\2\u00e0\u00de\3\2\2"+
		"\2\u00e0\u00df\3\2\2\2\u00e1\27\3\2\2\2\u00e2\u00e7\7>\2\2\u00e3\u00e4"+
		"\7=\2\2\u00e4\u00e6\7>\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\31\3\2\2\2\u00e9\u00e7\3\2\2"+
		"\2\u00ea\u00eb\7\n\2\2\u00eb\u00ee\7>\2\2\u00ec\u00ed\7,\2\2\u00ed\u00ef"+
		"\7>\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0"+
		"\u00f1\5J&\2\u00f1\33\3\2\2\2\u00f2\u00f3\7>\2\2\u00f3\u00f4\7\"\2\2\u00f4"+
		"\u00f7\5X-\2\u00f5\u00f7\7>\2\2\u00f6\u00f2\3\2\2\2\u00f6\u00f5\3\2\2"+
		"\2\u00f7\35\3\2\2\2\u00f8\u00f9\7\6\2\2\u00f9\u00fc\5\34\17\2\u00fa\u00fb"+
		"\7=\2\2\u00fb\u00fd\5\34\17\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\3\2\2\2"+
		"\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0119\3\2\2\2\u0100\u0101"+
		"\7\7\2\2\u0101\u0104\5 \21\2\u0102\u0103\7=\2\2\u0103\u0105\5 \21\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2"+
		"\2\2\u0107\u0119\3\2\2\2\u0108\u0109\7\b\2\2\u0109\u010c\5\"\22\2\u010a"+
		"\u010b\7=\2\2\u010b\u010d\5\"\22\2\u010c\u010a\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0119\3\2\2\2\u0110"+
		"\u0111\7>\2\2\u0111\u0114\5\30\r\2\u0112\u0113\7=\2\2\u0113\u0115\5\30"+
		"\r\2\u0114\u0112\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u00f8\3\2\2\2\u0118\u0100\3\2"+
		"\2\2\u0118\u0108\3\2\2\2\u0118\u0110\3\2\2\2\u0119\37\3\2\2\2\u011a\u011b"+
		"\7>\2\2\u011b\u011c\7\"\2\2\u011c\u011f\5Z.\2\u011d\u011f\7>\2\2\u011e"+
		"\u011a\3\2\2\2\u011e\u011d\3\2\2\2\u011f!\3\2\2\2\u0120\u0121\7>\2\2\u0121"+
		"\u0122\7\"\2\2\u0122\u0125\7\23\2\2\u0123\u0125\7>\2\2\u0124\u0120\3\2"+
		"\2\2\u0124\u0123\3\2\2\2\u0125#\3\2\2\2\u0126\u0127\7:\2\2\u0127\u0128"+
		"\5&\24\2\u0128\u0129\7>\2\2\u0129\u012a\7\"\2\2\u012a\u0136\7\65\2\2\u012b"+
		"\u012d\5(\25\2\u012c\u012b\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u0137\3\2"+
		"\2\2\u012e\u0133\5(\25\2\u012f\u0130\7=\2\2\u0130\u0132\5(\25\2\u0131"+
		"\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u012c\3\2\2\2\u0136"+
		"\u012e\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\7\66\2\2\u0139\u013f\3"+
		"\2\2\2\u013a\u013b\7:\2\2\u013b\u013c\5&\24\2\u013c\u013d\7>\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u0126\3\2\2\2\u013e\u013a\3\2\2\2\u013f%\3\2\2\2"+
		"\u0140\u0148\7>\2\2\u0141\u0148\7\6\2\2\u0142\u0148\7\7\2\2\u0143\u0148"+
		"\7\b\2\2\u0144\u0145\7\t\2\2\u0145\u0146\7:\2\2\u0146\u0148\5&\24\2\u0147"+
		"\u0140\3\2\2\2\u0147\u0141\3\2\2\2\u0147\u0142\3\2\2\2\u0147\u0143\3\2"+
		"\2\2\u0147\u0144\3\2\2\2\u0148\'\3\2\2\2\u0149\u014c\5P)\2\u014a\u014c"+
		"\7>\2\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014c)\3\2\2\2\u014d\u014e"+
		"\7\16\2\2\u014e\u014f\7>\2\2\u014f\u0150\7\65\2\2\u0150\u0151\7\21\2\2"+
		"\u0151\u0153\7\66\2\2\u0152\u0154\t\2\2\2\u0153\u0152\3\2\2\2\u0153\u0154"+
		"\3\2\2\2\u0154\u0160\3\2\2\2\u0155\u0156\7\16\2\2\u0156\u0157\7:\2\2\u0157"+
		"\u0158\7>\2\2\u0158\u0159\7>\2\2\u0159\u015a\7\65\2\2\u015a\u015b\7\21"+
		"\2\2\u015b\u015d\7\66\2\2\u015c\u015e\t\2\2\2\u015d\u015c\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u014d\3\2\2\2\u015f\u0155\3\2"+
		"\2\2\u0160+\3\2\2\2\u0161\u0162\7\17\2\2\u0162\u0163\7>\2\2\u0163\u0164"+
		"\7\65\2\2\u0164\u0165\7\21\2\2\u0165\u0166\7=\2\2\u0166\u0167\7\21\2\2"+
		"\u0167\u0172\7\66\2\2\u0168\u0169\7\17\2\2\u0169\u016a\7:\2\2\u016a\u016b"+
		"\7>\2\2\u016b\u016c\7>\2\2\u016c\u016d\7\65\2\2\u016d\u016e\7\21\2\2\u016e"+
		"\u016f\7=\2\2\u016f\u0170\7\21\2\2\u0170\u0172\7\66\2\2\u0171\u0161\3"+
		"\2\2\2\u0171\u0168\3\2\2\2\u0172-\3\2\2\2\u0173\u0174\7\13\2\2\u0174\u0175"+
		"\7>\2\2\u0175\u0176\7-\2\2\u0176\u0177\7\63\2\2\u0177\u0178\7>\2\2\u0178"+
		"\u0179\7=\2\2\u0179\u017a\7>\2\2\u017a\u017b\7\64\2\2\u017b\u017c\5\16"+
		"\b\2\u017c/\3\2\2\2\u017d\u017e\7\r\2\2\u017e\u017f\7>\2\2\u017f\u0180"+
		"\7\63\2\2\u0180\u0181\7>\2\2\u0181\u0182\7>\2\2\u0182\u0185\7\64\2\2\u0183"+
		"\u0184\7:\2\2\u0184\u0186\5N(\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2"+
		"\2\u0186\u0187\3\2\2\2\u0187\u0188\5\16\b\2\u0188\61\3\2\2\2\u0189\u018a"+
		"\7\f\2\2\u018a\u018b\7>\2\2\u018b\u018d\7\63\2\2\u018c\u018e\5R*\2\u018d"+
		"\u018c\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0192\7\64"+
		"\2\2\u0190\u0191\7:\2\2\u0191\u0193\5:\36\2\u0192\u0190\3\2\2\2\u0192"+
		"\u0193\3\2\2\2\u0193\63\3\2\2\2\u0194\u0195\7\f\2\2\u0195\u0196\7>\2\2"+
		"\u0196\u0198\7\63\2\2\u0197\u0199\5R*\2\u0198\u0197\3\2\2\2\u0198\u0199"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019d\7\64\2\2\u019b\u019c\7:\2\2\u019c"+
		"\u019e\5:\36\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2"+
		"\2\2\u019f\u01a0\5\16\b\2\u01a0\65\3\2\2\2\u01a1\u01a2\7\32\2\2\u01a2"+
		"\u01a3\5V,\2\u01a3\67\3\2\2\2\u01a4\u01a5\7>\2\2\u01a5\u01ae\7\63\2\2"+
		"\u01a6\u01af\5V,\2\u01a7\u01aa\5V,\2\u01a8\u01a9\7=\2\2\u01a9\u01ab\5"+
		"V,\2\u01aa\u01a8\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac"+
		"\u01ad\3\2\2\2\u01ad\u01af\3\2\2\2\u01ae\u01a6\3\2\2\2\u01ae\u01a7\3\2"+
		"\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\7\64\2\2\u01b1"+
		"9\3\2\2\2\u01b2\u01b5\5N(\2\u01b3\u01b5\7>\2\2\u01b4\u01b2\3\2\2\2\u01b4"+
		"\u01b3\3\2\2\2\u01b5;\3\2\2\2\u01b6\u01b7\5> \2\u01b7\u01b8\7;\2\2\u01b8"+
		"\u01c7\3\2\2\2\u01b9\u01ba\5@!\2\u01ba\u01bb\7;\2\2\u01bb\u01c7\3\2\2"+
		"\2\u01bc\u01bd\5B\"\2\u01bd\u01be\7;\2\2\u01be\u01c7\3\2\2\2\u01bf\u01c0"+
		"\5D#\2\u01c0\u01c1\7;\2\2\u01c1\u01c7\3\2\2\2\u01c2\u01c3\5H%\2\u01c3"+
		"\u01c4\7;\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c7\5F$\2\u01c6\u01b6\3\2\2"+
		"\2\u01c6\u01b9\3\2\2\2\u01c6\u01bc\3\2\2\2\u01c6\u01bf\3\2\2\2\u01c6\u01c2"+
		"\3\2\2\2\u01c6\u01c5\3\2\2\2\u01c7=\3\2\2\2\u01c8\u01c9\7>\2\2\u01c9\u01ca"+
		"\7\"\2\2\u01ca\u01cb\5X-\2\u01cb?\3\2\2\2\u01cc\u01cd\7>\2\2\u01cd\u01ce"+
		"\7\"\2\2\u01ce\u01cf\5Z.\2\u01cfA\3\2\2\2\u01d0\u01d1\7>\2\2\u01d1\u01d2"+
		"\7\"\2\2\u01d2\u01d3\7\23\2\2\u01d3C\3\2\2\2\u01d4\u01d5\7>\2\2\u01d5"+
		"\u01d6\7<\2\2\u01d6\u01d7\7>\2\2\u01d7\u01db\7\"\2\2\u01d8\u01da\t\3\2"+
		"\2\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dcE\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\7\21\2\2\u01df"+
		"\u01e1\7:\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2"+
		"\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e5\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5"+
		"\u01e6\7\67\2\2\u01e6\u01e7\7>\2\2\u01e7\u01eb\7\63\2\2\u01e8\u01ea\7"+
		"\21\2\2\u01e9\u01e8\3\2\2\2\u01ea\u01ed\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee\u01ef\7\64"+
		"\2\2\u01ef\u01f0\78\2\2\u01f0\u0202\7=\2\2\u01f1\u01f2\7>\2\2\u01f2\u01f6"+
		"\7\63\2\2\u01f3\u01f5\t\4\2\2\u01f4\u01f3\3\2\2\2\u01f5\u01f8\3\2\2\2"+
		"\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f6"+
		"\3\2\2\2\u01f9\u0202\7\64\2\2\u01fa\u01fb\7>\2\2\u01fb\u01fc\7:\2\2\u01fc"+
		"\u01fd\7\67\2\2\u01fd\u01fe\5|?\2\u01fe\u01ff\78\2\2\u01ff\u0200\7;\2"+
		"\2\u0200\u0202\3\2\2\2\u0201\u01e2\3\2\2\2\u0201\u01f1\3\2\2\2\u0201\u01fa"+
		"\3\2\2\2\u0202G\3\2\2\2\u0203\u0204\7>\2\2\u0204\u0205\7<\2\2\u0205\u0206"+
		"\7>\2\2\u0206\u020a\7\63\2\2\u0207\u0209\t\4\2\2\u0208\u0207\3\2\2\2\u0209"+
		"\u020c\3\2\2\2\u020a\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2"+
		"\2\2\u020c\u020a\3\2\2\2\u020d\u0218\7\64\2\2\u020e\u020f\7>\2\2\u020f"+
		"\u0213\7\63\2\2\u0210\u0212\t\4\2\2\u0211\u0210\3\2\2\2\u0212\u0215\3"+
		"\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2\2\2\u0214\u0216\3\2\2\2\u0215"+
		"\u0213\3\2\2\2\u0216\u0218\7\64\2\2\u0217\u0203\3\2\2\2\u0217\u020e\3"+
		"\2\2\2\u0218I\3\2\2\2\u0219\u021b\7\67\2\2\u021a\u021c\5L\'\2\u021b\u021a"+
		"\3\2\2\2\u021c\u021d\3\2\2\2\u021d\u021b\3\2\2\2\u021d\u021e\3\2\2\2\u021e"+
		"\u021f\3\2\2\2\u021f\u0220\78\2\2\u0220K\3\2\2\2\u0221\u0222\7\6\2\2\u0222"+
		"\u0223\7>\2\2\u0223\u0237\7;\2\2\u0224\u0225\7\7\2\2\u0225\u0226\7>\2"+
		"\2\u0226\u0237\7;\2\2\u0227\u0228\7\b\2\2\u0228\u0229\7>\2\2\u0229\u0237"+
		"\7;\2\2\u022a\u022b\7\t\2\2\u022b\u022c\7:\2\2\u022c\u022d\5&\24\2\u022d"+
		"\u022e\7>\2\2\u022e\u022f\7;\2\2\u022f\u0237\3\2\2\2\u0230\u0231\5\62"+
		"\32\2\u0231\u0232\7;\2\2\u0232\u0237\3\2\2\2\u0233\u0234\7>\2\2\u0234"+
		"\u0235\7>\2\2\u0235\u0237\7;\2\2\u0236\u0221\3\2\2\2\u0236\u0224\3\2\2"+
		"\2\u0236\u0227\3\2\2\2\u0236\u022a\3\2\2\2\u0236\u0230\3\2\2\2\u0236\u0233"+
		"\3\2\2\2\u0237M\3\2\2\2\u0238\u0239\t\5\2\2\u0239O\3\2\2\2\u023a\u023b"+
		"\t\6\2\2\u023bQ\3\2\2\2\u023c\u023d\5N(\2\u023d\u023e\7>\2\2\u023e\u024b"+
		"\3\2\2\2\u023f\u0240\5N(\2\u0240\u0241\7>\2\2\u0241\u0242\7=\2\2\u0242"+
		"\u0243\5R*\2\u0243\u024b\3\2\2\2\u0244\u0245\7>\2\2\u0245\u0246\7>\2\2"+
		"\u0246\u0247\7=\2\2\u0247\u024b\5R*\2\u0248\u0249\7>\2\2\u0249\u024b\7"+
		">\2\2\u024a\u023c\3\2\2\2\u024a\u023f\3\2\2\2\u024a\u0244\3\2\2\2\u024a"+
		"\u0248\3\2\2\2\u024bS\3\2\2\2\u024c\u0258\5r:\2\u024d\u0258\5x=\2\u024e"+
		"\u0258\5z>\2\u024f\u0258\5<\37\2\u0250\u0258\5|?\2\u0251\u0252\5V,\2\u0252"+
		"\u0253\7;\2\2\u0253\u0258\3\2\2\2\u0254\u0255\5\66\34\2\u0255\u0256\7"+
		";\2\2\u0256\u0258\3\2\2\2\u0257\u024c\3\2\2\2\u0257\u024d\3\2\2\2\u0257"+
		"\u024e\3\2\2\2\u0257\u024f\3\2\2\2\u0257\u0250\3\2\2\2\u0257\u0251\3\2"+
		"\2\2\u0257\u0254\3\2\2\2\u0258U\3\2\2\2\u0259\u025a\5Z.\2\u025aW\3\2\2"+
		"\2\u025b\u025c\5\\/\2\u025cY\3\2\2\2\u025d\u025e\5f\64\2\u025e[\3\2\2"+
		"\2\u025f\u0260\b/\1\2\u0260\u0261\5^\60\2\u0261\u026a\3\2\2\2\u0262\u0263"+
		"\f\5\2\2\u0263\u0264\7\35\2\2\u0264\u0269\5^\60\2\u0265\u0266\f\4\2\2"+
		"\u0266\u0267\7\36\2\2\u0267\u0269\5^\60\2\u0268\u0262\3\2\2\2\u0268\u0265"+
		"\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b"+
		"]\3\2\2\2\u026c\u026a\3\2\2\2\u026d\u026e\b\60\1\2\u026e\u026f\5`\61\2"+
		"\u026f\u027b\3\2\2\2\u0270\u0271\f\6\2\2\u0271\u0272\7\37\2\2\u0272\u027a"+
		"\5`\61\2\u0273\u0274\f\5\2\2\u0274\u0275\7 \2\2\u0275\u027a\5`\61\2\u0276"+
		"\u0277\f\4\2\2\u0277\u0278\7\34\2\2\u0278\u027a\5`\61\2\u0279\u0270\3"+
		"\2\2\2\u0279\u0273\3\2\2\2\u0279\u0276\3\2\2\2\u027a\u027d\3\2\2\2\u027b"+
		"\u0279\3\2\2\2\u027b\u027c\3\2\2\2\u027c_\3\2\2\2\u027d\u027b\3\2\2\2"+
		"\u027e\u027f\b\61\1\2\u027f\u0280\5b\62\2\u0280\u0286\3\2\2\2\u0281\u0282"+
		"\f\4\2\2\u0282\u0283\7!\2\2\u0283\u0285\5b\62\2\u0284\u0281\3\2\2\2\u0285"+
		"\u0288\3\2\2\2\u0286\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287a\3\2\2\2"+
		"\u0288\u0286\3\2\2\2\u0289\u028a\7\36\2\2\u028a\u028d\5d\63\2\u028b\u028d"+
		"\5d\63\2\u028c\u0289\3\2\2\2\u028c\u028b\3\2\2\2\u028dc\3\2\2\2\u028e"+
		"\u0295\7\21\2\2\u028f\u0295\7>\2\2\u0290\u0291\7\63\2\2\u0291\u0292\5"+
		"X-\2\u0292\u0293\7\64\2\2\u0293\u0295\3\2\2\2\u0294\u028e\3\2\2\2\u0294"+
		"\u028f\3\2\2\2\u0294\u0290\3\2\2\2\u0295e\3\2\2\2\u0296\u0297\b\64\1\2"+
		"\u0297\u0298\5h\65\2\u0298\u029e\3\2\2\2\u0299\u029a\f\4\2\2\u029a\u029b"+
		"\7+\2\2\u029b\u029d\5h\65\2\u029c\u0299\3\2\2\2\u029d\u02a0\3\2\2\2\u029e"+
		"\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029fg\3\2\2\2\u02a0\u029e\3\2\2\2"+
		"\u02a1\u02a2\b\65\1\2\u02a2\u02a3\5j\66\2\u02a3\u02a9\3\2\2\2\u02a4\u02a5"+
		"\f\4\2\2\u02a5\u02a6\7*\2\2\u02a6\u02a8\5j\66\2\u02a7\u02a4\3\2\2\2\u02a8"+
		"\u02ab\3\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aai\3\2\2\2"+
		"\u02ab\u02a9\3\2\2\2\u02ac\u02ad\b\66\1\2\u02ad\u02ae\5l\67\2\u02ae\u02b7"+
		"\3\2\2\2\u02af\u02b0\f\5\2\2\u02b0\u02b1\7\'\2\2\u02b1\u02b6\5l\67\2\u02b2"+
		"\u02b3\f\4\2\2\u02b3\u02b4\7(\2\2\u02b4\u02b6\5l\67\2\u02b5\u02af\3\2"+
		"\2\2\u02b5\u02b2\3\2\2\2\u02b6\u02b9\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b7"+
		"\u02b8\3\2\2\2\u02b8k\3\2\2\2\u02b9\u02b7\3\2\2\2\u02ba\u02bb\b\67\1\2"+
		"\u02bb\u02be\5X-\2\u02bc\u02be\5n8\2\u02bd\u02ba\3\2\2\2\u02bd\u02bc\3"+
		"\2\2\2\u02be\u02cd\3\2\2\2\u02bf\u02c0\f\b\2\2\u02c0\u02c1\7#\2\2\u02c1"+
		"\u02cc\5X-\2\u02c2\u02c3\f\7\2\2\u02c3\u02c4\7$\2\2\u02c4\u02cc\5X-\2"+
		"\u02c5\u02c6\f\6\2\2\u02c6\u02c7\7%\2\2\u02c7\u02cc\5X-\2\u02c8\u02c9"+
		"\f\5\2\2\u02c9\u02ca\7&\2\2\u02ca\u02cc\5X-\2\u02cb\u02bf\3\2\2\2\u02cb"+
		"\u02c2\3\2\2\2\u02cb\u02c5\3\2\2\2\u02cb\u02c8\3\2\2\2\u02cc\u02cf\3\2"+
		"\2\2\u02cd\u02cb\3\2\2\2\u02cd\u02ce\3\2\2\2\u02cem\3\2\2\2\u02cf\u02cd"+
		"\3\2\2\2\u02d0\u02d1\7)\2\2\u02d1\u02d4\5p9\2\u02d2\u02d4\5p9\2\u02d3"+
		"\u02d0\3\2\2\2\u02d3\u02d2\3\2\2\2\u02d4o\3\2\2\2\u02d5\u02dd\7\22\2\2"+
		"\u02d6\u02dd\7>\2\2\u02d7\u02d8\7\63\2\2\u02d8\u02d9\5Z.\2\u02d9\u02da"+
		"\7\64\2\2\u02da\u02dd\3\2\2\2\u02db\u02dd\58\35\2\u02dc\u02d5\3\2\2\2"+
		"\u02dc\u02d6\3\2\2\2\u02dc\u02d7\3\2\2\2\u02dc\u02db\3\2\2\2\u02ddq\3"+
		"\2\2\2\u02de\u02df\7\24\2\2\u02df\u02e0\7\63\2\2\u02e0\u02e1\5Z.\2\u02e1"+
		"\u02e2\7\64\2\2\u02e2\u02e6\5\f\7\2\u02e3\u02e5\5v<\2\u02e4\u02e3\3\2"+
		"\2\2\u02e5\u02e8\3\2\2\2\u02e6\u02e4\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7"+
		"\u02ea\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e9\u02eb\5t;\2\u02ea\u02e9\3\2\2"+
		"\2\u02ea\u02eb\3\2\2\2\u02ebs\3\2\2\2\u02ec\u02ed\7\26\2\2\u02ed\u02ee"+
		"\5\f\7\2\u02eeu\3\2\2\2\u02ef\u02f0\7\25\2\2\u02f0\u02f1\7\63\2\2\u02f1"+
		"\u02f2\5Z.\2\u02f2\u02f3\7\64\2\2\u02f3\u02f4\5\f\7\2\u02f4w\3\2\2\2\u02f5"+
		"\u02f6\7\31\2\2\u02f6\u02f7\7\63\2\2\u02f7\u02f8\5Z.\2\u02f8\u02f9\7\64"+
		"\2\2\u02f9\u02fa\5\f\7\2\u02fay\3\2\2\2\u02fb\u02fc\7\30\2\2\u02fc\u02fd"+
		"\7\63\2\2\u02fd\u02fe\7>\2\2\u02fe\u02ff\7.\2\2\u02ff\u0300\7>\2\2\u0300"+
		"\u0301\7\64\2\2\u0301\u0302\5\f\7\2\u0302{\3\2\2\2\u0303\u0304\7\62\2"+
		"\2\u0304\u0307\7\63\2\2\u0305\u0308\7\23\2\2\u0306\u0308\5Z.\2\u0307\u0305"+
		"\3\2\2\2\u0307\u0306\3\2\2\2\u0307\u0308\3\2\2\2\u0308\u0310\3\2\2\2\u0309"+
		"\u030c\7=\2\2\u030a\u030d\7\23\2\2\u030b\u030d\5Z.\2\u030c\u030a\3\2\2"+
		"\2\u030c\u030b\3\2\2\2\u030d\u030f\3\2\2\2\u030e\u0309\3\2\2\2\u030f\u0312"+
		"\3\2\2\2\u0310\u030e\3\2\2\2\u0310\u0311\3\2\2\2\u0311\u0313\3\2\2\2\u0312"+
		"\u0310\3\2\2\2\u0313\u0314\7\64\2\2\u0314\u0315\7;\2\2\u0315}\3\2\2\2"+
		"L\u0090\u0092\u009b\u009d\u00a6\u00a8\u00b0\u00b2\u00b9\u00d2\u00db\u00e0"+
		"\u00e7\u00ee\u00f6\u00fe\u0106\u010e\u0116\u0118\u011e\u0124\u012c\u0133"+
		"\u0136\u013e\u0147\u014b\u0153\u015d\u015f\u0171\u0185\u018d\u0192\u0198"+
		"\u019d\u01ac\u01ae\u01b4\u01c6\u01db\u01e2\u01eb\u01f6\u0201\u020a\u0213"+
		"\u0217\u021d\u0236\u024a\u0257\u0268\u026a\u0279\u027b\u0286\u028c\u0294"+
		"\u029e\u02a9\u02b5\u02b7\u02bd\u02cb\u02cd\u02d3\u02dc\u02e6\u02ea\u0307"+
		"\u030c\u0310";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
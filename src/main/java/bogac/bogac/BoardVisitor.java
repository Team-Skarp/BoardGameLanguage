// Generated from C:/programs/semester4/Math-language/src/main/java/bogac\Board.g4 by ANTLR 4.9.2
package bogac.bogac;
import bogac.bogac.BoardParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BoardParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BoardVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BoardParser#game}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGame(BoardParser.GameContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(BoardParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(BoardParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#gameloop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameloop(BoardParser.GameloopContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(BoardParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#declerations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclerations(BoardParser.DeclerationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(BoardParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(BoardParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#aexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAexpr(BoardParser.AexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#addOrSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOrSub(BoardParser.AddOrSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#multDivMod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivMod(BoardParser.MultDivModContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(BoardParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(BoardParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#bexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBexpr(BoardParser.BexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#dcltype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDcltype(BoardParser.DcltypeContext ctx);
}
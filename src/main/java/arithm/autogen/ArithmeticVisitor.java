// Generated from /Users/jsaad/Documents/Github/Math-language/src/main/java/arithm/Arithmetic.g4 by ANTLR 4.9.2
package arithm.autogen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ArithmeticParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ArithmeticVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ArithmeticParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(ArithmeticParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ArithmeticParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#modulus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulus(ArithmeticParser.ModulusContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#addOrSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOrSub(ArithmeticParser.AddOrSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#multOrDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOrDiv(ArithmeticParser.MultOrDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link ArithmeticParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ArithmeticParser.AtomContext ctx);
}
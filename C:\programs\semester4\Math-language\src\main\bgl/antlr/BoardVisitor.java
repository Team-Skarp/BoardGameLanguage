// Generated from /Users/Markus/Documents/GitHub/Math-language/src/main/bgl/Board.g4 by ANTLR 4.10.1
package antlr;
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
	 * Visit a parse tree produced by {@link BoardParser#setupBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetupBlock(BoardParser.SetupBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#normalBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalBlock(BoardParser.NormalBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#rulesBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulesBlock(BoardParser.RulesBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#gameloopBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameloopBlock(BoardParser.GameloopBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#normalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalDeclaration(BoardParser.NormalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#setupDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetupDeclaration(BoardParser.SetupDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#uniqueDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniqueDeclaration(BoardParser.UniqueDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#designDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignDeclaration(BoardParser.DesignDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#designDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignDefinition(BoardParser.DesignDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#integerDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDeclaration(BoardParser.IntegerDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#sequentialDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequentialDeclaration(BoardParser.SequentialDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#booleanDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDeclaration(BoardParser.BooleanDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#stringDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDeclaration(BoardParser.StringDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#listDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDeclaration(BoardParser.ListDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#listType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(BoardParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#listElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListElement(BoardParser.ListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#pathDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPathDeclaration(BoardParser.PathDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#gridDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGridDeclaration(BoardParser.GridDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#specialDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialDeclaration(BoardParser.SpecialDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#choiceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoiceDeclaration(BoardParser.ChoiceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#actionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionDeclaration(BoardParser.ActionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#actionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionDefinition(BoardParser.ActionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#actionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionCall(BoardParser.ActionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(BoardParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(BoardParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#intAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntAssigment(BoardParser.IntAssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#booleanAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAssigment(BoardParser.BooleanAssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#stringAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAssigment(BoardParser.StringAssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#dotAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotAssignment(BoardParser.DotAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#choiceAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoiceAssignment(BoardParser.ChoiceAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#actionAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionAssignment(BoardParser.ActionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#designBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignBody(BoardParser.DesignBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#fieldRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldRow(BoardParser.FieldRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(BoardParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#primitiveValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveValue(BoardParser.PrimitiveValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(BoardParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BoardParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(BoardParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(BoardParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(BoardParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#additive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(BoardParser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#multiplicative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(BoardParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(BoardParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#unaryMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinus(BoardParser.UnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#arithmeticAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticAtom(BoardParser.ArithmeticAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#logor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogor(BoardParser.LogorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#logand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogand(BoardParser.LogandContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(BoardParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(BoardParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(BoardParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#booleanAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAtom(BoardParser.BooleanAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(BoardParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(BoardParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#elseifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifStatement(BoardParser.ElseifStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(BoardParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#foreach}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeach(BoardParser.ForeachContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(BoardParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link BoardParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(BoardParser.InputContext ctx);
}
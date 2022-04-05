package ASTvisitors;

import ASTnodes.*;
import antlr.BoardParser;
import antlr.BoardVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Class which converts antlers auto-generated CST into our desired AST
 */
public class ASTbuilder implements BoardVisitor<ASTNode> {

    @Override
    public ASTNode visitGame(BoardParser.GameContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitSetup(BoardParser.SetupContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitRules(BoardParser.RulesContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitGameloop(BoardParser.GameloopContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitSetupBlock(BoardParser.SetupBlockContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitNormalBlock(BoardParser.NormalBlockContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitNormalDeclaration(BoardParser.NormalDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitSpecialDeclaration(BoardParser.SpecialDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitChoiceDeclaration(BoardParser.ChoiceDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitActionDeclaration(BoardParser.ActionDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDesignDeclaraion(BoardParser.DesignDeclaraionContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitListDeclaration(BoardParser.ListDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitIntegerDeclaration(BoardParser.IntegerDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitBooleanDeclaration(BoardParser.BooleanDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitStringDeclaration(BoardParser.StringDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDesignBody(BoardParser.DesignBodyContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitPrimitiveType(BoardParser.PrimitiveTypeContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitFieldRow(BoardParser.FieldRowContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitFieldType(BoardParser.FieldTypeContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitFormalParameters(BoardParser.FormalParametersContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitStatements(BoardParser.StatementsContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitArithmeticExpression(BoardParser.ArithmeticExpressionContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitBooleanExpression(BoardParser.BooleanExpressionContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitAdditive(BoardParser.AdditiveContext ctx) {
        if (ctx.PLUS() != null) {
           return new PlusNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.MINUS() != null) {

            return new MinusNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.multiplicative() != null) {
            return ctx.getChild(0).accept(this);
        }
        else {
            System.out.println("Rule not found for additive");
            return null;
        }
    }

    @Override
    public ASTNode visitMultiplicative(BoardParser.MultiplicativeContext ctx) {

        if (ctx.MULT() != null) {
            return new MultNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.DIV() != null) {

            return new DivNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.MOD() != null) {

            return new ModNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.pow() != null) {
            return ctx.getChild(0).accept(this);
        }
        else {
            System.out.println("No rule found for multiplicative!");
            return null;
        }
    }

    @Override
    public ASTNode visitPow(BoardParser.PowContext ctx) {

        if (ctx.EXP() != null) {
            return new PowNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.arithmeticAtom() != null) {

            return ctx.getChild(0).accept(this);
        }
        else {
            System.out.println("No rule found for power!");
            return null;
        }
    }

    @Override
    public ASTNode visitArithmeticAtom(BoardParser.ArithmeticAtomContext ctx) {

        if (ctx.INT() != null) {
            return new IntNode(Integer.parseInt(ctx.INT().getText()));
        }
        else if (ctx.IDENTIFIER() != null) {
            return new IdNode(ctx.IDENTIFIER().getText(), "ID");
        }
        return null;
    }

    @Override
    public ASTNode visitLogor(BoardParser.LogorContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitLogand(BoardParser.LogandContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitEquality(BoardParser.EqualityContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitRelational(BoardParser.RelationalContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitBooleanAtom(BoardParser.BooleanAtomContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitIfstmnt(BoardParser.IfstmntContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitElsestmnt(BoardParser.ElsestmntContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitWhilestmnt(BoardParser.WhilestmntContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitForeach(BoardParser.ForeachContext ctx) {
        return null;
    }

    @Override
    public ASTNode visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public ASTNode visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public ASTNode visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public ASTNode visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}

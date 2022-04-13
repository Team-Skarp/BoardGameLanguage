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
        return ctx.setupBlock().accept(this);
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
    public ASTNode visitGameloopBlock(BoardParser.GameloopBlockContext ctx) { return  null;}

    @Override
    public ASTNode visitSetupBlock(BoardParser.SetupBlockContext ctx) {
        BlockNode block = new BlockNode();

        for (ParseTree node : ctx.children) {
            ASTNode astNode = node.accept(this);

            if (astNode != null) {

                block.children.add(astNode);
            }
        }

        System.out.println(block.children);
        return block;

    }

    @Override
    public ASTNode visitNormalBlock(BoardParser.NormalBlockContext ctx) {
        BlockNode block = new BlockNode();

        //Loop through every ast node and add it as child to block node
        for (ParseTree node : ctx.children) {
            ASTNode astNode = node.accept(this);

            if (astNode != null) {

                block.children.add(astNode);
            }
        }

        System.out.println(block.children);
        return block;
    }

    @Override
    public ASTNode visitNormalDeclaration(BoardParser.NormalDeclarationContext ctx) {
        if (ctx.integerDeclaration() != null) {
            return ctx.integerDeclaration().accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitSetupDeclaration(BoardParser.SetupDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitRulesBlock(BoardParser.RulesBlockContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitUniqueDeclaration(BoardParser.UniqueDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDesignDeclaration(BoardParser.DesignDeclarationContext ctx) {
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
    public ASTNode visitAssignmentStatement(BoardParser.AssignmentStatementContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitIntAssigment(BoardParser.IntAssigmentContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitBooleanAssigment(BoardParser.BooleanAssigmentContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitStringAssigment(BoardParser.StringAssigmentContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDotAssignment(BoardParser.DotAssignmentContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitChoiceAssignment(BoardParser.ChoiceAssignmentContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitActionAssignment(BoardParser.ActionAssignmentContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitListDeclaration(BoardParser.ListDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitPathDeclaration(BoardParser.PathDeclarationContext ctx) {
        if (ctx.IDENTIFIER() != null && ctx.INT() != null) {
            if (ctx.UNI_DIR() != null) {
                return new PathDeclarationNode(
                        new IdNode(ctx.IDENTIFIER().get(0).getText(), "path"),
                        Integer.parseInt(ctx.INT().getText()),
                        ctx.UNI_DIR().getText()
                );
            } else if (ctx.BI_DIR() != null) {
                return new PathDeclarationNode(
                        new IdNode(ctx.IDENTIFIER().get(0).getText(), "path"),
                        Integer.parseInt(ctx.INT().getText()),
                        ctx.BI_DIR().getText()
                );
            } else if (ctx.STATIC_DIR() != null) {
                return new PathDeclarationNode(
                        new IdNode(ctx.IDENTIFIER().get(0).getText(), "path"),
                        Integer.parseInt(ctx.INT().getText()),
                        ctx.STATIC_DIR().getText()
                );
            } else {
                return new PathDeclarationNode(
                        new IdNode(ctx.IDENTIFIER().get(0).getText(), "path"),
                        Integer.parseInt(ctx.INT().getText())
                );
            }
        } else {
            return null;
        }
    }

    @Override
    public ASTNode visitGridDeclaration(BoardParser.GridDeclarationContext ctx) {
        if (ctx.IDENTIFIER() != null && ctx.INT().get(0) != null && ctx.INT().get(1) != null) {
            return new GridDeclarationNode(
                    new IdNode(ctx.IDENTIFIER().get(0).getText(), "grid"),
                    Integer.parseInt(ctx.INT().get(0).getText()),
                    Integer.parseInt(ctx.INT().get(1).getText())
            );
        } else {
            return null;
        }
    }

    @Override
    public ASTNode visitIntegerDeclaration(BoardParser.IntegerDeclarationContext ctx) {
        if (ctx.ASSIGN() != null && ctx.COMMA() != null) {
            return null; //Not implemented
        }
        else if (ctx.ASSIGN() != null) {
            return new IntegerAssignDeclarationNode(new IdNode(ctx.IDENTIFIER().getText(), "int"), ctx.arithmeticExpression().accept(this));
        }
        else if (ctx.IDENTIFIER() != null && ctx.COMMA() != null) {
            return null; //Not implemented
        }
        else if (ctx.IDENTIFIER() != null) {
            return new IntegerDeclarationNode(new IdNode(ctx.IDENTIFIER().getText(), "int"));
        }

        return null;
    }

    //TODO: check for correct capitalization of true and false
    @Override
    //TODO: change "bool" to booldcl
    public ASTNode visitBooleanDeclaration(BoardParser.BooleanDeclarationContext ctx) {
        if (ctx.booleanExpression() != null) {
            System.out.println("1");
            return new BooleanDeclarationNode(
                    new IdNode(ctx.IDENTIFIER().getText(),"bool"),
                    ctx.getChild(3).accept(this)
            );
        } else if (ctx.BOOLDCL() != null && ctx.IDENTIFIER() != null) {
            return new BooleanDeclarationNode(
                    new IdNode(ctx.IDENTIFIER().getText(),"bool")
            );
        }
        return null;
    }

    @Override
    public ASTNode visitStringDeclaration(BoardParser.StringDeclarationContext ctx) {

        // Check if string exists
        if (ctx.STRING() != null) {
            return new StringDeclarationNode(
                    ctx.STRDCL().getText(),
                    ctx.IDENTIFIER().getText(),
                    ctx.ASSIGN().getText(),
                    ctx.STRING().getText()
            );
        }

        // Check if only strdcl and identifier exists
        else if (ctx.STRDCL() != null && ctx.IDENTIFIER() != null) {
            return new StringDeclarationNode(
                    ctx.STRDCL().getText(),
                    ctx.IDENTIFIER().getText()
            );
        }

        // Guard return null
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
    public ASTNode visitFormalParameters(BoardParser.FormalParametersContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitStatements(BoardParser.StatementsContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitArithmeticExpression(BoardParser.ArithmeticExpressionContext ctx) {
        if (ctx.additive() != null){
            return ctx.getChild(0).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitBooleanExpression(BoardParser.BooleanExpressionContext ctx) {
        if (ctx.logor() != null){
            return ctx.getChild(0).accept(this);
        }
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
        }else if(ctx.arithmeticExpression() != null){
            return ctx.getChild(1).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitLogor(BoardParser.LogorContext ctx) {
        if (ctx.OR() != null) {
            return new OrNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.logand() != null) {

            return ctx.getChild(0).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitLogand(BoardParser.LogandContext ctx) {
        if (ctx.AND() != null) {
            return new AndNode(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
        }
        else if (ctx.equality() != null) {

            return ctx.getChild(0).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitEquality(BoardParser.EqualityContext ctx) {
        if (ctx.EQL() != null){
            return new EqualNode(ctx.getChild(0).accept(this),ctx.getChild(2).accept(this));
        }
        else if (ctx.NEQL() != null){
            return new NotEqualNode(ctx.getChild(0).accept(this),ctx.getChild(2).accept(this));
        }
        else if (ctx.relational() != null){
            return ctx.getChild(0).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitRelational(BoardParser.RelationalContext ctx) {
        if (ctx.GTHEQL() != null){
            return new GreaterThanEqualsNode(ctx.getChild(0).accept(this),ctx.getChild(2).accept(this));
        }
        else if (ctx.LTHEQL() != null){
            return new LessThanEqualsNode(ctx.getChild(0).accept(this),ctx.getChild(2).accept(this));
        }
        else if (ctx.GTH() != null){
            return new GreaterThanNode(ctx.getChild(0).accept(this),ctx.getChild(2).accept(this));
        }
        else if (ctx.LTH() != null){
            return new LessThanNode(ctx.getChild(0).accept(this),ctx.getChild(2).accept(this));
        }
        else if (ctx.arithmeticExpression() != null){
            return ctx.getChild(0).accept(this);
        }
        else if (ctx.negation() != null){
            return ctx.getChild(0).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitNegation(BoardParser.NegationContext ctx) {
        if(ctx.NOT() != null){
            return new NegationNode(ctx.getChild(1).accept(this));
        }else if (ctx.booleanAtom() != null){
            return ctx.getChild(0).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitBooleanAtom(BoardParser.BooleanAtomContext ctx) {
        if (ctx.BOOL() != null){
            return new BooleanNode(Boolean.parseBoolean(ctx.BOOL().getText()));
        }else if (ctx.IDENTIFIER() != null) {
            return new IdNode(ctx.IDENTIFIER().getText(), "ID");
        }else if(ctx.booleanExpression() != null){
            return ctx.getChild(1).accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitIfStatement(BoardParser.IfStatementContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitElseStatement(BoardParser.ElseStatementContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitWhileStatement(BoardParser.WhileStatementContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitForeach(BoardParser.ForeachContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitPrint(BoardParser.PrintContext ctx) {
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

package ASTvisitors;

import ASTnodes.*;
import SymbolTable.TypeErrorException;
import antlr.BoardParser;
import antlr.BoardVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import SymbolTable.types.*;
import Logging.Logger;

import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

/**
 * Class which converts antlers auto-generated CST into our desired AST
 */
public class ASTbuilder implements BoardVisitor<ASTNode> {

    Logger lo = new Logger();

    @Override
    public ASTNode visitGame(BoardParser.GameContext ctx) {
        if(ctx.setup() != null && ctx.rules() != null && ctx.gameloop() != null){
            return new GameNode(
                    ctx.setup().accept(this),
                    ctx.rules().accept(this),
                    ctx.gameloop().accept(this)
            );
        }
        return null;
    }

    @Override
    public ASTNode visitSetup(BoardParser.SetupContext ctx) {
        if(ctx.setupBlock() != null){
            return ctx.setupBlock().accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitRules(BoardParser.RulesContext ctx) {
        if(ctx.rulesBlock() != null){
            return ctx.rulesBlock().accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitGameloop(BoardParser.GameloopContext ctx) {
        if(ctx.gameloopBlock() != null){
            return ctx.gameloopBlock().accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitGameloopBlock(BoardParser.GameloopBlockContext ctx) {

        List<ASTNode> children = new ArrayList<>();

        for (ParseTree node : ctx.children) {
            ASTNode astNode = node.accept(this);
            if (astNode != null) {
                children.add(astNode);
            }
        }

        return new BlockNode(children.toArray(new ASTNode[0]));
    }

    @Override
    public ASTNode visitSetupBlock(BoardParser.SetupBlockContext ctx) {

        List<ASTNode> children = new ArrayList<>();

        for (ParseTree node : ctx.children) {
            ASTNode astNode = node.accept(this);
            if (astNode != null) {
                children.add(astNode);
            }
        }

        return new BlockNode(children.toArray(new ASTNode[0]));

    }

    @Override
    public ASTNode visitNormalBlock(BoardParser.NormalBlockContext ctx) {
        lo.g(ctx.children);
        List<ASTNode> children = new ArrayList<>();

        for (ParseTree node : ctx.children) {
            ASTNode astNode = node.accept(this);
            if (astNode != null) {
                children.add(astNode);
            }
        }

        return new BlockNode(children.toArray(new ASTNode[0]));
    }

    @Override
    public ASTNode visitNormalDeclaration(BoardParser.NormalDeclarationContext ctx) {
        if (ctx.integerDeclaration() != null) {
            return ctx.integerDeclaration().accept(this);
        }
        else if(ctx.booleanDeclaration() != null) {
            return ctx.booleanDeclaration().accept(this);
        }
        else if (ctx.stringDeclaration() != null) {
            return ctx.stringDeclaration().accept(this);
        }
        else if (ctx.listDeclaration() != null) {
            return ctx.listDeclaration().accept(this);
        }
        else if (ctx.designDeclaration() != null) {
            return ctx.designDeclaration().accept(this);
        }
        else if (ctx.sequentialDeclaration() != null) {
            return ctx.sequentialDeclaration().accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitSetupDeclaration(BoardParser.SetupDeclarationContext ctx) {
        if (ctx.getChild(0) != null) {
            return ctx.getChild(0).accept(this);
        }
        return null;
    }

    @Override
    public ASTNode visitRulesDeclaration(BoardParser.RulesDeclarationContext ctx) {
        if (ctx.actionDefinition() != null) {
            return ctx.actionDefinition().accept(this);
        }
        else if (ctx.specialDeclaration() != null) {
            throw new RuntimeException("Specials is not implemented in the current version");
        }
        else if (ctx.choiceDeclaration() != null) {
            throw new RuntimeException("Choice is not implemented in the current version");
        }
        return null;
    }

    @Override
    public ASTNode visitRulesBlock(BoardParser.RulesBlockContext ctx) {

        List<ASTNode> children = new ArrayList<>();

        for (ParseTree node : ctx.children) {
            ASTNode astNode = node.accept(this);
            if (astNode != null) {
                children.add(astNode);
            }
        }

        return new BlockNode(children.toArray(new ASTNode[0]));
    }

    @Override
    public ASTNode visitDesignDeclaration(BoardParser.DesignDeclarationContext ctx) {
        return new DesignDeclarationNode(
                ctx.IDENTIFIER(0).getText(),
                ctx.IDENTIFIER(1).getText()
        );

    }

    @Override
    public ASTNode visitDesignDefinition(BoardParser.DesignDefinitionContext ctx) {

        List<Declaration> fields = new ArrayList<>();

        for (ParseTree field : ctx.designBody().fieldRow()) {
            fields.add((Declaration) field.accept(this));
        }

        if (ctx.FROM() != null) {
            return new DesignDefinitionNode(
                    new IdNode(ctx.IDENTIFIER(0).getText()),
                    new IdNode(ctx.IDENTIFIER(1).getText()),
                    fields.toArray(new Declaration[0])
            );
        }
        else {
            return new DesignDefinitionNode(
                    new IdNode(ctx.IDENTIFIER(0).getText()),
                    fields.toArray(new Declaration[0])
            );
        }

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
        //Spawn new ActionDeclartionNode()
        //TODO: Implement
        return null;
    }

    @Override
    public ASTNode visitActionDefinition(BoardParser.ActionDefinitionContext ctx) {

        //For each formal parameter create declaration
        List<Declaration> formalParameters = new ArrayList<>();
        for (BoardParser.FormalParameterContext fp : ctx.formalParameter()) {
            formalParameters.add((Declaration) fp.accept(this));
        }
        
        if (ctx.type() != null) {
            //return action def with params & type
            return new ActionDefinitionNode(
                    ctx.IDENTIFIER().getText(),
                    getType(ctx.type()),
                    new ParameterBlock(
                            ((BlockNode) ctx.normalBlock().accept(this)).children.toArray(new ASTNode[0])
                    ),
                    formalParameters.toArray(new Declaration[0])
            );
        }
        else {
            //return action def with void type
            return new ActionDefinitionNode(
                    ctx.IDENTIFIER().getText(),
                    new VoidType(),
                    new ParameterBlock(
                            ((BlockNode) ctx.normalBlock().accept(this)).children.toArray(new ASTNode[0])
                    ),
                    formalParameters.toArray(new Declaration[0])
            );
        }
        
    }

    @Override
    public ASTNode visitReturnStatement(BoardParser.ReturnStatementContext ctx) {

        return new ReturnNode(
                (Expression) ctx.expression().accept(this)
        );

    }

    @Override
    public ASTNode visitActionCall(BoardParser.ActionCallContext ctx) {
        return null;
        //TODO: Missing
    }

    @Override
    public ASTNode visitFieldAccess(BoardParser.FieldAccessContext ctx) {

        if (ctx.IDENTIFIER() != null) {
            IdNode origin = new IdNode(ctx.IDENTIFIER(0).toString());
            List<String> fieldIds = new ArrayList<>();

            for (int i = 1; i < ctx.children.size(); i++) {
                fieldIds.add(ctx.getChild(i).getText());
            }
            return new FieldAccessNode(origin, fieldIds);
        } else {
            return null;
        }
    }

    @Override
    public ASTNode visitType(BoardParser.TypeContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitAssignmentStatement(BoardParser.AssignmentStatementContext ctx) {
        if(ctx.children != null){
            return ctx.getChild(0).accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitIntAssigment(BoardParser.IntAssigmentContext ctx) {

        if (ctx.ASSIGN() != null) {
            return new IntegerAssignmentNode(
                    new IdNode(ctx.IDENTIFIER().getText()),
                    (ArithmeticExpression) ctx.arithmeticExpression().accept(this)
            );
        }

        return null;
    }

    @Override
    public ASTNode visitBooleanAssigment(BoardParser.BooleanAssigmentContext ctx) {

        if (ctx.ASSIGN() != null) {
            return new BooleanAssignmentNode(
                    ctx.IDENTIFIER().getText(),
                    (BooleanExpression) ctx.booleanExpression().accept(this)
            );
        }

        return null;
    }

    @Override
    public ASTNode visitStringAssigment(BoardParser.StringAssigmentContext ctx) {
        if (ctx.ASSIGN() != null) {
            return new StringAssignmentNode(
              ctx.IDENTIFIER().getText(),
              ctx.STR().getText());
        }
        //old ctx.STR().accept(this).toString());

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
    public ASTNode visitDesignAssignment(BoardParser.DesignAssignmentContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitListDeclaration(BoardParser.ListDeclarationContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitListType(BoardParser.ListTypeContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitListElement(BoardParser.ListElementContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitPathDeclaration(BoardParser.PathDeclarationContext ctx) {

        if (ctx.IDENTIFIER() != null && ctx.INT() != null) {
            if (ctx.UNI_DIR() != null) {
                return new PathDeclarationNode(
                        ctx.IDENTIFIER().get(0).getText(),
                        Integer.parseInt(ctx.INT().getText()),
                        ctx.UNI_DIR().getText()
                );
            }
            else if (ctx.BI_DIR() != null) {
                return new PathDeclarationNode(
                        ctx.IDENTIFIER().get(0).getText(),
                        Integer.parseInt(ctx.INT().getText()),
                        ctx.BI_DIR().getText()
                );
            }
            else if (ctx.STATIC_DIR() != null) {
                return new PathDeclarationNode(
                        ctx.IDENTIFIER().get(0).getText(),
                        Integer.parseInt(ctx.INT().getText()),
                        ctx.STATIC_DIR().getText()
                );
            }
            else {
                return new PathDeclarationNode(
                        ctx.IDENTIFIER().get(0).getText(),
                        Integer.parseInt(ctx.INT().getText())
                );
            }
        }

        return null;
    }

    @Override
    public ASTNode visitGridDeclaration(BoardParser.GridDeclarationContext ctx) {

        if (
                ctx.IDENTIFIER() != null &&
                ctx.INT().get(0) != null &&
                ctx.INT().get(1) != null
        ) {
            return new GridDeclarationNode(
                    ctx.IDENTIFIER().get(0).getText(),
                    Integer.parseInt(ctx.INT().get(0).getText()),
                    Integer.parseInt(ctx.INT().get(1).getText())
            );
        }

        return null;
    }

    @Override
    public ASTNode visitIntegerDeclaration(BoardParser.IntegerDeclarationContext ctx) {

        if (ctx.ASSIGN() != null) {
            return new IntegerDeclarationNode(
                    ctx.getChild(0).getText(),
                    ctx.getChild(2).accept(this));
        }

        else if (ctx.IDENTIFIER() != null) {
            return new IntegerDeclarationNode(
                    ctx.getChild(0).getText()
            );
        }
        return null;
    }

    @Override
    public ASTNode visitSequentialDeclaration(BoardParser.SequentialDeclarationContext ctx) {

        List<Declaration>       declarations = new ArrayList<>();
        SequentiallyDeclared    type;

        if (ctx.INTDCL() != null) {
            type = new IntType();
            for (BoardParser.IntegerDeclarationContext node : ctx.integerDeclaration()) {
                declarations.add( (Declaration) node.accept(this) );
            }
        }
        else if (ctx.BOOLDCL() != null) {
            type = new BoolType();
            for (BoardParser.BooleanDeclarationContext node : ctx.booleanDeclaration()) {
                declarations.add( (Declaration) node.accept(this) );
            }
        }
        else if (ctx.STRDCL() != null) {
            type = new StringType();
            for (BoardParser.StringDeclarationContext node : ctx.stringDeclaration()) {
                declarations.add( (Declaration) node.accept(this) );
            }
        }
        else if (ctx.designDeclaration() != null) {
            type = new DesignRef(ctx.designDeclaration().IDENTIFIER(0).getText());

            for (BoardParser.StringDeclarationContext node : ctx.stringDeclaration()) {
                declarations.add( (Declaration) node.accept(this) );
            }
        }
        else {
            throw new RuntimeException("failed to run sequential declaration");
        }

        return new SequentialDeclaration(type, declarations.toArray(new Declaration[0]));
    }

    //TODO: check for correct capitalization of true and false
    //TODO: change "bool" to booldcl
    @Override
    public ASTNode visitBooleanDeclaration(BoardParser.BooleanDeclarationContext ctx) {

        if(ctx.IDENTIFIER() != null && ctx.ASSIGN() != null){
            return new BooleanDeclarationNode(
                    ctx.getChild(0).getText(),
                    ctx.getChild(2).accept(this));
        }
        else if(ctx.IDENTIFIER() != null){
            return new BooleanDeclarationNode(ctx.getChild(0).getText());
        }
        return null;
    }

    @Override
    public ASTNode visitStringDeclaration(BoardParser.StringDeclarationContext ctx) {
        if(ctx.IDENTIFIER() != null && ctx.ASSIGN() != null){
            return new StringDeclarationNode(
                    ctx.getChild(0).getText(),
                    new StringNode(ctx.STR().getText()));
        }
        else if(ctx.IDENTIFIER() != null){
            return new StringDeclarationNode(ctx.getChild(0).getText());
        }

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
    public ASTNode visitPrimitiveValue(BoardParser.PrimitiveValueContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitFormalParameter(BoardParser.FormalParameterContext ctx) {
        
        TypeDenoter paramType = getType(ctx.type());
        String      paramName = ctx.IDENTIFIER().getText();

        if (paramType instanceof IntType) {
            return new IntegerDeclarationNode(paramName);
        }
        else if (paramType instanceof StringType) {
            return new StringDeclarationNode(paramName);
        }
        else if (paramType instanceof BoolType) {
            return new BooleanDeclarationNode(paramName);
        }
        else if (paramType instanceof DesignRef design) {
            return new DesignDeclarationNode(design.name, paramName);
        }
        else if (paramType instanceof ListType list) {
            return new ListDeclarationNode(list.elementType, paramName);
        }
        else {
            throw new TypeErrorException("type %s is not suitable as a parameter type".formatted(
                    paramType
            ));
        }
    }

    @Override
    public ASTNode visitFieldRow(BoardParser.FieldRowContext ctx) {

        if (ctx.INTDCL() != null) {
            return new IntegerDeclarationNode(ctx.IDENTIFIER(0).getText());
        }
        else if (ctx.BOOLDCL() != null) {
            return new BooleanDeclarationNode(ctx.IDENTIFIER(0).getText());
        }
        else if (ctx.STRDCL() != null) {
            return new StringDeclarationNode(ctx.IDENTIFIER(0).getText());
        }
        else if (ctx.LISTDCL() != null) {
            return new ListDeclarationNode(
                    getListType(ctx.listType()),
                    ctx.IDENTIFIER(0).getText());
        }
        else if (ctx.IDENTIFIER(0) != null && ctx.IDENTIFIER(1) != null) {
            return new DesignDeclarationNode(
                    ctx.IDENTIFIER(0).getText(),
                    ctx.IDENTIFIER(1).getText()
            );
        }

        return null;
    }

    /**
     * Returns a list type object that allows nesting of list types
     */
    private TypeDenoter getListType(BoardParser.ListTypeContext listTypeCTX) {

        if (listTypeCTX.INTDCL() != null) {
            return new IntType();
        }
        else if (listTypeCTX.BOOLDCL() != null) {
            return new BoolType();
        }
        else if (listTypeCTX.STRDCL() != null) {
            return new StringType();
        }
        else if (listTypeCTX.IDENTIFIER() != null) {
            return new DesignRef(listTypeCTX.IDENTIFIER().getText());
        }

        //If we have nested list types we recursively call getListType on whatever the listtype is
        else if (listTypeCTX.listType() != null) {
            return new ListType(getListType(listTypeCTX.listType()));
        }
        else {
            return null;
        }
    }

    /**
     * Maps the grammer for a type to a Type Denoter
     * @param type Type grammer rule
     * @return TypeDenoter
     */
    private TypeDenoter getType(BoardParser.TypeContext type) {

        if (type.INTDCL() != null) {
            return new IntType();
        }
        else if (type.BOOLDCL() != null) {
            return new BoolType();
        }
        else if (type.STRDCL() != null) {
            return new StringType();
        }
        else if (type.IDENTIFIER() != null) {
            return new DesignRef(type.IDENTIFIER().getText());
        }
        //If we have nested list types we recursively call getListType on whatever the listtype is
        else if (type.listType() != null) {
            return new ListType(getListType(type.listType()));
        }
        else {
            return null;
        }
    }

    @Override
    public ASTNode visitStatement(BoardParser.StatementContext ctx) {

        if (ctx.ifStatement() != null) {
            return ctx.ifStatement().accept(this);
        }
        else if (ctx.whileStatement() != null) {
            return ctx.whileStatement().accept(this);
        }
        else if (ctx.foreach() != null) {
            return ctx.foreach().accept(this);
        }
        else if (ctx.assignmentStatement() != null) {
            return ctx.assignmentStatement().accept(this);
        }
        else if (ctx.print() != null) {
            return ctx.print().accept(this);
        }
        else if (ctx.expression() != null) {
            return ctx.expression().accept(this);
        }else if(ctx.input() != null){
            return ctx.input().accept(this);
        }
        else if (ctx.returnStatement() != null) {
            return ctx.returnStatement().accept(this);
        }
        //TODO: Action call statements should go here

        return null;
    }

    @Override
    public ASTNode visitExpression(BoardParser.ExpressionContext ctx) {
        if (ctx.booleanExpression() != null) {
            return ctx.booleanExpression().accept(this);
        }

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
           return new PlusNode(
                   ctx.getChild(0).accept(this),
                   ctx.getChild(2).accept(this)
           );
        }
        else if (ctx.MINUS() != null) {
            return new MinusNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
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
            return new MultNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.DIV() != null) {

            return new DivNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.MOD() != null) {

            return new ModNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
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
            return new PowNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.unaryMinus() != null) {
            return ctx.getChild(0).accept(this);
        }
        else {
            System.out.println("No rule found for power!");
            return null;
        }
    }

    @Override
    public ASTNode visitUnaryMinus(BoardParser.UnaryMinusContext ctx) {

        if(ctx.MINUS() != null){
            return new UnaryMinusNode(ctx.getChild(1).accept(this));
        }
        else if(ctx.arithmeticAtom() != null){
            return ctx.getChild(0).accept(this);
        }
        else {
            System.out.println("No rule found for unary minus!");
            return null;
        }
    }

    @Override
    public ASTNode visitArithmeticAtom(BoardParser.ArithmeticAtomContext ctx) {

        if (ctx.INT() != null) {
            return new IntNode(Integer.parseInt(ctx.INT().getText()));
        }
        else if (ctx.IDENTIFIER() != null) {
            return new IdNode(ctx.IDENTIFIER().getText());
        }
        else if(ctx.arithmeticExpression() != null){
            return ctx.arithmeticExpression().accept(this);
        }
        else if(ctx.fieldAccess() != null){
            return ctx.fieldAccess().accept(this);
        }
        //Todo: missing impl for action call
        return null;
    }

    @Override
    public ASTNode visitLogor(BoardParser.LogorContext ctx) {
        if (ctx.OR() != null) {
            return new OrNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.logand() != null) {
            return ctx.getChild(0).accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitLogand(BoardParser.LogandContext ctx) {
        if (ctx.AND() != null) {
            return new AndNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.equality() != null) {
            return ctx.getChild(0).accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitEquality(BoardParser.EqualityContext ctx) {
        if (ctx.EQL() != null){
            return new EqualNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.NEQL() != null){
            return new NotEqualNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.relational() != null){
            return ctx.getChild(0).accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitRelational(BoardParser.RelationalContext ctx) {
        if (ctx.GTHEQL() != null){
            return new GreaterThanEqualsNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.LTHEQL() != null){
            return new LessThanEqualsNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.GTH() != null){
            return new GreaterThanNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
        }
        else if (ctx.LTH() != null){
            return new LessThanNode(
                    ctx.getChild(0).accept(this),
                    ctx.getChild(2).accept(this)
            );
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
        }
        else if (ctx.booleanAtom() != null){
            return ctx.getChild(0).accept(this);
        }

        return null;
    }

    @Override
    public ASTNode visitBooleanAtom(BoardParser.BooleanAtomContext ctx) {
        if (ctx.BOOL() != null){
            return new BooleanNode(Boolean.parseBoolean(ctx.BOOL().getText()));
        }
        else if (ctx.IDENTIFIER() != null) {
            return new IdNode(ctx.IDENTIFIER().getText());
        }
        else if(ctx.booleanExpression() != null){
            return ctx.getChild(1).accept(this);
        }
        //Todo: missing impl for action call
        return null;
    }



    @Override
    public ASTNode visitIfStatement(BoardParser.IfStatementContext ctx) {
        if (ctx.booleanExpression() != null && ctx.normalBlock() != null){
            //loop to get all elseif blocks
            List<ASTNode> elseifBlocks = new ArrayList<>();

            //Loop through every ast node and add it as child to block node
            for (ParseTree node : ctx.children) {
                ASTNode astNode = node.accept(this);
                ElifConditionalNode elifConditionalNode = new ElifConditionalNode(); //created to test class type of astNode
                if (astNode != null && astNode.getClass() == elifConditionalNode.getClass()) {
                    //block.children.add(astNode);
                    elseifBlocks.add(astNode);
                }

            }
            //if elseif else
            if (ctx.elseStatement() != null && ctx.elseifStatement() != null){
                return new ConditionalNode(
                        ctx.getChild(2).accept(this),
                        ctx.getChild(4).accept(this),
                        elseifBlocks,
                        ctx.getChild(ctx.children.size()-1).getChild(1).accept(this)
                );
            }
            //if else
            else if (ctx.elseStatement() != null){
                return new ConditionalNode(
                        ctx.getChild(2).accept(this),
                        ctx.getChild(4).accept(this),
                        ctx.getChild(ctx.children.size()-1).getChild(1).accept(this)
                );
            }
            //if elseif
            else if (ctx.elseifStatement() != null){
                return new ConditionalNode(
                        ctx.getChild(2).accept(this),
                        ctx.getChild(4).accept(this),
                        elseifBlocks);
            }
            //if
            else{
                return new ConditionalNode(
                        ctx.getChild(2).accept(this),
                        ctx.getChild(4).accept(this)
                );
            }
        }

        return null;
    }

    @Override
    public ASTNode visitElseStatement(BoardParser.ElseStatementContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitElseifStatement(BoardParser.ElseifStatementContext ctx) {

        if(ctx.booleanExpression() != null && ctx.normalBlock() != null){
            return new ElifConditionalNode(
                    ctx.getChild(2).accept(this),
                    ctx.getChild(4).accept(this)
            );
        }

        return null;
    }

    @Override
    public ASTNode visitWhileStatement(BoardParser.WhileStatementContext ctx) {

        if(ctx.booleanExpression() != null && ctx.normalBlock() != null){
            return new WhileNode(
                    ctx.getChild(2).accept(this),
                    ctx.getChild(4).accept(this)
            );
        }

        return null;
    }

    @Override
    public ASTNode visitForeach(BoardParser.ForeachContext ctx) {

        return new ForeachNode(
                new IdNode(ctx.IDENTIFIER(0).getText()),
                new IdNode(ctx.IDENTIFIER(1).getText()),
                new ParameterBlock(
                        ((BlockNode) ctx.normalBlock().accept(this))
                                .children
                                .toArray(new ASTNode[0])
                )
        );
    }

    @Override
    public ASTNode visitPrint(BoardParser.PrintContext ctx) {

        if(ctx.PRINT() != null){
            List<ASTNode> prints = new ArrayList<>();

            //TODO Fix for loop
            for (int i = 0; i < ctx.children.size()-4; i+=2){
                ASTNode astNode = ctx.getChild(i+2).accept(this);
                //if astnode is null, that means its a simple string
                if(astNode == null){
                    prints.add(new StringNode(ctx.getChild(i+2).getText()));
                } else {
                    prints.add(astNode);
                }
            }
            return new PrintNode(prints);
        }

        return null;
    }

    @Override
    public ASTNode visitInput(BoardParser.InputContext ctx) {

        if(ctx.IDENTIFIER() != null) {
            return new InputNode(new IdNode(ctx.IDENTIFIER().getText()));
        }
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

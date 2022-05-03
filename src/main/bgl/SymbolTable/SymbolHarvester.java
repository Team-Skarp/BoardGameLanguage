package SymbolTable;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import SymbolTable.types.*;


/**
 * Class used to handle declarations and definitions to do contextual analysis
 */
public class SymbolHarvester implements ASTvisitor<SymbolTable> {

    SymbolTable ST;
    TypeEnvironment TENV;
    TypeChecker TC;

    public SymbolHarvester() {
        this.ST = new SymbolTable();
        this.TENV = new TypeEnvironment();
    }

    @Override
    public SymbolTable visit(GameNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(Expression n) {
        return null;
    }

    @Override
    public SymbolTable visit(ArithmeticExpression n) {
        return null;
    }

    @Override
    public SymbolTable visit(PlusNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(MinusNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(UnaryMinusNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(MultNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(DivNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(ModNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(PowNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(IdNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(IntNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(EqualNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(NotEqualNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(LessThanNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(GreaterThanNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(GreaterThanEqualsNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(LessThanEqualsNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(BooleanNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(NegationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(OrNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(AndNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(BlockNode n) {
        ST.openScope();

        //Visit all children of block node
        for (ASTNode node : n.children) {

            node.accept(this);
        }

        ST.closeScope();

        return ST;
    }

    @Override
    public SymbolTable visit(ActionBodyNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(Assignment n) {
        return visit(n);
    }

    @Override
    public SymbolTable visit(DesignDefinitionNode n) {

        //Create a seperate symbol table that resides in the design type
        SymbolTable fields = new SymbolTable();

        //Write in all the declarations into that symboltable
        Symbol sym;

        for (Declaration field : n.fields) {
            sym = new Symbol(field.varName(), field.type());
            fields.enterSymbol(sym);
        }

        //Save design type inside type environment
        DesignType type;

        if (n.parentType == null) {
            type = new DesignType(
                    n.typeDefinition.name,
                    fields
            );
        }
        else {
            type = new DesignType(
                    n.typeDefinition.name,
                    n.parentType.name,
                    fields
            );
        }

        TENV.enterType(type);

        return ST;

    }

    @Override
    public SymbolTable visit(ActionDefinitionNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(Declaration n) {
        n.accept(this);
        return ST;
    }

    @Override
    public SymbolTable visit(ActionDeclarationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(DesignDeclarationNode n) {

        //Check that the type is actually defined in the type environment
        TC = new TypeChecker(ST, TENV);
        TC.visit(n);

        Symbol sym = new Symbol(
                n.name,
                new DesignRef(n.name));

        ST.enterSymbol(sym);
        return ST;
    }

    @Override
    public SymbolTable visit(SequentialDeclaration n) {

        TC = new TypeChecker(ST, TENV);

        for (Declaration declaration : n.declarations) {

            //Check that every declaration adheres to scope rules
            declaration.accept(TC);

            ST.enterSymbol(new Symbol(
                    declaration.varName(),
                    n.type));
        }

        return ST;
    }

    @Override
    public SymbolTable visit(StringNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(BooleanExpression n) {
        return null;
    }

    @Override
    public SymbolTable visit(IntegerDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(IntegerAssignDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(BooleanDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(StringDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(PathDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(PathTypedDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(GridDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(GridTypedDeclarationNode n) {

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(ConditionalNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(ElifConditionalNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(ElseNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(PredicateNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(WhileNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(ForeachNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(PrintNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(ActionCallNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(ReturnNode n) {
        return null;
    }
}

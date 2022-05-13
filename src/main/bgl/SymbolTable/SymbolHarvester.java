package SymbolTable;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import SymbolTable.types.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Class used to handle declarations and definitions to do contextual analysis
 */
public class SymbolHarvester implements ASTvisitor<SymbolTable> {

    SymbolTable ST;
    public TypeEnvironment TENV;
    TypeChecker TC;

    // Blank SymbolHarvester
    public SymbolHarvester() {
        this.ST = new SymbolTable();
        this.TENV = new TypeEnvironment();
    }

    // Received after precompiling BGL standard library
    public SymbolHarvester(SymbolTable ST, TypeEnvironment TENV) {
        this.ST = ST;
        this.TENV = TENV;
    }

    @Override
    public SymbolTable visit(GameNode n) {
        n.setup.accept(this);
        n.rules.accept(this);
        n.gameloop.accept(this);

        return ST;
    }

    @Override
    public SymbolTable visit(Expression n) {
        return ST;
    }

    @Override
    public SymbolTable visit(ArithmeticExpression n) {
        return ST;
    }

    @Override
    public SymbolTable visit(PlusNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(MinusNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(UnaryMinusNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(MultNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(DivNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(ModNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(PowNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(IdNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(IntNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(StringNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(BooleanNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(EqualNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(NotEqualNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(LessThanNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(GreaterThanNode n) {

        return ST;
    }

    @Override
    public SymbolTable visit(GreaterThanEqualsNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(LessThanEqualsNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(NegationNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(OrNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(AndNode n) {
        return ST;
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
    public SymbolTable visit(ParameterBlock n) {
        ST.openScope();

        //Enter all variables that was passed down into the block
        for (Symbol var : n.variables) {
            ST.enterSymbol(var);
        }

        for (ASTNode node : n.children) {
            node.accept(this);
        }

        ST.closeScope();

        return ST;
    }

    @Override
    public SymbolTable visit(NonScopeBlockNode n) {

        for (ASTNode node : n.children) {
            node.accept(this);
        }

        return ST;
    }

    @Override
    public SymbolTable visit(Assignment n) {
        return ST;
    }

    @Override
    public SymbolTable visit(StringAssignmentNode n) {
        // no type check required since grammar rule enforces correct type
        // we only even get a StringAssignmentNode if right side is a string literal
        // limitation: function calls returning a string not allowed in grammar
        return ST;
    }

    @Override
    public SymbolTable visit(IntegerAssignmentNode n) {
        n.accept(TC);
        return ST;
    }

    @Override
    public SymbolTable visit(BooleanAssignmentNode n) {
        n.accept(TC);
        return ST;
    }

    @Override
    public SymbolTable visit(DotAssignmentNode n) {
        n.accept(TC);
        return ST;
    }

    @Override
    public SymbolTable visit(DesignDefinitionNode n) {

        //Create a separate symbol table that resides in the design type
        SymbolTable fields = new SymbolTable();

        //Write in all the declarations into that symbol table
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

        //Convert declarations to symbols
        List<Symbol> formalParams = new ArrayList<>();
        for (Declaration param : n.formalParameters) {
            formalParams.add(
                    new Symbol(
                            param.varName(),
                            param.type()
                    )
            );
        }

        //Enter action definition into ST
        ST.enterSymbol(
                new Symbol(
                        n.varName(),
                        new ActionType(
                                n.returnType,
                                n.formalParameters
                        )
                )
        );

        //Pass down the formal parameters to the action body
        n.body.variables = formalParams;

        //Create symbols
        ST = (SymbolTable) n.body.accept(this);

        //Type check that return expression matches return type
        TC = new TypeChecker(ST, TENV);
        TC.visit(n);



        //Visit action body
        return ST;
    }

    @Override
    /**
     * Dummy proof. Nothing should visit a declaration interface
     */
    public SymbolTable visit(Declaration n) {
        n.accept(this);
        return ST;
    }

    @Override
    public SymbolTable visit(ActionDeclarationNode n) {

        //Two action declarations with the same name is not allowed
        ST.enterSymbol(
                new Symbol(
                        n.name,
                        new ActionType(
                                n.returnType,
                                n.formalParameters
                        )
                )
        );

        return ST;
    }

    @Override
    public SymbolTable visit(DesignDeclarationNode n) {

        //Check that the type is actually defined in the type environment
        TC = new TypeChecker(ST, TENV);
        TC.visit(n);

        Symbol sym = new Symbol(
                n.name,
                new DesignRef(n.dName));

        ST.enterSymbol(sym);
        return ST;
    }

    @Override
    public SymbolTable visit(ListDeclarationNode n) {
        return ST;
    } //Todo: implement?

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
    public SymbolTable visit(BooleanExpression n) {
        return ST;
    }

    @Override
    public SymbolTable visit(IntegerDeclarationNode n) {

        TC = new TypeChecker(ST, TENV);

        if ((n.value != null) && (n.value.accept(TC).getClass() != IntType.class)) {
            throw new TypeErrorException("Types in assignment did not match");
        }

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(BooleanDeclarationNode n) {

        TC = new TypeChecker(ST, TENV);

        if ((n.value != null) && (n.value.accept(TC).getClass() != BoolType.class)) {
            throw new TypeErrorException("Types in assignment did not match");
        }

        ST.enterSymbol(new Symbol(
                n.name,
                n.type()
        ));

        return ST;
    }

    @Override
    public SymbolTable visit(StringDeclarationNode n) {

        TC = new TypeChecker(ST, TENV);

        if ((n.value != null) && (n.value.accept(TC).getClass() != StringType.class)) {
            throw new TypeErrorException("Types in assignment did not match");
        }

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
        n.ifBlock.accept(this);

        if (n.elseifBlocks != null) {
            n.elseifBlocks.forEach(elif->elif.accept(this));
        }
        if (n.elseBlock != null) {
            n.elseBlock.accept(this);
        }
        return ST;
    }

    @Override
    public SymbolTable visit(ElifConditionalNode n) {
        return (SymbolTable) n.ifBlock.accept(this);
    }

    @Override
    public SymbolTable visit(ElseNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(PredicateNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(WhileNode n) {
        return (SymbolTable) n.whileBlock.accept(this);
    }

    @Override
    public SymbolTable visit(ForeachNode n) {

        // Look-up for iterable
        Symbol iterableSymbol = ST.retrieveSymbol(n.iterable.name);

        if ( !((iterableSymbol.type instanceof ListType) || iterableSymbol.type instanceof StringType)) {
            throw new TypeErrorException("%s of type '%s' is not iterable".formatted(
                    iterableSymbol.name,
                    iterableSymbol.type
            ));
        }

        //Assign type to the iterator to be of the element type of iterable
        TypeDenoter iteratorElementType;
        if (iterableSymbol.type instanceof ListType list) {
            iteratorElementType = list.elementType;
        } else {
            iteratorElementType = iterableSymbol.type;
        }
        Symbol iteratorSym = new Symbol(
                n.iterator.name,
                iteratorElementType
        );

        //Declare iterator in current scope and pass down to the foreach body
        ST.enterSymbol(iteratorSym);

        n.body.variables = List.of(
                iteratorSym
        );

        return (SymbolTable) n.body.accept(this);

    }

    @Override
    public SymbolTable visit(PrintNode n) {
        return ST;
    }

    @Override
    public SymbolTable visit(InputNode n) {
        //Typecheck input variable to have type string
        TC = new TypeChecker(ST, TENV);
        n.inputVariableName.accept(this);

        return ST;
    }

    @Override
    public SymbolTable visit(ActionCallNode n) {

        //Check actionCall for correct amount of params & correct type of params
        TC = new TypeChecker(ST, TENV);
        TC.visit(n);

        //Visit action body
        return ST;
    }

    @Override
    public SymbolTable visit(ReturnNode n) {
        n.returnVal.accept(this);
        return ST;
    }

    @Override
    public SymbolTable visit(FieldAccessNode n) {

        //Typecheck that all fields that are accessed exists
        TC = new TypeChecker(ST, TENV);
        n.accept(TC);

        return ST;
    }

    @Override
    public SymbolTable visit(ListElementNode n) {
        return ST;
    }
}

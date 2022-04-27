package ASTvisitors;

import ASTnodes.*;
import symboltable.DuplicateSymbolException;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;
import symboltable.attributes.Attributes;
import symboltable.attributes.PrimitiveAttributes;
import symboltable.types.IntType;
import symboltable.types.Primitive;
import symboltable.types.TypeDenoter;


public class SymbolHarvester implements ASTvisitor<SymbolTable> {

    SymbolTable ST;

    public SymbolHarvester() {
        this.ST = new SymbolTable();
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
    public SymbolTable visit(Assignment n) {
        return visit(n);
    }

    @Override
    public SymbolTable visit(DesignDefinitionNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(Declaration n) {
        return null;
    }

    @Override
    public SymbolTable visit(SequentialDeclaration n) {

        TypeChecker typeChecker = new TypeChecker(ST);
        Attributes attributes;
        TypeDenoter sequenceType = n.type;

        try {

            attributes = initAttribute(sequenceType);

            for (Declaration declaration : n.declarations) {

                //Typecheck the declaration
                declaration.accept(typeChecker);

                ST.enterSymbol(declaration.getIdentifier().name, attributes);
            }
        } catch (TypeErrorException typeError) {
            System.out.println(typeError.getMessage());
        }

        return ST;
    }

    private Attributes initAttribute(TypeDenoter type) {

        Attributes attributes;

        if (type instanceof Primitive) {
            attributes = new PrimitiveAttributes((Primitive) type);
        }

//        //SpcTile a, b, c;
//        else if (type.getClass() == DesignType.class) {
//            //todo: Not implemented. We need to get type of design type from design ast node
//            attributes = null;
//        }

        else {
            throw new TypeErrorException(String.format("type '%s' is not compatible with sequential declaration", type));
        }

        return attributes;
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

        IdNode identifier = n.id;

        PrimitiveAttributes attrs = new PrimitiveAttributes(new IntType());

        identifier.attrs = attrs;

        if (ST.declaredLocally(identifier.name)) {
            throw new DuplicateSymbolException(identifier.name + " is already declared in current scope");
        }

        ST.enterSymbol(identifier.name, attrs);
        return ST;
    }

    @Override
    public SymbolTable visit(IntegerAssignDeclarationNode n) {

        IdNode identifier = n.id;
        PrimitiveAttributes attrs = new PrimitiveAttributes(new IntType());

        identifier.attrs = attrs;

        if (ST.declaredLocally(identifier.name)) {
            throw new DuplicateSymbolException(identifier.name + " is already declared in current scope");
        }

        ST.enterSymbol(identifier.name, attrs);
        return ST;
    }

    @Override
    public SymbolTable visit(BooleanDeclarationNode n) {
        IdNode identifier = n.id;
        ST.enterSymbol(identifier.name,identifier.attrs);
        return ST;
    }

    @Override
    public SymbolTable visit(StringDeclarationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(PathDeclarationNode n) {
        IdNode identifier = n.id;
        ST.enterSymbol(identifier.name,identifier.attrs);
        return ST;
    }

    @Override
    public SymbolTable visit(PathTypedDeclarationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(GridDeclarationNode n) {
        IdNode identifier = n.id;
        ST.enterSymbol(identifier.name,identifier.attrs);
        return ST;
    }

    @Override
    public SymbolTable visit(GridTypedDeclarationNode n) {
        return null;
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
}

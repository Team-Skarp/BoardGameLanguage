package symboltable;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import symboltable.types.BoolType;
import symboltable.types.IntType;
import symboltable.types.StringType;
import symboltable.types.TypeDenoter;

import java.lang.reflect.Type;

/**
 * Class used to type check any given node in the AST. The class needs a symbol table in order
 * to do type checking
 * <br>
 * The type checker is instanciated and used inside the {@link SymbolTable} class
 */
public class TypeChecker implements ASTvisitor<TypeDenoter> {

    private SymbolTable ST;

    public TypeChecker(SymbolTable ST) {
        this.ST = ST;
    }

    /**
     * Both the left type and right type should be of same type
     * @return {@link TypeDenoter} of the type of assignment
     * @throws TypeErrorException if types are incompatible
     */
    @Override
    public TypeDenoter visit(Assignment n) {

        TypeDenoter idType = (TypeDenoter) n.getLeft().accept(this);
        TypeDenoter exprType = (TypeDenoter) n.getRight().accept(this);

        if (idType.getClass() == exprType.getClass()) {
            return idType;          //Could be the expression type or the id type
        }
        else {
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", idType, exprType));
        }
    }

    @Override
    public TypeDenoter visit(ArithmeticExpression n) {
        return null;
    }

    @Override
    public TypeDenoter visit(PlusNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType.getClass() == IntType.class && rightType.getClass() == IntType.class) {
            return leftType;
        }
        else if (leftType.getClass() == StringType.class && rightType.getClass() == StringType.class) {
            return leftType;
        }
        else {
            //'a of type 'int' cannot be assigned to type 'string'
            throw new TypeErrorException(String.format("type '%s' cannot be added to type '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(MinusNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(MultNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(DivNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ModNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(PowNode n) {
        return null;
    }

    @Override

     //Returns the type of the looked up identifier
    public TypeDenoter visit(IdNode n) {

        Symbol symbol = ST.retrieveSymbol(n.name);
        return symbol.attrs.thisType();
    }

    @Override
    public TypeDenoter visit(IntNode n) {
        return new IntType();
    }

    @Override
    public TypeDenoter visit(EqualNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType.getClass() == IntType.class && rightType.getClass() == IntType.class) {
            return new BoolType();
        }
        else if (leftType.getClass() == StringType.class && rightType.getClass() == StringType.class) {
            return new BoolType();
        }
        else if (leftType.getClass() == BoolType.class && rightType.getClass() == BoolType.class) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("type '%s' cannot be compared equal to type '%s'", leftType, rightType));
        }

    }

    @Override
    public TypeDenoter visit(NotEqualNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(LessThanNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(GreaterThanNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(GreaterThanEqualsNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(LessThanEqualsNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(BooleanNode n) {
        return new BoolType();
    }

    @Override
    public TypeDenoter visit(NegationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(OrNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(AndNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(BlockNode n) {
        for (ASTNode child : n.children) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public TypeDenoter visit(StringNode n) {
        return new StringType();
    }

    @Override
    public TypeDenoter visit(BooleanExpression n) {
        return null;
    }

    @Override
    public TypeDenoter visit(IntegerDeclarationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(IntegerAssignDeclarationNode n) {
        TypeDenoter exprType = (TypeDenoter) n.expr.accept(this);

        if (exprType.getClass() == IntType.class) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("Type of expression should be of type 'int', got type '%s'", exprType));
        }

    }

    @Override
    public TypeDenoter visit(BooleanDeclarationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(StringDeclarationNode n) {
        return null;
    }
}

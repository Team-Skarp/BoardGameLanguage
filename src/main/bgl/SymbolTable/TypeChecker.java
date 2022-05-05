package SymbolTable;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import SymbolTable.types.*;

import java.util.List;

/**
 * Class used to type check any given node in the AST. The class needs a symbol table in order
 * to do type checking
 * <br>
 * The type checker is instanciated and used inside the {@link SymbolTable} class
 */
public class TypeChecker implements ASTvisitor<TypeDenoter> {

    private final SymbolTable ST;
    private final TypeEnvironment TENV;

    public TypeChecker(SymbolTable ST, TypeEnvironment TENV) {
        this.ST = ST;
        this.TENV = TENV;
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
    public TypeDenoter visit(StringAssignmentNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(DesignDefinitionNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ActionDefinitionNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(Declaration n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ActionDeclarationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(DesignDeclarationNode n) {

        //Check that the type is actually in the type environment
        return TENV.recieveType(n.ref.name);
    }

    @Override
    public TypeDenoter visit(SequentialDeclaration n) {

        TypeDenoter sequenceType = n.type;
        for (Declaration dcl : n.declarations) {
            if (dcl instanceof Assignment) {
                Expression expr = (Expression) ((Assignment) dcl).getRight();
                TypeDenoter typeOfExpr = (TypeDenoter) expr.accept(this);

                if (sequenceType.getClass() != typeOfExpr.getClass()) {
                    throw new TypeErrorException(String.format("value of expression yielded type '%s' and cannot be assigned to '%s' declaration",typeOfExpr, sequenceType));
                }
            }
        }

        return sequenceType;
    }

    @Override
    public TypeDenoter visit(GameNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(Expression n) {
        return (TypeDenoter) n.accept(this);

    }

    @Override
    public TypeDenoter visit(ArithmeticExpression n) {
        return null;

    }

    @Override
    public TypeDenoter visit(PlusNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        }
        else if (leftType instanceof StringType && rightType instanceof StringType) {
            return new StringType();
        }
        else {
            throw new TypeErrorException(
                    String.format("type '%s' cannot be added to type '%s'", leftType, rightType)
            );
        }
    }

    @Override
    public TypeDenoter visit(MinusNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("type '%s' cannot be negated to type '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(UnaryMinusNode n) {

        TypeDenoter operandType = (TypeDenoter) n.operand.accept(this);

        if (operandType instanceof IntType) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("unary minus is not defined for type '%s'", operandType));
        }
    }

    @Override
    public TypeDenoter visit(MultNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("type '%s' cannot be multiplied with type '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(DivNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("type '%s' cannot be divided with type '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(ModNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("modulus can not operate on type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(PowNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("exponent can not operate on type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(IdNode n) {

        Symbol symbol = ST.retrieveSymbol(n.name);
        return symbol.type;
    }

    @Override
    public TypeDenoter visit(IntNode n) {
        return new IntType();
    }

    @Override
    public TypeDenoter visit(EqualNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        }
        else if (leftType instanceof StringType && rightType instanceof StringType) {
            return new BoolType();
        }
        else if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("type '%s' cannot be compared equal to type '%s'", leftType, rightType));
        }

    }

    @Override
    public TypeDenoter visit(NotEqualNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        }
        else if (leftType instanceof StringType && rightType instanceof StringType) {
            return new BoolType();
        }
        else if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("not equal is not defined between type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(LessThanNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("less than is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(GreaterThanNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("less than is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(GreaterThanEqualsNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("greater than or equal is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(LessThanEqualsNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("less than is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(BooleanNode n) {
        return new BoolType();
    }

    @Override
    public TypeDenoter visit(NegationNode n) {
        TypeDenoter exprType = (TypeDenoter) n.child.accept(this);

        if (exprType instanceof BoolType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("negation is not defined for type: '%s'", exprType));
        }
    }

    @Override
    public TypeDenoter visit(OrNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("or operator is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(AndNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        }
        else {
            throw new TypeErrorException(String.format("and operator is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(BlockNode n) {
        for (ASTNode child : n.children) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public TypeDenoter visit(ActionBodyNode n) {
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

        if (exprType instanceof IntType) {
            return new IntType();
        }
        else {
            throw new TypeErrorException(String.format("type of expression should be of type 'int', got type '%s'", exprType));
        }

    }

    @Override
    public TypeDenoter visit(PathDeclarationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(PathTypedDeclarationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(GridDeclarationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(GridTypedDeclarationNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ConditionalNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ElifConditionalNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ElseNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(PredicateNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(WhileNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ForeachNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(PrintNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ActionCallNode call) {
        Symbol actionSym = ST.retrieveSymbol(call.actionName);
        ActionType action = (ActionType) actionSym.type;

        List<Declaration> formalParameters = action.formalParameters;
        if (formalParameters.size() != call.actualParameters.size()) {
            throw new TypeErrorException(
                    "action '%s' takes '%d' positional arguments but '%d' were given".
                    formatted(actionSym.name, formalParameters.size(), call.actualParameters.size()));
        }

        int arg = 0;
        while (arg < formalParameters.size()) {
            TypeDenoter paramType = formalParameters.get(arg).type();
            TypeDenoter argumentType = visit(call.actualParameters.get(arg));

            if (paramType.getClass() != argumentType.getClass()){
                throw new TypeErrorException(
                        "expected type '%s' on argument index '%d' but recieved type '%s'".
                                formatted(paramType, arg, argumentType)
                );
            }

            arg++;
        }

        return action.returnType;
    }

    @Override
    public TypeDenoter visit(ReturnNode n) {
        return null;
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

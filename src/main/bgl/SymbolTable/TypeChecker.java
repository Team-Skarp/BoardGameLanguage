package SymbolTable;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import SymbolTable.types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class used to type check any given node in the AST. The class needs a symbol table in order
 * to do type checking
 * <br>
 * The type checker is instanciated and used inside the {@link SymbolTable} class
 */
public class TypeChecker implements ASTvisitor<TypeDenoter> {

    private final SymbolTable ST;
    private final TypeEnvironment TENV;


    /**
     * The action node that we are currently in else
     * returns null if we are not in an action
     */
    private ActionDefinitionNode currentAction;

    public TypeChecker(SymbolTable ST, TypeEnvironment TENV) {
        this.ST = ST;
        this.TENV = TENV;
    }

    /**
     * Both the left type and right type should be of same type
     *
     * @return {@link TypeDenoter} of the type of assignment
     * @throws TypeErrorException if types are incompatible
     */
    @Override
    public TypeDenoter visit(Assignment n) {

        TypeDenoter idType = (TypeDenoter) n.getLeft().accept(this);
        TypeDenoter exprType = (TypeDenoter) n.getRight().accept(this);

        if (idType.getClass() == exprType.getClass()) {
            return idType;          //Could be the expression type or the id type
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", exprType, idType));
        }
    }

    @Override
    public TypeDenoter visit(StringAssignmentNode n) {
        TypeDenoter idType = (TypeDenoter) n.getLeft().accept(this);
        TypeDenoter exprType = (TypeDenoter) n.getRight().accept(this);

        if (idType.getClass() == exprType.getClass()) {
            return idType;          //Could be the expression type or the id type
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", exprType, idType));
        }
    }

    @Override
    public TypeDenoter visit(IntegerAssignmentNode n) {
        TypeDenoter idType = (TypeDenoter) n.getLeft().accept(this);
        TypeDenoter exprType = (TypeDenoter) n.getRight().accept(this);

        if (idType.getClass() == exprType.getClass()) {
            System.out.println(idType.getClass() + " " + exprType.getClass()); //todo remove
            return idType;          //Could be the expression type or the id type
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", exprType, idType));
        }
    }

    @Override
    public TypeDenoter visit(BooleanAssignmentNode n) {
        TypeDenoter idType = (TypeDenoter) n.getLeft().accept(this);
        TypeDenoter exprType = (TypeDenoter) n.getRight().accept(this);

        if (idType.getClass() == exprType.getClass()) {
            return idType;          //Could be the expression type or the id type
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", exprType, idType));
        }
    }

    @Override
    public TypeDenoter visit(DotAssignmentNode n) {
        TypeDenoter fieldType = (TypeDenoter) n.getLeft().accept(this);
        TypeDenoter exprType = (TypeDenoter) n.getRight().accept(this);

        if (fieldType.getClass() == exprType.getClass()) {
            return fieldType;          //Could be the expression type or the id type
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", exprType, fieldType));
        }
    }

    @Override
    public TypeDenoter visit(DesignDefinitionNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(ActionDefinitionNode n) {

        currentAction = n;

        //Type check body. All return statements found within are type checked against the return type of the action
        n.body.accept(this);

        //When we leave the action there should not be a current action
        currentAction = null;
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
        return TENV.receiveType(n.dName);
    }

    @Override
    public TypeDenoter visit(ListDeclarationNode n) {

        List<TypeDenoter> actualTypesOfElementNodes = new ArrayList<>();

        // Collect all the types of the list elements
        if (n.assignedList != null) {
            for (ASTNode listElementNode : n.assignedList.elements) {

                actualTypesOfElementNodes.add((TypeDenoter) listElementNode.accept(this));
            }

            //System.out.println(Arrays.toString(actualTypesOfElementNodes.toArray()));

            for (TypeDenoter actualTypeOfElementNode : actualTypesOfElementNodes) {
                // To allow empty lists, we skip the check if their type ends with null
                if (!actualTypeOfElementNode.toString().endsWith("null")) {
                    System.out.println("actualTypeOfElementNode = " + actualTypeOfElementNode);
                    if ((!Objects.equals(actualTypeOfElementNode.toString(), n.elementType.toString()))) {
                        //System.out.println("left: " + n.elementType.getClass() + " right: " + actualTypesOfElementNode.getClass());
                        System.out.println("YIKES! " + n.elementType + " != " + actualTypeOfElementNode);
                        throw new TypeErrorException(
                                "Element of type %s does not match list of type %s".
                                        formatted(actualTypeOfElementNode, n.elementType));
                    }

                    /* didn't catch incorrectly nested lists because classes were both ListType //Todo: gardening
                    if (actualTypesOfElementNode.getClass() != n.elementType.getClass()) {
                        throw new TypeErrorException(
                                "Element of type %s does not match list of type %s".
                                        formatted(actualTypesOfElementNode, n.elementType));
                    }
                     */
                }
            }
        }

        return n.elementType;
    }

    @Override
    public TypeDenoter visit(ListNode n) {

        // If visiting an empty list, we provide a null value as TypeDenoter
        if (n.elements != null && n.elements.isEmpty()) {
            // Todo: need to check for incorrect levels of nesting of empty lists
            return new ListType(null);
        }

        List<TypeDenoter> actualTypesOfElementNodes = new ArrayList<>();

        if (n.elements != null) {
            for (ASTNode listElementNode : n.elements) {
                actualTypesOfElementNodes.add((TypeDenoter) listElementNode.accept(this));
            }
        }

        if (n.elements != null) {

            // Find type of the first element in the list
            TypeDenoter typeOfFirstListElementNode = new ListType(null);

            // // Find type of the first non-empty list element in the list
            for (ASTNode listElementNode: n.elements) {
                typeOfFirstListElementNode = (TypeDenoter) listElementNode.accept(this);
                if (!typeOfFirstListElementNode.toString().endsWith("null")) {
                    break;
                }
            }

            // Check if elements in list have matching types
            for (TypeDenoter actualTypeOfElementNode : actualTypesOfElementNodes) {
                // To allow empty lists, we skip the check for them
                if (!actualTypeOfElementNode.toString().endsWith("null")) {


                if (!Objects.equals(actualTypeOfElementNode.toString(), typeOfFirstListElementNode.toString())) {

                    throw new TypeErrorException(
                            "List contains incompatible types %s and %s".
                                    formatted(actualTypeOfElementNode, typeOfFirstListElementNode));
                }
            }

            }
            return new ListType(typeOfFirstListElementNode);
        }

        else {
            // Hopefully we never see this
            throw new TypeErrorException("Type checking a list failed badly");
        }
    }

    @Override
    public TypeDenoter visit(ListElementNode n) {

        return (TypeDenoter) n.accept(this);
    }

    @Override
    public TypeDenoter visit(SequentialDeclaration n) {

        TypeDenoter sequenceType = n.type;
        for (Declaration dcl : n.declarations) {
            if (dcl instanceof Assignment) {
                Expression expr = (Expression) ((Assignment) dcl).getRight();
                TypeDenoter typeOfExpr = (TypeDenoter) expr.accept(this);

                if (sequenceType.getClass() != typeOfExpr.getClass()) {
                    throw new TypeErrorException(String.format("value of expression yielded type '%s' and cannot be assigned to '%s' declaration", typeOfExpr, sequenceType));
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
        return (TypeDenoter) n.accept(this);

    }

    @Override
    public TypeDenoter visit(PlusNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        } else if (leftType instanceof StringType && rightType instanceof StringType) {
            return new StringType();
        } else {
            throw new TypeErrorException(
                    String.format("type '%s' cannot be added to type '%s'", rightType, leftType)
            );
        }
    }

    @Override
    public TypeDenoter visit(MinusNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be negated to type '%s'", rightType, leftType));
        }
    }

    @Override
    public TypeDenoter visit(UnaryMinusNode n) {

        TypeDenoter operandType = (TypeDenoter) n.operand.accept(this);

        if (operandType instanceof IntType) {
            return new IntType();
        } else {
            throw new TypeErrorException(String.format("unary minus is not defined for type '%s'", operandType));
        }
    }

    @Override
    public TypeDenoter visit(MultNode n) {

        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be multiplied with type '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(DivNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be divided with type '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(ModNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        } else {
            throw new TypeErrorException(String.format("modulus can not operate on type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(PowNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new IntType();
        } else {
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
        } else if (leftType instanceof StringType && rightType instanceof StringType) {
            return new BoolType();
        } else if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be compared equal to type '%s'", leftType, rightType));
        }

    }

    @Override
    public TypeDenoter visit(NotEqualNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        } else if (leftType instanceof StringType && rightType instanceof StringType) {
            return new BoolType();
        } else if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        } else {
            throw new TypeErrorException(String.format("not equal is not defined between type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(LessThanNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        } else {
            throw new TypeErrorException(String.format("less than is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(GreaterThanNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        } else {
            throw new TypeErrorException(String.format("less than is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(GreaterThanEqualsNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        } else {
            throw new TypeErrorException(String.format("greater than or equal is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(LessThanEqualsNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof IntType && rightType instanceof IntType) {
            return new BoolType();
        } else {
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
        } else {
            throw new TypeErrorException(String.format("negation is not defined for type: '%s'", exprType));
        }
    }

    @Override
    public TypeDenoter visit(OrNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        } else {
            throw new TypeErrorException(String.format("or operator is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(AndNode n) {
        TypeDenoter leftType = (TypeDenoter) n.left.accept(this);
        TypeDenoter rightType = (TypeDenoter) n.right.accept(this);

        if (leftType instanceof BoolType && rightType instanceof BoolType) {
            return new BoolType();
        } else {
            throw new TypeErrorException(String.format("and operator is not defined for type '%s' and '%s'", leftType, rightType));
        }
    }

    @Override
    public TypeDenoter visit(BlockNode n) {
        ST.dive();
        for (ASTNode child : n.children) {
            child.accept(this);
        }
        ST.climb();
        return null;
    }

    @Override
    public TypeDenoter visit(ParameterBlock n) {
        ST.dive();
        for (ASTNode child : n.children) {
            child.accept(this);
        }
        ST.climb();
        return null;
    }

    @Override
    public TypeDenoter visit(NonScopeBlockNode n) {
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
        TypeDenoter idType = (TypeDenoter) n.accept(this);
        TypeDenoter exprType = (TypeDenoter) n.accept(this);

        if (idType.getClass() == exprType.getClass()) {
            return idType;          //Could be the expression type or the id type
        } else {
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", idType, exprType));
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
        n.ifBlock.accept(this);

        if (n.elseifBlocks != null) {
            n.elseifBlocks.forEach(elif -> elif.accept(this));
        }
        if (n.elseBlock != null) {
            n.elseBlock.accept(this);
        }

        return null;

    }

    @Override
    public TypeDenoter visit(ElifConditionalNode n) {
        n.ifBlock.accept(this);
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
    public TypeDenoter visit(InputNode n) {

        //Check that identifier has type of string
        TypeDenoter inputType = (TypeDenoter) n.inputVariableName.accept(this);
        if (!(inputType instanceof StringType)) {
            throw new TypeErrorException(
                    "input only accepts a variable of type string, but '%s' have type '%s'".formatted(
                            n.inputVariableName.name,
                            inputType
                    ));
        }

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

            if (paramType.getClass() != argumentType.getClass()) {
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
    //Hand control over to the type checking of an action call
    public TypeDenoter visit(MethodCallNode n) {
        return visit(new ActionCallNode(
                n.actionName,
                n.actualParameters
        ));
    }

    @Override
    public TypeDenoter visit(ReturnNode n) {

        if (isNotInAction()) {
            throw new SyntaxError("return statement must be inside an action");
        } else if (isReturningFromVoid(n)) {
            throw new TypeErrorException(
                    "action '%s' does not expect a value to be returned".formatted(
                            currentAction.name
                    )
            );
        } else if (haveEmptyReturnWhenOneExpected(n)) {
            throw new TypeErrorException(
                    "action '%s' expects a return type of '%s' but nothing was given".formatted(
                            currentAction.name,
                            currentAction.returnType
                    )
            );
        } else if (nonMatchingReturnType(n)) {
            throw new TypeErrorException(
                    "return value of type '%s' does not match return type of '%s', expected type '%s'".formatted(
                            n.returnVal.accept(this),
                            currentAction.name,
                            currentAction.returnType
                    )
            );
        }

        return null;
    }

    /**
     * Checks that type of return value matches current action definition
     *
     * @param n
     */
    private boolean nonMatchingReturnType(ReturnNode n) {
        TypeDenoter exprType = (TypeDenoter) n.returnVal.accept(this);

        return exprType.getClass() != currentAction.returnType.getClass();
    }

    /**
     * Check that if there is no return value, then the action return type should be Void
     *
     * @param n
     */
    private boolean haveEmptyReturnWhenOneExpected(ReturnNode n) {
        return n.returnVal == null && !(currentAction.returnType instanceof VoidType);
    }

    /**
     * Check that nothing is returned from a void action
     *
     * @param n
     */
    private boolean isReturningFromVoid(ReturnNode n) {
        return n.returnVal != null && currentAction.returnType instanceof VoidType;
    }

    private boolean isNotInAction() {
        return currentAction == null;
    }

    @Override
    /**
     * Field can have either an identifier or an action call as a sequence
     *
     * Ex. a.b.foo() in where the type of the last element in the chain is returned
     */
    public TypeDenoter visit(FieldAccessNode n) {
        String dName = "";
        Symbol currentSymbol = new Symbol("error", new VoidType());
        SymbolTable temp = ST;

        for (Accessable field: n.fields) {

            currentSymbol = temp.retrieveSymbol(field.getAccessName());
            if (currentSymbol.type instanceof DesignRef design) {
                dName = design.name;
                temp = TENV.receiveType(dName).fields;
            }
            else {
                if (n.fields.indexOf(field) != n.fields.size()-1) {
                    throw new IllegalFieldAccessException(
                            "cannot access field %s in %s of type %s".formatted(
                                    n.fields.get(n.fields.indexOf(field)+1),
                                    field.getAccessName(),
                                    dName));
                }
            }
        }

        //If last accessor is a function call, return the type of the call
        if (currentSymbol.type instanceof ActionType action) {
            return action.returnType;
        }
        return currentSymbol.type;
    }

    @Override
    public TypeDenoter visit(IntegerDeclarationNode n) {
        if ((n.value != null) && (n.value.accept(this).getClass() != IntType.class)) {
            throw new TypeErrorException("Types in assignment did not match");
        } else {
            return new IntType();
        }
    }

    @Override
    public TypeDenoter visit(BooleanDeclarationNode n) {
        if ((n.value != null) && (n.value.accept(this).getClass() != BoolType.class)) {
            throw new TypeErrorException("Types in assignment did not match");
        } else {
            return new BoolType();
        }
    }

    @Override
    public TypeDenoter visit(StringDeclarationNode n) {
        if ((n.value != null) && (n.value.accept(this).getClass() != StringType.class)) {
            throw new TypeErrorException("Types in assignment did not match");
        } else {
            return new StringType();
        }
    }

}

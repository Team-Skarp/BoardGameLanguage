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
    public TypeDenoter visit(AssignmentNode n) {
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

        // since id = id goes through here due to grammar rules, we need enhanced type check for lists
        // if we have a list on both side
        if (idType.toString().contains("list:") && exprType.toString().contains("list:")) {
            // if types (and nesting level) don't match
            if (!Objects.equals(idType.toString(), exprType.toString())) {
                throw new TypeErrorException("types in assignment are of different types %s and %s".formatted(idType, exprType));
            }
        }
        // non-list assignment case
        else if (idType.getClass() == exprType.getClass()) {
            return idType;          // could return either the expression type or the id type
        }
        // if one side has a list, remove occurrences of "list:" from type to just check the base type to allow assignment through indexation
        else if (!idType.toString().replace("list:", "").equals(exprType.toString().replace("list:", ""))) {
            System.out.println("is this a fail?");
            System.out.println(idType.toString() + " " + exprType.toString().replace("list:", ""));
            throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", exprType, idType));
        }
        return null;
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
            System.out.println("left type: %s, right type: %s".formatted(fieldType.getClass(), exprType.getClass()));
            // had to disable since empty list literals [] don't have a type
            System.out.println("exception thrown at type check for dotAssignment disabled");
            //throw new TypeErrorException(String.format("type '%s' cannot be assigned to type '%s'", exprType, fieldType));
        }
        return fieldType;
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
                    // System.out.println("actualTypeOfElementNode = " + actualTypeOfElementNode);
                    if ((!Objects.equals(actualTypeOfElementNode.toString(), n.elementType.toString()))) {
                        //System.out.println("left: " + n.elementType.getClass() + " right: " + actualTypesOfElementNode.getClass());
                        //System.out.println("YIKES! " + n.elementType + " != " + actualTypeOfElementNode);
                        throw new TypeErrorException(
                                "Element of type %s does not match list of type %s".
                                        formatted(actualTypeOfElementNode, n.elementType));
                    }

                    /* didn't catch incorrectly nested lists because classes were both ListType //Todo: gardening, remove when everything works
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
            return new ListType(null);
        }

        List<TypeDenoter> actualTypesOfElementNodes = new ArrayList<>();

        if (n.elements != null) {
            for (ASTNode listElementNode : n.elements) {
                actualTypesOfElementNodes.add((TypeDenoter) listElementNode.accept(this));
            }
        }
        System.out.println("actualTypesOfElementNodes = " + actualTypesOfElementNodes);

        List<String> typesAsStrings = actualTypesOfElementNodes.stream().map(type->type.toString()).toList();
        if (actualTypesOfElementNodes != null) {
            // Todo: need to check for incorrect levels of nesting of empty lists,
            //  must match other list elements and the main list decl
            int previousIndex = 0;
            int count = 0;
            for (String typeAsString: typesAsStrings) {

                 {
                    int indexOfLastColonInThisString = typeAsString.lastIndexOf(":");
                    if (count != 0) {

                        if (previousIndex != indexOfLastColonInThisString) {
                            throw new TypeErrorException("Incorrect nesting of list element");
                        }

                    }
                    else {
                        previousIndex = indexOfLastColonInThisString;
                        System.out.println("indexOfLastColon = " + indexOfLastColonInThisString);
                    }
                    count++;
                }
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
    public TypeDenoter visit(IndexAccessNode n) {
        for (ASTNode node: n.value) {
            if (node instanceof IdNode IdN) {
                // check that the symbol is declared
                Symbol temp = ST.retrieveSymbol(IdN.getAccessName());

                if (temp.value < 1) {
                    throw new IndexOutOfBoundsException("BGL indexing starts from 1, unlike C which starts from 0");
                }
                else return temp.type;

            }
            if (node instanceof IntNode IntN) {
                if (IntN.value == 0) {
                    throw new IndexOutOfBoundsException("BGL indexing starts from 1, unlike C which starts from 0");
                }
                else return new IntType();
            }
        }

        return null;
    }


    @Override
    public TypeDenoter visit(ListIndexAssignmentNode n) {
        return null; //Todo: implement return type of whatever is the last index
    }

    @Override
    public TypeDenoter visit(ExitNode n) {
        return null;
    }

    @Override
    public TypeDenoter visit(RandomNode n) {
        return new IntType();
    }

    @Override
    public TypeDenoter visit(SizeOfNode n) {

        //Check that the identifier is a list
        Symbol identifier = ST.retrieveSymbol(n.var);

        if (!(identifier.type instanceof ListType)) {
            throw new TypeErrorException("sizeof expects a variable of type list");
        }

        return new IntType();
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
//        TypeDenoter inputType = (TypeDenoter) n.inputVariableName.accept(this);
//        if (!(inputType instanceof StringType)) {
//            throw new TypeErrorException(
//                    "input only accepts a variable of type string, but '%s' have type '%s'".formatted(
//                            n.inputVariableName.name,
//                            inputType
//                    ));
//        }

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
    //Much like the action call, except we check inside the design of the accessor
    public TypeDenoter visit(MethodCallNode call) {

        //Get the symbol table for the accessor --> a.f() here we retrieve a
        Symbol callingSym = ST.retrieveSymbol(call.calledBy);
        if (!(callingSym.type instanceof DesignRef)) {
            throw new ReferenceErrorException("can not call a method on a variable that's not of design type");
        }
        SymbolTable accessST = TENV.receiveType(((DesignRef) callingSym.type).name).fields;
        Symbol methodSym = accessST.retrieveSymbol(call.actionName);

        ActionType method = (ActionType) methodSym.type;

        //Check that the method defined in the design matches that of the method call
        List<Declaration> formalParameters = method.formalParameters;
        if (formalParameters.size() != call.actualParameters.size()) {
            throw new TypeErrorException(
                    "method '%s' takes '%d' positional arguments but '%d' were given".
                            formatted(call.actionName, formalParameters.size(), call.actualParameters.size()));
        }

        //Check that every argument matches formal parameters
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

        return method.returnType;

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
     * Field can have either an identifier or an method call as a sequence
     *
     * Ex. a.b.foo() in where the type of the last element in the chain is returned
     *
     * Now it can also have index access nodes which we don't record the type of!
     */
    public TypeDenoter visit(FieldAccessNode n) {

        String dName = "";
        Symbol currentSymbol = new Symbol("error", new VoidType());
        SymbolTable temp = ST;
        TypeDenoter rt = new VoidType();                 //Type to be returned fron the field access

        for (Accessable field : n.fields) {

            currentSymbol = temp.retrieveSymbol(field.getAccessName());
            if (currentSymbol.type instanceof DesignRef design) {
                dName = design.name;
                temp = TENV.receiveType(dName).fields;
                rt = currentSymbol.type;
            }
            //a[0].color <--
            else if (currentSymbol.type instanceof ListType list) {
                rt = list.elementType;
                if (rt instanceof DesignRef design && field instanceof IndexAccessNode) {
                    dName = design.name;
                    temp = TENV.receiveType(dName).fields;
                }
            }
            else {
                //a.color <--
                if (n.fields.indexOf(field) != n.fields.size() - 1) {
                    throw new IllegalFieldAccessException(
                            "cannot access field %s in %s of type %s".formatted(
                                    n.fields.get(n.fields.indexOf(field) + 1),
                                    field.getAccessName(),
                                    dName));
                }
                rt = currentSymbol.type;
            }
        }

        //If last accessor is a function call, return the type of the call
        if (rt instanceof ActionType action) {
            return action.returnType;
        }

        return rt;
    }

    @Override
    /**
     * For each Accessible get its symbol and check for next accessible in that symbol's scope / type env
     * return type of the last one found
     */
    public TypeDenoter visit(FieldAccessLHNode n) {

        String dName = "";
        Symbol currentSymbol = new Symbol("error", new VoidType());
        SymbolTable temp = ST;
        TypeDenoter rt = new VoidType();                 //Type to be returned fron the field access

        for (Accessable field : n.fields) {

            currentSymbol = temp.retrieveSymbol(field.getAccessName());
            if (currentSymbol.type instanceof DesignRef design) {
                dName = design.name;
                temp = TENV.receiveType(dName).fields;
                rt = currentSymbol.type;
            }
            else if (currentSymbol.type instanceof ListType list) {
                rt = list.elementType;
                if (rt instanceof DesignRef design && field instanceof IndexAccessNode) {
                    dName = design.name;
                    temp = TENV.receiveType(dName).fields;
                }
            }
            else {
                if (n.fields.indexOf(field) != n.fields.size() - 1) {
                    throw new IllegalFieldAccessException(
                            "cannot access field %s in %s of type %s".formatted(
                                    n.fields.get(n.fields.indexOf(field) + 1),
                                    field.getAccessName(),
                                    dName));
                }
                rt = currentSymbol.type;
            }
        }

        return rt;
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

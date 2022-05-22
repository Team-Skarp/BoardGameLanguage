package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.ListType;
import SymbolTable.types.TypeDenoter;

public class ListDeclarationNode implements ASTNode<Object>, Declaration {

    public String name;
    public TypeDenoter elementType;
    public ListNode assignedList;

    // Declaration without assignment
    public ListDeclarationNode(String name, TypeDenoter elementType) {
        this.name = name;
        this.elementType = elementType;
    }

    // Declaration with assignment
    public ListDeclarationNode(String name, TypeDenoter elementType, ListNode assignedList) {
        this.name = name;
        this.elementType = elementType;
        this.assignedList = assignedList;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String varName() {
        return name;
    }

    @Override
    public TypeDenoter type() {
        return new ListType(elementType);
    }

    public ListNode getAssignedList() {
        return assignedList;
    }
}

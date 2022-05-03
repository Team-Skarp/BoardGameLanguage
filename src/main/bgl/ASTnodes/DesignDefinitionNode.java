package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class DesignDefinitionNode implements ASTNode<Object> {

    public final IdNode typeDefinition;          //Type to be defined
    public List<Declaration> fields;             //Fields of the design definition
    public final IdNode parentType;              //*Optional parrent type when extending from another type

    public DesignDefinitionNode(IdNode typeDefinition, IdNode parentType, Declaration... fields) {
        this.typeDefinition = typeDefinition;
        this.fields = List.of(fields);
        this.parentType = parentType;
    }

    public DesignDefinitionNode(IdNode typeDefinition, Declaration... fields) {
        this.typeDefinition = typeDefinition;
        this.fields = List.of(fields);
        this.parentType = null;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}

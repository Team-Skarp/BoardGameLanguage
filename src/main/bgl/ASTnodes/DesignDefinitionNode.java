package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class DesignDefinitionNode implements ASTNode<Object> {

    public final String dName;          //Type to be defined
    public List<Declaration> fields;             //Fields of the design definition
    public final String parentDName;              //*Optional parrent type when extending from another type

    public DesignDefinitionNode(String dName, String parentDName, Declaration... fields) {
        this.dName = dName;
        this.fields = List.of(fields);
        this.parentDName = parentDName;
    }

    public DesignDefinitionNode(String dName, Declaration... fields) {
        this.dName = dName;
        this.fields = List.of(fields);
        this.parentDName = null;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}

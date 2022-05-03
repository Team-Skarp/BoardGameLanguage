package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.DesignRef;
import SymbolTable.types.TypeDenoter;

/**
 * Specifies the declaration of a custom design type
 *
 * example: Player p1;
 */
public class DesignDeclarationNode implements ASTNode<Object>, Declaration {

    public final DesignRef ref;         //Reference name to a design type name
    public final String name;           //Name of the identifier

    public DesignDeclarationNode(DesignRef ref, String name) {
        this.ref = ref;
        this.name = name;
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
        return new DesignRef(name);
    }
}

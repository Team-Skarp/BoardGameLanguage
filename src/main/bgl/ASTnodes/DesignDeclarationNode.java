package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.DesignRef;
import SymbolTable.types.TypeDenoter;
import java.util.List;

/**
 * Specifies the declaration of a custom design type
 *
 * example: Player p1;
 */
public class DesignDeclarationNode implements ASTNode<Object>, Declaration {

    public String dName;    // Reference name to a design type name
    public String name;     // Name of the identifier
    public List<String> value;   // Value of

    //
    public DesignDeclarationNode(String dName, String name) {
        this.dName = dName;
        this.name = name;
    }

    public DesignDeclarationNode(String dName, String name, List<String> value) {
        this.dName = dName;
        this.name = name;
        this.value = value;
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
        return new DesignRef(dName);
    }
}

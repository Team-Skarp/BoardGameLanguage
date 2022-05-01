package ASTnodes;
import ASTvisitors.ASTvisitor;
import symboltable.attributes.Attributes;
import symboltable.types.TypeDenoter;

public class IdNode implements ASTNode {

    public final String name;
    public final TypeDenoter type;
    public Attributes attrs;  //TODO: explain Hans wtf this is. added value field to keep value

    /**
     * Constructor used in case of visitor not needing additional attributes
     */
    public IdNode(String name, TypeDenoter type) {
        this.name = name;
        this.type = type;
        this.attrs = null;
    }

    /**
     * Used when a declaration can take place for the Identifier
     * @param name
     * @param attrs
     */
    public IdNode(String name, Attributes attrs) {
        this.name = name;
        this.type = attrs.thisType();
        this.attrs = attrs;  //Starts with an empty attribute reference
    }

    /**
     * Used when the identifier is only referenced in a grammar rule
     * @param name of the identifier
     */
    public IdNode(String name) {
        this.name = name;
        this.type = null;
        this.attrs = null;
    }


    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}

package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.types.IntType;
import SymbolTable.types.TypeDenoter;

public class IntegerDeclarationNode implements ASTNode<Object>, Declaration {

    public  String name;
    public ASTNode value;
    public RandomNode randomNode;

    public IntegerDeclarationNode(String name) {
        this.name = name;
    }
    public IntegerDeclarationNode(String name, ASTNode value) {
        if(value.getClass() == IntNode.class) {
            this.value = value;
        }else if(value.getClass() == RandomNode.class){
            this.randomNode = (RandomNode) value;
        }
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
        return new IntType();
    }

}

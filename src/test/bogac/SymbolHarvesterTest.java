import ASTnodes.IdNode;
import ASTnodes.IntegerDeclarationNode;
import ASTnodes.SequentialDeclaration;
import ASTvisitors.SymbolHarvester;
import org.junit.Test;
import symboltable.ReferenceErrorException;
import symboltable.Symbol;
import symboltable.SymbolTable;
import symboltable.attributes.PrimitiveAttributes;
import symboltable.types.BoolType;
import symboltable.types.DesignType;
import symboltable.types.IntType;
import symboltable.types.StringType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SymbolHarvesterTest {

    SymbolHarvester symbolHarvester;

    @Test
    public void entersSequentialIntegerDeclarationCorrectly() {     //tests: int a, b;


        symbolHarvester = new SymbolHarvester();

        IntegerDeclarationNode a = new IntegerDeclarationNode(new IdNode("a"));
        IntegerDeclarationNode b = new IntegerDeclarationNode(new IdNode("b"));

        SequentialDeclaration sequence = new SequentialDeclaration();
        sequence.type = new StringType();
        sequence.declarations = List.of(a, b);

        symbolHarvester.visit(sequence);
    }

    @Test
    public void should_throw_typeerror_when_doing_sequential_declaration_of_list_type() {     //tests: int a, b;


        symbolHarvester = new SymbolHarvester();

        IntegerDeclarationNode a = new IntegerDeclarationNode(new IdNode("a"));
        IntegerDeclarationNode b = new IntegerDeclarationNode(new IdNode("b"));

        SequentialDeclaration sequence = new SequentialDeclaration();
        sequence.type = new StringType();
        sequence.declarations = List.of(a, b);

        symbolHarvester.visit(sequence);
    }
}

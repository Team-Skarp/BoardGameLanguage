package symboltable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class used to define a single scope in the compiler
 *
 * Blocks contains all the symbols found within a given scope.
 *
 * Scopes are only initialised by the {@link SymbolTable} class
 */
class Block {

    private Block                parent;
    private Map<String, Symbol>  symbols = new HashMap<String, Symbol>();
    private List<Block>          children = new ArrayList<>();

    void addSymbol(Symbol sym) {
        symbols.put(sym.name, sym);
    }

    Symbol getSymbolWith(String name) {

        return symbols.get(name);

    }
    void addChild(Block block) {
        children.add(block);
    }

    Block getParent() {
        return parent;
    }

    void setParent(Block block) {
        parent = block;
    }
}

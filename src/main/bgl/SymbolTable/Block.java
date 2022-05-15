package SymbolTable;

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
public class Block {

    private Block                parent;
    private Map<String, Symbol>  symbols = new HashMap<String, Symbol>();
    private List<Block>          children = new ArrayList<>();

    int                          next = 0;           //Keeps track of which block should be diven into next

    public Block(){};

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

    public List<Block> getChildren() {
        return children;
    }

    void setParent(Block block) {
        parent = block;
    }

    public Map<String, Symbol> getSymbolMapping() {
        return symbols;
    }
}

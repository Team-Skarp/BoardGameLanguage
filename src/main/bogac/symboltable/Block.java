package symboltable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Block {

    private Block                parent;
    private Map<String, Symbol>  symbols = new HashMap<String, Symbol>();
    private List<Block>          children = new ArrayList<>();

    public void addSymbol(Symbol sym) {
        symbols.put(sym.name, sym);
    }

    public Symbol getSymbolWith(String name) {

        return symbols.get(name);

    }
    public void addChild(Block block) {
        children.add(block);
    }

    public Block getParent() {
        return parent;
    }
    public void setParent(Block block) {
        parent = block;
    }
}

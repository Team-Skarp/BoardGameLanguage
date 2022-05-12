package SymbolTable;

import SymbolTable.types.DesignType;
import STDLIB.PredefinedDesign;
import STDLIB.Tile;

import java.util.HashMap;
import java.util.List;

/**
 * Stores a table containing all defined design types
 *
 * Maps from design names to a design type
 */
public class TypeEnvironment {

    private HashMap<String, DesignType> env = new HashMap<>();

    /**
     * Initialises the type environment with all predefined types
     * @return Initialises type environment object
     */
    public static TypeEnvironment init() {

        //Here goes all build-in types
        Tile tile = new Tile();

        List<PredefinedDesign> predefinedDesigns = List.of(tile);

        //DesignType Tile = new DesignType("Tile");

//        for (DesignType type : predefinedTypes) {
//            env.put(type.name, )
//        }

        return new TypeEnvironment();
    }

    /**
     * Should create a design type of the given build-in type
     * @param type to enter
     */
    private static DesignType initType(PredefinedDesign type) {

        return null;
    }
    /**
     * Enters a new custom type into the type environment
     * @param type to enter
     * @throws TypeDefinitionException if parent type already exist or is already defined
     */
    public TypeEnvironment enterType(DesignType type) {

        if ( !parentTypeDefined(type.parent)) {
            throw new TypeDefinitionException("parent type '%s' is not defined".formatted(type.parent));
        }

        DesignType prevType = env.put(type.name, type);
        if (prevType != null) {
            throw new TypeDefinitionException("type '%s' is already defined".formatted(type.name));
        }

        System.out.printf("type '%s' entered into type env\n", type.name); //Todo: coding when you're tired %n -> \n
        return this;
    }

    /**
     * Checks that the parent type exist
     * @param parent type name of parent
     */
    private boolean parentTypeDefined(String parent) {
        if (parent != null) {
            try {
                receiveType(parent);
                return true;
            } catch (TypeDefinitionException err) {
                return false;
            }
        }
        return true;
    }

    /**
     * Receives a single type entry from the type environment
     * @param name of the type to receive
     * @throws TypeDefinitionException if type is not found
     */
    public DesignType receiveType(String name) {

        DesignType type = env.get(name);

        if (type == null) {
            throw new TypeDefinitionException("type '%s' is not defined".formatted(name));
        }

        System.out.printf("type '%s' received\n", type.name);

        return type;
    }
}

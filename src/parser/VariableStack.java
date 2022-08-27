package parser;

import java.util.HashMap;

public class VariableStack {
    private final HashMap<String, Object> variablesStack = new HashMap<>();

    public void appendVariable(String name, Object value) {
        variablesStack.put(name, value);
    }

    public void popVariable(String name) {
        variablesStack.remove(name);
    }

    public HashMap<String, Object> getStack() {
        return variablesStack;
    }
}

package parser;

import java.util.HashMap;

import java.util.ArrayList;

public class FunctionCallStack {
    private final ArrayList<HashMap<String, Object>> functionCallStack = new ArrayList<>();

    public void appendFunctionCall(HashMap<String, Object> callData) {
        functionCallStack.add(callData);
    }

    public ArrayList<HashMap<String, Object>> getStack() {
        return functionCallStack;
    }
}

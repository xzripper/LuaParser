package parser;

import java.util.HashMap;

public class FunctionCallDataGenerator {
    public static HashMap<String, Object> generateFunctionCallData(String functionName, Object[] functionArguments) {
        HashMap<String, Object> callData = new HashMap<>();

        callData.put("functionName", functionName);
        callData.put("functionArguments", functionArguments);

        return callData;
    }
}

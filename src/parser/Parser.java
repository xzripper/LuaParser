package parser;

import tokens.TokenExist;

import tokens.Keywords;

import tokens.Types;

import tokens.Syntax;

import java.io.FileNotFoundException;

import java.util.HashMap;

public class Parser {
    private Files file;

    private final VariableStack localVarStack = new VariableStack();

    private final FunctionCallStack localFuncCallStack = new FunctionCallStack();

    public Parser(String _file) {
        file = new Files(_file);
    }

    public HashMap<String, Object> parseLuaFile() throws FileNotFoundException {
        String[] luaLines = file.readLines();

        HashMap<String, Object> parsingResult = new HashMap<>();

        registerVariableCreation();
        registerFunctionCalling();

        parsingResult.put(
            "variables", localVarStack.getStack()
        );

        parsingResult.put(
            "funcCalls", localFuncCallStack.getStack()
        );

        return parsingResult;
    }

    public void registerVariableCreation() throws FileNotFoundException {
        for(String luaLine : file.readLines()) {
            String[] data = luaLine.split(" ");

            String stringKeyword = data[0];

            Keywords keyword = TokenExist.getTokenIfExist(stringKeyword);

            if(keyword == Keywords.LOCAL) {
                String varName = data[1];

                String varContent = luaLine.split("\s(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)")[3];

                Object varContentWithType = null;

                if(Types.matchesToString(varContent)) {
                    varContentWithType = varContent;
                } else if(Types.matchesToInteger(varContent)) {
                    varContentWithType = Integer.parseInt(varContent);
                } else if(Types.matchesToBoolean(varContent)) {
                    varContentWithType = varContent == "true";
                }

                localVarStack.appendVariable(varName, varContentWithType);
            }
        }
    }

    public void registerFunctionCalling() throws FileNotFoundException {
        for(String luaLine : file.readLines()) {
            if(Syntax.matchesToFunctionCall(luaLine)) {
                String[] data = luaLine.split("\\(");

                String functionName = data[0];

                if(functionName.startsWith(Keywords.FUNCTION.toString().toLowerCase())) {
                    continue;
                }

                String[] functionArgs = data[1].substring(0, data[1].length() - 1).split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");

                Object[] functionArgsWithTypes = new Object[functionArgs.length];

                for(int index=0; index < functionArgs.length; index++) {
                    if(Types.matchesToString(functionArgs[index])) {
                        functionArgsWithTypes[index] = functionArgs[index];
                    } else if(Types.matchesToInteger(functionArgs[index])) {
                        functionArgsWithTypes[index] = Integer.parseInt(functionArgs[index]);
                    } else if(Types.matchesToBoolean(functionArgs[index])) {
                        functionArgsWithTypes[index] = functionArgs[index] == "true";
                    }
                }

                localFuncCallStack.appendFunctionCall(FunctionCallDataGenerator.generateFunctionCallData(functionName, functionArgsWithTypes));
            }
        }
    }
}

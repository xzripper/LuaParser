import parser.Parser;

import java.io.FileNotFoundException;

import java.util.HashMap;

public class Tests {
    public static void main(String[] args) throws FileNotFoundException {
        Parser luaParser = new Parser("src\\main.lua");

        HashMap<String, Object> result = luaParser.parseLuaFile();

        System.out.println(result.get("variables"));
        System.out.println(result.get("funcCalls"));
    }
}

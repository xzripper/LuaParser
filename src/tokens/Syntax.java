package tokens;

public class Syntax {
    public static boolean matchesToFunctionCall(String string) {
        return string.matches(".*\\(.*\\)");
    }
}

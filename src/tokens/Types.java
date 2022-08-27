package tokens;

public class Types {
    public static boolean matchesToString(String string) {
        return string.startsWith("\"") && string.endsWith("\"");
    }

    public static boolean matchesToInteger(String string) {
        return string.matches("\\d+");
    }

    public static boolean matchesToBoolean(String string) {
        return string.equals("true") || string.equals("false");
    }
}

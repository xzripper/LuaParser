package tokens;

import java.util.Objects;

public class TokenExist {
    public static boolean tokenExist(String token) {
        for(Keywords keyword : Keywords.values()) {
            if(Objects.equals(token, keyword.toString().toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public static Keywords getTokenIfExist(String token) {
        if(!tokenExist(token)) {
            return null;
        }

        for(Keywords keyword : Keywords.values()) {
            if(Objects.equals(token, keyword.toString().toLowerCase())) {
                return keyword;
            }
        }

        return null;
    }
}

package data;

import java.util.HashMap;
import java.util.Map;

public class User {

    Map<String, String> userData = new HashMap<>();

    public String getUserData(String key) {
        return userData.get(key);
    }

    public void putValue(String value1, String value2) {
        userData.put(value1, value2);
    }
}

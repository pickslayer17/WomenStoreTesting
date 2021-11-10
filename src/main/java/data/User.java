package data;

import java.util.HashMap;
import java.util.Map;

public class User {

    Map<String, String> userData = new HashMap<>();

    public Map<String, String> getUserData() {
        return userData;
    }

    public void putValue(String value1, String value2) {
        userData.put(value1, value2);
    }
}

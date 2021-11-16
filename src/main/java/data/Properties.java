package data;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Properties {

    private static Properties instance;
    private Map<String, String> properties = new HashMap();

    private Properties() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("test.properties");
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String key = line.split("=")[0].trim();
            String value = line.split("=")[1].trim();
            properties.put(key, value);
        }
    }

    public static Properties getInstance() {
        if (instance == null) {
            instance = new Properties();
        }
        return instance;
    }

    public String getPropertyByKey(String key) {
        return properties.get(key);
    }
}

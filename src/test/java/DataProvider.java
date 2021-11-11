import data.User;
import data.UserParser;


public class DataProvider {

    public static  User getUser() {
        UserParser userParser = new UserParser();
        User user = userParser.getUserData();

        return user;
    }
}

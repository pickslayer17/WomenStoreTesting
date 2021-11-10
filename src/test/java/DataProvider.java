import data.User;
import data.UserParser;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class DataProvider {

    public static void main(String[] args) {
        UserParser userParser = new UserParser();
        User user = userParser.getUserData();

        System.out.println(user.getUserData().get("E-mail"));
    }

    public static  User getUser() {
        UserParser userParser = new UserParser();
        User user = userParser.getUserData();

        return user;
    }
}

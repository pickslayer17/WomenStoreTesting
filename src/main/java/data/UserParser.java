package data;

import lib.ReadExcelLib;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;


public class UserParser {

    public User getUserData() {
        User user = new User();
        ReadExcelLib readExcelLib = new ReadExcelLib();
        Object[][] excelArr = readExcelLib.GetExcelData(
                "ExcelExample.xlsx",
                "Sheet1",
                2);
        Map<Object, Object> userData = ArrayUtils.toMap(excelArr);

        user.setEmail((String) userData.get("E-mail"));
        user.setGender((String) userData.get("Gender"));
        user.setFirstName((String) userData.get("First Name"));
        user.setLastName((String) userData.get("Last Name"));
        user.setPassword((String) userData.get("Password"));
        user.setDateOfBirth((String) userData.get("Date of Birth"));
        user.setCompany((String) userData.get("Company"));
        user.setAddress((String) userData.get("Address"));
        user.setCity((String) userData.get("City"));
        user.setState((String) userData.get("State"));
        user.setZip((String) userData.get("Zip"));
        user.setHomePhone((String) userData.get("Home Phone"));

        return user;
    }
}

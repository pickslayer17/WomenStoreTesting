package data;

import lib.ReadExcelLib;

import java.util.HashMap;
import java.util.Map;

public class UserParser {

    public User getUserData(){
        User user = new User();
        ReadExcelLib readExcelLib = new ReadExcelLib();
        Object[][] obj = readExcelLib.GetExcelData(
                ReadExcelLib.class.getClassLoader().getResource("ExcelExample.xlsx").getFile(),
                "Sheet1",
                2);

        for (int i = 0; i < obj.length; i++) {
            user.putValue((String) obj[i][0], (String) obj[i][1]);
        }

        return user;
    }
}

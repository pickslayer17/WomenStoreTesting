package lib;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadExcelLib {

    public static void main(String[] args) {
        ReadExcelLib readExcelLib = new ReadExcelLib();
        Object[][] obj = readExcelLib.GetExcelData(
                ReadExcelLib.class.getClassLoader().getResource("ExcelExample.xlsx").getFile(),
                "Sheet1", 2
        );
        for (int i = 0; i < obj.length; i++) {
            for (int j = 0; j < obj[i].length; j++) {
                System.out.print(obj[i][j] + ": ");
            }
            System.out.println();
        }
    }

    public Object[][] GetExcelData(String fileName, String sheetName, int numberOfCols) {

        File file = new File(fileName);

        XSSFWorkbook wBook;
        XSSFSheet sheet;

        Object[][] excelArray = null;

        try {
            FileInputStream excel = new FileInputStream(file);
            wBook = new XSSFWorkbook(excel);
            sheet = wBook.getSheet(sheetName);
            int start = sheet.getFirstRowNum();
            int end = sheet.getLastRowNum();
            excelArray = new Object[end - start + 1][numberOfCols];
            DataFormatter formatter = new DataFormatter();
            for (int i = start; i <= end; i++) {
                for (int j = 0; j <= numberOfCols - 1; j++) {
                    excelArray[i][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return excelArray;
    }
}

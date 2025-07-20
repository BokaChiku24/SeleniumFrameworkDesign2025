package exceldatadriven;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class TestNGDataProviderExcelReader {

    // multiple sets of data to our test case
    // array public
    // sets od data as 5 arrays from data provider to your tests
    // then your test will
    @Test(dataProvider = "dataFromExcel")
    public void getDataFromExcel(String testCase, String name, String text, String number) {
        System.out.println(testCase + "-" + name + "-" + text + "-" + number);
    }

    @DataProvider(name = "dataFromExcel")
    public Object[][] getData() throws IOException {
        // Object[][] obj = new Object[][]{{"Test", "Name", 22}, {"Test1", "KC", 20}};
        // every row of excel should be sent to 1 array
        DataFormatter format = new DataFormatter();
        FileInputStream fis = new FileInputStream("/Users/kunalchavan/Desktop/TestExcel.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        // XSSFSheet sheet = wb.getSheetName("TestCase1"); // getting sheet by name
        XSSFSheet sheet = wb.getSheetAt(0); // getting sheet by index
        int getRowCount = sheet.getPhysicalNumberOfRows(); // get row count
        XSSFRow row = sheet.getRow(0); // return row
        int columnCount = row.getLastCellNum(); // return all column number
        // read excel and pass value to array
        /*
        This is how read excel and grab data
        0,0   0,1  0,2
        1,0   1,1  1,2
        2,0   2,1  2,2
         */
        // getRowCount - 1  to not include column header

        Object[][] obj = new Object[getRowCount - 1][columnCount]; // getRowCount - 1  to not include column header
        for (int i = 0; i < getRowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row.getCell(j);
                // obj[i][j] = row.getCell(j);
                obj[i][j] = format.formatCellValue(cell);
                System.out.println(obj[i][j]);
            }
        }
        return obj;
    }
}
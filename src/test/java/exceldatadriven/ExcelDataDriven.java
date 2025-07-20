package exceldatadriven;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataDriven {

    @Test
    public void getDataFromExcel() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/exceldata/Test Excel.xlsx"); // open the file by fileInputStream

        XSSFWorkbook workbook = new XSSFWorkbook(fis); // create an object of XSSFWorkbook

        int sheets = workbook.getNumberOfSheets(); // get all number of sheets

        for (int i = 0; i < sheets; i++) {
            // iterate sheet1, sheet2, sheet3 etc... if available
            if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) { // if sheetName matches
                XSSFSheet sheet = workbook.getSheetAt(i); // iterate sheet1, sheet2, sheet3 etc... if available
            }

        }

        // identify testCases column by scanning the entire 1st row
        // once column is identified then scan entire testCase column to identify purchase testCase row
        // after grab purchase testCase row = oull all the data of that row and feed into test


    }
}

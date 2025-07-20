package exceldatadriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FinalExcelDataReaderCode {

    public static ArrayList<String> getData(String xlsxName, String sheetName, String testCaseName) throws IOException {
        ArrayList<String> obj = new ArrayList<String>();

        FileInputStream fis = new FileInputStream("/Users/kunalchavan/Desktop/" + xlsxName + ".xlsx"); // open the file by fileInputStream

        XSSFWorkbook workbook = new XSSFWorkbook(fis); // create an object of XSSFWorkbook

        int sheets = workbook.getNumberOfSheets(); // get all number of sheets
        Iterator<Row> row = null;
        Row firstRow = null;
        int column = 0;
        for (int i = 0; i < sheets; i++) {
            System.out.println(workbook.getSheetName(i).equalsIgnoreCase(sheetName));
            // iterate sheet1, sheet2, sheet3 etc... if available
            if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) { // if sheetName matches
                XSSFSheet sheet = workbook.getSheetAt(i); // iterate sheet1, sheet2, sheet3 etc... if available
                row = sheet.iterator(); // sheet is collection of rows
                firstRow = row.next(); // 1st row Testcases
                Iterator<Cell> cell = firstRow.cellIterator(); // row is collection of cell
                int j = 0; // to check matches if match not found increment it and go for other cell
                // identify testCases column by scanning the entire 1st row
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        // desired column
                        column = j;
                        break;
                    }
                    j++;
                }
                System.out.println(column);
            }
        }
        // once column is identified then scan entire testCase column to identify purchase testCase row
        while (row.hasNext()) {
            firstRow = row.next();
            if (firstRow.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                // after you grab purchase testcase row pull all the data of that row and feed into test
                Iterator<Cell> cell = firstRow.cellIterator();
                while (cell.hasNext()) {
                    Cell c = cell.next();
                    if (c.getCellTypeEnum() == CellType.STRING) {
                        //System.out.println(cell.next().getStringCellValue());
                        obj.add(c.getStringCellValue());
                    } else {
                        obj.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                    }
                }
            }
        }
        return obj;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> obj = FinalExcelDataReaderCode.getData("TestExcel", "Test1", "Purchase");
        System.out.println(obj.get(0));
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        System.out.println(obj.get(3));
    }

}


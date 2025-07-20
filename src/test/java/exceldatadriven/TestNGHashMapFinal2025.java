package exceldatadriven;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestNGHashMapFinal2025 {

    // multiple sets of data to our test case
    // array public
    // sets od data as 5 arrays from data provider to your tests
    // then your test will
    @Test(dataProvider = "dataFromExcel")
    public void getDataFromExcel(HashMap<String, String> map, HashMap<String, String> map1, HashMap<String, String> map2, HashMap<String, String> map3) {
        System.out.println(map.get("Testcases") + "-" + map.get("Data1") + "-" + map.get("Data2") + "-" + map.get("Data3"));
        System.out.println(map1.get("Testcases") + "-" + map1.get("Data1") + "-" + map1.get("Data2") + "-" + map1.get("Data3"));
        System.out.println(map2.get("Testcases") + "-" + map2.get("Data1") + "-" + map2.get("Data2") + "-" + map2.get("Data3"));
        System.out.println(map3.get("Testcases") + "-" + map3.get("Data1") + "-" + map3.get("Data2") + "-" + map3.get("Data3"));

    }

    @DataProvider(name = "dataFromExcel")
    public Object[][] getData() throws IOException {
        // Object[][] obj = new Object[][]{{"Test", "Name", 22}, {"Test1", "KC", 20}};
        // every row of excel should be sent to 1 array
        DataFormatter format = new DataFormatter();
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
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
       /*
        Object[][] obj = new Object[getRowCount - 1][columnCount]; // getRowCount - 1  to not include column header
        for (int i = 0; i < getRowCount - 1; i++) {
            row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                XSSFCell cell = row.getCell(j);
                // obj[i][j] = row.getCell(j);
                obj[i][j] = format.formatCellValue(cell);
            }
        }

        */

        XSSFSheet sh = wb.getSheet("Test1");
        System.out.println(sh.getLastRowNum());
        System.out.println(columnCount);
        List<String> key = new ArrayList<>();
        List<String> value = new ArrayList<>();
        List<String> value1 = new ArrayList<>();
        List<String> value2 = new ArrayList<>();
        List<String> value3 = new ArrayList<>();

        for (int i = 0; i < getRowCount - 1; i++) {
            row = sheet.getRow(0);
            key.add(row.getCell(i).getStringCellValue());
            System.out.print(key + "\t");
        }
        System.out.println();
        for (int j = 0; j < columnCount; j++) {
            row = sheet.getRow(1);
            value.add(row.getCell(j).getStringCellValue());
            System.out.print(value + "\t");

        }
        System.out.println();
        for (int j = 0; j < columnCount; j++) {
            row = sheet.getRow(2);
            value1.add(row.getCell(j).getStringCellValue());
            System.out.print(value1 + "\t");
        }
        System.out.println();
        for (int j = 0; j < columnCount; j++) {
            row = sheet.getRow(3);
            value2.add(row.getCell(j).getStringCellValue());
            System.out.print(value2 + "\t");
        }
        System.out.println();

        for (int j = 0; j < columnCount; j++) {
            row = sheet.getRow(4);
            value3.add(row.getCell(j).getStringCellValue());
            System.out.print(value3 + "\t");
        }
        System.out.println();
        map.put(key.get(0), value.get(0));
        map.put(key.get(1), value.get(1));
        map.put(key.get(2), value.get(2));
        map.put(key.get(3), value.get(3));

        map1.put(key.get(0), value1.get(0));
        map1.put(key.get(1), value1.get(1));
        map1.put(key.get(2), value1.get(2));
        map1.put(key.get(3), value1.get(3));

        map2.put(key.get(0), value2.get(0));
        map2.put(key.get(1), value2.get(1));
        map2.put(key.get(2), value2.get(2));
        map2.put(key.get(3), value2.get(3));

        map3.put(key.get(0), value3.get(0));
        map3.put(key.get(1), value3.get(1));
        map3.put(key.get(2), value3.get(2));
        map3.put(key.get(3), value3.get(3));

        System.out.println(map);
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map3);

        List<Map<String, String>> data = new ArrayList<>();
        data.add(map);
        data.add(map1);
        data.add(map2);
        data.add(map3);
        return new Object[][]{{data.get(0), data.get(1), data.get(2), data.get(3)}};
    }
}
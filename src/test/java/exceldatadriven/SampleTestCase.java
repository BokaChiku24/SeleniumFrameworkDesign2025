package exceldatadriven;

import java.io.IOException;
import java.util.ArrayList;

public class SampleTestCase {
    public static void main(String[] args) throws IOException {
        ArrayList<String> getData = ExcelDataDrivenDataToArrayList.getData("TestExcel","Test1", "Purchase");
        System.out.println(getData.get(0));
        System.out.println(getData.get(1));
        System.out.println(getData.get(2));
        System.out.println(getData.get(3));
    }
}

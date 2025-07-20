package exceldatadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProviderArrayHardCoded {

    // multiple sets of data to our test case
    // array public
    // sets od data as 5 arrays from data provider to your tests
    // then your test will
    @Test(dataProvider = "dataFromExcel")
    public void getDataFromExcel(String name, String text, int number) {
        System.out.println(name + "-" + text + "-" + number);
    }

    @DataProvider(name = "dataFromExcel")
    public Object[][] getData() {
        Object[][] obj = new Object[][]{{"Test", "Name", 22}, {"Test1", "KC", 20}};
        return obj;
    }
}

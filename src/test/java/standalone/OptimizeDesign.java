package standalone;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;
import testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class OptimizeDesign extends BaseTest {

    @Test(dataProvider = "getData", groups = {"Purchase","Regression"})
    public void endToEnd(HashMap<String,String> map) throws IOException {
        // create an account
        // RegisterPage rp = new RegisterPage(driver);
        // rp.registerUser(wait,email,password);
        ProductCatalogue pc = obj.login(map.get("email"), map.get("password"));
        pc.addProductToCart(map.get("prodName"));
        CartPage cp = pc.addProductToCart(map.get("prodName"));
        Assert.assertTrue(cp.goToCart(map.get("prodName")));
        PaymentPage pp = cp.gotoPayment();
        OrderSummary os = pp.goToSummary(map.get("country"));
        String actualText = os.orderDetails();
        String expectedTest = "Thankyou for the order.";
        Assert.assertEquals(actualText, expectedTest.toUpperCase());
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedTest));
    }

    @Test(dependsOnMethods = {"endToEnd"}, dataProvider = "getOrderData")
    public void orderValidation(HashMap<String,String> map) {
        ProductCatalogue pc = obj.login(map.get("email"), map.get("password"));
        MyOrders mo = pc.goToOrder();
        Assert.assertEquals(mo.getOrderProductName(map.get("prodName")), map.get("prodName"));
    }

    @DataProvider(name = "getData")
    public Object[][] getDataFromDataProvider() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap("Purchase");
        return new Object[][]{{data.get(0)}, {data.get(1)}, {data.get(2)}};
    }
    @DataProvider(name = "getOrderData")
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap("Purchase");
        return new Object[][]{{data.get(0)}, {data.get(1)}, {data.get(2)}};
    }
    /*
    @DataProvider(name = "getData")
    public Object[][] getDataFromDataProvider() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", "testkc@gmail.com");
        map.put("password", "Admin@123");
        map.put("prodName", "ZARA COAT 3");
        map.put("country", "India");

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("email", "testkc@gmail.com");
        map1.put("password", "Admin@123");
        map1.put("prodName", "IPHONE 13 PRO");
        map1.put("country", "Brazil");
        return new Object[][]{{map}, {map1}};
    }

    @DataProvider(name = "getOrderData")
    public Object[][] getData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("email", "testkc@gmail.com");
        map.put("password", "Admin@123");
        map.put("prodName", "ZARA COAT 3");

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("email", "testkc@gmail.com");
        map1.put("password", "Admin@123");
        map1.put("prodName", "IPHONE 13 PRO");
        return new Object[][]{{map}, {map1}};
    }
     */

    /* return object
    @DataProvider(name = "getData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{{"testkc@gmail.com","Admin@123","ZARA COAT 3","India"},{"testkc@gmail.com","Admin@123","IPHONE 13 PRO","Brazil"}};
    }

    @DataProvider(name = "getOrderData")
    public Object[][] getData(){
        return new Object[][]{{"testkc@gmail.com","Admin@123","ZARA COAT 3"},{"testkc@gmail.com","Admin@123","IPHONE 13 PRO"}};
    }
     */
}

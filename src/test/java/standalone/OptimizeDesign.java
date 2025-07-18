package standalone;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.*;
import testcomponents.BaseTest;

import java.io.IOException;

public class OptimizeDesign extends BaseTest {

    @Test(dataProvider = "getData",groups = {"Purchase"})
    public void endToEnd(String email, String password, String prodName, String country) throws IOException {
        // create an account
        // RegisterPage rp = new RegisterPage(driver);
        // rp.registerUser(wait,email,password);
        ProductCatalogue pc = obj.login(email, password);
        pc.addProductToCart(prodName);
        CartPage cp = pc.addProductToCart(prodName);
        Assert.assertTrue(cp.goToCart(prodName));
        PaymentPage pp = cp.gotoPayment();
        OrderSummary os = pp.goToSummary(country);
        String actualText = os.orderDetails();
        String expectedTest = "Thankyou for the order.";
        Assert.assertEquals(actualText, expectedTest.toUpperCase());
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedTest));
    }

    @Test(dependsOnMethods = {"endToEnd"},dataProvider = "getOrderData")
    public void orderValidation(String email, String password, String prodName) {
        ProductCatalogue pc = obj.login(email, password);
        MyOrders mo = pc.goToOrder();
        Assert.assertEquals(mo.getOrderProductName(prodName),prodName);
    }

    @DataProvider(name = "getData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{{"testkc@gmail.com","Admin@123","ZARA COAT 3","India"},{"testkc@gmail.com","Admin@123","IPHONE 13 PRO","Brazil"}};
    }

    @DataProvider(name = "getOrderData")
    public Object[][] getData(){
        return new Object[][]{{"testkc@gmail.com","Admin@123","ZARA COAT 3"},{"testkc@gmail.com","Admin@123","IPHONE 13 PRO"}};
    }
}

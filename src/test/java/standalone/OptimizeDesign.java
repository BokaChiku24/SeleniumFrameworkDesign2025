package standalone;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;
import testcomponents.BaseTest;

import java.io.IOException;

public class OptimizeDesign extends BaseTest {

    String email = "testkc@gmail.com";
    String password = "Admin@123";
    String prodName = "ZARA COAT 3";
    String country = "India";


    @Test
    public void endToEnd() throws IOException {
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

    @Test(dependsOnMethods = {"endToEnd"})
    public void orderValidation() {
        ProductCatalogue pc = obj.login(email, password);
        MyOrders mo = pc.goToOrder();
        Assert.assertEquals(mo.getOrderProductName(prodName),prodName);
    }

}

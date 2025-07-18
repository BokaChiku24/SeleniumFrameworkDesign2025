package standalonetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

import java.time.Duration;

public class OptimizeDesign{

    String email = "testkc@gmail.com";
    String password = "Admin@123";
    String prodName = "ZARA COAT 3";
    String country = "India";
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void endToEnd() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://rahulshettyacademy.com/client");
        // create an account
        // RegisterPage rp = new RegisterPage(driver);
        // rp.registerUser(wait,email,password);

        // login to the account
        LandingPage obj = new LandingPage(driver);
        obj.login(email,password);

        // add item to cart
        ProductCatalogue pc = new ProductCatalogue(driver);
        pc.selectProduct(prodName);

        // go to cart
        CartPage cp = new CartPage(driver);
        Assert.assertTrue(cp.goToCart(prodName));
        cp.gotoPayment();

        // payment page
        PaymentPage pp = new PaymentPage(driver);
        pp.goToSummary(country);

        // order summary
        OrderSummary os = new OrderSummary(driver);
        String actualText = os.orderDetails();
        String expectedTest = "Thankyou for the order.";
        Assert.assertEquals(actualText,expectedTest.toUpperCase());
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedTest));
        driver.close();
    }
}

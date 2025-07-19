package cucumber.stepdefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.*;
import testcomponents.BaseTest;

import java.io.IOException;

public class StepDefinationImp extends BaseTest {

    public LandingPage ladingPage;
    public ProductCatalogue pc;
    public CartPage cp;
    public PaymentPage pp;
    public OrderSummary os;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        ladingPage = launchApplication();
    }

    @Given("^Login to the application with username (.+) and password (.+)$")
    public void login_to_the_application_with_username_and_password(String userName, String password) {
        pc = obj.login(userName, password);
    }

    @When("^I add (.+) to the cart$")
    public void i_add_product_to_the_cart(String productName) {
        pc.addProductToCart(productName);
        cp = pc.addProductToCart(productName);
    }

    @And("^Checkout (.+) and submit the order (.+)$")
    public void checkout_product_and_submit_the_order(String productName, String country){
        Assert.assertTrue(cp.goToCart(productName));
        pp = cp.gotoPayment();
        os = pp.goToSummary(country);
    }

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_confirmartionPage(String string){
        String actualText = os.orderDetails();
        String expectedTest = string;
        Assert.assertEquals(actualText.toUpperCase().trim(), expectedTest.toUpperCase());
        Assert.assertTrue(actualText.toUpperCase().trim().equalsIgnoreCase(expectedTest));
        driver.close();
    }
}

package pageobjects;

import abstractcomponenets.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {
    private WebDriver driver;

    @FindBy(id = "userEmail")
    private WebElement userName;

    @FindBy(id = "userPassword")
    private WebElement userPassword;

    @FindBy(name = "login")
    private WebElement loginBtn;

    @FindBy(css = "[class*='flyInOut']")
    private WebElement errorToast;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ProductCatalogue login(String email, String password) {
        userName.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
        ProductCatalogue pc = new ProductCatalogue(driver);
        return pc;
    }

    public void goToURL(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public String getErrorMessage(){
        visibilityOfElementByWebElement(errorToast);
        return errorToast.getText().trim();
    }

}

package pageobjects;

import abstractcomponenets.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends AbstractComponents {
    private WebDriver driver;

    @FindBy(css = "p.login-wrapper-footer-text")
    private WebElement signUpLink;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "userMobile")
    private WebElement userMobile;

    @FindBy(className = "custom-select")
    private WebElement customSelect;

    @FindBy(css = "input[value='Male']")
    private WebElement gender;

    @FindBy(id = "userPassword")
    private WebElement userPassword;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(css = "input[type='checkbox']")
    private WebElement age18Plus;

    @FindBy(id = "login")
    private WebElement loginBtn;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void registerUser(String email, String password) {
        visibilityOfElementByLocator(By.cssSelector("p.login-wrapper-footer-text"));
        signUpLink.click();
        firstName.sendKeys("Kunal");
        lastName.sendKeys("Chavan");
        userEmail.sendKeys(email);
        userMobile.sendKeys("1234567890");
        new Select(customSelect).selectByValue("3: Engineer");
        gender.click();
        userPassword.sendKeys(password);
        confirmPassword.sendKeys(password);
        age18Plus.click();
        loginBtn.click();
    }
}

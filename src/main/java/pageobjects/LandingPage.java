package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;

    @FindBy(id = "userEmail")
    private WebElement userName;

    @FindBy(id = "userPassword")
    private WebElement userPassword;

    @FindBy(name = "login")
    private WebElement loginBtn;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String email, String password) {
        userName.sendKeys(email);
        userPassword.sendKeys(password);
        loginBtn.click();
    }

}

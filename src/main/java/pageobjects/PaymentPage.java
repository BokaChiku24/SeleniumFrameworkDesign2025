package pageobjects;

import abstractcomponenets.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstractComponents {
    private WebDriver driver;

    private By countrySection = By.cssSelector("section.ta-results");

    @FindBy(css = "div.form-group input.text-validated")
    private WebElement countrySelection;

    @FindBy(className = "action__submit")
    private WebElement submitBtn;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OrderSummary goToSummary(String country) {
        actionsClassObject().moveToElement(countrySelection).click().build().perform();
        actionsClassObject().sendKeys(countrySelection, country).build().perform();
        elementToBeClickableByLocator(countrySection);
        driver.findElement(By.xpath(".//section[@class='ta-results list-group ng-star-inserted']//button//span[text()='" + " " + country + "']"))
                .click();
        submitBtn.click();
        OrderSummary os = new OrderSummary(driver);
        return os;
    }

}

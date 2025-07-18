package pageobjects;

import abstractcomponenets.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends AbstractComponents {
    private WebDriver driver;

    private By orderSummaryMessage = By.cssSelector("hero-primary");

    @FindBy(className = "hero-primary")
    private WebElement orderSummaryText;

    public OrderSummary(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String orderDetails() {
        visibilityOfElementByWebElement(orderSummaryText);
        String actualText = orderSummaryText.getText();
        return actualText;
    }

}

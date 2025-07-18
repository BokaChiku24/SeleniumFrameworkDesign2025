package abstractcomponenets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CartPage;
import pageobjects.MyOrders;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "li:nth-child(4) button.btn.btn-custom")
    private WebElement cartBtn;
    // button[routerlink*='cart']

    @FindBy(css = "li:nth-child(3) button.btn.btn-custom")
    private WebElement orderBtn;

    public CartPage goToCart() {
        cartBtn.click();
        CartPage obj = new CartPage(driver);
        return obj;
    }

    public MyOrders goToOrder() {
        orderBtn.click();
        MyOrders obj = new MyOrders(driver);
        return obj;
    }

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        PageFactory.initElements(driver, this);
    }

    public void visibilityOfElementByLocator(By findBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void visibilityOfElementByWebElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void invisibilityOfElementByLocator(By findBy) {
        /*
        try {
            Thread.sleep(Duration.ofSeconds(2000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public void invisibilityOfElementByWebElement(WebElement element) {
        /*
        try {
            Thread.sleep(Duration.ofSeconds(2000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void elementToBeClickableByLocator(By findBy) {
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void elementToBeClickableByWebElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Actions actionsClassObject() {
        Actions action = new Actions(driver);
        return action;
    }
}

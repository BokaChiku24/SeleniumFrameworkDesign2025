package abstractcomponenets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

    WebDriver driver;
    WebDriverWait wait;

    public AbstractComponents(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
    }

    public void visibilityOfElementByLocator(By findBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void visibilityOfElementByWebElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void invisibilityOfElementByLocator(By findBy){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public void invisibilityOfElementByWebElement(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void elementToBeClickableByLocator(By findBy){
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void elementToBeClickableByWebElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Actions actionsClassObject(){
        Actions action = new Actions(driver);
        return action;
    }
}

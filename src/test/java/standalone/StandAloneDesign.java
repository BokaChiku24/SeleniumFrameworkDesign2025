package standalone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StandAloneDesign {
    String email = "testkc@gmail.com";
    String password = "Admin@123";
    String prodName = "ZARA COAT 3";
    String country = "India";
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void endToEnd() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://rahulshettyacademy.com/client");
        // create an account
        // creatAnAccount();

        // login to the account
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        // add item to cart
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3 h5")));
        List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3 h5"));
        List<WebElement> productAddCart = driver.findElements(By.cssSelector(".mb-3 div[class='card-body'] button[class='btn w-10 rounded']"));
        /*
         List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = productList.stream().filter(s->s.getText()
                .equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        */
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getText().equalsIgnoreCase(prodName)) {
                driver.findElements(By.cssSelector(".mb-3 div[class='card-body'] button[class='btn w-10 rounded']"))
                        .get(i).click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ngx-spinner-overlay"))));
        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-spinner-overlay")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[routerlink*='cart']"))));

        // go to cart
        Thread.sleep(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
        List<WebElement> listOfCartProduct = driver.findElements(By.cssSelector(".cartSection h3"));
        boolean flag = listOfCartProduct.stream().anyMatch(s -> s.getText().equalsIgnoreCase(prodName));
        Assert.assertTrue(flag);
        driver.findElement(By.cssSelector(".totalRow button")).click();

        // payment page
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("div.form-group input.text-validated"))).click().build().perform();
        action.sendKeys(driver.findElement(By.cssSelector("div.form-group input.text-validated")), country).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section.ta-results")));
        driver.findElement(By.xpath(".//section[@class='ta-results list-group ng-star-inserted']//button//span[text()='" + " " + country + "']")).click();
        driver.findElement(By.className("action__submit")).click();

        // order summary
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));
        String actualText = driver.findElement(By.className("hero-primary")).getText();
        String expectedTest = "Thankyou for the order.";
        Assert.assertEquals(actualText,expectedTest.toUpperCase());
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedTest));
        driver.close();
    }

    public void creatAnAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.login-wrapper-footer-text")));
        driver.findElement(By.cssSelector("p.login-wrapper-footer-text")).click();
        driver.findElement(By.id("firstName")).sendKeys("Kunal");
        driver.findElement(By.id("lastName")).sendKeys("Chavan");
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userMobile")).sendKeys("1234567890");
        new Select(driver.findElement(By.className("custom-select"))).selectByValue("3: Engineer");
        driver.findElement(By.cssSelector("input[value='Male']")).click();
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("confirmPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.id("login")).click();
    }
}

package standalonetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class StandAloneDesign {
    String email = "test@gmail.com";
    String password = "Admin@123";
    WebDriver driver;
    WebDriverWait wait;
    @Test
    public void endToEnd() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumDrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10L));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://rahulshettyacademy.com/client");
        // create an account
        // creatAnAccount();

        driver.close();
    }

    public void creatAnAccount(){
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

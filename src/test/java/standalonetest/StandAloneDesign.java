package standalonetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class StandAloneDesign {
    @Test
    public void endToEnd() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/client");
        driver.close();
    }
}

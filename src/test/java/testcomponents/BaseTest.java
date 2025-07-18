package testcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public LandingPage obj;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/GlobalData.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/SeleniumDrivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/SeleniumDrivers/msedgedriver");
            driver = new EdgeDriver();
        } else {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        obj = new LandingPage(driver);
        obj.goToURL();
        return obj;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}

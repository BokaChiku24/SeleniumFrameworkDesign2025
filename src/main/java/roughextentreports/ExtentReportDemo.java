package roughextentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setupExtentReport() {
        // ExtentSparkReport, ExtentReports, ExtentTest
        String filePath = System.getProperty("user.dir") + "/extentreports/index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(filePath);
        report.config().setReportName("Kunal Selenium 2025");
        report.config().setDocumentTitle("Automation Report");
        report.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Tester","Kunal Chavan");
        extent.setSystemInfo("System","Mac");
        extent.setSystemInfo("Browser","Chrome");
    }


    @Test
    public void simpleTest() {
        test =  extent.createTest("Sample Test");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/SeleniumDrivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        test.info("Test pass....");
        driver.close();
    }

    @AfterTest
    public void closeReport(){
        extent.flush();
    }

}

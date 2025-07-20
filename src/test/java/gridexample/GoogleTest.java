package gridexample;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class GoogleTest {

    @Test
    public void homePageCheck() throws URISyntaxException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        caps.setPlatform(Platform.MAC);
        //caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        //caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");


        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.1.139:4444").toURL(), caps);
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Kunal");
        driver.close();
    }
}

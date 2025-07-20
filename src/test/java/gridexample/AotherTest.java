package gridexample;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AotherTest {

    @Test
    public void homePageCheck() throws URISyntaxException, MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setBrowserName("firefox");
        caps.setPlatform(Platform.MAC);
        //caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");


        WebDriver driver = new RemoteWebDriver(new URI("http://192.168.1.139:4444").toURL(), caps);
        driver.get("https://www.yahoo.com");
        System.out.println(driver.getTitle());
        //driver.findElement(By.name("q")).sendKeys("Kunal");
        driver.close();
    }
}

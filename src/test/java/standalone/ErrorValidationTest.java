package standalone;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcomponents.BaseTest;
import testcomponents.RetryAnalyser;

public class ErrorValidationTest extends BaseTest {
    @Test(groups={"ErrorHandling","Regression"}, retryAnalyzer = RetryAnalyser.class)
    public void errorTest(){
        obj.login("kc@gmail.com","62387512");
        String actualErrorMessage = obj.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Incorrect email or password.");
    }
}

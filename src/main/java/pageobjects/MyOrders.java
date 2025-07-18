package pageobjects;

import abstractcomponenets.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyOrders extends AbstractComponents {
    private WebDriver driver;

    private By orderProduceList = By.cssSelector("tbody td:nth-child(3)");

    @FindBy(css = "tbody td:nth-child(3)")
    private List<WebElement> orderProductList;

    public MyOrders(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    public void selectProduct(String prodName) {
        visibilityOfElementByLocator(productAppears);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getText().equalsIgnoreCase(prodName)) {
                productAddCart.get(i).click();
                break;
            }
        }
        visibilityOfElementByLocator(toastMessage);
        invisibilityOfElementByLocator(spinner);
    }
     */
    public List<WebElement> getOrderProductName() {
        visibilityOfElementByLocator(orderProduceList);
        return orderProductList;
    }

    public String getOrderProductName(String productName) {
        WebElement order = getOrderProductName().stream().filter(product -> product
                .getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return order.getText();
    }

    /*
    public CartPage addProductToCart(String productName){
        WebElement prod =  getProductName(productName);
        prod.findElement(addTocart).click();
        visibilityOfElementByLocator(toastMessage);
        invisibilityOfElementByLocator(spinner);
        CartPage cp = new CartPage(driver);
        return cp;
    }
*/

}

package pageobjects;

import abstractcomponenets.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    private WebDriver driver;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> listOfCartProduct;

    @FindBy(css = ".totalRow button")
    private WebElement paymentBtn;

    @FindBy(css = "li:nth-child(4) button.btn.btn-custom")
    private WebElement cartBtn;
    // button[routerlink*='cart']

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean goToCart(String prodName) {
        visibilityOfElementByWebElement(cartBtn);
        cartBtn.click();
        boolean flag = listOfCartProduct.stream().anyMatch(s -> s.getText().equalsIgnoreCase(prodName));
        return flag;
    }

    public void gotoPayment(){
        paymentBtn.click();
    }

}

package pageobjects;

import abstractcomponenets.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponents {
    private WebDriver driver;

    private By productAppears = By.cssSelector(".mb-3 h5");
    private By toastMessage = By.cssSelector("#toast-container");
    private By spinner = By.cssSelector(".ng-animating");
    private By addTocart = By.cssSelector(".card-body button:last-of-type");

    @FindBy(css = ".mb-3 h5")
    private List<WebElement> productList;

    @FindBy(css = ".mb-3")
    private List<WebElement> productListNew;

    @FindBy(css = ".mb-3 div[class='card-body'] button[class='btn w-10 rounded']")
    private List<WebElement> productAddCart;

    @FindBy(css = "button[routerlink*='cart']")
    private WebElement cartBtn;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
    public List<WebElement> getProductList(){
        visibilityOfElementByLocator(productAppears);
        return productListNew;
    }

    public WebElement getProductName(String productName){
        return getProductList().stream().filter(product->product.findElement(By.cssSelector("b"))
                .getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
    }

    public CartPage addProductToCart(String productName){
        WebElement prod =  getProductName(productName);
        prod.findElement(addTocart).click();
        visibilityOfElementByLocator(toastMessage);
        invisibilityOfElementByLocator(spinner);
        CartPage cp = new CartPage(driver);
        return cp;
    }
}

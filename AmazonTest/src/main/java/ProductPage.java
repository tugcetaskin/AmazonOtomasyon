import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {

    By shippingOptionLocator = By.id("p_n_free_shipping_eligible-title");
    By productNameLocator = new By.ByCssSelector("span.a-size-base-plus");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    private List<WebElement> getAllProducts() {
        return findAll(productNameLocator);
    }
}

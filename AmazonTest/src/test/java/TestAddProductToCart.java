import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestAddProductToCart extends BaseTest{

    HomePage homePage;
    ProductPage productPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void searchProduct() {
        homePage=new HomePage(driver);
        productPage=new ProductPage(driver);

        homePage.acceptCookies();
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productPage.isOnProductPage(), "Not on the product page!");
    }

    @Test
    @Order(2)
    public void selectProduct() {
        productDetailPage=new ProductDetailPage(driver);

        productPage.selectProduct(2);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(), "Not on the product detail page!");
    }

    @Test
    @Order(3)
    public void addProductToCard() {
        productDetailPage.addToCart();
        Assertions.assertTrue(homePage.isProductCountUp(),"The number of products did not increase!");
    }

    @Test
    @Order(4)
    public void goToCart() {
        cartPage=new CartPage(driver);

        homePage.goToCart();
        Assertions.assertTrue(cartPage.isProductAdded(),"Product not added to cart!");

    }
}

package tests;

import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import Pages.ShoppingCart;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest  extends  TestBase{

    String ProductName = "Apple MacBook Pro";
    SearchProductPage searchObj;
    ProductPageDetails productDetails;
    ShoppingCart shoppingCartObj;

    @Test(priority = 1 ,alwaysRun = true)
    public void UserCanResearchWithAutoSuggest(){
        searchObj = new SearchProductPage(driver);
        productDetails = new ProductPageDetails(driver);
        searchObj.ProductSearchUsingAutoSuggest(ProductName);
        Assert.assertTrue(productDetails.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
    }

    @Test(priority = 2 , dependsOnMethods = "UserCanResearchWithAutoSuggest")
    public void UserCanAddProduct(){
        productDetails = new ProductPageDetails(driver);
        productDetails.AddToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//div[@id='bar-notification']//span[@class='close']")));
        productDetails.CloseTheMessageOfAddProduct();
        productDetails.OpenPageOfShopping();
    }

    @Test(priority = 3 , dependsOnMethods ="UserCanAddProduct" )
    public void  UserCanUpQuantity(){
        shoppingCartObj = new ShoppingCart(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id^='quantity-up-']")));
        shoppingCartObj.AddNewQuantity();
   // Assert.assertTrue(shoppingCartObj.textOfPrice.getText().contains("$1,800.00"));
    }

    @Test(priority = 4)
    public void UserCanClearShoppingCart(){
        shoppingCartObj = new ShoppingCart(driver);
        shoppingCartObj.ClearShopping();
        Assert.assertTrue(shoppingCartObj.CartEmpty.getText().contains("Your Shopping Cart is empty!"));
    }
}

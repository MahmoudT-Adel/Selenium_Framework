package tests;

import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import Pages.WishListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishListTest extends TestBase{
    String ProductName = "Apple MacBook Pro";
    SearchProductPage searchObj;
    ProductPageDetails productDetails;
    WishListPage wishListObj;

    @Test(priority = 1 , alwaysRun = true)
    public void UserCanSearchOfProduct() throws InterruptedException{
        searchObj = new SearchProductPage(driver);
        productDetails = new ProductPageDetails(driver);
        searchObj.SearchOfProduct(ProductName);
        searchObj.OpenProductDetails();
        Assert.assertTrue(productDetails.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
        productDetails.AddProductToWishList();
        Thread.sleep(3000);
        productDetails.OpenPageOfWishList();
    }

    @Test(priority = 2)
    public void UserCanAddProductToWishList(){
        wishListObj = new WishListPage(driver);
     //   Assert.assertTrue(wishListObj.pageTitle.getText().contains("Wishlist"));
        wishListObj.UpdateCartProduct();
    }

    @Test(priority = 3  ,dependsOnMethods = "UserCanAddProductToWishList")
    public void UserCanRemoveWishList() throws InterruptedException{
        wishListObj = new WishListPage(driver);
        Thread.sleep(3000);
         wishListObj.RemoveWishList();
        Assert.assertTrue(wishListObj.nodData.getText().contains("The wishlist is empty!"));
    }

}

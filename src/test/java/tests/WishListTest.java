package tests;

import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import Pages.WishListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishListTest extends TestBase{
    String ProductName = "Apple MacBook Pro";
    SearchProductPage searchObj;
    ProductPageDetails productDetails;
    WishListPage wishListObj;

    @Test(priority = 1 , alwaysRun = true)
    public void UserCanSearchOfProduct(){
        searchObj = new SearchProductPage(driver);
        productDetails = new ProductPageDetails(driver);
        searchObj.SearchOfProduct(ProductName);
        searchObj.OpenProductDetails();
        Assert.assertTrue(productDetails.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
        productDetails.AddProductToWishList();
        productDetails.OpenPageOfWishList();
    }

    @Test(priority = 2)
    public void UserCanAddProductToWishList(){
        wishListObj = new WishListPage(driver);
        Assert.assertTrue(wishListObj.pageTitle.getText().contains("Wishlist"));
        wishListObj.UpdateCartProduct();
    }

    @Test(priority = 3)
    public void UserCanRemoveWishList(){
        wishListObj.RemoveWishList();
        Assert.assertTrue(wishListObj.nodData.getText().contains("The wishlist is empty!"));
    }

}

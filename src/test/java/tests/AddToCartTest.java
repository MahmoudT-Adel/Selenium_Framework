package tests;

import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import Pages.ShoppingCart;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test(priority = 2)
    public void UserCanAddProduct(){
        productDetails = new ProductPageDetails(driver);
        productDetails.AddToCart();
//        productDetails.CloseTheMessageOfAddProduct();
        productDetails.OpenPageOfShopping();
    }
//
//    @Test(priority = 3)
//    public void  UserCanUpQuantity(){
//        shoppingCartObj = new ShoppingCart(driver);
//        shoppingCartObj.AddNewQuantity();
//        Assert.assertTrue(shoppingCartObj.textOfPrice.getText().contains("$1,800.00"));
//    }
//
//    @Test(priority = 4)
//    public void UserCanClearShoppingCart(){
//        shoppingCartObj = new ShoppingCart(driver);
//        shoppingCartObj.ClearShopping();
//        Assert.assertTrue(shoppingCartObj.CartEmpty.getText().contains("Your Shopping Cart is empty!"));
//    }
}

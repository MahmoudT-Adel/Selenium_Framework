package tests;

import Pages.CheckOutPage;
import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import Pages.ShoppingCart;
import org.testng.annotations.Test;

public class RegisterUserCheckOutTest extends  TestBase{
    String ProductName = "Apple MacBook Pro";
    String FirstName = "Mahmoud";
    String LastName = "Adel";
    String Email = "Apple4@gmail.com";
    String City = "Egypt";
    String Address="3 Of Any";
    String code ="235";
    String Phone = "01065870527";

    SearchProductPage searchObj;
    ProductPageDetails productDetails;
    ShoppingCart shoppingCartObj;
    CheckOutPage checkOutPageObj;

    @Test(priority = 1 , alwaysRun = true)
    public void UserCanSearchOfProduct(){
        searchObj = new SearchProductPage(driver);
        productDetails = new ProductPageDetails(driver);
        searchObj.SearchOfProduct(ProductName);
        searchObj.OpenProductDetails();
    }

    @Test(priority = 2)
    public void UserCanAddProduct(){
        productDetails = new ProductPageDetails(driver);
        productDetails.AddToCart();

    }
    @Test(priority = 3)
    public  void UserCanOpenShoppingCartPage(){
        productDetails.OpenPageOfShopping();
    }



    @Test(priority = 4 )
    public void UserCanOpenCheckOutPage(){
        shoppingCartObj = new ShoppingCart(driver);
    shoppingCartObj.TermsOfServiceConditional();
    shoppingCartObj.CheckOutBtn();
    }

    @Test(priority = 5)
    public void CheckOutAsGuest(){
        checkOutPageObj = new CheckOutPage(driver);
        checkOutPageObj.OpenCheckOutGuestPage();
    }

    @Test(priority = 6)
    public  void UserCanCheckOut(){
        checkOutPageObj = new CheckOutPage(driver);
        checkOutPageObj.UserInformDataToCheckOut(FirstName , LastName ,Email , City , Address , code , Phone);
    }

//    @Test(priority = 7)
//    public void EndOCheckOut(){
//        checkOutPageObj.ChooseShippingMethod();
//    }
}

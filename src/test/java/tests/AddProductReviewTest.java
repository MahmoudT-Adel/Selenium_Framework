package tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductReviewTest extends  TestBase{

    ProductPageDetails productDetailsObj;
    ProductPageReview productPageReviewObj;
    String TitleOfReview = "Review Of This Product";
    String TextOfReview = "This Product is Good For You";
    SearchProductPage searchObj;
    HomePage homeObject;
    UserRegistration userRegistrationObj;
    String Email ="Mahmoud12200@gmail.com";
    String ProductName = "Apple MacBook Pro";

    //User Can Register.....
    @Test(priority = 1 , alwaysRun = true)
    public  void UserRegistrationSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.OPenRegistrationPage();
        userRegistrationObj = new UserRegistration(driver);
        userRegistrationObj.userRegistration("Mahmoud" , "Adel" , Email , "32342343");
        Assert.assertTrue(userRegistrationObj.messageSuccessful.getText().contains("Your registration completed"));
    }


    //User Can Search Of Product...
    @Test(priority = 2)
    public void UserCanSearchOfProduct(){
        searchObj = new SearchProductPage(driver);
        productDetailsObj = new ProductPageDetails(driver);
        searchObj.SearchOfProduct(ProductName);
        searchObj.OpenProductDetails();
        Assert.assertTrue(productDetailsObj.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
    }

    @Test(priority = 3)
    public  void UserCanAddReview(){
        productDetailsObj = new ProductPageDetails(driver);
        productPageReviewObj =new ProductPageReview(driver);
        productDetailsObj.OpenPageOfAddReview();
        productPageReviewObj.UserCanAddReview(TitleOfReview , TextOfReview);
        Assert.assertTrue(productPageReviewObj.successfullyAdded.getText().contains("Product review is successfully added."));
    }

    @Test(priority = 4)
    public void registerUserCanCloseNavBar(){
        userRegistrationObj.CloseSpan();
    }
    @Test(priority = 4)
    public void registerUserCanLogOut(){
        userRegistrationObj.LogOutLink();
    }


}

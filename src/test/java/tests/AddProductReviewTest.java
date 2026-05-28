package tests;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddProductReviewTest extends  TestBase{

    ProductPageDetails productDetailsObj;
    ProductPageReview productPageReviewObj;
    String TitleOfReview = "Review Of This Product";
    String TextOfReview = "This Product is Good For You";
    SearchProductPage searchObj;
    HomePage homeObject;
    UserRegistration userRegistrationObj;
    String Email ="MahmoudAdelTaha90@gmail.com";
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
        productDetailsObj.OpenPageOfAddReview();
        productPageReviewObj = new ProductPageReview(driver);
        productPageReviewObj.UserCanAddReview(TitleOfReview , TextOfReview);
        productPageReviewObj.ratingOfProduct.click();
        productPageReviewObj.addBtn.click();
        Assert.assertTrue(productPageReviewObj.successfullyAdded.getText().contains("Product review is successfully added."));
        productPageReviewObj.closeMassage.click();
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

package tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends  TestBase{

    SearchProductPage searchObj;
    ProductPageDetails  productDetails;
    HomePage homeObject;
    UserRegistration userRegistrationObj;
    EmailFriendPage sendEmailToYourFriendObj;
    String Email="Mahmoudf@gmail.com";
    String FriendsEmail = "Ahmed0112200@gmail.com";
    String SendMassage ="Hello My Friend";
    String ProductName = "Apple MacBook Pro";


    // User Can Registration
    @Test(priority = 1 , alwaysRun = true)
    public  void UserRegistrationSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.OPenRegistrationPage();
        userRegistrationObj = new UserRegistration(driver);
        userRegistrationObj.userRegistration("Mahmoud" , "Adel" , Email , "32342343");
        Assert.assertTrue(userRegistrationObj.messageSuccessful.getText().contains("Your registration completed"));
    }

    //User Can search of Product
    @Test(priority = 2)
    public void UserCanResearchWithAutoSuggest(){
        searchObj = new SearchProductPage(driver);
        productDetails = new ProductPageDetails(driver);
        searchObj.ProductSearchUsingAutoSuggest("Mac");
        productDetails = new ProductPageDetails(driver);
        Assert.assertTrue(productDetails.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
    }


    //User Can Send Email
    @Test(priority = 3)
    public void UserCanSendEmail(){
        productDetails.OpenSendEmailToFriend();
        sendEmailToYourFriendObj = new EmailFriendPage(driver);
        sendEmailToYourFriendObj.UserCanSendEmailToHerFriend(FriendsEmail , SendMassage );
        sendEmailToYourFriendObj.sendEmailBtn.click();;
      Assert.assertTrue(sendEmailToYourFriendObj.successMassageNotification.getText().contains("Your message has been sent."));
    }

    //User Can Log Out
    @Test(priority = 4)
    public void registerUserCanLogOut(){
        userRegistrationObj.LogOutLink();
    }



}

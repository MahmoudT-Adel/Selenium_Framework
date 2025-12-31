package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistration;
import org.testng.Assert;
import org.testng.annotations.Test;



public class UserRegistrationTest extends TestBase{
    HomePage homeObject;
    UserRegistration userRegistrationObj;
    LoginPage loginObj;
    String Email="Mahmod00245@gmail.com";
//
//    @Test(priority = 1 , alwaysRun = true)
//    public void Human() {
//
//        userRegistrationObj.NotReport();
//    }

    @Test(priority = 2 , alwaysRun = true)
    public  void UserRegistrationSuccessfully() {
        homeObject = new HomePage(driver);
        userRegistrationObj = new UserRegistration(driver);
        homeObject.OPenRegistrationPage();
         userRegistrationObj.userRegistration("Mahmoud" , "Adel" , Email , "32342343");
        Assert.assertTrue(userRegistrationObj.messageSuccessful.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = {"UserRegistrationSuccessfully"})
    public void registerUserCanLogOut(){
        userRegistrationObj.LogOutLink();
    }

    @Test(dependsOnMethods = {"registerUserCanLogOut"})
    public  void  UserCanLogin(){
        homeObject.OPenLoginPage();
        loginObj = new LoginPage(driver);
        loginObj.UserLogin(Email , "32342343");
        Assert.assertTrue(userRegistrationObj.logOut.isDisplayed());
    }


}

package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistration;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends  TestBase{
    String firstName="Mahmoud";
    String lastName ="Adel";
    String Email= "MahmoudH20913@gmail.com";
    String Password ="123456";
    String NewPassword ="123456";
    String OldPassword="123456";

    HomePage homeObject;
    UserRegistration userRegistrationObj;
    MyAccountPage MyAccountOb;
    LoginPage loginObj;

    @Test(priority = 1 , alwaysRun = true)
    public  void UserRegistrationSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.OPenRegistrationPage();
        userRegistrationObj = new UserRegistration(driver);
        userRegistrationObj.userRegistration(firstName , lastName , Email , Password);
        Assert.assertTrue(userRegistrationObj.messageSuccessful.getText().contains("Your registration completed"));
    }

    @Test(dependsOnMethods = {"UserRegistrationSuccessfully"})
    public  void RegisterUserCanChangePassword(){
        MyAccountOb = new MyAccountPage(driver);
        MyAccountOb.OpenChangePassPage();
     MyAccountOb.ChangePassword(OldPassword ,NewPassword);
     Assert.assertTrue(MyAccountOb.divResult.getText().contains("Password was changed"));
    }

    @Test(dependsOnMethods = {"RegisterUserCanChangePassword"})
    public void registerUserCanLogOut(){
        userRegistrationObj.LogOutLink();
    }

    @Test(dependsOnMethods = {"registerUserCanLogOut"})
    public  void  UserCanLogin(){
        homeObject.OPenLoginPage();
        loginObj = new LoginPage(driver);
        loginObj.UserLogin(Email , NewPassword);
        Assert.assertTrue(userRegistrationObj.logOut.isDisplayed());
    }
}

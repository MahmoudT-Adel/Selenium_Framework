package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationDDTandDataProviderUserRegistrationDDTandDataProvider extends TestBase{
    HomePage homeObject;
    UserRegistration userRegistrationObj;
    LoginPage loginObj;
    String Email="Mahmoud0245@gmail.com";

    @DataProvider(name = "testData")
    public static Object [][] userData()
    {
        return new Object [][]{
                {"Mahmoud" , "Adel" , "M4.13Adel2AO1@gmail.com" , "123456"},
                {"Mahmoud" , "Taha" , "N8.14Ade03@gmail.com" , "123456"},
        };
    }

    @DataProvider
    public static Object [][] userLoginData()
    {
        return new Object [][]{
                { "M4.13Adel2AO1@gmail.com" , "123456"},

        };
    }


    @Test(priority = 1 , alwaysRun = true , dataProvider = "testData")
    public  void UserRegistrationSuccessfully(String fName , String lName , String email , String password){
        homeObject = new HomePage(driver);
        homeObject.OPenRegistrationPage();
      userRegistrationObj = new UserRegistration(driver);
      userRegistrationObj.userRegistration(fName , lName , email , password);
        Assert.assertTrue(userRegistrationObj.messageSuccessful.getText().contains("Your registration completed"));
        userRegistrationObj.LogOutLink();
        loginObj = new LoginPage(driver);
        homeObject.OPenLoginPage();
        loginObj.UserLogin(email ,password );
        userRegistrationObj.LogOutLink();
    }



    @Test(dependsOnMethods = {"UserRegistrationSuccessfully"} , dataProvider = "userLoginData")
    public  void  UserCanLogin(String email , String password){
        homeObject = new HomePage(driver);
        homeObject.OPenLoginPage();
        loginObj.UserLogin(email ,password );//Assert.assertTrue(userRegistrationObj.logOut.isDisplayed());
    }


}

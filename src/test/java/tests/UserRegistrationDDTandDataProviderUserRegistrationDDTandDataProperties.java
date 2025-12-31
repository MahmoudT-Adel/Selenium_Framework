package tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistration;
import deta.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationDDTandDataProviderUserRegistrationDDTandDataProperties extends TestBase{
    HomePage homeObject;
    UserRegistration userRegistrationObj;
    LoginPage loginObj;
//    String Email="Mahmoud20245@gmail.com";
   String fName = LoadProperties.userData.getProperty("fName");
   String lName = LoadProperties.userData.getProperty("lName");
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");



    @Test(priority = 1 , alwaysRun = true )
    public  void UserRegistrationSuccessfully(){
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

//    @Test(dependsOnMethods = {"UserRegistrationSuccessfully"})
//    public void registerUserCanLogOut(){
//        userRegistrationObj.LogOutLink();
//    }
//
//    @Test(dependsOnMethods = {"registerUserCanLogOut"} , dataProvider = "testData")
//    public  void  UserCanLogin(String email , String password){
//        homeObject.OPenLoginPage();
//        loginObj = new LoginPage(driver);
//        loginObj.UserLogin(email ,password );
//        Assert.assertTrue(userRegistrationObj.logOut.isDisplayed());
//    }


}

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
    String Email="Mahmoud20245@gmail.com";

    @DataProvider(name = "testData")
    public static Object [][] userData()
    {
        return new Object [][]{
                {"Mahmoud" , "Adel" , "Adel11@gmail.com" , "123456"},
                {"Mahmoud" , "Taha" , "Adel131@gmail.com" , "123456"},
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

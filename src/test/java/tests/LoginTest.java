package tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
      HomePage homePage;
      LoginPage loginPage;
    @Test
    public  void UserLogin(){
        homePage =new HomePage(driver);
        homePage.OPenLoginPage();
        loginPage = new LoginPage(driver);
        loginPage.UserLogin("Ma22500!5A@gmail.com" , "32342343");
    }
}

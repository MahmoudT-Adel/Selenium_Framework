package tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
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
        String messageCancel = driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(messageCancel, "Login Successful");
      }
}


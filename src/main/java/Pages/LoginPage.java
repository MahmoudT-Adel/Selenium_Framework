package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  PageBase{

    public  LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css ="input.email")
    WebElement EmailTxtBox;
    @FindBy(id="Password")
    WebElement PasswordTxt;
    @FindBy(xpath="//button[@class='button-1 login-button']")
   public   WebElement LoginBtn;

    public void UserLogin(String Email ,String Password ){
        SendText(EmailTxtBox , Email);
        SendText(PasswordTxt , Password);
        ClickButton(LoginBtn);
    }
}

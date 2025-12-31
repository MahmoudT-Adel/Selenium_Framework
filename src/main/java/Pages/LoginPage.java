package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends  PageBase{

    public  LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id ="Email")
    WebElement EmailTxtBox;
    @FindBy(id="Password")
    WebElement PasswordTxt;
    @FindBy(css="input.button-1.login-button")
    WebElement LoginBtn;

    public void UserLogin(String Email ,String Password ){
        SendText(EmailTxtBox , Email);
        SendText(PasswordTxt , Password);
ClickButton(LoginBtn);
    }
}

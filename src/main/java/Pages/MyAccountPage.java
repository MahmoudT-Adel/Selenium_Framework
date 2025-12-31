package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends  PageBase{
    public  MyAccountPage (WebDriver driver){
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement ChangePassBtn;
    @FindBy(id = "OldPassword")
    WebElement oldPasswordTxt;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;


    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPasswordTxt;

    @FindBy(css = "input.button-1.change-password-button")
    WebElement changePassBtn;
    @FindBy(css = "input.content")
    public  WebElement divResult;

    public  void OpenChangePassPage(){
        ClickButton(ChangePassBtn);
    }

    public void ChangePassword(String OldPassword , String NewPassword){
        SendText(oldPasswordTxt , OldPassword);
        SendText(newPasswordTxt , NewPassword);
        SendText(ConfirmPasswordTxt , NewPassword);
        ClickButton(changePassBtn);
    }

}

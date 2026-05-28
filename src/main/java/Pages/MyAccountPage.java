package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends  PageBase{
    public  MyAccountPage (WebDriver driver){
        super(driver);
    }
    @FindBy(css = "a[href='/customer/changepassword']")
    WebElement ChangePassBtn;
    @FindBy(id = "OldPassword")
     public WebElement oldPasswordTxt;

    @FindBy(id = "NewPassword")
    WebElement newPasswordTxt;


    @FindBy(id = "ConfirmNewPassword")
    WebElement ConfirmPasswordTxt;

    @FindBy(css = "button.change-password-button")
    WebElement changePassBtn;
    @FindBy(css = "div.bar-notification.success p.content")
    public  WebElement divResult;
    @FindBy(css = "div.bar-notification.success span.close")
     public WebElement divResultClose;

    public  void OpenChangePassPage(){
        ClickButton(ChangePassBtn);
    }

    public void ChangePassword(String OldPassword , String NewPassword  ){
        SendText(oldPasswordTxt , OldPassword);
        SendText(newPasswordTxt , NewPassword);
        SendText(ConfirmPasswordTxt , NewPassword);
        ClickButton(changePassBtn);
    }

}

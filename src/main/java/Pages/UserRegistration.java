package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistration extends PageBase{
public UserRegistration(WebDriver driver){
super(driver);
}


@FindBy(id = "gender-male")
    WebElement genderBtn;
@FindBy (id = "FirstName")
    WebElement firstTxtName;

@FindBy(id = "LastName")
    WebElement lastTxtName;
@FindBy(id = "Email")
    WebElement emailTxt;
@FindBy(id = "Password")
    WebElement passwordTxt;

@FindBy(id = "ConfirmPassword")
    WebElement confirmTxtPassword;
@FindBy(id = "register-button")
    WebElement btnReg;

@FindBy(xpath = "//*[@id=\"SoGDz7\"]/div/label/input")
WebElement notReport;


public  @FindBy(css = "div.result")
WebElement messageSuccessful;




 @FindBy(xpath= "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
   public   WebElement logOut;

@FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
WebElement CloseSpan;





    public  void userRegistration(String firstName , String lastName , String Email , String Password ){
   ClickButton(genderBtn);
  SendText(firstTxtName , firstName);
    SendText(lastTxtName , lastName);
   SendText(emailTxt , Email);
    SendText(passwordTxt , Password);
    SendText(confirmTxtPassword , Password);
    ClickButton(btnReg);

}

public void NotReport(){
        ClickButton(notReport);
}

public void CloseSpan(){
    ClickButton(CloseSpan);
}
public void  LogOutLink () {
    ClickButton(logOut);
}





}

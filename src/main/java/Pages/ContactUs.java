package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs extends  PageBase{
    public  ContactUs (WebDriver driver){
        super(driver);
    }
    @FindBy(id ="FullName")
     WebElement Name;

    @FindBy(id = "Email")
     WebElement UserEmail;

    @FindBy(id = "Enquiry")
     WebElement enquiry;

    @FindBy(css= "button.contact-us-button")
     WebElement btnSubmit;
    @FindBy(css = "div.result")
     public WebElement successMessage;

    public  void  UserCanContactUs(String NameTxt, String EmailTxt ,String EnquireTxt){
        SendText(Name , NameTxt);
        SendText(UserEmail , EmailTxt);
        SendText(enquiry , EnquireTxt  );
        btnSubmit.click();
    }
}

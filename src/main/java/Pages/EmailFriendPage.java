package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends  PageBase {
    public EmailFriendPage (WebDriver driver){
        super(driver);
    }

    @FindBy(css = "input.friend-email")
    WebElement friendEmailTxt;

   @FindBy(css = "input.your-email")
           WebElement EmailAddressTxT;

    @FindBy(xpath = "//*[@id=\"PersonalMessage\"]")
    WebElement personalMassage;

    @FindBy(css = "button.button-1.send-email-a-friend-button")
      public  WebElement sendEmailBtn;

    @FindBy(css = "div.result")
    public  WebElement successMassageNotification;

    public void UserCanSendEmailToHerFriend(String FriendEmail  , String sendMessage){
        SendText(friendEmailTxt , FriendEmail);
//       SendText(EmailAddressTxT , EmailAddress);
        SendText(personalMassage , sendMessage);
//        ClickButton(sendEmailBtn);

    }
}

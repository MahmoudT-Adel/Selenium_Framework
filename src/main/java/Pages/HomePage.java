package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class HomePage extends  PageBase{
    public HomePage(WebDriver driver){
    super(driver);
    JSE = (JavascriptExecutor) driver;
    action = new Actions(driver);
}


    @FindBy(xpath ="/html/body/div[6]/header/div[1]/div[2]/div[1]/ul/li[1]/a")
    WebElement registerLink;

    @FindBy (linkText = "Log in")
    WebElement loginLink;

    @FindBy (linkText = "Contact us")
    WebElement contactUs;

    @FindBy(id = "customerCurrency")
    WebElement currencyList;

    @FindBy(css ="a[href='/computers']")
    WebElement ComputerMenu;

    @FindBy(css =" a[href='/notebooks']")
    WebElement NoteMenu;
    @FindBy(css = "a.ico-account")
    WebElement MyAccountBtn;

    public void OPenRegistrationPage() {
    registerLink.click();
    }

    public void OPenLoginPage() {
        loginLink.click();
    }
    public  void  OpenContactUsPage(){
     ScrollButton();
     ClickButton(contactUs);
    }

    public void  OpenCurrencyList(){
        select = new Select(currencyList);
        select.selectByVisibleText("Euro");
        System.out.println(currencyList.getText());
    }

    public void OpenNoteBookPage(){
        action.moveToElement(ComputerMenu)
                .pause(Duration.ofSeconds(5)) // wait for menu to appear
                .moveToElement(NoteMenu)
                .click()
                .perform();
    }

    public void OpenMyAccountPage(){
        ClickButton(MyAccountBtn);
    }
}

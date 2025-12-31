package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



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

    @FindBy(xpath ="/html/body/div[6]/div[2]/ul[1]/li[1]/a")
    WebElement ComputerMenu;

    @FindBy(xpath ="/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
    WebElement NoteMenu;


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
                .moveToElement(NoteMenu)
                .click().build().perform();
    }
}

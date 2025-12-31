package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.plaf.PanelUI;

public class ShoppingCart extends PageBase{
    public   ShoppingCart(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"quantity-up-30\"]")
    WebElement UpQuantity;

    @FindBy(css = "span.product-unit-price")
    public WebElement textOfPrice;

    @FindBy(css = "button.remove-btn")
    WebElement RemoveBtn;

    @FindBy(css = "div.no-data")
    public  WebElement CartEmpty;

    @FindBy(id = "checkout")
     WebElement checkoutBtn;

    @FindBy(id = "termsofservice")
    WebElement termsOfService;

    public void AddNewQuantity(){
        ClickButton(UpQuantity);
    }

    public void ClearShopping(){
        ClickButton(RemoveBtn);
    }

    public void TermsOfServiceConditional()
    {
        ClickButton(termsOfService);

    }

    public void CheckOutBtn(){
        ClickButton(checkoutBtn);
    }
}
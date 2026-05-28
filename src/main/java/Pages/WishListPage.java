package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase{
    public  WishListPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath="//*[@id=\"main\"]/div/div/div/div[1]/h1")
    public  WebElement pageTitle;
    //updatecart
    @FindBy(id = "updatecart")
    WebElement updateBtn;

    @FindBy(xpath = "//input[@name='removefromcart']")
    WebElement removeProduct;

    @FindBy(xpath ="//*[@id=\"main\"]/div/div/div/div[2]/div")
    public WebElement nodData;

    public void UpdateCartProduct(){
        ClickButton(updateBtn);
     }

     public void RemoveWishList(){
         ClickButton(removeProduct);
     }

}

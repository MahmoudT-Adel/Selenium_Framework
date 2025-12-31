package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageReview extends  PageBase{
    public  ProductPageReview (WebDriver driver){
        super(driver);
    }
    UserRegistration userRegistrationObj;

    @FindBy(id = "AddProductReview_Title")
    WebElement titleOfAddReviewTxt;

    @FindBy(id = "AddProductReview_ReviewText")
    WebElement txtOfReview;

    @FindBy(id = "addproductrating_5")
    WebElement ratingOfProduct;

    @FindBy(id="add-review")
    WebElement addBtn;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/p")
    public WebElement successfullyAdded;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
    public WebElement closeMassage;

    public void UserCanAddReview(String TitleOfReview , String TextOfReview ){
   SendText(titleOfAddReviewTxt, TitleOfReview);
   SendText(txtOfReview , TextOfReview);
   ClickButton(ratingOfProduct);
   ClickButton(addBtn);
   ClickButton(closeMassage);
    }
}

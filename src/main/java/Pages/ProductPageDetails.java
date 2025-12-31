package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageDetails extends  PageBase{
  public  ProductPageDetails(WebDriver driver){
      super(driver);
  }

  @FindBy(css = "div.product-name")
 public     WebElement productNameOfCrumb;

    @FindBy(css = "button.button-2.email-a-friend-button")
    public     WebElement sendEmail;

    @FindBy(id="price-value-4")
    public WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[3]/div[3]/a")
    WebElement addReview;

    @FindBy(id = "add-to-wishlist-button-4")
    WebElement AddWishList;

    @FindBy(xpath = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a")
    WebElement OpenPageOfWishList;

    @FindBy(css = "button.button-2.add-to-compare-list-button")
    WebElement CompareBtn;

    @FindBy(partialLinkText ="comparison")
  public   WebElement ProductComparisonLink;

    @FindBy(id = "add-to-cart-button-4")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"bar-notification\"]/div/span")
    WebElement CloseMessageOfAddToCard;

    @FindBy(xpath ="//*[@id=\"topcartlink\"]/a")
    WebElement ShoppingLink;

    public  void OpenSendEmailToFriend(){
        ClickButton(sendEmail);
    }

    public  void OpenPageOfAddReview(){
        ClickButton(addReview);
    }

    public void AddProductToWishList(){
        ClickButton(AddWishList);
    }

    public  void OpenPageOfWishList(){
        ClickButton(OpenPageOfWishList);
    }

    public void addToCompare(){
        ClickButton(CompareBtn);
    }


    public void AddToCart(){
        ClickButton(addToCartBtn);
    }

//    public void  CloseTheMessageOfAddProduct(){
//        ClickButton(CloseMessageOfAddToCard);
//    }

    public void  OpenPageOfShopping(){
        ClickButton(ShoppingLink);
    }
}

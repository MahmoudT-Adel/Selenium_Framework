package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchProductPage extends PageBase{
    public  SearchProductPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="small-searchterms")
    WebElement SearchInput ;

    @FindBy(xpath="//*[@id=\"small-search-box-form\"]/button")
    WebElement btnSrc ;

    @FindBy(xpath="//*[@id=\"ui-id-1\"]")
    List <WebElement> ProductList ;

    @FindBy(linkText ="Apple MacBook Pro")
    WebElement ProductTitle;


    public void SearchOfProduct(String value) {
       SendText(SearchInput , value);
       ClickButton(btnSrc);
    }

    public void OpenProductDetails(){
        ClickButton(ProductTitle);
    }

    public void ProductSearchUsingAutoSuggest(String searchTxt){
        SendText(SearchInput , searchTxt);


        try {
            Thread.sleep(3000);
            ProductList.getFirst().click();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}

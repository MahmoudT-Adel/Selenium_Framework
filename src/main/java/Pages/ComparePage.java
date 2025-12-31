package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ComparePage extends PageBase{
    public ComparePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath ="//*[@id=\"main\"]/div/div[2]/div/div[1]/h1")
    public WebElement PageTitle;
    @FindBy(css = "a.clear-list")
    public  WebElement ClearBtn;
    @FindBy(css = "table.compare-products-table")
    WebElement TableCompare;
    @FindBy(tagName = "tr")
    List<WebElement> AllRows;
    @FindBy(tagName = "td")
    List <WebElement> AllColl;
    @FindBy (css="div.no-data")
    public  WebElement noData;

    public void UserCanCompare(){
        System.out.println(AllRows.size());
        for (WebElement row:AllRows){
            System.out.println(row.getText()+"\td");
            for (WebElement col: AllColl){
                System.out.println(col.getText()+"\td");
            }
        }
    }

    public void UserCanClearProduct(){
        ClickButton(ClearBtn);
    }
}


package tests;

import Pages.ComparePage;
import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareBetweenProductTest extends TestBase{
    String SearchOfFirstProduct ="Apple MacBook Pro";
    String SearchOfSecondProduct = "Asus Laptop";
    SearchProductPage searchObj;
    ProductPageDetails productDetails;
    ComparePage  comparePageObj;

    @Test(priority = 1 , alwaysRun = true)
    public void UserCanSearchOfProduct(){
        searchObj = new SearchProductPage(driver);
        productDetails = new ProductPageDetails(driver);

        searchObj.SearchOfProduct(SearchOfFirstProduct);
        productDetails.addToCompare();

        searchObj.SearchOfProduct(SearchOfSecondProduct);
        productDetails.addToCompare();
        driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
    }

    @Test(priority = 2 )
    public  void UserCanOpenPageOfCompare(){
        comparePageObj = new ComparePage(driver);
        Assert.assertTrue(comparePageObj.PageTitle.getText().contains("Compare products"));
        comparePageObj.UserCanCompare();
        System.out.println(comparePageObj.PageTitle);
    }

//    @Test(priority = 3)
//    public void UserCanClearAllProducts(){
//        comparePageObj.UserCanClearProduct();
//        Assert.assertTrue(comparePageObj.noData.getText().contains("You have no items to compare."));
//    }
}

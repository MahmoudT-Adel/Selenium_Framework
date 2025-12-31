package tests;

import Pages.HomePage;
import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeCurrencyTest extends  TestBase{
    HomePage homeObj;
    String ProductName = "Apple MacBook Pro";
    SearchProductPage searchObj;
    ProductPageDetails productDetails;


@Test(priority = 1)
public  void  UserCanChangeCurrency(){
    homeObj = new HomePage(driver);
    homeObj.OpenCurrencyList();
}

    @Test(priority = 1)
    public void UserCanSearchOfProduct(){
        searchObj = new SearchProductPage(driver);
        productDetails = new ProductPageDetails(driver);
        searchObj.SearchOfProduct(ProductName);
        searchObj.OpenProductDetails();
        Assert.assertTrue(productDetails.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
        Assert.assertTrue(productDetails.productPrice.getText().contains("€"));
   System.out.println(productDetails.productPrice.getText());
}


}

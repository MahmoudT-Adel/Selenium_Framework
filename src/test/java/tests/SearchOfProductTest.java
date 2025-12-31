package tests;

import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchOfProductTest extends TestBase{

   String ProductName = "Apple MacBook Pro";
    SearchProductPage searchObj;
    ProductPageDetails productDetails;

    @Test
    public void UserCanSearchOfProduct(){
   searchObj = new SearchProductPage(driver);
   productDetails = new ProductPageDetails(driver);
   searchObj.SearchOfProduct(ProductName);
   searchObj.OpenProductDetails();
   Assert.assertTrue(productDetails.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
    }

}


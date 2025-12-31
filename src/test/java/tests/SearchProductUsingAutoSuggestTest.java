package tests;
import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class SearchProductUsingAutoSuggestTest extends TestBase {

    String ProductName = "Apple MacBook Pro";
    SearchProductPage searchObj;
    ProductPageDetails productDetails;


    @Test
    public void UserCanResearchWithAutoSuggest(){
        searchObj = new SearchProductPage(driver);
        searchObj.ProductSearchUsingAutoSuggest(ProductName);
        productDetails = new ProductPageDetails(driver);
        productDetails.AddToCart();
       Assert.assertTrue(productDetails.productNameOfCrumb.getText().equalsIgnoreCase(ProductName));
    }
}


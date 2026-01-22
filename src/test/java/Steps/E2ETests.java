package Steps;

import Pages.ProductPageDetails;
import Pages.SearchProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.AddToCartTest;
import tests.RegisterUserCheckOutTest;
import tests.SearchOfProductTest;
import tests.TestBase;

public class E2ETests extends TestBase {
    SearchProductPage searchObj;
    ProductPageDetails productDetails;
    AddToCartTest  AddToCartTestPage;
    RegisterUserCheckOutTest RegisterUserCheckOutTestPage;

    @When(":  he search for {string}")
    public void he_search_for(String nameOfProduct) {
       searchObj = new SearchProductPage(driver);
       searchObj.SearchOfProduct(nameOfProduct);
        productDetails = new ProductPageDetails(driver);
        Assert.assertTrue(productDetails.productNameOfCrumb.getText().contains(nameOfProduct));
    }

    @When(": choose to by two items")
    public void choose_to_by_two_items() throws InterruptedException{
        productDetails = new ProductPageDetails(driver);
        AddToCartTestPage = new AddToCartTest();
        productDetails.AddToCart();
        driver.navigate().to("http://demo.nopcommerce.com/" + "cart");
    }

    @And(": move to checkout cart and enter personal details on checkout page and place the order")
    public void move_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() {
        RegisterUserCheckOutTestPage = new RegisterUserCheckOutTest();
        RegisterUserCheckOutTestPage.CheckOutAsGuest();
        RegisterUserCheckOutTestPage.UserCanCheckOut();

    }

    @Then(": he can view the order and  dwonload the voise")
    public void he_can_view_the_order_and_dwonload_the_voise()throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

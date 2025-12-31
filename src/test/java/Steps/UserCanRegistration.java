package Steps;

import Pages.HomePage;
import Pages.UserRegistration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import tests.TestBase;
import tests.UserRegistrationTest;

import java.util.concurrent.TimeUnit;

public class UserCanRegistration extends TestBase {

HomePage homeObject;
UserRegistrationTest userRegistrationObj;
    UserRegistration userRegistration ;

    @Given(": The user in home page")
    public void the_user_in_home_page() {
        homeObject = new HomePage(driver);
        homeObject.OPenRegistrationPage();
    }
    @When(": I click on register link")
    public void i_click_on_register_link() throws   InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }
//    @When(": I entered the user data")
//    public void i_entered_the_user_data() throws   InterruptedException{
//userRegistrationObj = new UserRegistrationTest();
//        Thread.sleep(15000);
//userRegistrationObj.UserRegistrationSuccessfully();
//
//    }

@When(": I entered {string} , {string} , {string} , {string}")
public void i_entered(String firstName, String lastName, String email, String password) {
userRegistrationObj = new UserRegistrationTest();
    userRegistration.userRegistration(firstName, lastName, email, password);

}


    @Then(": The registratoin page is displayed Successfully")
    public void the_registratoin_page_is_displayed_successfully()

    {
        userRegistrationObj.registerUserCanLogOut();
    }
}

package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends  PageBase{
public CheckOutPage(WebDriver driver){
    super(driver);
}
    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(css = "h1")
    WebElement titleOfPage;

   @FindBy(css = "button.button-1.checkout-as-guest-button")
    WebElement CheckOutGuest;

   @FindBy(xpath = "//*[@id=\"BillingNewAddress_FirstName\"]")
   WebElement FirstName;
   @FindBy(id ="BillingNewAddress_LastName")
   WebElement LastName;
   @FindBy(id = "BillingNewAddress_Email")
   WebElement YourEmail;

   @FindBy(id = "BillingNewAddress_CountryId")
   WebElement  CountryId;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement  ProvinceId;

   @FindBy(id = "BillingNewAddress_City")
   WebElement YourCity;
   @FindBy(id = "BillingNewAddress_Address1")
   WebElement YourAddress;
   @FindBy(id = "BillingNewAddress_ZipPostalCode")
   WebElement YourCode;
   @FindBy(id = "BillingNewAddress_PhoneNumber")
   WebElement PhoneNumber;

   @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[2]")
   WebElement BtnContinue;

   @FindBy(xpath = "//*[@id=\"shippingoption_0\"]")
   WebElement ShippingOption;

   @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
   WebElement ShippingMethodBtnNextStep;

   @FindBy(xpath = "//*[@id=\"paymentmethod_0\"]")
   WebElement paymentMethodOption;

   @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
   WebElement paymentInfoNextStepButton;

   @FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/button")
   WebElement btnConfirm;

   @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[2]/div/div[3]/button")
   WebElement orderCompletedContinueBtn;

   public void OpenCheckOutGuestPage(){
       ClickButton(CheckOutGuest);
   }

    public void UserInformDataToCheckOut(String firstNameTxt , String lastNameTxt, String EmailTxt , String CityTxt , String AddressTxt , String codeTxt , String PhoneTxt)
    {

  FirstName.sendKeys(firstNameTxt);
       LastName.sendKeys(lastNameTxt);
        SendText(YourEmail ,EmailTxt);
        SendText(YourCity ,CityTxt);
        SendText(YourAddress ,AddressTxt);
        SendText(YourCode,codeTxt);
        SendText(PhoneNumber , PhoneTxt);
        select = new Select(CountryId);
        select.selectByVisibleText("United States of America");

        select = new Select(ProvinceId);
        select.selectByVisibleText("Alabama");


        ClickButton(BtnContinue);

//
//        js.executeScript("arguments[0].value=arguments[1];", FirstName, firstNameTxt);
//        js.executeScript("arguments[0].value=arguments[1];", LastName, lastNameTxt);
//        js.executeScript("arguments[0].value=arguments[1];", YourEmail, EmailTxt);
//        js.executeScript("arguments[0].value=arguments[1];", YourCity, CityTxt);
//        js.executeScript("arguments[0].value=arguments[1];", YourAddress, AddressTxt);
//        js.executeScript("arguments[0].value=arguments[1];", YourCode, codeTxt);
//        js.executeScript("arguments[0].value=arguments[1];", PhoneNumber, PhoneTxt);
//
//        // select elements normally
//        select = new Select(CountryId);
//        select.selectByVisibleText("United States of America");
//
//        select = new Select(ProvinceId);
//        select.selectByVisibleText("Alabama");
//
//        // click using JS
//        js.executeScript("arguments[0].click();", BtnContinue);
    }

//   public void SelectYourCountry(){
//       select = new Select(CountryId);
//       select.selectByVisibleText("United States of America");
//       System.out.println(CountryId.getText());
//   }
//
//    public void SelectYourProvince(){
//        select = new Select(ProvinceId);
//        select.selectByVisibleText("Alabama");
//        System.out.println(CountryId.getText());
//    }

    public void ChooseShippingMethod(){
       ClickButton(ShippingOption);
       ClickButton(ShippingMethodBtnNextStep);
       ClickButton(paymentMethodOption);
       ClickButton(paymentInfoNextStepButton);
       ClickButton(btnConfirm);
       ClickButton(orderCompletedContinueBtn);
    }


}

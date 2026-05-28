package tests;

import Pages.ContactUs;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest  extends  TestBase{
    HomePage homeObj;
    ContactUs contactUsObj;

    String fullName= "MahmoudAdel";
    String Email="MAhmoudAtAHA03@gmail.com";
    String Enquire ="Hello Admin , This Is Test";

    @Test
    public void  UserCanContactUs(){
    homeObj = new HomePage(driver);
    homeObj.OpenContactUsPage();
    contactUsObj = new ContactUs(driver);
    contactUsObj.UserCanContactUs(fullName , Email , Enquire);
    Assert.assertTrue(contactUsObj.successMessage.getText().contains("Your enquiry") );
    }
}

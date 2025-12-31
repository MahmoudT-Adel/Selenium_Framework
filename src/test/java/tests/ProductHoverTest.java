package tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverTest extends TestBase{
    HomePage homeObj;

@Test
    public  void UserCanOpenNoteBookPage(){
    homeObj = new HomePage(driver);
    homeObj.OpenNoteBookPage();
    Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
}
}

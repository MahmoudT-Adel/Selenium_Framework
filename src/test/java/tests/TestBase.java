package tests;

import helper.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

public class TestBase   {
    public  WebDriver driver;

//Before start run thih file C:\Users\mahmo\Downloads\nopCommerce_4.90.4_NoSource_win_x64
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(" http://localhost:5000");
        ((JavascriptExecutor) driver).executeScript(
                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
        );
    }





    @AfterMethod
    public  void ScreenshotOnFailure(ITestResult results) throws IOException{
        if (results.getStatus() == ITestResult.FAILURE){
    System.out.println("Failed!");
    System.out.println("Taking Screenshot...");
    Helper.CaptureScreenShots(driver, results.getName());

        }

    }

        @AfterClass
    public void CleanUp(){
        driver.quit();

    }

}

package tests;

import helper.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Map;

public class TestBase  extends AbstractTestNGCucumberTests {
    public static WebDriver driver;


//    @BeforeSuite
//    public void setUp() {
//        driver = new ChromeDriver();
//        driver.navigate().to("https://demo.nopcommerce.com/");
//        ((JavascriptExecutor) driver).executeScript(
//                "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
//        );
//    }


   // Run The Test Cases Without INTR.

    @BeforeSuite
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");
        options.addArguments(
                "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/120.0.0.0 Safari/537.36"
        );
        driver = new ChromeDriver(options);

        // Inject BEFORE page load
        ((ChromeDriver) driver).executeCdpCommand(
                "Page.addScriptToEvaluateOnNewDocument",
                Map.of(
                        "source",
                        "Object.defineProperty(navigator, 'webdriver', {get: () => undefined});"
                )
        );

        driver.get("https://demo.nopcommerce.com/");
    }




    @AfterMethod
    public  void ScreenshotOnFailure(ITestResult results) throws IOException {
        if (results.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot...");
            Helper.CaptureScreenShots(driver, results.getName());

        }

    }
        @AfterSuite
    public void CleanUp(){
        driver.close();

    }

}

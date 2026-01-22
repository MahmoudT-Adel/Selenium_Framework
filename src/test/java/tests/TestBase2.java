package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase2 {
 public static String Base_URL = "https://demo.nopcommerce.com/";

 protected ThreadLocal<RemoteWebDriver> driver = null;

    @BeforeClass
    @Parameters(value = {"browser"})

    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
     driver = new ThreadLocal<>();
     DesiredCapabilities caps = new DesiredCapabilities();
     caps.setCapability("browserName", browser);
     driver.set(new RemoteWebDriver(new URL("http://localhost:4444") , caps));
    getDriver().navigate().to(Base_URL);

 }

 public WebDriver getDriver(){
        return driver.get();
 }
 @AfterClass
    public void StopDriver(){
        getDriver().quit();
        getDriver().close();
 }

}

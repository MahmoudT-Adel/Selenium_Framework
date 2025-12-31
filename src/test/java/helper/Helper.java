package helper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import javax.imageio.IIOException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {

 public static  void CaptureScreenShots(WebDriver driver , String screenShotName) throws IOException {
    Path dest = Paths.get("./Screenshots"+screenShotName+".png");
    try {
        Files.createDirectories(dest.getParent());
        FileOutputStream out = new FileOutputStream(dest.toFile());
        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        out.close();
    }catch (IIOException e){
System.out.println("Expectation While Taking Screenshots" +e.getMessage());
    }
}}

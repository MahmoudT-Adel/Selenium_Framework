package Runner;
import io.cucumber.testng.CucumberOptions;
import tests.TestBase;


@CucumberOptions(
        features ="src/test/java/Features",
        glue = {"Steps"},
        plugin = {"pretty", "html:target/cucumber-html-report/index.html"
        })

public class TestRunner extends TestBase {

}

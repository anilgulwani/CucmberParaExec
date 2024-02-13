package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:features"
        }, monochrome = true,
        glue = {"stepDefs"},
plugin = {
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },

        dryRun = false,
        tags=""
)

public class ExtentReport {

}

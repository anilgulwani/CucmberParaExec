package stepDefs;

import browserFactory.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class Hooks {
    private DriverFactory driverFactory;
    private WebDriver driver;


    @Before(order = 0)
    public void getProperty() {
    }

    @Before(order = 1)
    public void launchBrowser() {
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver("chrome");
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.write(sourcePath, "image/png", screenshotName);
            scenario.write("Browser Opened" + screenshotName);
        }
    }
}

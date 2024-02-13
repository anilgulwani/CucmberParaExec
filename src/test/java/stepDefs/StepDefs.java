package stepDefs;

import browserFactory.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
//import io.github.bonigarcia.wdm.ChromeDriverManager;
//import org.junit.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;

public class StepDefs {

    Scenario scenario;

//    @Before
//    public void setUp(Scenario s){
//        scenario=s;
//    }

    @Given("I open browser and navigate url {string}")
    public void i_open_browser_and_navigate_url(String string) {
        // Write code here that turns the phrase above into concrete actions
        DriverFactory.getDriver().get(string);
//        WebDriver driver;
//        ChromeDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.setAcceptInsecureCerts(true);
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.navigate().to(string);
//        scenario.write("Browser Opened" + string);
    }
}

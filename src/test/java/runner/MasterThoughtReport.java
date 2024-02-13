package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:features"
        }, monochrome = true,
        glue = {"stepDefs"},

        plugin = {"html:target/cucumberHtmlReport",
                "json:target/cucumber.json", "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml",
                "pretty:target/cucumber-pretty.txt",
//				"rerun:target/rerun.txt"
        },
        dryRun = false,
        tags=""


)
public class MasterThoughtReport {
        static Logger log = LoggerFactory.getLogger(MasterThoughtReport.class);

        @AfterClass
        public static void tearDown(){
                generateReport();
        }

        public static void generateReport(){
                String projectDir = System.getProperty("user.dir");
                File reportOutputDirectory = new File(projectDir + "/target/Masterthought");
                reportOutputDirectory.delete();
                List<String> list = new ArrayList<String>();
                list.add("target/cucumber.json");
                String projectName = "Cucumber Parallel Execution";
                boolean skippedFails = false;
                boolean pendingFails = false;
                boolean undefinedFails = true;
                boolean missingFails = true;
                boolean runWithJenkins = false;
                boolean parallelTesting = false;

                Configuration configuration = new Configuration(
                        reportOutputDirectory, projectName);
                configuration.setBuildNumber("ApplicationBuild");
                ReportBuilder reportBuilder = new ReportBuilder(list, configuration);

                reportBuilder.generateReports();
                try{
                        log.info("\nReport available on: " + reportOutputDirectory.getCanonicalPath()
                                + "/feature-overview.html");
                }
                catch (IOException io){
                        log.info(io.getMessage());
                }

        }
}

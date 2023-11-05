package stepdefinations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
    features = "src/main/java/featurefiles",
    glue = "stepdefinations",
    plugin = {"pretty", "html:target/report.html"},
    tags = "@test"
)
public class RunnerTestNG extends AbstractTestNGCucumberTests {
}

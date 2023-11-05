package stepdefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Junit or TestNG

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/java/featurefiles"}, glue = {"stepdefinations"}
, plugin = {"pretty", "html:target/report.html"}, tags = "@test")
public class runner {

}
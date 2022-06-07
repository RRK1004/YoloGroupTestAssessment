package runnerFile;
import org.junit.runner.*;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
glue = "stepDefinition",
plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cucumber-report/cucumber.xml"},
monochrome = true)


public class RunnerClass {

}
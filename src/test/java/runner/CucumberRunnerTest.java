package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions (tags ="",
features = {"src/test/java/resources/features/VWOLogin.feature"},
glue = {"StepDefinitions.VWOLoginDefinition.java"},
plugin = {"pretty","html:target/cucumber-reports.html"}
)

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}

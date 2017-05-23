package loveholidays;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


/**
 * Created by user
 */
@RunWith(Cucumber.class)
@CucumberOptions(tags = {"~@ignore"}, features = "src/test/resources/features", format = {"pretty", "html:target/cucumber"}, glue = "loveholidays.stepdefs")
public class RunCukesIT {
}

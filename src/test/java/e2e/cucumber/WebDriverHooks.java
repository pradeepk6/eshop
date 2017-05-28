package e2e.cucumber;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class WebDriverHooks {

    @Autowired
    private EventFiringWebDriver driver;

    @Before
    public void setUp() {
        driver.manage().window().maximize();
    }

    @After
    public void finish(Scenario scenario) {
        try {
            byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } finally {
            // driver.close();
        }
    }

    @After
    public void quitDriverObject() {
        //driver.quit();
    }

}

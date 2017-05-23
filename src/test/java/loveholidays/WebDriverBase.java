package loveholidays;

import cucumber.api.java.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;

//import org.junit.Before;


/**
 * Created by user
 */
public class WebDriverBase {

    protected static WebDriver driver;

    public WebDriverBase() {
        //driver = DriverFactory.getDriver();
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void quitDriverObject() {
        driver.quit();
    }
}

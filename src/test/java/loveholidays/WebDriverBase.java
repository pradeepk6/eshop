package loveholidays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


/**
 * Created by user on 08/05/2017.
 */
public class WebDriverBase {

    protected static WebDriver driver;

    public WebDriverBase() {
        driver = DriverFactory.getDriver();
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

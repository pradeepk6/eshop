package e2e.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by user
 */
public class WebDriverBase {

    @Autowired
    protected static EventFiringWebDriver driver;

    public WebDriverBase() {
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

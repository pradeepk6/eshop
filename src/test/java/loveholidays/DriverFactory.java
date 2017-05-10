package loveholidays;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by user on 9/05/2017.
 */
public class DriverFactory {
    private static String browser;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        Capabilities capabilities;
        if (browser == null) browser = getBrowser();
        switch (browser) {
            case "CHROME":
                capabilities = DesiredCapabilities.chrome();
                driver = new ChromeDriver(capabilities);
                break;
            case "FIREFOX":
                capabilities = DesiredCapabilities.firefox();
                driver = new FirefoxDriver(capabilities);
                break;
            case "EDGE":
                capabilities = DesiredCapabilities.edge();
                driver = new EdgeDriver(capabilities);
        }
        return driver;
    }

    public static String getBrowser() {
        if (browser != null) return browser;
        //system property set via maven failsafe plugin
        browser = System.getProperty("browser");
        if (browser == null) throw new NullPointerException("system property 'browser' must be set.");
        else browser = browser.toUpperCase();
        return browser;
    }
}

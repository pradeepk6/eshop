package e2e;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by user
 */
@Configuration
public class DriverFactory {
    private static String browser;
    private static WebDriver driver;

    @Bean
    @Scope("cucumber-glue")
    public static EventFiringWebDriver eventFiringWebDriver() {
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
                break;
            case "PHANTOMJS":
                capabilities = DesiredCapabilities.phantomjs();
                driver = new PhantomJSDriver(capabilities);
                break;
            case "HTMLUNIT":
                capabilities = DesiredCapabilities.htmlUnit();
                driver = new HtmlUnitDriver(capabilities);
                break;
        }
        return new EventFiringWebDriver(driver);
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

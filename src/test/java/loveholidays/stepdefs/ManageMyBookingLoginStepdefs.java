package loveholidays.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import loveholidays.DriverFactory;
import loveholidays.pages.ManageMyBookingPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by user
 */
public class ManageMyBookingLoginStepdefs implements En {
    WebDriver driver;
    private ManageMyBookingPage mmbPage;
    private String mmbUrl = "https://www.loveholidays.com/manage/login.html";

    public ManageMyBookingLoginStepdefs() {

        Given("^User on Manage My Booking page$", () -> {
            driver.get(mmbUrl);
        });

        When("^User enters (\\w+)$", (String bookingRefNum) -> {
            mmbPage.bookingRefNum.sendKeys(bookingRefNum);
        });

        And("^clicks Submit button$", () -> {
            mmbPage.loginFormSubmit_but.click();
        });

        And("^clicks Submit button to submit$", () -> {
            mmbPage.loginFormSubmit_but.submit();
        });

        Then("^the error message should be shown:$", (String errMessage) -> {
            assertTrue(mmbPage.bookingRefNum.getAttribute("validationMessage").contains(errMessage));
        });

        Then("^the invalid error message should be shown:$", (String errMessage) -> {
            assertTrue(mmbPage.errMsg1.getText().contains(errMessage));
        });
    }

    @Before
    public void initPageObjects() {
        driver = DriverFactory.getDriver();
        mmbPage = new ManageMyBookingPage(driver);
        driver.manage().window().maximize();
    }

    @After
    public void quitDriverObject() {
        driver.quit();
    }

}

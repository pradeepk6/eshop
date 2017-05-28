package e2e.cucumber;

import cucumber.api.java.Before;
import cucumber.api.java8.En;
import e2e.pageobjects.ManageMyBookingPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

/**
 * Created by user
 */
public class ManageMyBookingLoginSteps implements En {

    @Autowired
    EventFiringWebDriver driver;

    private ManageMyBookingPage mmbPage;
    private String mmbUrl = "https://www.loveholidays.com/manage/login.html";

    public ManageMyBookingLoginSteps() {

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
        //page init must happen after driver init
        mmbPage = new ManageMyBookingPage(driver);
    }
}

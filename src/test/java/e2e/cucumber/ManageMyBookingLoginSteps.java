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

    public ManageMyBookingLoginSteps() {

        Given("^User on Manage My Booking page$", () -> {
            mmbPage.visitPage();
        });

        When("^he logs in by filling in ONLY bookingRef with \"(\\w+)\"$",
                (String bookingRefNum) -> {
                    mmbPage.fill_bookingRefNum(bookingRefNum);
                    mmbPage.submitLoginForm();
        });
        When("^he logs in by filling in ONLY bookingRef and leadPassengerSurname with \"(\\w+)\" and \"(\\w+)\"$",
                (String bookingRef, String leadPassengerSurname) -> {
                    mmbPage.fill_bookingRefNum(bookingRef);
                    mmbPage.fill_leadPassengerSurname(leadPassengerSurname);
                    mmbPage.submitLoginForm();
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

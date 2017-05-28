package e2e.junit;

import e2e.pageobjects.ManageMyBookingPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by user
 */
public class ManageMyBookingLogin extends WebDriverBase {

    private ManageMyBookingPage mmbPage;
    private String mmbUrl = "https://www.loveholidays.com/manage/login.html";

    @Before
    public void initPageObjects() {
        mmbPage = new ManageMyBookingPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void refNumberWithInvalidFormat() throws Exception {
        String errMessage = "Your booking reference starts with LVE or LOV and" +
                " can be found on your booking summary. If you haven’t received your" +
                " booking summary yet, you’ll be unable to login to Manage My Booking";
        driver.get(mmbUrl);
        mmbPage.bookingRefNum.sendKeys("6783467");
        mmbPage.loginFormSubmit_but.click();
        assertTrue(mmbPage.bookingRefNum.getAttribute("validationMessage").contains(errMessage));
    }

    @Test
    public void invalidRefNumber() throws Exception {
        String errMessage = "Sorry this is not a valid booking reference." +
                " If you have booked within the last 24 hours please wait" +
                " until you receive your LOV or LVE reference number by email before logging in.";
        driver.get(mmbUrl);
        mmbPage.bookingRefNum.sendKeys("LVE1702LCCCQV9H");
        mmbPage.leadPassengerSurname.sendKeys("Test");
        mmbPage.loginFormSubmit_but.submit();
        assertTrue(mmbPage.errMsg1.getText().contains(errMessage));
    }

}

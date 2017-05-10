package loveholidays;

import loveholidays.pages.ManageMyBookingPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 08/05/2017.
 */
public class ManageMyBookingLoginIT extends WebDriverBase {

    private ManageMyBookingPage mmbPage;
    private String mmbUrl = "https://www.loveholidays.com/manage/login.html";

    @Before
    public void initPageObjects() {
        mmbPage = new ManageMyBookingPage(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testInvalidFormatOfRefNumber() throws Exception {
        String invalidMessage = "Your booking reference starts with LVE or LOV and" +
                " can be found on your booking summary. If you haven’t received your" +
                " booking summary yet, you’ll be unable to login to Manage My Booking";
        driver.get(mmbUrl);
        mmbPage.bookingRefNum.sendKeys("6783467");
        mmbPage.loginFormSubmit_but.click();
        assertTrue(mmbPage.bookingRefNum.getAttribute("validationMessage").contains(invalidMessage));
    }

    @Test
    public void testInvalidRefNumber() throws Exception {
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

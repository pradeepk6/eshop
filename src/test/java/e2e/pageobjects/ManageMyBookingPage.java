package e2e.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by user
 */
public class ManageMyBookingPage extends Page {

    @FindBy(how = How.ID, using = "js-reference-field-with-letters")
    public WebElement bookingRefNum;

    @FindBy(how = How.NAME, using = "surname")
    public WebElement leadPassengerSurname;

    @FindBy(how = How.CSS, using = "#getBooking > div.mmb-login__form__submit > button")
    public WebElement loginFormSubmit_but;

    @FindBy(how = How.CSS, using = "#getBooking > label.mmb-login__form__field > .error")
    public WebElement errMsg1;


    public ManageMyBookingPage(EventFiringWebDriver driver) {
        super(driver);
    }
}

Feature: Manage My Booking

  Background: A booking has been made succesfully

  Scenario: Unsuccessful Login due to bookingRef number starting with invalid format
    Given User on Manage My Booking page
    When he logs in by filling in ONLY bookingRef with "6783467"
    Then the error message should be shown:
    """
    Your booking reference starts with LVE or LOV and can be found on your booking summary. If you haven’t received your booking summary yet, you’ll be unable to login to Manage My Booking
    """

  Scenario: Unsuccessful Login due to invalid bookingRef number
    Given User on Manage My Booking page
    When he logs in by filling in ONLY bookingRef and leadPassengerSurname with "LVE1702LCCCQV9H" and "Test"
    Then the invalid error message should be shown:
    """
    Sorry this is not a valid booking reference. If you have booked within the last 24 hours please wait until you receive your LOV or LVE reference number by email before logging in
    """
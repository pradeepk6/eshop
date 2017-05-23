Feature: Manage My Booking

  Background: A booking has been made succesfully

  Scenario: Enter booking ref number with invalid format
    Given User on Manage My Booking page
    When User enters 6783467
    And clicks Submit button
    Then the error message should be shown:
    """
    Your booking reference starts with LVE or LOV and can be found on your booking summary. If you haven’t received your booking summary yet, you’ll be unable to login to Manage My Booking
    """

  Scenario: Enter invalid booking ref number
    Given User on Manage My Booking page
    When User enters LVE1702LCCCQV9H
    And clicks Submit button to submit
    Then the invalid error message should be shown:
    """
    Sorry this is not a valid booking reference. If you have booked within the last 24 hours please wait until you receive your LOV or LVE reference number by email before logging in
    """
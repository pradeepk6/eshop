Feature: Manage My Booking

  Background: A booking has been made succesfully
    Given User on Manage My Booking page

  Scenario: Enter booking ref number with invalid format
    When User enters 6783467 for booking reference
    And clicks Submit button
    Then the error message should be shown:
    """
    Your booking reference starts with LVE or LOV and can be found on your booking summary. If you haven’t received your booking summary yet, you’ll be unable to login to Manage My Booking
    """

  Scenario: Enter invalid booking ref number
    When User enters LVE1702LCCCQV9H for booking reference
    And enters Test for Lead Passenger Surname
    And clicks Submit button
    Then the invalid error message should be shown:
    """
    Sorry this is not a valid booking reference. If you have booked within the last 24 hours please wait until you receive your LOV or LVE reference number by email before logging in
    """
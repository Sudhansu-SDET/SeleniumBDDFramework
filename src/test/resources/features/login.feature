Feature: Feature to verify login functionality
# TODO: make this not break

 Background:
    Given User logs in to application successfully
    |userName            |password |
    |testusersp@gmail.com|123456789|


  Scenario Outline: Validate title of login page
    Given user is on login page
    When user gets the title of the page
    Then page title should be My account - My Store
    Then the test data <TestData> is passed
    Examples:
    |TestData|
    |sudhansu |









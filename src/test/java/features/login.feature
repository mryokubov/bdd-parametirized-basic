@regression
Feature: Test automationpractice.com login functionality

  Scenario Outline: Test login functionality with multiple credentials
    Given user is on the login page
    When user enters "<username>" and "<password>"
    And user clicks on login
    Then user should be navigated to homepage

    Examples:
      | username                       | password      |
      | gislason.alejandrina@gmail.com | Gislason!l12  |
      | mayer.blair@gmail.com          | Mayer!l12     |
      | bergstrom.harvey@gmail.com     | Bergstrom!a12 |

    @smoke
    Examples:
      | username                       | password      |
      | schmitt.yen@gmail.com          | Schmitt!e12   |


    @smoke
  Scenario: Test login functionality with incorrect credentials
    Given user is on the login page
    When user enters "abc@gmail.com" and "abc123!"
    And user clicks on login
    Then user should be navigated to homepage
@regression
Feature: Register OpenMRS patients

  Scenario: Register new patients on open mrs app
    Given user logins into open mrs application
    Then user clicks on register patient tab
    And user uses the below info to register new user
      | given | middle  | family | gender | dob            | address                          | phone      | relative | relName   |
      | Kevin | Johnson | Lee    | male   | 4 January 1999 | 123 main str Pittsburgh PA 15234 | 4120001212 | Sibling  | Peter Pan |
    And user clicks on confirm button
    And user should be navigated to patient details page
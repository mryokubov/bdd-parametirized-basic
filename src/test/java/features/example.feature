@regression
Feature: Simple example to show how data tables work

  Scenario: testing data tables
    Given user is on the login page
    Then user logs in
    And users clicks on register link
    Then user uses below data to register
      | firstName | lastName | dob            | address         | company | status  | ssn      |
      | Kevin     | Lee      | January 5 1980 | 123 main street | Google  | Married | 98375932 |
      | Oliver    | Hanse    | January 5 1980 | 123 main street | Google  | Married | 98375932 |
      | David     | Gerald   | January 5 1980 | 123 main street | Google  | Married | 98375932 |


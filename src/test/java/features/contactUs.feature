Feature: Test automationpractice.com contact us functionlality

  Background: Common user actions for various scenarious
    Given user is on the main page
    When user clicks on contact us link

  Scenario: Contact Us while NOT signed in

    When user selects "Customer Service"
    Then user enters "tom.peterson100@yahoo.com"
    Then user enters order reference as "AD90LKK12"
    Then user attaches file "Users/Downloads/java.png"
    And user types message "Hello, I think there is a problem with my order. Please I need refunds"
    And user clicks on send button
    Then user should see the success alert message

  Scenario: Contact Us while signed in
    Then user logs in with valid credentials "gislason.alejandrina@gmail.com" and "Gislason!l12"
    When user selects "Webmaster"
    Then user enters "gislason.alejandrina@gmail.com"
    Then user enters order reference as "KDLGH98DFG"
    And user types message "Hello, I think there is a problem with my order. Please I need refunds"
    And user clicks on send button
    Then user should see the success alert message

  Scenario: Contact Us negative testing
    When user selects "Webmaster"
    Then user enters order reference as "KDLGH98DFG"
    And user types message "Hello, I think there is a problem with my order. Please I need refunds"
    And user clicks on send button
    Then user should see error alert message

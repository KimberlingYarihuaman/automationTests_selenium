Feature: Manage of the alerts
  Optional description of the feature


  Scenario: Open Alert and Press a Button
    Given I enter to the main web: https://demoqa.com/alerts
    Then I load the DOM information Demoqa.json
    And I scroll to element Katalon Academy
    And I click on the Confirmation Alert element
    And I see the result for 5 seconds
    And I press the Accept button of the alert
    And I see the result for 3 seconds
    And I click on the Confirmation Alert element
    And I see the result for 5 seconds
    And I press the Cancel button of the alert
    And I see the result for 3 seconds



  Scenario: Open the Alert and Send a Message
    Given I enter to the main web: https://demoqa.com/alerts
    Then I load the DOM information Demoqa.json
    And I scroll to element Katalon Academy
    And I click on the Text Alert element
    And I put on the alert with text Hello! My name is Kimberling Yarihuaman. I'm a Native Spanish speaker.
    And I press the Accept button of the alert
    And I see the result for 5 seconds


  Scenario: Get the Message On the Alert
    Given I enter to the main web: https://demoqa.com/alerts
    Then I load the DOM information Demoqa.json
    And I scroll to element Katalon Academy
    And I click on the Notification Alert element
    And I get the message on the alert
    And I see the result for 2 seconds
    And I press the Accept button of the alert
    And I see the result for 5 seconds
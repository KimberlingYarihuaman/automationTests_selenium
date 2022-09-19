Feature: Manage of modal dialogs
  Optional description of the feature


  Scenario: Open Modal Dialogs and Press the Button
    Given I enter to the main web: https://demoqa.com/modal-dialogs
    Then I load the DOM information Demoqa.json
    And I click on the Large Modal Button element
    And I see the result for 5 seconds
    And I click on the Close Modal element in the modal
    And I see the result for 3 seconds


  Scenario: Open Modal Dialogs and Press the X symbol
    Given I enter to the main web: https://demoqa.com/modal-dialogs
    Then I load the DOM information Demoqa.json
    And I click on the Large Modal Button element
    And I see the result for 5 seconds
    And I click on the X Symbol element in the modal
    And I see the result for 3 seconds


  Scenario: Get the Message of the modal
    Given I enter to the main web: https://demoqa.com/modal-dialogs
    Then I load the DOM information Demoqa.json
    And I click on the Large Modal Button element
    And I see the result for 2 seconds
    And I get the message of the modal
    And I click on the Close Modal element in the modal
    And I see the result for 3 seconds


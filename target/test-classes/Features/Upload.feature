Feature: Manage of the upload files
  Optional description of the feature


  Scenario: Upload a file
    Given I enter to the main web: https://the-internet.herokuapp.com/upload
    Then I load the DOM information Demoqa.json
    And I click the Input File Name element and attach the ubicated file in the path: C:/Users/Kimberling/Downloads/Notes_220712_083556.pdf
    And I click on the Submit Button element
    Then The expected result for File Name element must have been: Notes_220712_083556.pdf
    And I see the result for 5 seconds




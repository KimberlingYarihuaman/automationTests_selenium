Feature: Search on internet
  Optional description of the feature


  Scenario: Open another tab and do a research
    Given I enter to the main web: https://demoqa.com/links
    Then I load the DOM information Demoqa.json
    And I see the result for 5 seconds
    #Open another tab
    And I click on the Simple Link element
    And I switch to the 2 tab
    And I open another website through the URL: https://www.google.com/
    And I put in the Search field with text ¿Que es la carlota?
    And I press the ENTER key on the Search element
    And I see the result for 5 seconds



  Scenario: Open others tabs
    Given I enter to the main web: https://demoqa.com/links
    Then I load the DOM information Demoqa.json
    #Open another tab
    And I click on the Simple Link element
    And I switch to the 2 tab
    And I scroll to element Interactions
    And I click on the Interactions element
    #Open another tab
    And I click on the Katalon Academy element
    And I switch to the 3 tab
    And I open another website through the URL: https://www.google.com/
    And I put in the Search field with text ¿Que es la carlota?
    And I press the ENTER key on the Search element
    And I open another website through the URL: https://demoqa.com/alerts
    And I switch to the 4 tab
    And I see the result for 5 seconds
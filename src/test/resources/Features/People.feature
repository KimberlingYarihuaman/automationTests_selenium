
Feature: People Magazine
  Optional description of the feature


  @test
  Scenario: Empty Fields
    Given I enter to the main web: https://people.com/
    Then I load the DOM information people.json
    And I click on the Login Button element
    And I click on the Sign in with Email element
    And I click on the Email element
    And I click on the Password element
    Then The expected result for Error Email element must have been: Please enter your email
    And I click on the Email element
    Then The expected result for Error Password element must have been: Please enter your password


  @test
  Scenario: invalid email and password fields
    Given I enter to the main web: https://people.com/
    Then I load the DOM information people.json
    And I click on the Login Button element
    And I click on the Sign in with Email element
    And I put in the Email field with text kimber.vvb@gmail.com
    And I put in the Password field with text Caracol123..pp
    And I click on the Sign in element
    Then The expected result for Error Email element must have been: Your password or email do not match. Please try again or reset your password
    And I clear the Email field
    And I put in the Email field with text kimberling.yarihuaman@gmail.com
    And I clear the Password field
    And I put in the Password field with text Caracol123..xx
    And I click on the Sign in element
    Then The expected result for Error Email element must have been: Your password or email do not match. Please try again or reset your password


   @test
   Scenario: Select a category and open the PDF file
     Given I enter to the main web: https://people.com/
     Then I load the DOM information people.json
     And I scroll to element Logo
     And I click on the Announcement Button element
     And I click on the Entertainment Button element
     And I click on the Movies Option element
     And I scroll to element Load More
     And I click on the Advertise element
     And I see the result for 5 seconds



















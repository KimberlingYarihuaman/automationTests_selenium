Feature: Atlas Moderna
  Optional description of the feature


  @test
  Scenario: Validate Fields For Contact Us In Moderna Atlas
    Given I enter to the main web: https://atlas.modernatx.com/connect-with-us
    Then I load the DOM information Atlas.json
    And I click on the Accept cookies element
    And I scroll to element Full Name
    And I click on the Full Name element
    And I click on the Title element
    Then The expected result for Error Full Name element must have been: This is a required field.
    And I click on the Email element
    And I click on the Title element
    Then The expected result for Error Email element must have been: Provide a valid email.
    And I put in the Email field with text mariaperez@nsn+com
    And I click on the Title element
    Then The expected result for Error Email element must have been: email must be a valid email
    And I put in the Phone field with text 123
    And I scroll to element Phone
    And I click on the Check Phone element
    Then The expected result for Error Phone element must have been: Provide a valid phone number.
    And I scroll to element HCP
    And I click on the Subject element
    And I click on the HCP element
    Then The expected result for Error Subject element must have been: This is a required field.
    And I click on the Details element
    And I click on the HCP element
    Then The expected result for Error Details element must have been: An error occurred





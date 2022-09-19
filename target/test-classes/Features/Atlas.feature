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


  @test
  Scenario: Send The Contact Form Successfully In Atlas platform
    Given I enter to the main web: https://atlas.modernatx.com/
    Then I load the DOM information Atlas.json
    And I click on the Accept cookies element
    And I scroll to element Contact Us
    And I click on the Contact Us element
    And I put in the Full Name field with text Jhon Mathas
    And I put in the Title field with text Important question
    And I put in the Email field with text jhon.mathas@gmail.com
    And I scroll to element Phone
    And I put in the Phone field with text +56129129292
    And I click on the Check Phone element
    And I put in the HCP field with text Nurse
    And I scroll to element HCP
    #And I put in the Subject field with text Other
    #And I see the result for 2 seconds
    And I click on the Subject element
    And I click on the Option Subject element
    And I put in the Details field with text Congratulations for the page!!
    And I see the result for 3 seconds
    And I click on the Submit element
    And I see the result for 3 seconds
    Then The expected result for Result element must have been: Your communication has been sent





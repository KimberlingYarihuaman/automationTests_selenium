
Feature: GuiaInfantil
  Optional description of the feature


@test
     Scenario Outline: Fill the Application Form Up and Register in the system
       Given I enter to the main web: https://www.guiainfantil.com/register
       Then I load the DOM information GuiaInfantil.json
       And I click on the Email element
       And I put in the Email field with text <email>
       And I click on the Password element
       And I put in the Password field with text <password>
       And I click on the Confirm Password element
       And I put in the Confirm Password field with text <password>
       And I click on the Name element
       And I put in the Name field with text <name>
       And I click on the Last Name element
       And I put in the Last Name field with text <lastname>
       And I select on Country list the text <country>
       And I check on the Terms and Conditions check
       And I click on the Register element
       Then The expected result for Welcome Message element must have been: Bienvenid@ <name> <lastname>!
       And I click on the Logout element

  Examples:
    | email                   |  password | name      | lastname  | country    |
    | mary.perez@gmail.com    | Y247doc.  | Mary      | Perez     | Venezuela  |
    | mario.vargas@gmail.com  | Y247doc.  | Mario     | Vargas    | Venezuela  |
    | jesus.rojo@gmail.com    | Y247doc.  | Jesús     | Rojo      | Venezuela  |



  @test
      Scenario Outline: Login In The GuiaInfantil System
        Given I enter to the main web: https://www.guiainfantil.com/login
        Then I load the DOM information GuiaInfantil.json
        And I put in the Login Email field with text <email>
        And I put in the Login Password field with text <password>
        And I click on the Login element
        Then The expected result for Welcome Message element must have been: Bienvenid@ <name> <lastname>!
        And I click on the Logout element

    Examples:
      | email                      | password  | name      | lastname |
      | qw.bermudez@gmail.com      | Y247doc.  | QW        | Bermudez |
      | ronald.mezoro@gmail.com    | Y247doc.  | Ronald    | Mezoro   |
      | ulises.sanchez@gmail.com   | Y247doc.  | Ulises    | Sanchez  |
      | catriona.gray@gmail.com    | Y247doc.  | Catriona  | Gray     |
      | aquiles.nazoa@gmail.com    | Y247doc.  | Aquiles   | Nazoa    |
      | jesus.rojo@gmail.com       | Y247doc.  | Jesús     | Rojo     |
      | mary.perez@gmail.com       | Y247doc.  | Mary      | Perez    |
      | mario.vargas@gmail.com     | Y247doc.  | Mario     | Vargas   |




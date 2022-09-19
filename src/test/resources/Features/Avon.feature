
Feature: Avon
  Optional description of the feature


@test
    Scenario: Validate Fields For Registering Users In Avon Platform
      Given I enter to the main web: https://www.avon.co/customer/logon/
      Then I load the DOM information Avon.json
      And I scroll to element Create Account
      And I click on the Create Account element
      And I put in the Email field with text kimber
      Then The expected result for Error Email element must have been: Por favor, escribe una dirección de email válida
      And I put in the Password field with text Cara
      Then The expected result for Error Password element must have been: Usa entre 6 y 8 caracteres combinando letras y números.
      And I put in the Confirm Password field with text Manu
      Then The expected result for Error Confirm Password element must have been: Las contraseñas deben coincidir
      And I put in the Name field with text K
      Then The expected result for Error Name element must have been: Por favor, escribe un nombre válido
      And I put in the Last Name field with text J
      Then The expected result for Error Last Name element must have been: Por favor, escribe un apellido correcto
      And I put in the Identification Document field with text Arge
      Then The expected result for Error Identification Document element must have been: Ingresa un número de documento válido.
      And I put in the Address field with text Mer
      Then The expected result for Error Address element must have been: Máx. 35 caracteres. Usa abreviaturas.
      And I put in the Completed Address field with text Aven
      Then The expected result for Error Completed Address element must have been: Máx. 35 caracteres. Usa abreviaturas.
      And I put in the Phone Number field with text 456
      Then The expected result for Error Phone Number element must have been: Por favor, escribe un número de teléfono móvil correcto
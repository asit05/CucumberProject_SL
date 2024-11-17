Feature: This feature will validate the login scenario of Simplilearn.com

  Scenario: Validate the login failure scenario
    Given I have launched the application
    And I click on the Login link
    When I enter the user name
    And I enter the password
    And I click on the login button
    Then I should get the error message as "The email or password you have entered is invalid."

  @Regression
  Scenario: Validate the Login failure scenario using parameters
    Given I have launched the application
    And I click on the Login link
    When I enter the user name as "abc@xyz.com"
    And I enter the password as "Abc@1234"
    And I click on the login button
    Then I should get the error message as "The email or password you have entered is invalid."

  Scenario Outline: Validate the Login failure scenario with scenario outline
    Given I have launched the application
    And I click on the Login link
    When I enter the user name as "<UserName>"
    And I enter the password as "<Password>"
    And I click on the login button
    Then I should get the error message as "<Error>"

    Examples: 
      | UserName    | Password | Error                                              |
      | abc@xyz.com | Abc@1234 | The email or password you have entered is invalid. |
      | pqr@xyz.com | Xyz@1324 | The email or password you have entered is invalid. |

  @U_1000 @Regression
  Scenario: Validate the different login options present on the login screen
    Given I have launched the application
    And I click on the Login link
    Then I see the below login options present on the screen
      | Google   |
      | Facebook |
      | Linkedin |
      | Apple    |

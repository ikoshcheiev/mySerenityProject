Feature: User registration to the pet-store application

  Scenario: As a shopper I need to register myself as a new user to the pet-store application
    Given I navigate to the registration page
    And I add new user information
    And I add account information
    And I add profile information
    And I save my information
    When I login with my credentials
    Then I must be able to view the welcome greeting with my name
Feature: Purchase pets from the store

  Background: User must be logged in
    Given I Login to the application with valid test and test

  Scenario Outline:
  As a user, I must be able to search pets from the store and purchase them
  by entering my details

    When i search for a <petType> it must show up in the search results
    And I view details about the pet <pet> and add it to cart
    And I proceed to checkout
    And I enter my payment details <cardType>,<cardNumber>,<expiryDate>,<firstName>,<lastName>,<addr1>,<addr2>,<city>,<state>,<zip>,<country>
    And I click on Continue
    When I submit the order, the store must provide me a confirmation message on the placed order

    Examples:
      | pet                  | petType | cardType | cardNumber       | expiryDate | firstName | lastName | addr1 | addr2  | city   | state | zip   | country |
      | Male Adult Bulldog   | Bulldog | Visa     | 9999999999999999 | 04/2026    | John      | Doe      | 33    | Wdrive | Mobile | AL    | 06340 | USA     |
      | Female Puppy Bulldog | Bulldog | Visa     | 9999999999999999 | 04/2026    | John      | Doe      | 33    | Wdrive | Mobile | AL    | 06340 | USA     |

  Scenario Outline: As user, I want to view the Pet Types

    When i search for a <petType> it must show up in the search results

    Examples:
      | petType |
      | Bulldog |
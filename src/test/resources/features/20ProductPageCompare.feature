Feature: User should be able to add products for comparison on the product page.

  Background:
    Given User is on homepage

  Scenario Outline: Add to comparison button is visible on the product page
    When User enters value "<product>" in the search field
    And User clicks the search button
    And User clicks on product by name "<product>" in search results
    Then User should see Compare this product button
    Examples:
      | product     |
      | MacBook Air |

  Scenario Outline: Add to comparison button on product page adds product for comparison
    Given User goes to compare page
    And User removes all products from comparison
    When User enters value "<product1>" in the search field
    And User clicks the search button
    And User clicks on product by name "<product1>" in search results
    And User clicks Compare this product button
    And User enters value "<product2>" in the search field
    And User clicks the search button
    And User clicks on product by name "<product2>" in search results
    And User clicks Compare this product button
    And User clicks product comparison link.
    Then User should see "<product1>" product in comparison
    And User should see "<product2>" product in comparison
    Examples:
      | product1    | product2    |
      | MacBook Air | MacBook Pro |
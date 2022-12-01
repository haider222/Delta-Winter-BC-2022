Feature: User should be able to see product image,
  product price and product specification on the product page

  Background:
    Given User is on homepage

  Scenario Outline: User sees product image on product page
    When User enters value "<product>" in the search field
    And User clicks the search button
    And User clicks on product by name "<product>" in search results
    Then User should be able to see product image
    Examples:
      | product      |
      | Canon EOS 5D |
      | MacBook Air  |

  Scenario Outline: : User sees product price on the product page
    When User selects "<currency>" currency
    And User enters value "<product>" in the search field
    And User clicks the search button
    And User stores product "<product>" price from search results
    And User clicks on product by name "<product>" in search results
    Then User should be able to see correct product price in Euro
    Examples:
      | product      | currency |
      | Canon EOS 5D | EUR      |
      | MacBook Air  | EUR      |

  Scenario Outline: User sees product specification on the product page
    When User enters value "<product>" in the search field
    And User clicks the search button
    And User clicks on product by name "<product>" in search results
    Then User should be able to see product specification
    When User clicks on Specification tab
    Then User should be able to see specification tab
    Examples:
      | product      |
      | Canon EOS 5D |
      | MacBook      |
Feature: User Should be able to search using text
  found in the description on the prodcuts

  Background:
    Given User is on homepage

  Scenario Outline: Search in description does not work when turned off
    When User clicks the search button
    And User disables checking in product descriptions
    And User enters "<query>" in advanced search field
    And User clicks the advanced search button
    Then User should see message "<errorMessage>" in search results
    Examples:
      | query                | errorMessage                                         |
      | Intel Core 2 Duo | There is no product that matches the search criteria. |


  Scenario Outline: Search finds products by description when enabled
    When User clicks the search button
    And User enables checking in product descriptions
    And User enters "<query>" in advanced search field
    And User clicks the advanced search button
    Then User should see at least 2 products  with "<query>" in description.
    Examples:
      | query                |
      | Intel Core 2 Duo |
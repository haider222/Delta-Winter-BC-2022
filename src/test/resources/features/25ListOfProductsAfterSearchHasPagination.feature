Feature: List of products after search has pagination

  Background:
    Given User is at Homepage

  Scenario Outline: List of products with more than 1 page after search has pagination
    When User enters value <value> into search field in header
    And User clicks search button in the header
    Then User sees pagination in the bottom left corner
    Examples:
      | value |
      | " "   |

  Scenario Outline: List of products with 1 page after search has pagination
    When User enters value "<value>" into search field in header
    And User clicks search button in the header
    Then User sees pagination in the bottom left corner
    Examples:
      | value  |
      | iMac   |
      | iphone |


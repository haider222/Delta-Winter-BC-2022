Feature: List of products after search can be sorted

  Background:
    Given User is at home page

  Scenario Outline: Products are sorted by name and price
    When User enters value "<value>" into search field in header
    And User clicks search button magnifying glass
    And User selects sorting "<sorting>"
    Then User see search result list contains items "<items>"
    Examples:
#    items = a list of items separated by "," (without spaces)
      | sorting    | items                                                 | value |
      | NAME_ASC   | iPhone,iPod Classic,iPod Nano,iPod Shuffle,iPod Touch | iP    |
      | NAME_DESC  | iPod Touch,iPod Shuffle,iPod Nano,iPod Classic,iPhone | iP    |
      | PRICE_ASC  | iMac,MacBook,MacBook Air,MacBook Pro                  | Mac   |
      | PRICE_DESC | MacBook Pro,MacBook Air,MacBook,iMac                  | Mac   |

  Scenario: Rating highest search result with one rated product should contain that product first in a list
    When User enters value "Mac" into search field in header
    And User clicks search button magnifying glass
    And User selects sorting "RATING_HIGHEST"
    Then User see search result list contains items "MacBook,MacBook Pro,MacBook Air,iMac"

  Scenario: Rating lowest search result with one rated product should contain that product last in a list
    When User enters value "Mac" into search field in header
    And User clicks search button magnifying glass
    And User selects sorting "RATING_LOWEST"
    Then User see search result list contains items "iMac,MacBook Air,MacBook Pro,MacBook"
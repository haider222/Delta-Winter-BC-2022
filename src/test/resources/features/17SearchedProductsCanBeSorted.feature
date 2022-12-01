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

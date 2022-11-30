Feature: Search by name regexp

  Background:
    Given User is at home page

  Scenario Outline: Search by name regexp (positive scenario)
    When User enters value <"value"> into search field in header
    And User clicks search button magnifying glass
    Then User see search result list contains product name <"name">
    When User enters value <"value"> into search field in header
    And User press Enter for search field in header
    Then User see search result list contains product name <"name">
    Examples:
      | value  | name                     |
      | IMAc   | iMac                     |
      | iPhone | iPhone                   |
      | 941    | Samsung SyncMaster 941BW |
      | 306    | HP LP3065                |

  Scenario Outline: Search by name regexp (negative scenario)
    When User enters value <"value"> into search field in header
    And User clicks search button magnifying glass
    Then User see search result list is empty
    When User enters value <"value"> into search field in header
    And User press Enter for search field in header
    Then User see search result list is empty
    Examples:
      | value            |
      | 56DoesNotExist78 |
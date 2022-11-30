Feature: Search by name regexp

  Background:
    Given I am on home page

  Scenario Outline: Search by name regexp (positive scenario)
    When I enter value <"value"> into search field (in header)
    And I click search button (magnifying glass)
    Then I see search result list contain product name <"name">
    When I enter value <"value"> into search field (in header)
    And I press Enter for search field (in header)
    Then I see search result list contain product name <"name">
    Examples:
      | value  | name                     |
      | IMAc   | iMac                     |
      | iPhone | iPhone                   |
      | 941    | Samsung SyncMaster 941BW |
      | 306    | HP LP3065                |

  Scenario Outline: Search by name regexp (negative scenario)
    When I enter value <"value"> into search field (in header)
    And I click search button (magnifying glass)
    Then I see search result list is empty
    When I enter value <"value"> into search field (in header)
    And I press Enter for search field (in header)
    Then I see search result list is empty
    Examples:
      | value            |
      | 56DoesNotExist78 |
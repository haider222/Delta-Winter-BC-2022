Feature: Vlads Lavrenovs features

Feature: Search in subcategories

  Background:
    Given User is at Homepage

  Scenario Outline: Search in subcategories (negative scenario)
    When User clicks search button magnifying glass
    And User enters "<value>" into Search criteria field
    And User selects "<option>" in categories dropdown menu
    And User checks that Search in subcategories checkbox is unchecked
    And User clicks search button (on page)
    Then User sees empty search list
    Examples:
      | value | option   |
      | iMac  | Desktops |

  Scenario Outline: Search in subcategories (positive scenario)
    When User clicks search button magnifying glass
    And User enters "<value>" into Search criteria field
    And User selects "<option>" in categories dropdown menu
    And User checks that Search in subcategories checkbox is unchecked
    And user checks the Search in subcategories checkbox
    And User clicks search button (on page)
    Then User sees result list contain product "<value>"
    Examples:
      | value | option   |
      | iMac  | Desktops |

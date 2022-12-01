Feature: Search in subcategories

  Background:
    Given User is at Homepage

  Scenario Outline: Search in subcategories should work when the "Search in subcategories"
  checkbox is checked

    When User clicks search button in the header
    And User enters "<value>" into Search criteria field
    And User selects "<option>" in categories dropdown menu
    And User checks that Search in subcategories checkbox is unchecked
    And User clicks search button (on page)
    Then User sees empty search list
    Examples:
      | value | option   |
      | iMac  | Desktops |

  Scenario Outline: Search in subcategories should not work when the "Search in subcategories"
  checkbox is not checked

    When User clicks search button in the header
    And User enters "<value>" into Search criteria field
    And User selects "<option>" in categories dropdown menu
    And User checks that Search in subcategories checkbox is unchecked
    And user checks the Search in subcategories checkbox
    And User clicks search button (on page)
    Then User sees result list contain product "<value>"
    Examples:
      | value | option   |
      | iMac  | Desktops |

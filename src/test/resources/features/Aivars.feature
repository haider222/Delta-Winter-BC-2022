@sample
Feature: Aivars sample features sample file

  Scenario: can connect to demoshop
    When I go to demoshop url
    And I wait 1 seconds
    Then I should see searchbar
    And I click Login Page button
    And I wait 2 seconds

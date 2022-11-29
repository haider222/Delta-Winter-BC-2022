Feature: Aivars sample features sample file

  Scenario: can connect to demoshop
    When I go to demoshop url
    Then I should see searchbar
    And I wait 2 seconds

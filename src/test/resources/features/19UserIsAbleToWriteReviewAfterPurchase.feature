Feature: User is able to write review for product after purchase

  Background:
    Given User is at home page

  Scenario: User should NOT be able to write review while not Authenticated
    When User enters value "iMac" into search field in header
    And User clicks search button magnifying glass
    And User clicks on product by name "iMac" in search results
    And User clicks reviews tab on product page
    And User enters name "Bob Bob" in review section
    And User enters review "My very large iMac product review" in review section
    And User checks rating to 5 stars in review section
    And User clicks Continue in review section
    Then User should not see message "Thank you for your review." in review section



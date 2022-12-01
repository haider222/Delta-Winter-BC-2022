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

  Scenario: User should NOT be able to write review while Authenticated and NOT purchased product
    When User clicks Login button in header
    And User enters email "pijag11131@teknowa.com" and password "qwerty" in login form
    And User clicks login in login form
    And User enters value "iPhone" into search field in header
    And User clicks search button magnifying glass
    And User clicks on product by name "iPhone" in search results
    And User clicks reviews tab on product page
    And User enters name "Bob Bob" in review section
    And User enters review "My very large  iPhone product review" in review section
    And User checks rating to 5 stars in review section
    And User clicks Continue in review section
    Then User should not see message "Thank you for your review." in review section

  Scenario: User should be able to write review after product purchase from Product Page
    When User clicks Login button in header
    When User enters email "pijag11131@teknowa.com" and password "qwerty" in login form
    And User clicks login in login form
    And User enters value "MacBook Air" into search field in header
    And User clicks search button magnifying glass
    And User clicks on product by name "MacBook Air" in search results
    And User clicks reviews tab on product page
    And User enters name "Bob Bob" in review section
    And User enters review "My very large MacBook Air product review" in review section
    And User checks rating to 5 stars in review section
    And User clicks Continue in review section
    Then User should see message "Thank you for your review." in review section


Feature: User is able to add products to the wishlist

  Background:
    Given User is at Homepage

  Scenario Outline: User is able to add product to the wishlist using "add to wishlist" button on the product page
    When User clicks Login button in header
    And User enters email <em> and password <pw> in login form
    And User clicks login in login form
    And User navigates to the wish list using button in the header
    And User checks that the wishlist is empty, if not - empties it
    And User enters value <arg0> into search field in header
    And User clicks search button in the header
    And User clicks on product by name <productName> in search results
    And User clicks Add to wishlist button on the product page
    And User navigates to the wish list using button in the header
    Then User sees the product by name <arg0> in the wish list
    Examples:
      | em              | pw       | arg0   | productName |
      | "fail@mail.com" | "qwerty" | "iMac" | "iMac"      |


  Scenario Outline: User is able to add product to the wishlist using "add to wishlist" button on the product preview
    When User clicks Login button in header
    And User enters email <em> and password <pw> in login form
    And User clicks login in login form
    And User navigates to the wish list using button in the header
    And User checks that the wishlist is empty, if not - empties it
    And User enters value <arg0> into search field in header
    And User clicks search button in the header
    And User clicks Add to wishlist button on the product preview
    And User navigates to the wish list using button in the header
    Then User sees the product by name <arg0> in the wish list
    Examples:
      | em              | pw       | arg0   |
      | "fail@mail.com" | "qwerty" | "iMac" |



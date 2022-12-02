Feature: User is able to open product page and add product to cart

  Background:
    Given user is at demoshop page


  Scenario: User is able to open product page and add product to cart when not logged in
    When user selects main menu category "Phones & PDAs"
    And user selects product "HTC Touch HD"
    And user presses Add to Cart button
    And user clicks Shopping Cart icon at header
    Then product "HTC Touch HD" is in the Shopping Cart


    Scenario Outline: User is able to open product page and add product to cart when logged in
      Given user is at demoshop page
      When user clicks My account
      And user clicks login
      And user enters data to log in
        | myemail    | <myemail>    |
        | mypassword | <mypassword> |
      And user clicks login button
    And user selects main menu category "Cameras"
      And user selects product "Canon EOS 5D"
      And user presses Add to Cart button
      And user clicks Shopping Cart icon at header
      Then product "Canon EOS 5D" is not in the Shopping Cart
      Examples:
        | myemail         | mypassword |
        | test5@gmail.com | 55555      |
        |test0@gmail.com  |00000       |

  @bug
  Scenario Outline: user is able to open product page and add product to cart from the wish list when logged in
    Given user is at demoshop page
    When user clicks My account
    And user clicks login
    And user enters data to log in
      | myemail    | <myemail>    |
      | mypassword | <mypassword> |
    And user selects main menu category "Phones & PDAs"
    And user selects product "HTC Touch HD"
    And user adds the product to the Wish List
    And user clicks Wish List icon at header
    And user clicks Add to Cart button in the Wish List
    And user clicks Shopping Cart icon at header
    Then product "HTC Touch HD" is in the Shopping Cart
    Examples:
      | myemail         | mypassword |
      | test7@gmail.com | 77777      |


    Scenario: user is able to open product page and add product to cart from the wish list not logged in
      When user selects main menu category "Phones & PDAs"
      And user selects product "HTC Touch HD"
      And user adds the product to the Wish List
      And user clicks Wish List icon at header
      Then user is redirected to Login page





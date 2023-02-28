Feature: Search bar is displayed at all pages (req. #7)

  Background: Search box is displayed at initial page
    Given user is at demoshop page

  Scenario: Search box is displayed at initial page
    Then user can see Search box

  Scenario: Search box is displayed after selecting currency
    When user clicks currency dropdown at the header (top left)
    And user selects currency:
      | EUR |
      | GBP |
    Then user can see Search box

  Scenario: Search box is displayed after clicking Account dropdown options at header
    When user clicks Account icon at header
    And user clicks Register at header
    And user can see Search box
    And user clicks Account icon at header
    And user clicks Login at header
    Then user can see Search box

  Scenario: Search box is displayed after clicking top right header icons
    When user clicks Phone icon at header
    And user can see Search box
    And user clicks Wish List icon at header
    And user can see Search box
    And user clicks Shopping Cart icon at header
    And user can see Search box
    And user clicks Checkout icon at header
    Then user can see Search box

  Scenario: Search box is displayed after clicking sub-category "Show all"
    When user selects main menu category:
      | Desktops            |
      | Laptops & Notebooks |
      | Components          |
      | Tablets             |
      | Software            |
      | Phones & PDAs       |
      | Cameras             |
      | MP3 Players         |
    And user selects sub-category "Show All"
    Then user can see Search box

  Scenario: Search box is displayed after clicking main menu category
    When user selects main menu category:
      | Desktops            |
      | Laptops & Notebooks |
      | Components          |
      | Tablets             |
      | Software            |
      | Phones & PDAs       |
      | Cameras             |
      | MP3 Players         |
    Then user can see Search box

  Scenario: Search box is displayed after clicking sub-category "Monitors"
    When user selects main menu category "Components"
    And user selects sub-category "Monitors"
    Then user can see Search box

  Scenario: Search box is displayed after clicking minor sub-category "test 1(0)"
    When user selects main menu category "Components"
    And user selects sub-category "Monitors"
    And user selects minor sub-category "test 1 (0)"
    Then user can see Search box

  Scenario: Search box is displayed after clicking any footer link
    When user presses a footer link "Privacy Policy"
    Then user can see Search box

  Scenario: Search box is displayed after clicking any footer link
    When user presses any footer link:
      | About Us             |
      | Delivery Information |
      | Privacy Policy       |
      | Terms & Conditions   |
      | Contact Us           |
      | Returns              |
      | Site Map             |
      | Brands               |
      | Gift Certificates    |
      | Affiliate            |
      | Specials             |
      | My Account           |
      | Order History        |
      | Wish List            |
      | Newsletter           |
    Then user can see Search box

  Scenario Outline: Search box is displayed after sending "Contact Us" form
    Given user is at demoshop page
    When user presses a footer link "Contact Us"
    And user can see Search box
    And user fills in the form with valid credentials
      | name    | <name>    |
      | email   | <email>   |
      | enquiry | <enquiry> |
    And user clicks Submit button
    And user can see Search box
    And user clicks Continue button
    Then user can see Search box
    Examples:
      | name | email         | enquiry      |
      | Ann  | ann@gmail.com | Good luck!!! |

  Scenario Outline: Search box is displayed after sending "Returns" form
    Given user is at demoshop page
    When user presses a footer link "Returns"
    And user can see Search box
    And user fills in Returns form with valid credentials
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |
      | phone     | <phone>     |
      | orderId   | <orderId>   |
      | product   | <product>   |
      | model     | <model>     |
    And user selects return option
    And user clicks Submit button
    And user can see Search box
    And user clicks Continue button
    Then user can see Search box
    Examples:
      | firstName | lastName | email         | phone     | orderId   | product | model   |
      | Ann       | Apple    | ann@gmail.com | 346236747 | who knows | phone   | samsung |

  Scenario: Search box is displayed at Gift Certificates page
    When user presses a footer link "Gift Certificates"
    Then user can see Search box

  Scenario: Search box is displayed when selecting by Brand
    When user presses a footer link "Brands"
    And user can see Search box
    And user selects brand "Sony"
    Then user can see Search box

  Scenario: Search box is displayed during registration for Affiliate program
    When user presses a footer link "Affiliate"
    And user can see Search box
    And user clicks Continue button
    Then user can see Search box

  Scenario Outline: Search box is displayed when logging in
    Given user is at demoshop page
    When user clicks My account
    And user can see Search box
    And user clicks login
    And user can see Search box
    And user enters data to log in
      | myemail    | <myemail>    |
      | mypassword | <mypassword> |
    And user clicks login button
    Then user can see Search box
    Examples:
      | myemail         | mypassword |
      | test5@gmail.com | 55555      |

  Scenario Outline: Search box is displayed when editing account information
    Given user is at demoshop page
    When user clicks My account
    And user can see Search box
    And user clicks login
    And user can see Search box
    And user enters data to log in
      | myemail    | <myemail>    |
      | mypassword | <mypassword> |
    And user clicks login button
    And user can see Search box
    And user clicks Edit Account link
    And user can see Search box
    And user edits phone
    And user clicks Continue button
    Then user can see Search box
    Examples:
      | myemail         | mypassword |
      | test5@gmail.com | 55555      |

  Scenario: Search box is displayed at an item page
    When user selects main menu category "Tablets"
    And user can see Search box
    And user selects product "Samsung Galaxy Tab 10.1"
    Then user can see Search box

  Scenario: Search box is displayed when purchasing an item
    When user selects main menu category "Phones & PDAs"
    And user can see Search box
    And user selects product "HTC Touch HD"
    And user can see Search box
    And user presses "Add to Cart" button
    And user can see Search box
    And user clicks Shopping Cart icon at header
    And user can see Search box
    And user clicks "Checkout" button under product
    Then user can see Search box


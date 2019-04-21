Feature: Customer is able to add items to cart

  Scenario: Add one item to cart
    Given user has main page opened
    When user adds one item
    Then cart should have an item

  Scenario: Find item and add to cart
    Given user has main page opened
    When user searches for Faded Short Sleeve T-shirts
    And user adds one item
    Then cart should have an item

  Scenario Outline: Find diffent items and add them to the cart
    Given user has main page opened
    When user searches for <Item>
    And user adds it
    Then cart should have this item

    Examples:
    |Item                       |
    |Blouse                     |
    |Printed Chiffon Dress      |
    |Faded Short Sleeve T-shirts|


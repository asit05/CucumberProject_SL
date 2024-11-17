Feature: This feature will test calculator functionality for multiple data

  Scenario Outline: This scenario will run addition of two numbers with different data sets
    Given I have two numbers <num1> and <num2>
    When I add those two numbers
    Then I should get the result as <result>

    Examples: |
      | num1 | num2 | result |
      |   21 |   10 |     31 |
      |   10 |   24 |     34 |
      |   20 |   30 |     50 |

  Scenario: This scenario will add two or more numbers and validate the results
    Given I have below numbers
      | 11 |
      | 25 |
      | 33 |
      | 41 |
      |  7 |
    When i add the numbers
    Then I should get the result as 117
    
    
    Scenario: Validate the total bill amount of the purchased items
    Given Below items are added to the cart
    |coffee|20|
    |Burger|30|
    When I do the checkout
    Then The bill amount is displayed as 50
    
    
    Scenario: Validate the total bill amount of the purchased items in multiple quantity
    Given Below items are added to the cart with given quantity
    |coffee|2|20|
    |Burger|3|30|
    |Pizza|1|50|
    When I do the checkout with given quantity
    Then The bill amount is displayed as 180

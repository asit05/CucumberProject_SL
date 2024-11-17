Feature: This feature file will be doing different string operations

  Scenario: To compare the values of two strings
    Given The first string is "Pranab"
    And The second string is "Pranab"
    When I compare the strings
    Then I should get the result as "matching"

  Scenario Outline: To compare the values of two strings using examples
    Given The first string is "<string1>"
    And The second string is "<string2>"
    When I compare the strings
    Then I should get the result as "<isMatching>"

    Examples:
      | string1 | string2 | isMatching  |
      | Asit    | Asit    | matching    |
      | Asit    | Alok    | mismatching |
      | Nalini  | Yazna   | mismatching |

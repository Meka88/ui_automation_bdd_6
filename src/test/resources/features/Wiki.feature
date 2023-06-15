Feature: Wiki Search functionality

  Scenario Outline: Validate Wiki search
    Given user navigates to "https://www.wikipedia.org/"
    When user searches for "<key>" on Wikipedia
    Then user should see "<key>" in the title
    And user should see "<key>" in the url
    And user should see "<key>" in the first heading
    Examples:
      | key        |
      | Bill Gates   |
      | Elon Musk    |
      | Barack Obama |
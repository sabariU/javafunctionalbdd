Feature: Provide Dashboard for Netflix video library

  Scenario: Render Dashboard for Netflix movie library for a basic user
            with total number of titles
    Given I have logged in to netflix as a "basic-user@gmail.com"
    When I go to the dashboard
    And I see my dashboard statistics
    Then I view the list of values

  Scenario: Render Dashboard for Netflix movie library for a standard user
  with total number of titles
    Given I have logged in to netflix as a "standard-user@gmail.com"
    When I go to the dashboard
    And I see my dashboard statistics
    Then I view the list of values

  Scenario: Render Dashboard for Netflix movie library for a premium user
  with total number of titles
    Given I have logged in to netflix as a "premium-user@gmail.com"
    When I go to the dashboard
    And I see my dashboard statistics
    Then I view the list of values


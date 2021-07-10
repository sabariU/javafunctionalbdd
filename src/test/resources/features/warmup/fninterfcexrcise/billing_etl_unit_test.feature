Feature: Test source data conversion and loading

  Scenario: Convert data row to customer object
    Given The following data row to be converted as a customer object
      | 1001 | Wael Ehsan | Basic | Egypt | April 26,1976 |
    When I pass the data row
    Then I can get equivalnet customer object

  Scenario: Data loading and sorting
    Given The following data from "Online system" row to be loaded and sorted by id
      | 44001 | test user1 | Basic | Egypt | April 26,1976 |
      | 104402 | test user2 | Basic | Egypt | April 26,1976 |
      | 103 | test user3 | Basic | Egypt | April 26,1976 |
    When I load the data for "Billing system"
    Then I can see expected data loading and sorting






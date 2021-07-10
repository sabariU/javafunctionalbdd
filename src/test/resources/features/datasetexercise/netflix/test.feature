Feature: Providing flexible and advanced filter options on Costpool browse page
  I want to be able to apply various advanced filters to Costpool browse table records

  Scenario: Apply no filter
    Given System contains non-zero records for the Costpool browse page after filtering out by base conditions such as MarketCd, BizDate, RunDate
    When I go to the Costpool Browse page
    And I enter nothing
    And I hit enter
    Then I see results after filtering out only by base conditions such as MarketCd, BizDate, RunDate

  Scenario: Apply a empty filter
    Given System contains non-zero records for the Costpool browse page after filtering out by base conditions such as MarketCd, BizDate, RunDate
    When I go to the Costpool Browse page
    And I enter a few white spaces
    And I hit enter
    Then I see results after filtering out only by base conditions such as MarketCd, BizDate, RunDate

  Scenario: Apply a single filter with "equals" operator for a suggested field value
    Given System contains non-zero records for the Costpool browse page after filtering out by base conditions such as MarketCd, BizDate, RunDate
    When I go to the Costpool Browse page
    And I select a particular field from dropdown
    And I select "equals" operator
    And I select field value from dropdown
    And I hit enter
    Then I see results after apply my filter above on top of base filters


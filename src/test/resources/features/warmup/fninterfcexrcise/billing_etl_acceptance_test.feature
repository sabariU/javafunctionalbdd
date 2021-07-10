Feature: Provide ETL feature to support Billing system

  Scenario: Do ETL for raw customer data to billing compatible object
    Given The following customers from "Retail system"
      | 1001 | Wael Ehsan | Basic | Egypt | April 26,1976 |
      | 3040 | James Toback | Basic | United States | January 13,21982 |
      | 2834 | Perry Lang | Premium | United States | March 1,1956 |
      | 3489 | Brad Silberling | Standard | Serbia,United States | March 1,2001 |
      | 3942 | Juan Camilo Pinzon | Basic | Colombia | March 1,2009 |
      | 3426 | Liu Yi | Standard | Taiwan | December 5,2020 |
      | 3211 | Masaaki Yuasa | Premium | Japan | December 5,2010 |
      | 3428 | Sameh Abdulaziz | Premium | Egypt | December 5,1990 |
    When I pass the customers as raw data
    Then I can see the data persisted in the system
    Then I can see the data transformed to customer object compatible to "Billing system"
    Then I can load the customer objects to "Billing system" (just print) sort by id in descending order



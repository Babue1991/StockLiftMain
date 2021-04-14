@CategoryCreate
Feature: Category feature

  Scenario: Verify category creation functionality
    Given The Category name as an input Json payload
    When The user calls  with  POST HTTP method to create category
    Then The status message should be success and the message is eqal to "Article category created successfully."

  Scenario: Verify category view functionality
    Given The "<Category ID>" as an URL input
    When The user calls  with  GET HTTP method to view a category
    Then The success message should be true and the message is eqal to Single article category!.

  Scenario: Verify category update functionality
    Given The user ID and name as an input payload
    When The user calls  with  PUT HTTP method to update a category
    Then The success message should be true and the message is eqal to Article category updated successfully.

  Scenario: Verify category list functionality
    Given The access token value of users as an header value
    When The user calls  with  GET HTTP method to list a category
    Then The success message should be true and the message is eqal to "Article category Lists!."

  Scenario: Verify category delete functionality
    Given The  Category ID as an input Json payload
    When The user calls  with  DELETE HTTP method to delete a category
    Then The success message should be true and the message is eqal to Article category deleted successfully.

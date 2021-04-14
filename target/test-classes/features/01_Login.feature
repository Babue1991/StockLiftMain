@StockLiftLogin
Feature: Patient app login  feature

  Scenario Outline: Verify the user login feature
    Given The login input payload with "<email>" "<password>"
    When The user calls  with  HTTP method
    Then The status message should be success and the response should be 200

    Examples: 
      | email              | password |
      | man3@yopmail.com   | Test@123 |
	  # |babufsp4@gmail.com  | Test1@34 |
  
  Scenario Outline: Verify the user login feature with invalid credential
    Given The invalid login input payload with "<email1>" "<password1>"
    When The user calls  with  POST HTTP method to login
    Then The success message should be false and the response should be "Username or password is incorrect."

    Examples: 
      | email1             | password1|
      | babufsp5@gmail.com | Test@12  |
      | test@gmail.com     | Test1@34 |
      | NULL               |  NULL    |

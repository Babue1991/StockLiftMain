@SignUp
Feature: The user signup feature from patient app
 Scenario: Verify the user SignUp feature
    Given The user information as input payload
    When The user calls post HTTP method to create new user
    Then The status code should return 200 and response should contain Thank you message.
   
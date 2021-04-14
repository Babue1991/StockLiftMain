@myProfile
Feature: Care team app myprofile feature

  Scenario: Verify the myprofile feature in care team app
    Given The  user access token as an header value
    When The user calls  with  GET HTTP method to get user profile data
    Then The message should be success and the my profile API response status code value should be "200"
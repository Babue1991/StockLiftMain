@EditProfile
Feature: Care team app edit profile feature

  Scenario Outline: Verify the edit profile feature in care team app
    Given The  user information as input payload "<First name>" , "<Last name>", "<Time Zone>", "<Phone>" and "<Email>"
    When The user calls  with  GET HTTP method to update user profile data
    Then The response message should be success

    Examples: 
      | First name | Last name | Time Zone    | Phone      | Email                           |
      | Nagarajan  | M         | Asia/Kolkata | 8884711241 | lukabartolic.farshore@gmail.com |

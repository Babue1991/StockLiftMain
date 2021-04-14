@Newsfeed
Feature: Article list screen

  @tag1
  Scenario: Verify article list feature
    Given The user auth token as an input header
    When The user calls with GET http method to get article list
    Then The user should receive Article list! as an message.
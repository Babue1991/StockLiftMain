@PostCreation
Feature: Post creation feature

  @tag1
  Scenario: post creation scenario
    Given The json input payload for post creation
    When The user calls post HTTP method to create a new post
    Then The post should be created successfuly

  @tag2
 Scenario: post creation scenario
    Given The json input payload for article creation
    When The user sends post http method to create article
    Then The user should get "Article created successfully." message

   
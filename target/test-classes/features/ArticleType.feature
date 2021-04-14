@ArticleTypeManagement
Feature: Article type management

  @tag1
  Scenario: Verify article creation
    Given The article name as input payload
    When The user calls POST http method to create article type
    Then The user should receive "Article type created successfully." message.

  @tag2
  Scenario: Verify article type list feature
    Given The user sends article type ID in URL
    When The user calls GET http method to get article type view
    Then The user should receive "Article  Lists!." message in response.

  @tag3
  Scenario: Verify article view feature
    Given The access token value as input param
    When The user calls GET http method to get article type list
    Then The user should receive Single article type!. message in response.

  @tag4
  Scenario: Verify article update feature
    Given The article name and article ID as an input param
    When The user calls PUT http method to update article type list
    Then The user should receive Article type updated successfully message in response.

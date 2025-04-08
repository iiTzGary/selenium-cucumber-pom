@General
Feature: Validates that the user is able to perform a search using google browser

  @GoogleSearch
  Scenario:User perform a search and is able to see the expected content
    Given The user is on the google page
    When perform the google search
    Then The user should see the expected homepage
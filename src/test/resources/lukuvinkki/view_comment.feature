Feature: User can view all comments connected to a tip

  Scenario: added comments can be viewed on the tip page
    Given there are some tips created
    And   user is on a tip a page
    When  new comment is created with nickname "Foo Bar" and content "Lorem ipsum"
    And   new comment is created with nickname "Mars Bar" and content "muspi meroL"
    Then  page contains nickname "Foo Bar" and content "Lorem ipsum"
    And   page contains nickname "Mars Bar" and content "muspi meroL"

  Scenario: latest comment is listed first
    Given there are some tips created
    And   user is on a tip a page
    When  new comment is created with nickname "Foo Bar" and content "Lorem ipsum"
    And   new comment is created with nickname "Mars Bar" and content "muspi meroL"
    And   new comment is created with nickname "Bar Man" and content "romanus sum"
    Then  tip page contains a list of comments sorted by creation time
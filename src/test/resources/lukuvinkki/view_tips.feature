Feature: User can view tips

  Scenario: user can view all tips in correct order
    Given there are some tips created
    And   user is on the index page
    Then  page contains a list of tips sorted by creation time


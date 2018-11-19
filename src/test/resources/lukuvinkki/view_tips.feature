Feature: User can view tips

  Scenario: user can view all tips in correct order
    Given there are some tips created
    And   command view tips is selected
    Then  page contains a list of tips sorted by creation time


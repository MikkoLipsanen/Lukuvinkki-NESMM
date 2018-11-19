Feature: User can view tips
  Scenario: user can view all tips
    Given there are some tips created
    And user selects view tips
    Then page contains list of tips in correct order
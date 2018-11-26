Feature: User can mark tip as read

  Scenario: user can mark tip as read
    Given there are some tips created
    And   command Mark as Read is selected
    Then  page shows the selected tip marked as read
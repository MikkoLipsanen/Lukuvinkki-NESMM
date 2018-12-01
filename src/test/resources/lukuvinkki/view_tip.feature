Feature: User can view tip

  Scenario: user can click title to get all fields of the tip
    Given tip with title "vain yksi", author "eero", url "localhost:8080" and description "Vain taman lukuvinkin pitaisi nakya" is created
    And command view tips is selected
    When title "vain yksi" is clicked
    Then page contains title "vain yksi", author "eero", description "Vain taman lukuvinkin pitaisi nakya" and url "localhost:8080"
Feature: User can create a new tip

#  Scenario: user can create a new tip with some values
#    Given command new tip is selected
#    When  title "title", author "author", url "url" and description "desc" are given
#    Then  a new tip with is created with title "title", author "author", url "url" and description "desc"

  Scenario: a proper form for adding tips exists
    Given command new tip is selected
    Then  a proper form with title, author, url and description is shown
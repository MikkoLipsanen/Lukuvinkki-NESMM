Feature: User can view tip

  Scenario: user can click title to get all fields of the tip
    Given tip with title "vain yksi", author "eero", url "localhost:8080" and description "Vain taman lukuvinkin pitaisi nakya" is created
    And command view tips is selected
    When title "vain yksi" is clicked
    Then page contains title "vain yksi", author "eero", description "Vain taman lukuvinkin pitaisi nakya" and url "localhost:8080"

  Scenario: the url of a tip is a link
    Given tip with title "testtitle", author "testauthor", url "https://lukuvinkki-nesmm.herokuapp.com/" and description "testdesc" is created
    And command view tips is selected
    And title "testtitle" is clicked
    Then url "https://lukuvinkki-nesmm.herokuapp.com/" can be clicked
    And the current url address is "https://lukuvinkki-nesmm.herokuapp.com/"
    

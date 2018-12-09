#Feature: User can create a new tip

#  Scenario: a proper form for adding tips exists
#    Given command new tip is selected
#    Then  a proper form with title, author, url and description is shown

#  Scenario: after creating a tip the main page is shown 
#    Given command new tip is selected
#    When  title "testtitle", author "testauthor", url "testurl" and description "testdesc" are given
#    Then  the page of the new tip is shown
#
#  Scenario: user can create a new tip with some values
#    Given command new tip is selected
#    When  title "testtitle", author "testauthor", url "testurl" and description "testdesc" are given
#    And   command view tips is selected
#    Then  a new tip is created with title "testtitle", author "testauthor" and description "testdesc"

#  Scenario: user can create a new tip with tags
#    Given command new tip is selected
#    When  title "Some book", author "Shakespeare", url "https://example.com", description "Foobar" and tags "book; tag; classics" are given
#    And   command view tips is selected
#    Then  following tags are found in newly created tip:
#      |book|tag|classics|

#  Scenario: user can create a new tip with existing tags
#    Given there are some tips created
#    And   command new tip is selected
#    When  title "Some book", author "Shakespeare", url "https://example.com", description "Foobar" and tags "foo; bar; baz" are given
#    And   command view tips is selected
#    Then  following tags are found in newly created tip:
#      |foo|bar|baz|
#    And   only following tags are created:
#      |foo|bar|baz|

#  Scenario: user cannot add two tags of the same name to a tip
#    Given command new tip is selected
#    When  title "testtitle", author "testauthor", url "testurl", description "testdesc" and tags "foo; bar; foo; bar" are given
#    And   command view tips is selected
#    Then  the new tip has only two tags

#  Scenario: tag "video" is added when creating a tip that is a YouTube video
#    Given command new tip is selected
#    When  title "testtitle", author "testauthor", url "https://www.youtube.com/watch?v=dQw4w9WgXcQ" and description "testdesc" are given
#    And   command view tips is selected
#    Then  following tags are found in newly created tip:
#      |video|

#  Scenario: tag "tieteellinen julkaisu" is added when creating a tip that is from ACM DL
#    Given command new tip is selected
#    When  title "testtitle", author "testauthor", url "https://dl.acm.org/citation.cfm?id=950595" and description "testdesc" are given
#    And   command view tips is selected
#    Then  following tags are found in newly created tip:
#      |tieteellinen julkaisu|
#
#  Scenario: tag "tieteellinen julkaisu" is added when creating a tip that is from IEEE Xplore
#    Given command new tip is selected
#    When  title "testtitle", author "testauthor", url "https://ieeexplore.ieee.org/document/6740844" and description "testdesc" are given
#    And   command view tips is selected
#    Then  following tags are found in newly created tip:
#      |tieteellinen julkaisu|

#Scenario: user can not create a new tip without any values
#    Given command new tip is selected
#    When  title "", author "", url "" and description "" are given
#    Then  no new tip is created

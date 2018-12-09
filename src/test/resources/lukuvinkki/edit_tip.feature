Feature: User can edit tip

#  Scenario: user can edit all the fields of the tip and view the edited version
#    Given there are some tips created
#    And command view tips is selected
#    And title "Sepon tarinat" is clicked
#    When command edit tip is selected
#    And title " II", author " S.", url "; https://example.com", description " koskaan" and tags " book" are given
#    Then view tip page is shown
#    And page contains title "Sepon tarinat II", author "Seppo S.", url "https://google.com; https://example.com", description "Toiseksi mahtavin tarina ikinä koskaan", tag1 "foo" and tag2 "book" 


#  Scenario: deleted information is not preserved in the edited tip
#    Given there are some tips created
#    And command view tips is selected
#    And title "Sepon tarinat" is clicked
#    When command edit tip is selected
#    And field "author" is cleared
#    Then view tip page is shown
#    And page does not contain deleted field content "Seppo"
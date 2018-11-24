Feature: User can search tips

    Scenario: user finds tip with proper tag name
        Given tip with proper tag "supertag" is created
        When command search is selected with keyword "supertag"
        Then list contains tip with tag "supertag"

    Scenario: user doesnt find tip with miswritten tag name
        Given tip with misspelled tag "elamankerta" is created
        When command search is selected with invalid keyword "elamakerta"
        Then list doesnt contain tip with tag "elamankerta"
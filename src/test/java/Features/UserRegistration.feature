Feature: User Registration
  I want to check that the user can register in our e-commerce website.

  Scenario Outline:User Registration
    Given : The user in home page
    When : I click on register link
    And : I entered "<firstName>" , "<lastName>" , "<email>" , "<password>"
    Then : The registratoin page is displayed Successfully
Examples:
      | firstName | lastName | email | password|
      | ahmed  |  mohammed | ahmed43@gmail.com | 12234|
Feature: Automated E2E Test
  Description : The purpose of this feature is to test  End 2 End Automation;
  Scenario Outline: Customer place an order  by purchasing an item from search;
    Given : The user in home page
    When :  he search for "<productName>"
    And : choose to by two items
    And : move to checkout cart and enter personal details on checkout page and place the order
    Then : he can view the order and  dwonload the voise
    Examples:
    | productName            |
    | Apple MacBook Pro |
Feature: Retrieving person details from a web table

  Scenario: Retrieve person details by name
    Given I am on the demo website
    When I select the language
    And I input the person's name "Iris"
    Then I should see the person's details
      | Id      | 785                |
      | Person  | Iris               |
      | Food    | Cheesecake         |
      | Date    | 6/7/2009           |
      | Country | Redridge Mountains |
      | Meals   | Wheat, Potato      |
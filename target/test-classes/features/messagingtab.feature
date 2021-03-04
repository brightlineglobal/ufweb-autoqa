Feature: Message
  Description: validate login page function

  Background: user is on login page
    Given I open the browser
    When I navigate to the login page
    And I enter user name "gilman.dallas@gmail.com" and password "Kadir123"
   # Then user click on login button
    Then I click on login
    Then verify dashboard page title as "UpFounders"
   # Then verify dashboard page title as "UpFounders"
    #And user verify the user name "kadir gilman juniors" and company name "Global Inc"


  Scenario: sending the first mesage
    And i click on mesage button
    And I click on popup mesage
    Then I verify i am on meseging page
    And I type "hello friend" on text field and click send then verify
    And I verify "hello friend" message from sender "Kadir Akti"
    Then I click on logout link


  Scenario: verify receiving message from another account and reply
    Then I click on logout link
    And I enter user name "abd.akti@gmail.com" and password "Mavibeyaz25"
    Then I click on login
    And i click on mesage button
    And I click on popup mesage from "kadir gilman juniors"
    And I verify "hello friend" message from other sender "kadir gilman juniors"
    And I type "hello friend" on text field and click send then verify
    Then I click on logout link
Feature: login page
  Description: validate login page function

  Background: user is on login page
    Given I open the browser
    When I navigate to the login page

  Scenario: user attempt to login without any credential
    And click on login button
    Then empty email error message "Email is required" should be displayed

  Scenario: user attempt to login with incorrect email format
    And click on login button
    Then I enter user name "mytest$outlook.com"
    And click on login button
    Then error message "Invalid email" should be displayed

  Scenario: user attempt to login without password
    And I enter user name "abd.akti@gmail.com"
    And click on login button
    Then login failure message "Password is required" should be displayed

  Scenario Outline: user attempt to login with unregistered email account
    And I enter user name "<email>"
    And I enter password "<password>"
    And click on login button
    Then no account found "No Account Found" should be displayed

    Examples:
      |email                     |password    |
      |abd.akti23@gmail.com      |Mavibeyaz251|

  Scenario Outline: user login successfully with correct credential
    And I enter user name "<email>"
    And I enter password "<password>"
    And click on login button
    Then I click on logout link

    Examples:
      |email                     |password   |
      |gilman.dallas@gmail.com   |Kadir123   |
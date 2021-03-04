Feature: reset password page
  Description: validate reset password function

  Background: user is on login page
    Given I open the browser
    When I navigate to the login page

  Scenario: user verify reset password email received and use the password to relogin
    And user navigate to his own mailbox
    And user input email "testingpw@upfounders.co" and pw "Welcome2021!"
    And user click to the reset password email
    Then I copy new password and navigate to UpFounders login page and input new pw for "testingpw@upfounders.co"
    And click on login button
    Then verify dashboard page title as "UpFounders"
    Then I click on logout link


  Scenario Outline: user reset password
    And user click on UpFounders logo to refresh the login page and verify
    And user click on "<reset password link>" to be directed to reset password page and verify "<url>"
    Then user click "<return link>" to return to login page and verify logo
    And user click on "<reset password link>" to be directed to reset password page and verify "<url>"
    Then user directed to reset password page and verify "<head title>" head title
    Then user try to reset without entering email and get "<require message>"
    And user try to reset with "<wrong email>" format and get "<format warning>"
    And user enter correct "<email>" and click on "<reset button>"
    And user verify "<confirmation message>"
    Then user will be automatically redirected to login page and verify logo

    Examples:
      |reset password link |url                                             |require message  |wrong email   |format warning|return link   |head title    |email                     |reset button  |confirmation message    |
      |Forget password?    |https://upfounders-staging.herokuapp.com/resetpw|Email is required|test@mmail,com|Invalid email |Back to Login?|Reset Password|testingpw@upfounders.co|RESET PASSWORD|A Temporary password will be sent this email if a matching user record is found|


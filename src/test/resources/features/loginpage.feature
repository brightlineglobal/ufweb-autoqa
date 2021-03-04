Feature: login page
  Description: validate login page function

 Background: user is on login page
  Given I open the browser
   When I navigate to the login page

  Scenario: UFWEB-256 S1 user attempt to login without any credential
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

# Scenario Outline: user reset password
  #  And user click on UpFounders logo to refresh the login page and verify
   # And user click on "<reset password link>" to be directed to reset password page and verify "<url>"
   # Then user click "<return link>" to return to login page and verify logo
   # And user click on "<reset password link>" to be directed to reset password page and verify "<url>"
   # Then user directed to reset password page and verify "<head title>" head title
   # Then user try to reset without entering email and get "<require message>"
   # And user try to reset with "<wrong email>" format and get "<format warning>"
   # And user enter correct "<email>" and click on "<reset button>"
   # And user verify "<confirmation message>"
   # Then user will be automatically redirected to login page and verify logo

    #Examples:
     # |reset password link |url                                             |require message  |wrong email   |format warning|return link   |head title    |email                     |reset button  |confirmation message    |
      #|Forget password?    |https://upfounders-staging.herokuapp.com/resetpw|Email is required|test@mmail,com|Invalid email |Back to Login?|Reset Password|gilman.kadir@upfounders.co|RESET PASSWORD|A Temporary password will be sent this email if a matching user record is found|

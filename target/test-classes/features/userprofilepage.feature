Feature: User Profile Page
  Description: Update user profile page and validate all the functions

  Background: User Successfully Login To Dashborad
    Given User is on login page and get the title of the login page
    When User inters username "omer.a.oghuz@upfounders.co" and password "Work@2020"
    And User clicks login button
    Then User get home page title


  Scenario: UFWEBAUTO-155-S1 Select user profile icon and validate drop down options
    Given User is on home page and veridy the title of the Home page
    When User clicks user profile icon
    Then Validate drop down options when apppears
    And User verify "userId" "profile" "Settings" "Help" and "Logout" options
    Then User clicks logout
    And Return to login page and verify login button is displayed

  Scenario: UFWEBAUTO-156-S1 Update user profile account details
    Given Click on user icon after landing to the home page
    When Select the Profile from dropdwon
    When Enter texts to the fields
    Then Click on Save and Update button
    And validate the "profile updated successfully" message

  Scenario: UFWEBAUTO-156-S1 Update user password
    Given User is on home page and clicks on user icon
    When Navigate to user profile page
    Then Select change password link
    And Enter new password as "Test@2021" into the fields
    Then Click on save and validate the "password updated" message
    And Click on user icon and logout
    When User relogin with username "omer.a.oghuz@upfounders.co" and new password "Test@2021"
    And User clicks login button
    Then Navigate to user profile page And Select change password link
    And User reverse back the old password "Work@2020" and click on Save button

  Scenario: UFWEBAUTO-156-S1 Update and validate general info of the user
    Given User is on login page And clicks on user Icon
    When User select Profile and landing to the account information page
    Then Update username, job title And company name
    And click on save and update button And refresh the page
    Then Validate the changed username jop title and company name
    And Reverse back the original user info
    Then click on same and update button And validate the success message





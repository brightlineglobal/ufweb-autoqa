Feature: Dashboard Functions
  Description: test and validate dashboard functions

  Background: user is on login page
    Given I open the browser
    When I navigate to the login page
    And I enter user name "gilman.dallas@gmail.com" and password "Kadir123"
    Then I click on login
    Then verify dashboard page title as "UpFounders"


  Scenario: UFWEBAUTO-148-S1 user verify and click links at dashboard sidebar
    And verify post button is visible at creating new post area
    And user verify the user name "kadir gilman juniors" and company name "Global Inc"
    Then verify the head bar title is "HOME"
    And click the upfounders logo to redirect to people page and verify "PEOPLE" head title
    #click logo should refresh the page to home page, there is a bug here
    Then verify the following links as clickable icons on the full size sidebar
      |Home|My Mentor|Story|People|Content|Links|Notes|
    And click each links and verify each page's head title
    Then I click on logout link

    Scenario: UFWEBAUTO-148-S2 user verify and click links at minimized sidebar
      Then verify the head bar title is "HOME"
      And user click the arrow icon to minimize the sidebar
          #same situation as line 12
      Then verify and click the following links as clickable icons on the minimized sidebar
      |home|supervised_user_circle|web|people|collections_bookmark|link|note|
      And click each links on mini side bar and verify each page's head title
      And click the arrow icon to maximize the side bar
      Then I click on logout link

  Scenario: UFWEBAUTO-148-S3 user verify clickable function icons on head bar and virtual assistant
    Then verify the head bar title is "HOME"
    And click on user's avatar to go to user profile page and close popup window if show up
    Then verify, open and close each of the following clickable function icons on head bar
      |message|notifications|account_circle|
    And click to open and close virtual assistant icon
    Then I click on logout link

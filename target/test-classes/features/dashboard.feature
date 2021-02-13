Feature: Dashboard Functions
  Description: test and validate dashboard functions

  Background: user successfully login to the dashboard
    Given user opens the browser and navigate to the login page
    When user login to the dashboard with email "gilman.dallas@gmail.com" and password "Kadir123"
    Then verify dashboard page title as "https://upfounders-staging.herokuapp.com/dashboard/home"
    And verify place holder content "Post something" at text input area of creating new post

  Scenario: user verify and click links at dashboard sidebar
    When user verify the UpFounders logo
    And click the upfounders logo to redirect to people page
    #click logo should refresh the page to home page, there is a bug here
    Then verify and click the following links as clickable icons on the full size sidebar
      |Home|My Mentor|Story|People|Content|links|Notes|Admin|
    And click on user's avatar to go to user profile page
    And close the popup window on user profile page to remain at dashboard
    Then click logout on dashboard to return to login page

    Scenario: user verify and click links at minimized sidebar
      When user click the arrow icon to minimize the sidebar
      And click the upfounders logo to redirect to people page
      #same situation as line 12
      Then verify and click the following links as clickable icons on the minimized sidebar
      |home|supervized_user_circle|web|people|collections_bookmark|link|note|people|
      And click the arrow icon to maximize the side bar
      Then click logout on dashboard to return to login page

  Scenario: user verify clickable function icons on head bar and virtual assistant
    When user verify the head bar named as "HOME"
    Then open and close each of the following clickable function icons on head bar
      |message|notifications|account_circle|
    And click to open and close virtual assistant icon
    Then click logout on dashboard to return to login page

Feature: content page
  Description: Access to All Content Page Functionalities

  Background: user successfully login to the dashboard
    Given user opens the browser and navigate to the login page
    When user login to the dashboard with email "gilman.dallas@gmail.com" and password "Kadir123"
    Then verify dashboard page title as "https://upfounders-staging.herokuapp.com/dashboard/home"
    And verify place holder content "Post something" at text input area of creating new post
    Then click on content page and verify head bar name "CONTENT"

    Scenario Outline: User verify My Links and Shared Links then add a new link or links
    Given user click on Links tab and verify
    When click on first link in My Links and verify page title "Global Link"
    Then go to shared link and verify first link's page title "Global Link"
    And user add new link using Add icon with "<link name>" and "<url>" and "<description>" and "<tag>"
    And go to edit link to make the status of the newly created link as "public"
    Then verify the new added link in shared link tab
    Then click logout on dashboard to return to login page


      Examples:
    |link name   |url                    |description         |tag       |
    |amazon      |https://www.amazon.com |testing purpose     |UsefulLink|


  Scenario Outline: User verify My Notes and Shared Notes then add a simple note and a note with link
    Given user click on Notes tab and verify
    Then add a new Note using Add icon with title "Test Note" and description "Test Content" and tag "testTag"
    And go to shared Note to verify newly added note
    Then add a new Note with Link using Add icon with "<title>" and "<url>" and "<tag>"
    Then go to shared Note to verify newly added note with its link
    Then click logout on dashboard to return to login page

    Examples:
      |title               |url                    |tag           |
      |Test Note with Link |https://www.amazon.com |NoteWithLink  |

    Scenario: user delete all three newly added links and notes
      Given user click on Links tab and select edit icon to edit the newly created link
      Then user delete this newly created link and validate if the link is not deleted
      And user click on Notes tab and select edit note icon to edit the newly created simple note
      Then user delete this newly created simple note and validate if the note is not deleted
      And user click on shared Notes tab and select edit note icon to edit the newly created note with link
      Then user delete this newly created note with link and validate if the note is not deleted
      Then click logout on dashboard to return to login page



Feature: content page
  Description: Access to All Content Page Functionalities

  Background: user is on login page
    Given I open the browser
    When I navigate to the login page
    And I enter user name "gilman.dallas@gmail.com" and password "Kadir123"
    Then I click on login
    Then verify dashboard page title as "UpFounders"
    Then user click on content page and verify head bar name "CONTENT"

    Scenario Outline: User verify My Links and Shared Links then add a new link or links
    Given user click on Links link and verify head bar name "LINKS"
    When click on first link in My Links and verify page title "Global Link"
    Then go to shared link click and verify first link's page title "Global Link"
    And user add new link using Add icon with "<link name>" and "<url>" and "<description>" and "<tag>"
    And go to edit link to make the status of the newly created link as "public"
    Then verify the new added link "<link name>" and "<description>" in shared link tab
    And click the link and verify "<page title>"
      Then I click on logout link


      Examples:
    |link name   |url                    |description         |tag       |page title |
    |amazon      |https://www.amazon.com |testing purpose     |UsefulLink|Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more|


  Scenario Outline: User add a simple note and a note with link and make them public then verify them in Shared Notes tab
    Given user click on Notes link and verify head bar name "NOTES" and tab name "My Notes"
    Then add a new Note using Add icon with title "Test Note" and description "Test Content" and tag "testTag"
    And make the note "Private" and verify the note in "My Notes" tab
    Then go to edit note and make the note "Public" and verify the note in "Shared" Notes tab
    Then add a new Note with Link using Add icon with "<title>" and "<url>" and "<tag>"
    And make the note "Private" and verify the note in "My Notes" tab
    Then go to edit note and make the note "Public" and verify the note in "Shared" Notes tab
    And go to shared Note to verify newly added note's "<title>" "<url>" and "<tag>"
    Then click the link at this Note with link and verify "<page title>"
    Then I click on logout link

    Examples:
      |title               |url                    |tag           |page title  |
      |Test Note with Link |https://www.amazon.com |NoteWithLink  |Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more|

    Scenario Outline: user verify newly added public notes and link in Home Page and then delete all three of them
      Given user is on the home page and verify "HOME" head bar title
      And user verify shared "<link name>" and shared "<link tag>" and click the link and verify "<page title>"
      Then user verify shared "<note title>" and shared "<note tag>"
      And user verify shared "<note with link name>" and click the link then verify "<page title>"
      And verify all added shared links and notes in home page
      Then user click Shared links tab and delete the newly created link and validate if the link is deleted
      And user click Shared Notes tab and delete the newly created simple note and validate if the note is deleted
      And user click Shared Notes tab and select edit note icon to edit the newly created note with link
      Then user delete this newly created note with link and validate if the note is not deleted
      Then I click on logout link


      Examples:
        |link name  |link tag   |note title |note tag  |note with link name  |page title|
        |amazon     |UsefulLink |Test Note  |testTag   |amazon               |Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more|




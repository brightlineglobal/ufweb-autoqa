Feature: Message
  Description: validate login page function

  Scenario: UFWEB-256 S1 user attempt to login without any credential
    And click on logidn button
    Then empty emaddil error message "Email is required" should be displayed
    And later do this
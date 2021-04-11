Feature: Land On Go

  Scenario: Player gets 200 pounds when player lands on go
    Given A player starts a turn on "Mayfair" with a balance of 0
    When The player rolls a 1
    Then The player ends the turn on "Go"
    And The player has a balance of 200

  Scenario: Player balance is unchanged when player does not land on go
    Given A player starts a turn on "Community Chest 2" with a balance of 0
    When The player rolls a 4
    Then The player ends the turn on "Strand"
    And The player has a balance of 0
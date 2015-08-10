Feature: Land On Go

  # As a player
  # When I land on go
  # I get 200 pounds as my salary for staying in the game

  Scenario: Player gets 200 pounds when player lands on go
    Given A player is at position 40
    When The player rolls a 1
    Then The player is on "Go"
    And The player has a balance of 200

  Scenario: Player balance is unchanged when player does not land on go
    Given A player is at position 17
    When The player rolls a 5
    Then The player is on "Strand"
    And The player has a balance of 0
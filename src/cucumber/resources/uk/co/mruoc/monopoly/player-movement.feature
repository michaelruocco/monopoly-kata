Feature: Player Movement

  # As a player
  # I want to be able to take a turn
  # So that I can move around the board

  Scenario: Movement from go
    Given A player is at position 0
    When The player rolls a 7
    Then The player is at position 7

  Scenario: Movement when player passes go
    Given A player is at position 39
    When The player rolls a 6
    Then The player is at position 5

  Scenario: Player gets 200 pounds when player lands on go
    Given A player is at position 40
    When The player rolls a 1
    Then The player is on "Go"
    And The player has a balance of 200

  Scenario: Player balance is unchanged when player does not land on go
    Given A player is at position 1
    When The player rolls a 5
    Then The player is on "Kings Cross Station"
    And The player has a balance of 0
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
    Given A player is at position 17
    When The player rolls a 5
    Then The player is on "Strand"
    And The player has a balance of 0

  Scenario: Player gets 200 pounds when player passes go
    Given A player is at position 38
    When The player rolls a 14
    Then The player is on "Pall Mall"
    And The player has a balance of 200

  Scenario: Player balance is unchanged when player starts on go and does not pass or land on go
    Given A player is at position 1
    When The player rolls a 5
    Then The player is on "Kings Cross Station"
    And The player has a balance of 0

  Scenario: Player gets 200 pounds every time player passes go
    Given A player is at position 1
    When The player rolls a 80
    Then The player is on "Go"
    And The player has a balance of 400
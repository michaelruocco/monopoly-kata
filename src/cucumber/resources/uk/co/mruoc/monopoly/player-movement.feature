Feature: Player Movement

  Scenario: Movement from go
    Given A player starts a turn on "Go"
    When The player rolls a 7
    Then The player ends the turn on "Chance 1"

  Scenario: Movement when player passes go
    Given A player starts a turn on "Mayfair"
    When The player rolls a 6
    Then The player ends the turn on "Kings Cross Station"
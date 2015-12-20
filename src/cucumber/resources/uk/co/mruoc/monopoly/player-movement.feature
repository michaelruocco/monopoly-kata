Feature: Player Movement

  Scenario: Movement from go
    Given A player starts a turn on "Go"
    When The player rolls a 7
    Then The player ends the turn on "Chance 1"

  Scenario: Movement when player passes go
    Given A player starts a turn on "Mayfair"
    When The player rolls a 6
    Then The player ends the turn on "Kings Cross Station"

  Scenario: Player does not roll doubles
    Given A player starts a turn on "Go"
    When The players rolls a 1 and a 6
    Then The player ends the turn on "Chance 1"

  Scenario: Player rolls doubles and can take an extra turn
    Given A player starts a turn on "Go"
    When The players rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The players rolls a 1 and a 3
    Then The player ends the turn on "Just Visiting / Jail"

  Scenario: Player rolls two doubles and can take two extra turns
    Given A player starts a turn on "Go"
    When The players rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The players rolls a 3 and a 3
    Then The player ends the turn on "Electric Company"
    When The players rolls a 1 and a 3
    Then The player ends the turn on "Bow Street"

  Scenario: Player does rolls three doubles and moves to just visiting
    Given A player starts a turn on "Go"
    When The players rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The players rolls a 3 and a 3
    Then The player ends the turn on "Electric Company"
    When The players rolls a 3 and a 3
    Then The player ends the turn on "Just Visiting / Jail"
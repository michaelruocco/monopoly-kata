Feature: Player Movement

  Scenario: Movement from go
    Given A player starts a turn on "Go"
    When The player rolls a 6
    Then The player ends the turn on "The Angel Islington"

  Scenario: Movement when player passes go
    Given A player starts a turn on "Mayfair"
    When The player rolls a 6
    Then The player ends the turn on "Kings Cross Station"

  Scenario: Player does not roll doubles
    Given A player starts a turn on "Go"
    When The player rolls a 1 and a 5
    Then The player ends the turn on "The Angel Islington"

  Scenario: Player rolls doubles and can take an extra turn
    Given A player starts a turn on "Go"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The player rolls a 1 and a 3
    Then The player ends the turn on "Just Visiting"

  Scenario: Player rolls two doubles and can take two extra turns
    Given A player starts a turn on "Go"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "Electric Company"
    When The player rolls a 1 and a 3
    Then The player ends the turn on "Bow Street"

  Scenario: Player rolls three doubles and goes to jail
    Given A player starts a turn on "Go"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "Electric Company"
    When The player rolls a 3 and a 3
    Then The player is in jail
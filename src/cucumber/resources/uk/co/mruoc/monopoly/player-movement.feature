@wip
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
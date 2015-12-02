@wip
Feature: Passing Over Go

  # As a player
  # When I pass over go
  # I get 200 pounds as my salary for staying in the game

  Scenario: Player gets 200 pounds when player passes go
    Given A player is at position 38
    When The player rolls a 23
    Then The player is on "Free Parking"
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
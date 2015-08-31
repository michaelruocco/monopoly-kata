Feature: Player Win

  # As a player in a two player game
  # I want the other players balance to go below zero
  # So that I can win the game

  Scenario: Two players, on players balance goes below zero
    Given The game is set up with 2 players
    When The first player lands on super tax
    Then The second player is the winner
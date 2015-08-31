Feature: Player Win

  # As a player in a game
  # I want the other players balance to go below zero
  # So that I can win the game

  Scenario: Two players, one players balance goes below zero
    Given The game is set up with 2 players
    When The first player lands on super tax
    Then The second player is the winner

  Scenario: Three players, one players balance goes below zero
    Given The game is set up with 3 players
    When The first player lands on super tax
    Then The other two players continue complete the game
    And have played 20 rounds each
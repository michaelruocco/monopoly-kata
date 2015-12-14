Feature: Player Win

  # As a player in a game
  # I want the other players balance to go below zero
  # So that I can win the game

  Scenario: Two players, one players balance goes below zero
    Given The game is set up with 2 players
    When Player 1 lands on "Super Tax"
    Then Player 1 has a balance of -75
    And Player 2 is the winner

  Scenario: Three players, one players balance goes below zero
    Given The game is set up with 3 players
    When Player 1 lands on "Super Tax"
    Then Player 1 has a balance of -75
    And The other players continue complete the game
    And Have played 20 rounds

  Scenario: Three players, two players balance goes below zero
    Given The game is set up with 3 players
    When Player 1 lands on "Super Tax"
    When Player 2 lands on "Super Tax"
    Then Player 1 has a balance of -75
    And Player 2 has a balance of -75
    And Player 3 is the winner
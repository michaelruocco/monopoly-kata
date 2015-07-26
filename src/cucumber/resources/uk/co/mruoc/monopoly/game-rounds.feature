Feature: Game Rounds

  # As a game
  # I want to be able to execute 20 rounds
  # So that I can complete a game

  Scenario: Each player plays 20 rounds
    Given A game is played
    When The game is complete
    Then There were 20 rounds in total
    And Each player has played 20 rounds

  Scenario: Each player plays 20 rounds in the correct order
    Given A game is played
    When The game is complete
    Then The order of the players is the same for each round
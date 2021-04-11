Feature: Game Rounds

  Scenario: Each player plays 20 rounds
    Given A game is played
    When The game is complete
    Then There were 20 rounds in total
    And Each player has played 20 rounds

  Scenario: Each player plays 20 rounds in the correct order
    Given A game is played
    When The game is complete
    Then There were 20 rounds in total
    And The order of the players is the same for each round
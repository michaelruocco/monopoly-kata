Feature: Players

  Scenario: Create a game with two players
    Given 2 players
    When the game is started
    Then One of the players is "Horse"
    And One of the players is "Car"

  Scenario: Error if less than two players
    Given 1 player
    When the game is started
    Then An error occurred with the message "cannot create a game with less than 2 players"

  Scenario: Error if more than eight players
    Given 9 players
    When the game is started
    Then An error occurred with the message "cannot create a game with more than 8 players"

  Scenario: Player order is assigned randomly
    Given 2 players
    When 100 games are started
    Then "Horse" is the first player at least once
    And "Car" is the first player at least once
Feature: Game Players

  Scenario: Create game with two players
    When A game is set up with 2 players
    Then The game has 2 players
    And One of the players is "Horse"
    And One of the players is "Car"

  Scenario: Error if less than two players
    When A game is set up with one player
    Then An error is thrown with the message "cannot create a game with less than 2 players"

  Scenario: Error if more than eight players
    When A game is set up with 9 players
    Then An error is thrown with the message "cannot create a game with more than 8 players"

  Scenario: Player order is assigned randomly
    When 100 games are created with 2 players
    Then "Horse" is the first player at least once
    And "Car" is the first player at least once
Feature: Players

  Scenario: Create a game with two players
    Given a player "Horse"
    And a player "Car"
    When the game is started
    Then One of the players is "Horse"
    And One of the players is "Car"

  Scenario: Error if less than two players
    Given a player "Horse"
    When the game is started
    Then An error occurred with the message "game has 1 players, cannot create a game with less than 2 players"

  Scenario: Error if more than eight players
    Given a player "Horse"
    And a player "Car"
    And a player "Boat"
    And a player "Dog"
    And a player "Thimble"
    And a player "Boot"
    And a player "Hat"
    And a player "Wheelbarrow"
    And a player "Iron"
    When the game is started
    Then An error occurred with the message "game has 9 players, cannot create a game with more than 8 players"

  Scenario: Player order is assigned randomly
    Given a player "Horse"
    And a player "Car"
    When 100 games are started
    Then "Horse" is the first player at least once
    And "Car" is the first player at least once
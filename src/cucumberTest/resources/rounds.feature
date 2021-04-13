Feature: Rounds

  Scenario: 20 Rounds played in game
    Given a player "Horse"
    And a player "Car"
    And the game is created
    When the game is played
    Then 20 rounds have been played in total
    And "Horse" has played 20 rounds
    And "Car" has played 20 rounds

  Scenario: Player order is the same in every round
    Given a player "Horse"
    And a player "Car"
    And the game is created
    When the game is played
    Then the order of the players is the same in every round
Feature: Player Movement

  Scenario: Player moves according to roll using location index
    Given a player "Horse"
    And a player "Car"
    And the game is created
    And player "Car" starts at location 0
    When player "Car" rolls 7
    Then player "Car" is at location 7

  Scenario: Player moves past the end of the board using location index
    Given a player "Horse"
    And a player "Car"
    And the game is created
    And player "Car" starts at location 39
    When player "Car" rolls 6
    Then player "Car" is at location 5

  Scenario: Player moves according to roll using location name
    Given a player "Horse"
    And a player "Car"
    And the game is created
    And player "Car" starts at location "Go"
    When player "Car" rolls 7
    Then player "Car" is at location "Chance"

  Scenario: Player moves past the end of the board using location name
    Given a player "Horse"
    And a player "Car"
    And the game is created
    And player "Car" starts at location "Mayfair"
    When player "Car" rolls 6
    Then player "Car" is at location "Kings Cross Station"
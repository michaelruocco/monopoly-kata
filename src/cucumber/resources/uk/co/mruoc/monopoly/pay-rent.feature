Feature: Pay Rent

  Scenario: Player lands on train station owned by another player that owns just 1 train station and pays 25 rent
    Given The game is set up with 2 players
    And Player 1 owns "Kings Cross Station"
    And Player 1 starts with a balance of 25
    And Player 2 starts with a balance of 25
    When Player 2 lands on "Kings Cross Station"
    Then Player 2 has to pay 25 in rent to player 1
    And Player 1 has a balance of 50
    And Player 2 has a balance of 0

  Scenario: Player lands on train station owned by another player that owns 2 train stations and pays 50 rent
    Given The game is set up with 2 players
    And Player 1 owns "Kings Cross Station"
    And Player 1 owns "Marylebone Station"
    And Player 1 starts with a balance of 25
    And Player 2 starts with a balance of 60
    When Player 2 lands on "Kings Cross Station"
    Then Player 2 has to pay 50 in rent to player 1
    And Player 1 has a balance of 75
    And Player 2 has a balance of 10

  Scenario: Player lands on train station owned by another player that owns 3 train stations and pays 100 rent
    Given The game is set up with 2 players
    And Player 1 owns "Kings Cross Station"
    And Player 1 owns "Marylebone Station"
    And Player 1 owns "Fenchurch Street Station"
    And Player 1 starts with a balance of 25
    And Player 2 starts with a balance of 120
    When Player 2 lands on "Kings Cross Station"
    Then Player 2 has to pay 100 in rent to player 1
    And Player 1 has a balance of 125
    And Player 2 has a balance of 20

  Scenario: Player lands on train station owned by another player that owns 4 train stations and pays 200 rent
    Given The game is set up with 2 players
    And Player 1 owns "Kings Cross Station"
    And Player 1 owns "Marylebone Station"
    And Player 1 owns "Fenchurch Street Station"
    And Player 1 owns "Liverpool Street Station"
    And Player 1 starts with a balance of 25
    And Player 2 starts with a balance of 230
    When Player 2 lands on "Kings Cross Station"
    Then Player 2 has to pay 200 in rent to player 1
    And Player 1 has a balance of 225
    And Player 2 has a balance of 30
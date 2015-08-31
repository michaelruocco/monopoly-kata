Feature: Property Purchase

  # As a player
  # I want to be able to buy unowned properties that I land on
  # So that I can try to win the game

  Scenario: Player buys unowned property
    Given A player has a balance of 1000
    When The player moves 4 places
    Then The player owns "Whitechapel Road"
    And The player balance has decreased by the cost of the property
Feature: Property Purchase

  # As a player
  # I want to be able to buy unowned properties that I land on
  # So that I can try to win the game

  Scenario: Player buys unowned property
    Given A player starts a turn on "Go" with a balance of 1000
    When The player rolls a 3
    Then The player ends the turn on "Whitechapel Road"
    And The player owns "Whitechapel Road"
    And The player has a balance of 940
    
  Scenario: Player lands on a property they already own
    Given A player owns "Whitechapel Road"
    And A player starts a turn on "Go" with a balance of 1000
    When The player rolls a 3
    Then The player ends the turn on "Whitechapel Road"
    And The player has a balance of 1000

  Scenario: Player passes over a property that is unowned
    Given A player starts a turn on "Go" with a balance of 1000
    When The player rolls a 20
    Then The player ends the turn on "Free Parking"
    And The player has a balance of 1000
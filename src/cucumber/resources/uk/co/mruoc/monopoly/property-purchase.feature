@wip
Feature: Property Purchase

  # As a player
  # I want to be able to buy unowned properties that I land on
  # So that I can try to win the game

  Scenario: Player buys unowned property
    Given A player has a balance of 1000
    When The player moves 4 places
    Then The player owns "Whitechapel Road"
    And The player balance has decreased by the cost of the property

  Scenario: Player lands on a property they already own
    Given A player has a balance of 1000
    And The player has brought a property
    And The players balance has changed to 940
    When The player passes go and lands on that property again
    Then The the players balance remains unchanged

  Scenario: Player passes over a property that is unowned
    Given A player has a balance of 1000
    When The passes over an unowned property
    Then The the players balance remains unchanged
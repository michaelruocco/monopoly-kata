Feature: Land On Super Tax

  # As a player
  # When I land on super tax
  # Then I have to pay 75

  Scenario: Player with an initial total worth of 1800 lands on Super Tax. The balance decreases by 75.
    Given A player is at position 35
    And has an initial balance of 1800
    When The player rolls a 4
    Then The player is on "Super Tax"
    And The player has a balance of 1725

  Scenario: Player passes over super tax. Nothing happens.
    Given A player is at position 1
    And has an initial balance of 2000
    When The player rolls a 20
    Then The player is on "Free Parking"
    And The player has a balance of 2000
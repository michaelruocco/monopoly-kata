Feature: Land On Income Tax

  # As a player
  # When I land on income tax
  # Then I have to pay the smaller of 10% of my total worth or 200.

  Scenario: Player with an initial total worth of 1800 lands on Income Tax. The balance decreases by 180.
    Given A player is at position 1
    And has an initial balance of 1800
    When The player rolls a 4
    Then The player is on "Income Tax"
    And The player has a balance of 1620

  Scenario: Player with an initial total worth of 2200 lands on Income Tax. The balance decreases by 200.
    Given A player is at position 1
    And has an initial balance of 2200
    When The player rolls a 4
    Then The player is on "Income Tax"
    And The player has a balance of 2000

  Scenario: Player with an initial total worth of 0 lands on Income Tax. The balance decreases by 0.
    Given A player is at position 1
    And has an initial balance of 0
    When The player rolls a 4
    Then The player is on "Income Tax"
    And The player has a balance of 0

  Scenario: Player passes over income tax. Nothing happens.
    Given A player is at position 1
    And has an initial balance of 2000
    When The player rolls a 20
    Then The player is on "Free Parking"
    And The player has a balance of 2000
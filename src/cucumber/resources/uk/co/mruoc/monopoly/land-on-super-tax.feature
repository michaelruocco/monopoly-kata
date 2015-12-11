Feature: Land On Super Tax

  Scenario: Player with an initial total worth of 1800 lands on Super Tax. The balance decreases by 75.
    Given A player starts a turn on "Bond Street" with a balance of 1800
    When The player rolls a 4
    Then The player ends the turn on "Super Tax"
    And The player has a balance of 1725

  Scenario: Player passes over super tax. Nothing happens.
    Given A player starts a turn on "Go" with a balance of 2000
    When The player rolls a 20
    Then The player ends the turn on "Free Parking"
    And The player has a balance of 2000
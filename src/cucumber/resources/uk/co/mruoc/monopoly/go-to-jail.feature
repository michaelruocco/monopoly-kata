Feature: Go To Jail

  # As a player
  # When I land on Go To Jail
  # I move directly to Just Visiting

  Scenario: Player balance is unchanged and player goes to jail when player lands on go to jail
    Given A player is at position 25
    When The player rolls a 6
    Then The player is on "Just Visiting"
    And The player has a balance of 0

  Scenario: Player balance is unchanged and player moves as expected when player does not land on go to jail
    Given A player is at position 25
    When The player rolls a 7
    Then The player is on "Regent Street"
    And The player has a balance of 0
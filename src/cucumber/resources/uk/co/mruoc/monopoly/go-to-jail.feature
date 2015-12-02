Feature: Go To Jail

  Scenario: Player balance is unchanged and player goes to jail when player lands on go to jail
    Given A player starts a turn on "Trafalgar Square" with a balance of 0
    When The player rolls a 6
    Then The player ends the turn on "Just Visiting / Jail"
    And The player has a balance of 0

  Scenario: Player balance is unchanged and player moves as expected when player does not land on go to jail
    Given A player starts a turn on "Trafalgar Square" with a balance of 0
    When The player rolls a 7
    Then The player ends the turn on "Regent Street"
    And The player has a balance of 0
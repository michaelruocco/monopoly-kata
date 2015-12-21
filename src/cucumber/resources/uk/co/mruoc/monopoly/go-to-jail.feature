Feature: Go To Jail

  Scenario: Player goes to jail with unchanged balance when player lands on go to jail not having rolled a double
    Given A player has not rolled a double
    And The player starts with a balance of 500
    When The player lands on "Go To Jail"
    Then The player is in jail
    And The player has a balance of 500

  Scenario: Player goes to jail with unchanged balance when player lands on go to jail having rolled a double
    Given A player has rolled a double
    And The player starts with a balance of 500
    When The player lands on "Go To Jail"
    Then The player is in jail
    And The player has a balance of 500
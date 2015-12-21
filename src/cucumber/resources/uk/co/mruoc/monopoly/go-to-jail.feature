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

  Scenario: Player passes over go to jail and turn continues as normal
    Given A player starts a turn on "Piccadilly"
    When The player rolls a 2
    Then The player ends the turn on "Regent Street"

  Scenario: Player does rolls three doubles does not pass go in turn one or two, balance remains unchanged, player is in jail
    Given A player owns "The Angel Islington"
    And A player owns "Electric Company"
    And A player starts a turn on "Go" with a balance of 1000
    When The player rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "Electric Company"
    When The player rolls a 3 and a 3
    Then The player is in jail
    And The player has a balance of 1000

  Scenario: Player does rolls three doubles, passes go in turn 1, player gets 200, player is in jail
    Given A player owns "Kings Cross Station"
    And A player owns "Pall Mall"
    And A player starts a turn on "Mayfair" with a balance of 1000
    When The player rolls a 3 and a 3
    Then The player ends the turn on "Kings Cross Station"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "Pall Mall"
    When The player rolls a 3 and a 3
    Then The player is in jail
    And The player has a balance of 1200

  Scenario: Player rolls two doubles and does not end up in jail
    Given A player starts a turn on "Go"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "The Angel Islington"
    When The player rolls a 3 and a 3
    Then The player ends the turn on "Electric Company"
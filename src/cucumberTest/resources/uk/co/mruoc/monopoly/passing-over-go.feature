Feature: Passing Over Go

  Scenario: Player gets 200 pounds when player passes go
    Given A player starts a turn on "Park Lane" with a balance of 0
    When The player rolls a 23
    Then The player ends the turn on "Free Parking"
    And The player has a balance of 200

  Scenario: Player balance is unchanged when player starts on go and does not pass or land on go
    Given A player starts a turn on "Go" with a balance of 100
    When The player rolls a 5
    Then The player ends the turn on "Kings Cross Station"
    And The player has a balance of 100

  Scenario: Player gets 200 pounds every time player passes go
    Given A player starts a turn on "Go" with a balance of 0
    When The player rolls a 80
    Then The player ends the turn on "Go"
    And The player has a balance of 400
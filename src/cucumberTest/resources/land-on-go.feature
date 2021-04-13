Feature: Land on Go

  Scenario: Player receives salary of 200 when landing on go
    Given a player "Horse"
    And a player "Car" with a balance of 0.00
    And the game is created
    And player "Car" starts at location "Park Lane"
    When player "Car" rolls 3
    Then player "Car" is at location "Go"
    And player "Car" has a balance of 200.00

  Scenario: Player balance is unchanged when landing on "normal" location
    Given a player "Horse"
    And a player "Car" with a balance of 0.00
    And the game is created
    And player "Car" starts at location "Old Kent Road"
    When player "Car" rolls 7
    Then player "Car" is at location "Euston Road"
    And player "Car" has a balance of 0.00
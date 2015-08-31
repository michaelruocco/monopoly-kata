Feature: Board Locations

  # As a board
  # I need to have the correct layout of monopoly locations
  # So the game can be played correctly

  Scenario: Board locations
    When A board is created
    Then Location 1 is "Go"

    Then Location 2 is "Old Kent Road"
    And Location 2 has a cost of 60

    Then Location 3 is "Community Chest"

    Then Location 4 is "Whitechapel Road"
    And Location 4 has a cost of 60

    Then Location 5 is "Income Tax"

    Then Location 6 is "Kings Cross Station"
    And Location 6 has a cost of 200

    Then Location 7 is "The Angel Islington"
    And Location 7 has a cost of 100

    Then Location 8 is "Chance"

    Then Location 9 is "Euston Road"
    And Location 9 has a cost of 100

    Then Location 10 is "Pentonville Road"
    And Location 10 has a cost of 120

    Then Location 11 is "Just Visiting"

    Then Location 12 is "Pall Mall"
    And Location 12 has a cost of 140

    Then Location 13 is "Electric Company"
    And Location 13 has a cost of 150

    Then Location 14 is "Whitehall"
    And Location 14 has a cost of 140

    Then Location 15 is "Northumberland Avenue"
    And Location 15 has a cost of 160

    Then Location 16 is "Marylebone Station"
    And Location 16 has a cost of 200

    Then Location 17 is "Bow Street"
    And Location 17 has a cost of 180

    Then Location 18 is "Community Chest"

    Then Location 19 is "Marlborough Street"
    And Location 19 has a cost of 180

    Then Location 20 is "Vine Street"
    And Location 20 has a cost of 200

    Then Location 21 is "Free Parking"

    Then Location 22 is "Strand"
    And Location 22 has a cost of 220

    Then Location 23 is "Chance"

    Then Location 24 is "Fleet Street"
    And Location 24 has a cost of 220

    Then Location 25 is "Trafalgar Square"
    And Location 25 has a cost of 240

    Then Location 26 is "Fenchurch Street Station"
    And Location 26 has a cost of 200

    Then Location 27 is "Leicester Square"
    And Location 27 has a cost of 260

    Then Location 28 is "Coventry Street"
    And Location 28 has a cost of 260

    Then Location 29 is "Water Works"
    And Location 29 has a cost of 150

    Then Location 30 is "Piccadilly"
    And Location 30 has a cost of 280

    Then Location 31 is "Go To Jail"

    Then Location 32 is "Regent Street"
    And Location 32 has a cost of 300

    Then Location 33 is "Oxford Street"
    And Location 33 has a cost of 300

    Then Location 34 is "Community Chest"

    Then Location 35 is "Bond Street"
    And Location 35 has a cost of 320

    Then Location 36 is "Liverpool Street Station"
    And Location 36 has a cost of 200

    Then Location 37 is "Chance"

    Then Location 38 is "Park Lane"
    And Location 38 has a cost of 350

    Then Location 39 is "Super Tax"

    Then Location 40 is "Mayfair"
    And Location 40 has a cost of 400

    
    
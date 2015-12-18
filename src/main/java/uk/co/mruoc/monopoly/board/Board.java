package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final String JAIL_POSITION_NAME = "Just Visiting / Jail";

    private final List<Location> locations = new ArrayList<>();

    public Board() {
        addLocations();
    }

    public int size() {
        return locations.size();
    }

    public String getLocationName(int index) {
        Location location = getLocation(index);
        return location.getName();
    }

    public String getLocationName(Player player) {
        return getLocationName(player.getPosition());
    }

    public int getLocationPosition(String locationName) {
        for (int i = 0; i < size(); i++) {
            Location location = getLocation(i);
            if (location.nameEquals(locationName))
                return i;
        }
        throw new GameException("no location found with name " + locationName);
    }

    public int getJailPosition() {
        return getLocationPosition(JAIL_POSITION_NAME);
    }

    public Location getLocation(String locationName) {
        int position = getLocationPosition(locationName);
        return getLocation(position);
    }

    public Property getProperty(String propertyName) {
        int position = getLocationPosition(propertyName);
        Location location = getLocation(position);
        if (location instanceof Property)
            return (Property) location;
        throw new GameException("location " + propertyName + " is not a property");
    }

    public Location getLocation(Player player) {
        return getLocation(player.getPosition());
    }

    private Location getLocation(int index) {
        return locations.get(index);
    }

    private void addLocations() {
        locations.add(new BasicLocation("Go"));
        locations.add(new Street("Old Kent Road", 60, 2));
        locations.add(new BasicLocation("Community Chest 1"));
        locations.add(new Street("Whitechapel Road", 60, 4));
        locations.add(new IncomeTax());
        locations.add(new TrainStation("Kings Cross Station"));
        locations.add(new Street("The Angel Islington", 100, 6));
        locations.add(new BasicLocation("Chance 1"));
        locations.add(new Street("Euston Road", 100, 6));
        locations.add(new Street("Pentonville Road", 120, 8));
        locations.add(new BasicLocation(JAIL_POSITION_NAME));
        locations.add(new Street("Pall Mall", 140, 10));
        locations.add(new Utility("Electric Company", 150));
        locations.add(new Street("Whitehall", 140, 10));
        locations.add(new Street("Northumberland Avenue", 160, 12));
        locations.add(new TrainStation("Marylebone Station"));
        locations.add(new Street("Bow Street", 180, 14));
        locations.add(new BasicLocation("Community Chest 2"));
        locations.add(new Street("Marlborough Street", 180, 14));
        locations.add(new Street("Vine Street", 200, 16));
        locations.add(new BasicLocation("Free Parking"));
        locations.add(new Street("Strand", 220, 18));
        locations.add(new BasicLocation("Chance 2"));
        locations.add(new Street("Fleet Street", 220, 18));
        locations.add(new Street("Trafalgar Square", 240, 20));
        locations.add(new TrainStation("Fenchurch Street Station"));
        locations.add(new Street("Leicester Square", 260, 22));
        locations.add(new Street("Coventry Street", 260, 22));
        locations.add(new Utility("Water Works", 150));
        locations.add(new Street("Piccadilly", 280, 24));
        locations.add(new GoToJail(this));
        locations.add(new Street("Regent Street", 300, 26));
        locations.add(new Street("Oxford Street", 300, 26));
        locations.add(new BasicLocation("Community Chest"));
        locations.add(new Street("Bond Street", 320, 28));
        locations.add(new TrainStation("Liverpool Street Station"));
        locations.add(new BasicLocation("Chance"));
        locations.add(new Street("Park Lane", 350, 35));
        locations.add(new SuperTax());
        locations.add(new Street("Mayfair", 400, 50));
    }

}

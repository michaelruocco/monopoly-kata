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

    public Location getLocation(Player player) {
        return getLocation(player.getPosition());
    }

    private Location getLocation(int index) {
        return locations.get(index);
    }

    private void addLocations() {
        locations.add(new BasicLocation("Go"));
        locations.add(new Property("Old Kent Road", 60));
        locations.add(new BasicLocation("Community Chest 1"));
        locations.add(new Property("Whitechapel Road", 60));
        locations.add(new IncomeTax());
        locations.add(new Property("Kings Cross Station", 200));
        locations.add(new Property("The Angel Islington", 100));
        locations.add(new BasicLocation("Chance 1"));
        locations.add(new Property("Euston Road", 100));
        locations.add(new Property("Pentonville Road", 120));
        locations.add(new BasicLocation(JAIL_POSITION_NAME));
        locations.add(new Property("Pall Mall", 140));
        locations.add(new Property("Electric Company", 150));
        locations.add(new Property("Whitehall", 140));
        locations.add(new Property("Northumberland Avenue", 160));
        locations.add(new Property("Marylebone Station", 200));
        locations.add(new Property("Bow Street", 180));
        locations.add(new BasicLocation("Community Chest 2"));
        locations.add(new Property("Marlborough Street", 180));
        locations.add(new Property("Vine Street", 200));
        locations.add(new Property("Free Parking"));
        locations.add(new Property("Strand", 220));
        locations.add(new BasicLocation("Chance 2"));
        locations.add(new Property("Fleet Street", 220));
        locations.add(new Property("Trafalgar Square", 240));
        locations.add(new Property("Fenchurch Street Station", 200));
        locations.add(new Property("Leicester Square", 260));
        locations.add(new Property("Coventry Street", 260));
        locations.add(new Property("Water Works", 150));
        locations.add(new Property("Piccadilly", 280));
        locations.add(new GoToJail(this));
        locations.add(new Property("Regent Street", 300));
        locations.add(new Property("Oxford Street", 300));
        locations.add(new BasicLocation("Community Chest"));
        locations.add(new Property("Bond Street", 320));
        locations.add(new Property("Liverpool Street Station", 200));
        locations.add(new BasicLocation("Chance"));
        locations.add(new Property("Park Lane", 350));
        locations.add(new SuperTax());
        locations.add(new Property("Mayfair", 400));
    }

}

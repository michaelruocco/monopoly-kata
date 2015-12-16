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
        locations.add(new DefaultLocation("Go"));
        locations.add(new DefaultLocation("Old Kent Road", 60));
        locations.add(new DefaultLocation("Community Chest 1"));
        locations.add(new DefaultLocation("Whitechapel Road", 60));
        locations.add(new DefaultLocation("Income Tax"));
        locations.add(new DefaultLocation("Kings Cross Station", 200));
        locations.add(new DefaultLocation("The Angel Islington", 100));
        locations.add(new DefaultLocation("Chance 1"));
        locations.add(new DefaultLocation("Euston Road", 100));
        locations.add(new DefaultLocation("Pentonville Road", 120));
        locations.add(new DefaultLocation(JAIL_POSITION_NAME));
        locations.add(new DefaultLocation("Pall Mall", 140));
        locations.add(new DefaultLocation("Electric Company", 150));
        locations.add(new DefaultLocation("Whitehall", 140));
        locations.add(new DefaultLocation("Northumberland Avenue", 160));
        locations.add(new DefaultLocation("Marylebone Station", 200));
        locations.add(new DefaultLocation("Bow Street", 180));
        locations.add(new DefaultLocation("Community Chest 2"));
        locations.add(new DefaultLocation("Marlborough Street", 180));
        locations.add(new DefaultLocation("Vine Street", 200));
        locations.add(new DefaultLocation("Free Parking"));
        locations.add(new DefaultLocation("Strand", 220));
        locations.add(new DefaultLocation("Chance 2"));
        locations.add(new DefaultLocation("Fleet Street", 220));
        locations.add(new DefaultLocation("Trafalgar Square", 240));
        locations.add(new DefaultLocation("Fenchurch Street Station", 200));
        locations.add(new DefaultLocation("Leicester Square", 260));
        locations.add(new DefaultLocation("Coventry Street", 260));
        locations.add(new DefaultLocation("Water Works", 150));
        locations.add(new DefaultLocation("Piccadilly", 280));
        locations.add(new DefaultLocation("Go To Jail"));
        locations.add(new DefaultLocation("Regent Street", 300));
        locations.add(new DefaultLocation("Oxford Street", 300));
        locations.add(new DefaultLocation("Community Chest"));
        locations.add(new DefaultLocation("Bond Street", 320));
        locations.add(new DefaultLocation("Liverpool Street Station", 200));
        locations.add(new DefaultLocation("Chance"));
        locations.add(new DefaultLocation("Park Lane", 350));
        locations.add(new SuperTax());
        locations.add(new DefaultLocation("Mayfair", 400));
    }

}

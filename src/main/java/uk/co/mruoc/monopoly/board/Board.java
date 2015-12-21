package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.*;
import uk.co.mruoc.monopoly.chance.ChanceCards;
import uk.co.mruoc.monopoly.chance.DefaultChanceCards;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final String JAIL_POSITION_NAME = "Just Visiting / Jail";

    private final List<Location> locations = new ArrayList<>();

    private final ChanceCards chanceCards = new DefaultChanceCards();
    private final PropertyGroup brownGroup = new PropertyGroup();
    private final PropertyGroup trainStationGroup = new PropertyGroup();
    private final PropertyGroup blueGroup = new PropertyGroup();
    private final PropertyGroup pinkGroup = new PropertyGroup();
    private final PropertyGroup utilityGroup = new PropertyGroup();
    private final PropertyGroup orangeGroup = new PropertyGroup();
    private final PropertyGroup redGroup = new PropertyGroup();
    private final PropertyGroup yellowGroup = new PropertyGroup();
    private final PropertyGroup greenGroup = new PropertyGroup();
    private final PropertyGroup purpleGroup = new PropertyGroup();

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
        locations.add(new Street("Old Kent Road", brownGroup, 60, 2));
        locations.add(new BasicLocation("Community Chest 1"));
        locations.add(new Street("Whitechapel Road", brownGroup, 60, 4));
        locations.add(new IncomeTax());
        locations.add(new TrainStation("Kings Cross Station", trainStationGroup));
        locations.add(new Street("The Angel Islington", blueGroup, 100, 6));
        locations.add(new Chance("Chance 1", chanceCards));
        locations.add(new Street("Euston Road", blueGroup, 100, 6));
        locations.add(new Street("Pentonville Road", blueGroup, 120, 8));
        locations.add(new BasicLocation(JAIL_POSITION_NAME));
        locations.add(new Street("Pall Mall", pinkGroup, 140, 10));
        locations.add(new Utility("Electric Company", utilityGroup, 150));
        locations.add(new Street("Whitehall", pinkGroup, 140, 10));
        locations.add(new Street("Northumberland Avenue", pinkGroup, 160, 12));
        locations.add(new TrainStation("Marylebone Station", trainStationGroup));
        locations.add(new Street("Bow Street", orangeGroup, 180, 14));
        locations.add(new BasicLocation("Community Chest 2"));
        locations.add(new Street("Marlborough Street", orangeGroup, 180, 14));
        locations.add(new Street("Vine Street", orangeGroup, 200, 16));
        locations.add(new BasicLocation("Free Parking"));
        locations.add(new Street("Strand", redGroup, 220, 18));
        locations.add(new Chance("Chance 2", chanceCards));
        locations.add(new Street("Fleet Street", redGroup, 220, 18));
        locations.add(new Street("Trafalgar Square", redGroup, 240, 20));
        locations.add(new TrainStation("Fenchurch Street Station", trainStationGroup));
        locations.add(new Street("Leicester Square", yellowGroup, 260, 22));
        locations.add(new Street("Coventry Street", yellowGroup, 260, 22));
        locations.add(new Utility("Water Works", utilityGroup, 150));
        locations.add(new Street("Piccadilly", yellowGroup, 280, 24));
        locations.add(new GoToJail(this));
        locations.add(new Street("Regent Street", greenGroup, 300, 26));
        locations.add(new Street("Oxford Street", greenGroup, 300, 26));
        locations.add(new BasicLocation("Community Chest 3"));
        locations.add(new Street("Bond Street", greenGroup, 320, 28));
        locations.add(new TrainStation("Liverpool Street Station", trainStationGroup));
        locations.add(new Chance("Chance 3", chanceCards));
        locations.add(new Street("Park Lane", purpleGroup, 350, 35));
        locations.add(new SuperTax());
        locations.add(new Street("Mayfair", purpleGroup, 400, 50));
    }

}

package uk.co.mruoc.monopoly;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Logger LOG = Logger.getLogger(Board.class);

    private static final int BOARD_SIZE = 40;
    private final List<Location> locations = new ArrayList<>();

    public Board() {
        locations.add(new Location("Go"));
        locations.add(new Location("Old Kent Road", 60));
        locations.add(new Location("Community Chest"));
        locations.add(new Location("Whitechapel Road", 60));
        locations.add(new Location("Income Tax"));
        locations.add(new Location("Kings Cross Station", 200));
        locations.add(new Location("The Angel Islington", 100));
        locations.add(new Location("Chance"));
        locations.add(new Location("Euston Road", 100));
        locations.add(new Location("Pentonville Road", 120));
        locations.add(new Location("Just Visiting"));
        locations.add(new Location("Pall Mall", 140));
        locations.add(new Location("Electric Company", 150));
        locations.add(new Location("Whitehall", 140));
        locations.add(new Location("Northumberland Avenue", 160));
        locations.add(new Location("Marylebone Station", 200));
        locations.add(new Location("Bow Street", 180));
        locations.add(new Location("Community Chest"));
        locations.add(new Location("Marlborough Street", 180));
        locations.add(new Location("Vine Street", 200));
        locations.add(new Location("Free Parking"));
        locations.add(new Location("Strand", 220));
        locations.add(new Location("Chance"));
        locations.add(new Location("Fleet Street", 220));
        locations.add(new Location("Trafalgar Square", 240));
        locations.add(new Location("Fenchurch Street Station", 200));
        locations.add(new Location("Leicester Square", 260));
        locations.add(new Location("Coventry Street", 260));
        locations.add(new Location("Water Works", 150));
        locations.add(new Location("Piccadilly", 280));
        locations.add(new Location("Go To Jail"));
        locations.add(new Location("Regent Street", 300));
        locations.add(new Location("Oxford Street", 300));
        locations.add(new Location("Community Chest"));
        locations.add(new Location("Bond Street", 320));
        locations.add(new Location("Liverpool Street Station", 200));
        locations.add(new Location("Chance"));
        locations.add(new Location("Park Lane", 350));
        locations.add(new Location("Super Tax"));
        locations.add(new Location("Mayfair", 400));
    }

    public void movePlayer(int roll, Player player) {
        player.move(roll);
        while (passedGo(player)) {
            player.setPosition(getPassedGoPosition(player));
            player.incrementTimesPassedGo();
        }
        logInfo(createMoveDebugMessage(player, roll));
    }

    public Location getLocation(int position) {
        return locations.get(position - 1);
    }

    public Location getLocation(Player player) {
        return getLocation(player.getPosition());
    }

    public int getJailPosition() {
        return 11;
    }

    private boolean passedGo(Player player) {
        return player.getPosition() > BOARD_SIZE;
    }

    private int getPassedGoPosition(Player player) {
        return player.getPosition() - BOARD_SIZE;
    }

    private String createMoveDebugMessage(Player player, int roll) {
        Location location = getLocation(player);
        StringBuilder message = new StringBuilder("moved player ");
        message.append(player.getName());
        message.append(" ");
        message.append(roll);
        message.append(" space to location ");
        message.append(location.getName());
        return message.toString();
    }

    private void logInfo(String message) {
        LOG.info(message);
    }

}

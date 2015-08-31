package uk.co.mruoc.monopoly;

import com.sun.istack.internal.logging.Logger;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Logger LOG = Logger.getLogger(Board.class);

    private static final int BOARD_SIZE = 40;
    private final List<Location> locations = new ArrayList<>();

    public Board() {
        locations.add(new Location("Go"));
        locations.add(new Location("Old Kent Road"));
        locations.add(new Location("Community Chest"));
        locations.add(new Location("Whitechapel Road"));
        locations.add(new Location("Income Tax"));
        locations.add(new Location("Kings Cross Station"));
        locations.add(new Location("The Angel Islington"));
        locations.add(new Location("Chance"));
        locations.add(new Location("Euston Road"));
        locations.add(new Location("Pentonville Road"));
        locations.add(new Location("Just Visiting"));
        locations.add(new Location("Pall Mall"));
        locations.add(new Location("Electric Company"));
        locations.add(new Location("Whitehall"));
        locations.add(new Location("Northumberland Avenue"));
        locations.add(new Location("Marylebone Station"));
        locations.add(new Location("Bow Street"));
        locations.add(new Location("Community Chest"));
        locations.add(new Location("Marlborough Street"));
        locations.add(new Location("Vine Street"));
        locations.add(new Location("Free Parking"));
        locations.add(new Location("Strand"));
        locations.add(new Location("Chance"));
        locations.add(new Location("Fleet Street"));
        locations.add(new Location("Trafalgar Square"));
        locations.add(new Location("Fenchurch Street Station"));
        locations.add(new Location("Leicester Square"));
        locations.add(new Location("Coventry Street"));
        locations.add(new Location("Water Works"));
        locations.add(new Location("Piccadilly"));
        locations.add(new Location("Go To Jail"));
        locations.add(new Location("Regent Street"));
        locations.add(new Location("Oxford Street"));
        locations.add(new Location("Community Chest"));
        locations.add(new Location("Bond Street"));
        locations.add(new Location("Liverpool Street Station"));
        locations.add(new Location("Chance"));
        locations.add(new Location("Park Lane"));
        locations.add(new Location("Super Tax"));
        locations.add(new Location("Mayfair"));
    }

    public void movePlayer(int roll, Player player) {
        player.move(roll);
        while (passedGo(player)) {
            player.setPosition(getPassedGoPosition(player));
            player.receiveSalary();
        }
        Location location = getLocation(player);
        if (location.isGoToJail())
            player.setPosition(getJailPosition());
        if (location.isIncomeTax())
            player.payIncomeTax();
        if (location.isSuperTax())
            player.paySuperTax();

        logInfo(createMoveDebugMessage(player, roll, location));
    }

    public Location getLocation(int position) {
        return locations.get(position - 1);
    }

    public Location getLocation(Player player) {
        return getLocation(player.getPosition());
    }

    private boolean passedGo(Player player) {
        return player.getPosition() > BOARD_SIZE;
    }

    private int getPassedGoPosition(Player player) {
        return player.getPosition() - BOARD_SIZE;
    }

    private int getJailPosition() {
        return 11;
    }

    private String createMoveDebugMessage(Player player, int roll, Location location) {
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

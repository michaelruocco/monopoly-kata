package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class AdvanceToTrafalgarSquare implements ChanceCard {

    private static final String LOCATION_NAME = "Trafalgar Square";

    @Override
    public void applyTo(Player player) {
        player.advanceTo(LOCATION_NAME);
    }

    @Override
    public String getText() {
        return "Advance to " + LOCATION_NAME + ". If you pass GO, collect £200";
    }

}

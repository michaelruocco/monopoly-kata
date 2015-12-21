package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class AdvanceToMaryleboneStation implements ChanceCard {

    private static final String LOCATION_NAME = "Marylebone Station";

    @Override
    public void applyTo(Player player) {
        player.advanceTo(LOCATION_NAME);
    }

    @Override
    public String getText() {
        return "Take a trip to " + LOCATION_NAME + ". If you pass GO, collect £200";
    }

}

package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;

public class AdvanceToMayfair implements ChanceCard {

    private final String LOCATION_NAME = "Mayfair";

    @Override
    public void applyTo(Player player) {
        player.advanceTo(LOCATION_NAME);
    }

    @Override
    public String getText() {
        return "Advance to " + LOCATION_NAME;
    }

}

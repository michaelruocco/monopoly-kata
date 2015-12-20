package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public class BasicLocation extends Location {

    public BasicLocation(String name) {
        super(name);
    }

    @Override
    public void applyTo(Player player) {
        applyTo(player, 0);
    }

    @Override
    public void applyTo(Player player, int roll) {
        //intentionally blank
    }

}

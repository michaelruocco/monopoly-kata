package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;

public class BasicLocation extends Location {

    public BasicLocation(String name) {
        super(name);
    }

    @Override
    public void applyTo(Player player, Roll roll) {
        //intentionally blank
    }

}

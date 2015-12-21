package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;

public class GoToJail extends Location {

    private final Jail jail;

    public GoToJail(Jail jail) {
        super("Go To Jail");
        this.jail = jail;
    }

    @Override
    public void applyTo(Player player, Roll roll) {
        jail.put(player);
    }

}

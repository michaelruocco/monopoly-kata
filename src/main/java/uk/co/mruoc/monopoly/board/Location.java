package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.players.Player;

public interface Location {

    String getName();

    default void land(Player player) {
        // intentionally blank
    }

}

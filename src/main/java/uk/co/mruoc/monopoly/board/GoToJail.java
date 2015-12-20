package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public class GoToJail extends Location {

    private final Board board;

    public GoToJail(Board board) {
        super("Go To Jail");
        this.board = board;
    }

    @Override
    public void applyTo(Player player) {
        applyTo(player, 0);
    }

    @Override
    public void applyTo(Player player, int roll) {
        player.setPosition(board.getJailPosition());
    }

}

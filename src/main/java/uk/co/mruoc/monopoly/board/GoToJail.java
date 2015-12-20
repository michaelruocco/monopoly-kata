package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;

public class GoToJail extends Location {

    private final Board board;

    public GoToJail(Board board) {
        super("Go To Jail");
        this.board = board;
    }

    @Override
    public void applyTo(Player player, Roll roll) {
        player.setPosition(board.getJailPosition());
    }

}

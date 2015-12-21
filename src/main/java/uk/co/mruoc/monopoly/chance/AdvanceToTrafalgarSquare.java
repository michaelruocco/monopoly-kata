package uk.co.mruoc.monopoly.chance;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.board.Board;

public class AdvanceToTrafalgarSquare implements ChanceCard {

    private final Board board;

    public AdvanceToTrafalgarSquare(Board board) {
        this.board = board;
    }

    @Override
    public void applyTo(Player player) {
        int spacesToMove = calculateSpacesToMove(player);
        player.move(spacesToMove);
        player.endTurn(0);
    }

    private int calculateSpacesToMove(Player player) {
        int playerPosition = player.getPosition();
        int locationPosition = board.getLocationPosition("Trafalgar Square");
        if (playerPosition >= locationPosition)
            return (board.size() - playerPosition + locationPosition);
        return locationPosition - playerPosition;
    }

    @Override
    public String getText() {
        return "Advance to Trafalgar Square. If you pass GO, collect £200";
    }

}

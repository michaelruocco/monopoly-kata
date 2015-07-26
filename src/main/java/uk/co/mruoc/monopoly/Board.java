package uk.co.mruoc.monopoly;

public class Board {

    private static final int BOARD_SIZE = 40;

    public void movePlayer(int roll, Player player) {
        player.move(roll);
        if (passedGo(player))
            player.setPosition(getPassedGoPosition(player));
    }

    private boolean passedGo(Player player) {
        return player.getPosition() > BOARD_SIZE;
    }

    private int getPassedGoPosition(Player player) {
        return player.getPosition() - BOARD_SIZE;
    }

}

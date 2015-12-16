package uk.co.mruoc.monopoly;

public class PlayersValidator {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;

    public boolean validate(int numberOfPlayers) {
        if (numberOfPlayers < MIN_PLAYERS)
            throw new GameException(getMinPlayersMessage());
        if (numberOfPlayers > MAX_PLAYERS)
            throw new GameException(getMaxPlayersMessage());
        return true;
    }

    private String getMinPlayersMessage() {
        StringBuilder message = new StringBuilder("cannot create a game with less than ");
        message.append(MIN_PLAYERS);
        message.append(" players");
        return message.toString();
    }

    private String getMaxPlayersMessage() {
        StringBuilder message = new StringBuilder("cannot create a game with more than ");
        message.append(MAX_PLAYERS);
        message.append(" players");
        return message.toString();
    }

}

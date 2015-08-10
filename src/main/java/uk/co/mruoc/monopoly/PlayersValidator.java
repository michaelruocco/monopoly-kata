package uk.co.mruoc.monopoly;

public class PlayersValidator {

    private final int minPlayers = 2;
    private final int maxPlayers;

    public PlayersValidator(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void validate(int numberOfPlayers) {
        if (numberOfPlayers < minPlayers)
            throw new GameException(getMinPlayersMessage());
        if (numberOfPlayers > maxPlayers)
            throw new GameException(getMaxPlayersMessage());
    }

    private String getMinPlayersMessage() {
        StringBuilder message = new StringBuilder("cannot create a game with less than ");
        message.append(minPlayers);
        message.append(" players");
        return message.toString();
    }

    private String getMaxPlayersMessage() {
        StringBuilder message = new StringBuilder("cannot create a game with more than ");
        message.append(maxPlayers);
        message.append(" players");
        return message.toString();
    }

}

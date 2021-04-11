package uk.co.mruoc.monopoly.players;

import uk.co.mruoc.monopoly.MonopolyException;

public class GreaterThanMaxPlayersException extends MonopolyException {

    public GreaterThanMaxPlayersException(int numberOfPlayers, int maxPlayers) {
        super(String.format("game has %d players, cannot create a game with more than %d players",
                numberOfPlayers,
                maxPlayers)
        );
    }

}

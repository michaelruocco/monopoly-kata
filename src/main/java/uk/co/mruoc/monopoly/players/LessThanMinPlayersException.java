package uk.co.mruoc.monopoly.players;

import uk.co.mruoc.monopoly.MonopolyException;

public class LessThanMinPlayersException extends MonopolyException {

    public LessThanMinPlayersException(int numberOfPlayers, int minPlayers) {
        super(String.format("game has %d players, cannot create a game with less than %d players",
                numberOfPlayers,
                minPlayers)
        );
    }
}

package uk.co.mruoc.monopoly.players;

import uk.co.mruoc.monopoly.MonopolyException;

public class PlayerNotFoundException extends MonopolyException {

    public PlayerNotFoundException(String message) {
        super(message);
    }

}

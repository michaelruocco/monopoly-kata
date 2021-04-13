package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.MonopolyException;

public class LocationNotFoundException extends MonopolyException {

    public LocationNotFoundException(String message) {
        super(message);
    }

}

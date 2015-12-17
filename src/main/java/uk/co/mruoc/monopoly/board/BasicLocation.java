package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public class BasicLocation extends Location {

    public BasicLocation(String name) {
        super(name);
    }

    @Override
    public void applyTo(Player player) {
        //intentionally blank
    }

    @Override
    public void setOwner(Player player) {
        throw new UnsupportedOperationException(createSetOwnerErrorMessage());
    }

    private String createSetOwnerErrorMessage() {
        StringBuilder s = new StringBuilder();
        s.append("basic location ");
        s.append(getName());
        s.append(" cannot be purchased");
        return s.toString();
    }

}

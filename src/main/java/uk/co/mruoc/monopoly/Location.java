package uk.co.mruoc.monopoly;

public interface Location {

    String getName();

    boolean nameEquals(String name);

    boolean isGoToJail();

    boolean isIncomeTax();

    boolean isSuperTax();

    int getCost();

    Player getOwner();

    void setOwner(Player owner);

    boolean hasOwner();

}

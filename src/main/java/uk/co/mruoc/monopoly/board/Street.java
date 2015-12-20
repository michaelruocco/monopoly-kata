package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public class Street extends Property {

    private final int rent;

    public Street(String name, PropertyGroup group, int cost, int rent) {
        super(name, group, cost);
        this.rent  = rent;
    }

    @Override
    public int calculateRent(int roll) {
        if (!hasOwner())
            return rent;

        PropertyGroup group = getGroup();
        Player owner = getOwner();
        if (group.allOwnedBy(owner))
            return rent * 2;

        return rent;
    }

}

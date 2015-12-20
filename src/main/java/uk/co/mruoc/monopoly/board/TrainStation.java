package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;

public class TrainStation extends Property {

    private static final int COST = 200;
    private static final int BASE_RENT = 25;

    public TrainStation(String name, PropertyGroup group) {
        super(name, group, COST);
    }

    @Override
    public int calculateRent(Roll roll) {
        PropertyGroup group = getGroup();
        Player owner = getOwner();
        int rent = BASE_RENT;
        for (int i = 1; i < group.getNumberOfPropertiesOwnedBy(owner); i++)
            rent = rent * 2;
        return rent;
    }

}

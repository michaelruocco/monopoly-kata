package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Roll;

public class Utility extends Property {

    public Utility(String name, PropertyGroup group, int cost) {
        super(name, group, cost);
    }

    @Override
    public int calculateRent(Roll roll) {
        PropertyGroup group = getGroup();
        if (group.getNumberOfPropertiesOwned() == 0)
            return 0;

        if (group.allOwned())
            return roll.value() * 10;

        return roll.value() * 4;
    }

}

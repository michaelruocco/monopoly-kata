package uk.co.mruoc.monopoly.board;

public class Street extends Property {

    private final int rent;

    public Street(String name, PropertyGroup group, int cost, int rent) {
        super(name, group, cost);
        this.rent  = rent;
    }

    @Override
    public int calculateRent(int roll) {
        return rent;
    }

}

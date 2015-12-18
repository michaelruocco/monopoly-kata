package uk.co.mruoc.monopoly.board;

public class Street extends Property {

    private final int rent;

    public Street(String name, int cost, int rent) {
        super(name, cost);
        this.rent  = rent;
    }

    @Override
    public int calculateRent() {
        return rent;
    }

}

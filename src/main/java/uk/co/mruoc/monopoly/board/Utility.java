package uk.co.mruoc.monopoly.board;

public class Utility extends Property {

    public Utility(String name, int cost) {
        super(name, cost);
    }

    @Override
    public int calculateRent() {
        return 0;
    }

}

package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

public class TrainStation extends Property {

    private static final int BASE_RENT = 25;

    public TrainStation(String name) {
        super(name, 200);
    }

    @Override
    public int calculateRent(int roll) {
        Player owner = getOwner();
        int rent = BASE_RENT;
        for (int i = 1; i < owner.getNumberOfTrainStationsOwned(); i++)
            rent = rent * 2;
        return rent;
    }

}

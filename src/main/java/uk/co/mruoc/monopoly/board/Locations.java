package uk.co.mruoc.monopoly.board;

public interface Locations extends Iterable<Location> {

    int getNumberOfLocations();

    Location get(int index);

    int get(String name);

}

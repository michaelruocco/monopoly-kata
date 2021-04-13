package uk.co.mruoc.monopoly.board;


import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class DefaultLocations implements Locations {

    private final List<Location> values;

    public DefaultLocations() {
        this(buildValues());
    }

    @Override
    public Iterator<Location> iterator() {
        return values.iterator();
    }

    @Override
    public int getNumberOfLocations() {
        return values.size();
    }

    @Override
    public Location get(int index) {
        return values.get(index);
    }

    @Override
    public int get(String searchName) {
        return IntStream.range(0, values.size())
                .filter(i -> searchName.equals(values.get(i).getName()))
                .findFirst()
                .orElseThrow(() -> new LocationNotFoundException(searchName));
    }

    private static List<Location> buildValues() {
        Location chance = new Location("Chance");
        Location communityChest = new Location("Community Chest");
        return Arrays.asList(
                new Location("Go"),
                new Location("Old Kent Road"),
                new Location("Community Chest"),
                new Location("Whitechapel Road"),
                new Location("Income Tax"),
                new Location("Kings Cross Station"),
                new Location("The Angel Islington"),
                chance,
                new Location("Euston Road"),
                new Location("Pentonville Road"),
                new Location("Jail/Just Visiting"),
                new Location("Pall Mall"),
                new Location("Electric Company"),
                new Location("Whitehall"),
                new Location("Northumberland Avenue"),
                new Location("Marylebone Station"),
                new Location("Bow Street"),
                communityChest,
                new Location("Marlborough Street"),
                new Location("Vine Street"),
                new Location("Free Parking"),
                new Location("Strand"),
                chance,
                new Location("Fleet Street"),
                new Location("Trafalgar Square"),
                new Location("Fenchurch Street Station"),
                new Location("Leicester Square"),
                new Location("Coventry Street"),
                new Location("Water Works"),
                new Location("Piccadilly"),
                new Location("Go To Jail"),
                new Location("Regent Street"),
                new Location("Oxford Street"),
                communityChest,
                new Location("Bond Street"),
                new Location("Liverpool Street Station"),
                chance,
                new Location("Park Lane"),
                new Location("Super Tax"),
                new Location("Mayfair")
        );
    }

}
